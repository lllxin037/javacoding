package epi.greedy.invariants;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given a set of symbols with corresponding frequencies, find a code book that
 * has the smallest average code length.
 * 
 */

public class HuffmanCoding
{
	private static double[] FREQUENCY = new double[]
	{ 8.17, 1.49, 2.78, 4.25, 12.70, 2.23, 2.02, 6.09, 6.97, 0.15, 0.77, 4.03,
			2.41, 6.75, 7.51, 1.93, 0.10, 5.99, 6.33, 9.06, 2.76, 0.98, 2.36,
			0.15, 1.97, 0.07 };

	public static void encode(List<Symbol> symbols)
	{
		PriorityQueue<Symbol> minHeap = new PriorityQueue<HuffmanCoding.Symbol>(
				26);

		// sort the frequency in increment
		for (Symbol s : symbols)
			minHeap.add(s);

		Symbol root = null;

		while (minHeap.size() > 1)
		{
			// get two least frequency to create another new node.
			Symbol s1 = minHeap.poll();
			Symbol s2 = minHeap.poll();

			Symbol merged = new Symbol(s1.frequency + s2.frequency);
			merged.left = s1;
			merged.right = s2;

			// add new node to min heap again.
			minHeap.add(merged);
			root = merged;
		}

		// print all leaves. all left paths are with 0; right paths are with 1;

		assignHuffmanCode(root, "");

		for (Symbol s : symbols)
			System.out.println(" char:" + s.c + "  code:" + s.code);

	}

	private static void assignHuffmanCode(Symbol root, String s)
	{
		if (root == null)
			return;

		if (root.left == null && root.right == null)
			root.code = s;
		else
		{
			assignHuffmanCode(root.left, s + "0");
			assignHuffmanCode(root.right, s + "1");
		}
	}

	private static List<Symbol> init()
	{
		List<Symbol> list = new ArrayList<Symbol>(26);
		for (int i = 0; i < 26; i++)
			list.add(new Symbol((char) ('a' + i), FREQUENCY[i]));

		return list;
	}

	public static void main(String[] args)
	{
		encode(init());
	}

	private static class Symbol implements Comparable<Symbol>
	{
		protected Symbol left, right;
		protected String code;

		private double frequency;
		private char c;

		Symbol(double freq)
		{
			this.frequency = freq;
		}

		Symbol(char c, double freq)
		{
			this.c = c;
			this.frequency = freq;
		}

		public int compareTo(Symbol s1)
		{
			return (Double.valueOf(frequency).compareTo(Double
					.valueOf(s1.frequency)));
		}
	}
}
