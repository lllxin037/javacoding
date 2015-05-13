package topological.sorting;

import java.util.ArrayList;
import java.util.List;

public class Test
{
	private static void onecase(int[][] input)
	{
		int n = input[0][0];
		int m = input[0][1];

		// initial graph
		List<List<Integer>> graph = new ArrayList<List<Integer>>(n);
		int[] indegs = new int[n];
		for (int i = 0; i < n; ++i)
		{
			graph.add(new ArrayList<Integer>(n));
		}

		// parse edges
		for (int j = 0; j < m; ++j)
		{
			int v1 = input[j + 1][0] - 1, v2 = input[j + 1][1] - 1;

			// add v2 to v1's neighbor list
			graph.get(v1).add(v2);
			// increase v2's indegree
			indegs[v2]++;
		}

		BFSSolution s = new BFSSolution();
		s.toposort(graph, indegs);

	}

	public static void main(String[] args)
	{
		onecase(new int[][]
		{
		{ 8, 9 },
		{ 1, 4 },
		{ 1, 2 },
		{ 4, 2 },
		{ 4, 3 },
		{ 3, 2 },
		{ 5, 2 },
		{ 3, 5 },
		{ 8, 2 },
		{ 8, 6 } });

		onecase(new int[][]
		{
		{ 2, 2 },
		{ 1, 2 },
		{ 2, 1 } });
	}
}
