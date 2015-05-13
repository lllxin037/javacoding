package heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Google面试题 股市上一个股票的价格从开市开始是不停的变化的，需要开发一个系统，给定一个股票，
 * 它能实时显示从开市到当前时间的这个股票的价格的中位数（中值）.
 * 
 */

class StockMediaPrice
{
	private PriorityQueue<Integer> maxHeap, minHeap;
	private int size;

	StockMediaPrice()
	{
		Comparator<Integer> revCmp = Collections.reverseOrder();
		maxHeap = new PriorityQueue<Integer>(20, revCmp);
		minHeap = new PriorityQueue<Integer>(20);
		size = 0;
	}

	/**
	 * Maintains a condition that maxHeap.size() >= minHeap.size()
	 * 
	 * <pre>
	 * 1) the max-heap contains the smallest half of the numbers and min-heap contains the largest half 
	 * 2) the number of elements in max-heap is either equal to or 1 more than the number of elements 
	 * in the min-heap.
	 * </pre>
	 */
	public void addNumber(int value)
	{
		maxHeap.add(value);
		if ((size & 1) == 1)
		{
			minHeap.add(maxHeap.poll());
		}
		else
		{
			// compare the value and switch 
			if (size > 0 && minHeap.peek() < maxHeap.peek())
			{
				int smaller = minHeap.poll();
				int larger = maxHeap.poll();
				minHeap.add(larger);
				maxHeap.add(smaller);
			}
		}

		size++;
	}

	/**
	 * If maxHeap and minHeap are of different sizes, then maxHeap must have one
	 * extra element.
	 */
	public double getMedian()
	{
		if ((size & 1) == 1) // If total number received is not even
			return new Double(maxHeap.peek());
		else
			return (maxHeap.peek() + minHeap.peek()) / 2.0;
	}

	public void dumpHeaps()
	{
		System.out.println("Max heap: " + maxHeap);
		System.out.println("Min heap: " + minHeap);
	}
}
