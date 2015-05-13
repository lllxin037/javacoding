package heap;

import java.util.Arrays;

/**
 * http://blog.csdn.net/lidalong0408/article/details/7682661
 * 
 */

class MinMaxHeap<E>
{
	private final static int DEFAULT_SIZE = 100;
	private E[] objects;
	private int size;

	protected MinMaxHeap()
	{
		objects = (E[]) new Object[DEFAULT_SIZE];
		size = 0;
	}

	/**
	 * Create a priority queue with the given items. Takes time proportional to
	 * the number of items using sink-based heap construction.
	 */
	public MinMaxHeap(E[] values)
	{
		size = values.length;
		objects = (E[]) new Object[size + 1];
		for (int i = 0; i < size; i++)
			objects[i + 1] = values[i];
		for (int k = (size >> 1); k >= 1; k--)
			sink(k);
	}

	private void sink(int k)
	{
		if (isMin(k))
			sinkMin(k);
		else
			sinkMax(k);
	}

	private void sinkMin(int k)
	{
		if (2 * k <= size)
		{
			int m;
			if (4 * k > size)
			{
				if (size == 2 * k)
					m = 2 * k;
				else
					m = less(2 * k, 2 * k + 1) ? 2 * k : 2 * k + 1;
				if (less(m, k))
					swap(m, k);
			}
			else
			{
				m = 4 * k;
				for (int i = 4 * k + 1; i <= size && i < 4 * k + 4; i++)
					if (less(i, m))
						m = i;
				if (less(m, k))
				{
					swap(m, k);
					if (less(m / 2, m))
						swap(m / 2, m);
					sinkMin(m);
				}
			}
		}
	}

	private void sinkMax(int k)
	{
		if (2 * k <= size)
		{
			int m;
			if (4 * k > size)
			{
				if (size == 2 * k)
					m = 2 * k;
				else
					m = less(2 * k, 2 * k + 1) ? 2 * k + 1 : 2 * k;
				if (less(k, m))
					swap(m, k);
			}
			else
			{
				m = 4 * k;
				for (int i = 4 * k + 1; i <= size && i < 4 * k + 4; i++)
					if (less(m, i))
						m = i;
				if (less(k, m))
				{
					swap(m, k);
					if (less(m, m / 2))
						swap(m / 2, m);
					sinkMax(m);
				}
			}
		}
	}

	private boolean isMin(int k)
	{
		double r = Math.log((double) (k + 1)) / Math.log(2.0);
		int floor = (int) Math.ceil(r);
		return (floor & 1) == 1;
	}

	private boolean less(int i, int j)
	{
		return ((Comparable<E>) objects[i]).compareTo(objects[j]) < 0;
	}

	private void swap(int i, int j)
	{
		E swap = objects[i];
		objects[i] = objects[j];
		objects[j] = swap;
	}

	/**
	 * Add a new key to the priority queue.
	 */
	public void insert(E x)
	{

		objects[++size] = x;
		swim(size);
	}

	private void swim(int k)
	{
		if (isMin(k))
		{
			if (k > 1 && less(k / 2, k))
			{
				swap(k, k / 2);
				swimMax(k / 2);
			}
			else
				swimMin(k);
		}
		else
		{
			if (k > 1 && less(k, k / 2))
			{
				swap(k, k / 2);
				swimMin(k / 2);
			}
			else
				swimMax(k);
		}

	}

	private void swimMin(int k)
	{
		if (k / 4 > 0 && less(k, k / 4))
		{
			swap(k, k / 4);
			swimMin(k / 4);
		}
	}

	private void swimMax(int k)
	{
		if (k / 4 > 0 && less(k / 4, k))
		{
			swap(k, k / 4);
			swimMax(k / 4);
		}
	}

	public void dumpHeapInArray()
	{
		System.out.println(Arrays.toString(objects));
	}
}
