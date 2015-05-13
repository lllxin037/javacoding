package topological.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Sandro is a well organised person. Every day he makes a list of things which
 * need to be done and enumerates them from 1 to n. However, some things need to
 * be done before others. In this task you have to find out whether Sandro can
 * solve all his duties and if so, print the correct order.
 * 
 * Input In the first line you are given an integer n and m (1<=n<=10000,
 * 1<=m<=1000000). On the next m lines there are two distinct integers x and y,
 * (1<=x,y<=10000) describing that job x needs to be done before job y.
 * 
 * Output Print "Sandro fails." if Sandro cannot complete all his duties on the
 * list. If there is a solution print the correct ordering, the jobs to be done
 * separated by a whitespace. If there are multiple solutions print the one,
 * whose first number is smallest, if there are still multiple solutions, print
 * the one whose second number is smallest, and so on.
 * 
 * <pre>
 * Example 1
 * 
 * Input:
 * 8 9
 * 1 4
 * 1 2
 * 4 2
 * 4 3
 * 3 2
 * 5 2
 * 3 5
 * 8 2
 * 8 6
 * Output:
 * 1 4 3 5 7 8 2 6 
 * 
 * 
 * Example 2
 * 
 * Input:
 * 2 2
 * 1 2
 * 2 1
 * Output:
 * Sandro fails.
 * </pre>
 * 
 */

public class BFSSolution
{
	public void toposort(List<List<Integer>> graph, int[] indegs)
	{
		int n = indegs.length;
		boolean[] visited = new boolean[n];

		// use heap s.t. smallest-numbered available vertex first
		Queue<Integer> que = new PriorityQueue<Integer>();
		ArrayList<Integer> res = new ArrayList<Integer>(n);

		for (int i = 0; i < n; i++)
		{
			if (indegs[i] == 0)
				que.offer(i);
		}

		while (!que.isEmpty())
		{
			int node = que.poll();
			res.add(node + 1);

			// mark as visited
			visited[node] = true;

			// update its neighbors and enqueue 0-in-degree ones
			for (int nb : graph.get(node))
			{
				if (visited[nb])
				{ // a cycle detected
					break;
				}
				if (--indegs[nb] == 0)
					que.offer(nb);
			}
		}

		if (res.size() < n)
		{
			System.out.println("Sandro fails.");
		}
		else
		{
			System.out.println(res);
		}
	}
}
