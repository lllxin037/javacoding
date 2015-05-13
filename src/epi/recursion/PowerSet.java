package epi.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PowerSet
{
	public static void generatePowerSet(List<Integer> S)
	{
		Deque<Integer> res = new LinkedList<Integer>();
		recursiveHelper(S, 0, res);
	}

	private static void recursiveHelper(List<Integer> S, int start,
			Deque<Integer> res)
	{
		if (!res.isEmpty())
		{
			Iterator<Integer> iter1 = res.iterator();
			while (iter1.hasNext())
			{
				System.out.print(iter1.next());
				if (iter1.hasNext())
				{
					System.out.print(",");
				}
			}
			System.out.println();
		}

		for (int i = start; i < S.size(); i++)
		{
			res.offerLast(S.get(i));
			recursiveHelper(S, i + 1, res);
			res.pollLast();
		}
	}

	public static void generatePowerSetIteratively(List<Integer> S)
	{
		if (S == null)
			return;

		List<List<Integer>> sets = new ArrayList<List<Integer>>();
		sets.add(new ArrayList<Integer>());

		for (int i = 0; i < S.size(); i++)
		{
			int curSize = sets.size();
			while (curSize > 0)
			{
				List<Integer> one = sets.get(curSize - 1);

				ArrayList<Integer> newOne = new ArrayList<Integer>();
				newOne.addAll(one);
				newOne.add(S.get(i));
				sets.add(newOne);

				curSize--;
			}
		}

		for (List<Integer> one : sets)
			System.out.println(one);

	}

	public static void main(String[] args)
	{
		generatePowerSet(Arrays.asList(new Integer[]
		{ 1, 2 }));
		
		generatePowerSet(Arrays.asList(new Integer[]
		{ 3, 2, 1 }));
	}
}
