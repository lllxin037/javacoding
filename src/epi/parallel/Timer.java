package epi.parallel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

public class Timer
{
	private static DateFormat simpleFormat = new SimpleDateFormat(
			"HH:mm:ss.SSS");

	/**
	 * check timer and start the task.
	 */
	private String name;

	private PriorityQueue<Task> queue = new PriorityQueue<Task>();
	private Map<String, Task> map = new HashMap<String, Task>();
	private DispatcherThread dispatcher = null;

	public Timer(String name)
	{
		this.name = name;
		dispatcher = new DispatcherThread(queue, map);
		dispatcher.start();
	}

	public void shutdown()
	{
		synchronized (queue)
		{
			dispatcher.shutdown();
			queue.clear();
			queue.notify();
		}
		dispatcher = null;
	}

	public boolean addTask(Task one)
	{
		if (one == null || one.name == null || one.time == null)
			throw new IllegalArgumentException();

		if (map.keySet().contains(one.name))
			return false;

		synchronized (queue)
		{
			if (one.state != State.INIT)
				throw new IllegalArgumentException();

			synchronized (one)
			{
				one.state = State.IN_QUEUE;
			}

			queue.add(one);
			if (queue.peek() == one)
			{
				queue.notify();
			}

			map.put(one.name, one);

		}

		return true;
	}

	public boolean cancelTask(String taskName)
	{
		if (!map.containsKey(taskName))
			return false;

		synchronized (queue)
		{
			Task one = map.get(taskName);
			synchronized (one)
			{
				// don't cancel thread when it's running.
				if (one.state != State.RUNNING)
					one.state = State.CANCELLED;
			}

			map.remove(taskName);
			if (one == queue.peek())
				queue.notify();
		}

		return true;
	}

	private static class DispatcherThread extends Thread
	{
		private PriorityQueue<Task> queue = new PriorityQueue<Task>();
		private Map<String, Task> map = new HashMap<String, Task>();
		private boolean shutdown = false;

		DispatcherThread(PriorityQueue<Task> queue, Map<String, Task> map)
		{
			this.queue = queue;
			this.map = map;
		}

		public void run()
		{
			System.out.println("task dispatcher starts to run...");
			while (!shutdown)
			{
				boolean runTask = false;
				Task task = null;

				try
				{
					// wake up when recevies the notification of queue changes
					synchronized (queue)
					{
						while (queue.isEmpty() && !shutdown)
							queue.wait();

						if (queue.isEmpty())
							break; // Queue is empty and will forever remain;

						task = queue.peek();
						long currentTime = System.currentTimeMillis();

						long nextRun;
						synchronized (task)
						{
							nextRun = task.time.getTime();
							// expect to run task.
							if (nextRun <= currentTime)
							{
								runTask = true;
								queue.poll();
								map.remove(task.name);

								// ignore the invalid state.
								if (task.state != Timer.State.IN_QUEUE)
									continue;
							}
						}

						// if the queue is empty, nextRun could be max value.
						if (!runTask)
							queue.wait(nextRun - currentTime);
					}

					if (runTask)
						task.run();
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}

			System.out.println("task dispatcher stops...");
		}

		public void shutdown()
		{
			shutdown = true;
		}
	}

	public static void main(String[] args) throws Exception
	{
		Timer timer = new Timer("test");
		long currentTime = System.currentTimeMillis();

		int maxTime = 0;

		Random r = new Random();
		int addCount = r.nextInt(50) + 10;
		for (int i = 0; i < addCount; i++)
		{
			String taskName = "T_" + (i + 1);
			int ti = r.nextInt(1000 * 100) + 1000;

			maxTime = Math.max(ti, maxTime);

			final Task one = new Task(taskName, new Date(currentTime + ti));
			timer.addTask(one);

			System.out.println("add task " + taskName + " to run at "
					+ simpleFormat.format(new Date(currentTime + ti)));
		}

		int toDeleteCount = r.nextInt(10) + 10;
		for (int i = 0; i < toDeleteCount; i++)
		{
			int index = r.nextInt(addCount);
			String taskName = "T_" + index;

			timer.cancelTask(taskName);

			System.out.println("cancel task " + taskName);
		}

		Thread.sleep(maxTime + 1000 * 10);

		System.out.println("main thread wakes up...");
		timer.shutdown();
	}

	public static enum State
	{
		INIT, IN_QUEUE, RUNNING, FINISHED, CANCELLED
	};

	private static class Task implements Comparable<Task>
	{

		private Date time;
		private String name;
		private State state;

		Task(String name, Date time)
		{
			this.time = time;
			this.name = name;
			this.state = State.INIT;
		}

		public void run()
		{
			synchronized (this)
			{
				state = State.RUNNING;
				System.out.println("running task " + name + " at "
						+ simpleFormat.format(time));
				state = State.FINISHED;
			}
		}

		public int compareTo(Task t1)
		{
			return time.compareTo(t1.time);
		}

		public String toString()
		{
			return "task " + name + "  run at " + simpleFormat.format(time)
					+ "  current state: " + state;
		}
	}
}
