package google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * There is an array of 3-tuple, in the form of (a, 1, 5). The first element in
 * the tuple is the id, the second and third elements are both integers, and the
 * third is always larger than or equal to the second. Assume that the array is
 * sorted based on the second element of the tuple. Write a function that breaks
 * each of the 3-tuple into two 2-tuples like (a, 1) and (a, 5), and sort them
 * according to the integer. E.g. given (a, 1, 5), (b, 2, 4), (c, 7, 8), output
 * (a, 1), (b, 2), (b, 4), (a, 5), (c, 7), (c, 8).
 * 
 */

public class SortedTwoTuple
{
	public static List<TwoTuple> toTwoTuple(List<ThreeTuple> input)
	{
		if (input == null || input.size() == 0)
			return Collections.<TwoTuple> emptyList();

		int n = input.size();

		List<TwoTuple> ret = new ArrayList<TwoTuple>();
		PriorityQueue<TwoTuple> minHeap = new PriorityQueue<TwoTuple>();

		for (int i = 0; i < n; i++)
		{
			ThreeTuple one = input.get(i);
			while (!minHeap.isEmpty() && one.value >= minHeap.peek().value)
				ret.add(minHeap.poll());

			ret.add(new TwoTuple(one.id, one.value));
			minHeap.offer(new TwoTuple(one.id, one.highValue));
		}

		while (!minHeap.isEmpty())
			ret.add(minHeap.poll());

		return ret;
	}

	public static void main(String[] args)
	{
		ArrayList<ThreeTuple> arr = new ArrayList<ThreeTuple>();
		arr.add(new ThreeTuple('a', 1, 2));
		arr.add(new ThreeTuple('b', 1, 5));
		arr.add(new ThreeTuple('c', 2, 3));
		arr.add(new ThreeTuple('d', 4, 4));

		System.out.println(toTwoTuple(arr));

		arr.clear();
		arr.add(new ThreeTuple('a', 1, 5));
		arr.add(new ThreeTuple('b', 2, 4));
		arr.add(new ThreeTuple('c', 7, 8));
		
		System.out.println(toTwoTuple(arr));		
	}

	private static class TwoTuple implements Comparable<TwoTuple>
	{
		char id;
		int value;

		TwoTuple(char id, int value)
		{
			this.id = id;
			this.value = value;
		}

		public int compareTo(TwoTuple another)
		{
			return value - another.value;
		}

		public String toString()
		{
			return "(" + id + "," + value + ")";
		}
	}

	private static class ThreeTuple extends TwoTuple
	{
		int highValue;

		ThreeTuple(char id, int value, int highValue)
		{
			super(id, value);
			this.highValue = highValue;
		}
	}
}
