package heap;

import java.util.ArrayList;
import java.util.List;

/**
 * http://128kj.iteye.com/blog/1728555
 * 
 */

public class MaxHeap
{
	private transient List<Integer> heap;

	public MaxHeap()
	{
		heap = new ArrayList<Integer>();
	}

	public void delete(int index)
	{
		if (heap.size() == 0)
			return;
		heap.set(index, heap.get(heap.size() - 1));
		heapDown(index);

		heap.remove(heap.size() - 1);
	}

	private void heapDown(int index)
	{
		int n = heap.size() - 2;

		while (index * 2 <= n)
		{
			int child = (index << 1);

			// 如果左儿子小于右儿子的数值，取右儿子的下标
			if ((child < n) && heap.get(child) < heap.get(child + 1))
				child++;

			int childValue = heap.get(child);
			if (heap.get(child) > heap.get(index))
			{
				heap.set(child, heap.get(index));
				heap.set(index, childValue);

				index = child;
			}
			else
				break;
		}
	}

	public void insert(Integer value)
	{
		if (heap.size() == 0)
			heap.add(0);

		heap.add(value);
		heapUp();
	}

	private void heapUp()
	{
		int cur = heap.size() - 1;
		while (cur > 1)
		{
			int parentIndex = cur >> 1;
			int parentValue = heap.get(parentIndex);
			int curValue = heap.get(cur);
			if (curValue > parentValue)
			{
				heap.set(parentIndex, curValue);
				heap.set(cur, parentValue);
				cur = parentIndex;
			}
			else
				break;
		}
	}

	public static MaxHeap adjust(List<Integer> heap)
	{
		MaxHeap instance = new MaxHeap();
		instance.heap.addAll(heap);

		for (int i = instance.heap.size() / 2; i > 0; i--)
			instance.heapDown(i);

		return instance;
	}

	public void dumpHeapInArray()
	{
		System.out.println(heap);
	}
}
