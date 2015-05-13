package epi.stackandqueues;

import java.util.Arrays;

/**
 * Implement a queue API using an array for storing elements. Your API should
 * include a constructor function, which takes as argument the capacity of the
 * queue, enqueue and dequeue functions, a size function, which returns the
 * number of elements stored, and implement dynamic resizing.
 * 
 */

public class CircularQueue<T>
{
	private T[] objects = null;
	private int head = 0;
	private int tail = 0;

	public CircularQueue(int capacity)
	{
		objects = (T[]) new Object[capacity];
	}

	public void enqueue(T t)
	{
		if (t == null)
			throw new NullPointerException();

		objects[tail] = t;
		if (tail + 1 == objects.length && head == 0)
			resize();
		else if (tail + 1 == head)
			resize();
		else
		{
			tail++;
			if (tail == objects.length)
				tail = 0;
		}
	}

	public T dequeue()
	{
		int h = head;
		T ret = objects[h]; // Element is null if deque empty
		if (ret == null)
			return null;

		objects[head] = null;
		head++;
		if (head == objects.length)
			head = 0;
		return ret;
	}

	public int size()
	{
		int n = tail - head;
		if (n >= 0)
			return n;

		return n + objects.length;
	}

	private void resize()
	{
		int n = objects.length;
		int newCapcity = n << 1;
		int h = head;

		if (newCapcity < 0)
			throw new IllegalStateException("Sorry, deque too big");

		Object[] a = new Object[newCapcity];

		int r = n - h;
		System.arraycopy(objects, h, a, 0, r);
		System.arraycopy(objects, 0, a, r, h);
		objects = (T[]) a;
		head = 0;
		tail = n;
	}

	public String toString()
	{
		return Arrays.toString(objects) + "   head:" + head + "   tail:" + tail
				+ "  size:" + size();
	}

	public static void main(String[] args)
	{
		CircularQueue<Integer> queue = new CircularQueue<Integer>(6);
		queue.enqueue(2);
		System.out.println(queue);
		queue.enqueue(8);
		System.out.println(queue);
		queue.enqueue(13);
		System.out.println(queue);
		queue.enqueue(9);
		System.out.println(queue);
		queue.enqueue(7);
		System.out.println(queue);

		System.out.println("deqeue: " + queue.dequeue());
		System.out.println(queue);
		System.out.println("deqeue: " + queue.dequeue());
		System.out.println(queue);

		queue.enqueue(14);
		System.out.println(queue);
		queue.enqueue(15);
		System.out.println(queue);

		System.out.println("deqeue: " + queue.dequeue());
		System.out.println(queue);
		System.out.println("deqeue: " + queue.dequeue());
		System.out.println(queue);
		System.out.println("deqeue: " + queue.dequeue());
		System.out.println(queue);

		queue.enqueue(21);
		System.out.println(queue);
		queue.enqueue(25);
		System.out.println(queue);
		queue.enqueue(29);
		System.out.println(queue);
		queue.enqueue(30);
		System.out.println(queue);
	}
}
