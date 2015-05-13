package epi.parallel;

public class InterleavingThreads
{

	public static void main(String[] args)
	{
		Object monitor = new Object();

		NumberThread evenRunnable = new NumberThread(true, monitor);
		NumberThread oddRunnable = new NumberThread(false, monitor);

		Thread t1 = new Thread(evenRunnable);
		Thread t2 = new Thread(oddRunnable);
		t1.start();
		t2.start();

	}

	private static class NumberThread implements Runnable
	{
		private int curNum;
		private Object monitor;

		NumberThread(boolean even, Object monitor)
		{
			if (even)
				curNum = 2;
			else
				curNum = 1;

			this.monitor = monitor;
		}

		public void run()
		{
			while (curNum < 101)
			{
				if (curNum != 1)
				{
					try
					{
						synchronized (monitor)
						{
							monitor.wait();
						}
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
						return;
					}
				}

				synchronized (monitor)
				{
					System.out.println(curNum);
					curNum += 2;

					monitor.notifyAll();
				}
			}
		}
	}
}
