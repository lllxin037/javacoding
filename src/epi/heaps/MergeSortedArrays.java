package epi.heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 *
 */

public class MergeSortedArrays
{

	/**
	 * @param s
	 * @return
	 */

	public static List<Integer> mergeFiles(List<List<Integer>> s)
	{
		// setup the min heap, each node is for one file. Whenever, one node
		// should be updated. Wrote the minimal node to the file.

		PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>(16,
				new Comparator<Pair>()
				{

					@Override
					public int compare(Pair o1, Pair o2)
					{
						return o1.timeStamp.compareTo(o2.timeStamp);
					}
				});

		int[] arrayIndex = new int[s.size()];
		for (int i = 0; i < s.size(); i++)
		{
			if (s.get(i).size() > 0)
			{
				minHeap.add(new Pair(s.get(i).get(0), i));
				arrayIndex[i] = 1;
			}
		}

		List<Integer> ret = new ArrayList<Integer>();
		while (!minHeap.isEmpty())
		{
			Pair min = minHeap.remove();
			ret.add(min.timeStamp);

			if (arrayIndex[min.index] < s.get(min.index).size())
			{
				minHeap.add(new Pair(s.get(min.index)
						.get(arrayIndex[min.index]), min.index));
				arrayIndex[min.index]++;
			}
		}

		return ret;
	}

	private static class Pair
	{
		Integer timeStamp;
		int index;

		Pair(Integer timeStamp, int index)
		{
			this.timeStamp = timeStamp;
			this.index = index;
		}
	}
}
