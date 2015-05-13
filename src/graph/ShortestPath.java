package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class ShortestPath
{
	private static int[][] adjacentMatrix1 = new int[][]
	{
	{ 'S', 'B', 8 },
	{ 'S', 'E', 3 },
	{ 'E', 'J', 6 },
	{ 'E', 'F', 2 },
	{ 'J', 'K', 5 },
	{ 'B', 'F', 3 },
	{ 'B', 'A', 4 },
	{ 'F', 'K', 1 },
	{ 'F', 'G', 6 },
	{ 'K', 'L', 1 },
	{ 'A', 'G', 1 },
	{ 'A', 'C', 2 },
	{ 'G', 'H', 7 },
	{ 'G', 'L', 1 },
	{ 'L', 'M', 3 },
	{ 'C', 'D', 7 },
	{ 'C', 'H', 2 },
	{ 'H', 'I', 2 },
	{ 'H', 'M', 1 },
	{ 'M', 'T', 3 },
	{ 'D', 'I', 5 },
	{ 'I', 'T', 2 } };

	/**
	 * 
	 * <pre>
	 * A Graph example  we mark the vertexes  with 0,1,2,.14 from left to right , up to down
	 * 
	 * S- 8-B- 4- A-  2-C-  7-D
	 * |    |     |     |     |
	 * 3    3     1     2     5
	 * |    |     |     |     |
	 * E-2- F-  6-G-7  -H-  2-I
	 * |    |     |     |     |
	 * 6    1     1     1     2
	 * |    |     |     |     |
	 * J-5- K-  1-L-  3-M-  3-T
	 * 
	 * </pre>
	 */

	public static void floyd(List<UndirectedGraphNode> nodes, Distance[][] dists)
	{
		int n = nodes.size();

		// the key is the node label, and the value is the index in nodes.
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++)
		{
			UndirectedGraphNode node = nodes.get(i);
			map.put(node.label, i);
		}

		for (int i = 0; i < n; i++)
		{
			dists[i] = new Distance[n];
			for (int j = 0; j < n; j++)
			{
				dists[i][j] = new Distance(-1);
				if (i == j)
					dists[i][j].distance = 0;
			}
		}

		for (int i = 0; i < n; i++)
		{
			UndirectedGraphNode node = nodes.get(i);
			if (node.neighbors == null || node.neighbors.isEmpty())
				continue;

			for (int j = 0; j < node.neighbors.size(); j++)
			{
				UndirectedGraphNode toNode = node.neighbors.get(j);
				dists[i][map.get(toNode.label)].distance = node.weight.get(j);

				dists[i][map.get(toNode.label)].preV = i;
			}
		}

		for (int v = 0; v < n; v++)
		{
			for (int i = 0; i < n; i++)
			{
				for (int j = 0; j < n; j++)
				{
					if ((dists[i][v].distance != Integer.MAX_VALUE)
							&& (dists[v][j].distance != Integer.MAX_VALUE)
							&& (dists[i][v].distance + dists[v][j].distance < dists[i][j].distance))
					{
						dists[i][j].distance = dists[i][v].distance
								+ dists[v][j].distance;
						dists[i][j].preV = v;
					}
				}
			}
		}
	}

	public static void dijstra(List<UndirectedGraphNode> nodes, int fromV,
			Distance[] dists)
	{
		PriorityQueue<Distance> minHeap = new PriorityQueue<Distance>();
		int n = nodes.size();

		for (int i = 0; i < n; i++)
			dists[i] = new Distance(i);
		boolean[] visited = new boolean[n];
		dists[fromV].distance = 0;
		minHeap.add(dists[fromV]);

		int count = 0;
		while (count < n)
		{
			Distance one = minHeap.poll();
			if (visited[one.curV])
				continue;

			visited[one.curV] = true;
			count++;
			UndirectedGraphNode node = nodes.get(one.curV);
			if (node.neighbors == null || node.neighbors.isEmpty())
				continue;

			for (int i = 0; i < node.neighbors.size(); i++)
			{
				UndirectedGraphNode next = node.neighbors.get(i);
				int weight = node.weight.get(i);

				int toIndex = getNodeIndex(nodes, (char) next.label);
				if (visited[toIndex])
					continue;

				if (one.distance + weight < dists[toIndex].distance)
				{
					dists[toIndex].distance = one.distance + weight;
					dists[toIndex].preV = one.curV;

					minHeap.add(dists[toIndex]);
				}

			}
		}
	}

	private static Map<Integer, UndirectedGraphNode> createUnDirectedGraph(
			int[][] adjacentMatrix)
	{
		Map<Integer, UndirectedGraphNode> nodes = new LinkedHashMap<Integer, UndirectedGraphNode>();
		for (int[] edge : adjacentMatrix)
		{
			int start = edge[0];
			int end = edge[1];
			int weight = edge[2];

			UndirectedGraphNode vertex1 = nodes.get(start);
			if (vertex1 == null)
			{
				vertex1 = new UndirectedGraphNode(start);
				nodes.put(start, vertex1);
			}

			UndirectedGraphNode vertex2 = nodes.get(end);
			if (vertex2 == null)
			{
				vertex2 = new UndirectedGraphNode(end);
				nodes.put(end, vertex2);
			}

			if (vertex1.neighbors == null)
				vertex1.neighbors = new ArrayList<UndirectedGraphNode>();
			vertex1.neighbors.add(vertex2);

			if (vertex1.weight == null)
				vertex1.weight = new ArrayList<Integer>();
			vertex1.weight.add(weight);
		}
		return nodes;
	}

	public static void main(String[] args)
	{
		Map<Integer, UndirectedGraphNode> map = createUnDirectedGraph(adjacentMatrix1);
		List<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
		nodes.addAll(map.values());

		Distance[][] dists = new Distance[nodes.size()][];
		floyd(nodes, dists);

		int i = getNodeIndex(nodes, 'S');
		int j = getNodeIndex(nodes, 'T');

		Stack<Character> stack = new Stack<Character>();

		while (j != i)
		{
			stack.push((char) nodes.get(j).label);
			j = dists[i][j].preV;
		}
		stack.push((char) nodes.get(i).label);
		System.out.println("floyd solution: ");
		while (!stack.isEmpty())
		{
			System.out.print(stack.pop());
			if (!stack.isEmpty())
				System.out.print("->");
		}
		System.out.println();

		stack.clear();

		Distance[] dists1 = new Distance[nodes.size()];
		dijstra(nodes, i, dists1);
		j = getNodeIndex(nodes, 'T');

		while (j != i)
		{
			stack.push((char) nodes.get(j).label);
			j = dists1[j].preV;
		}
		stack.push((char) nodes.get(i).label);
		System.out.println("dijstra solution: ");
		while (!stack.isEmpty())
		{
			System.out.print(stack.pop());
			if (!stack.isEmpty())
				System.out.print("->");
		}
		System.out.println();
	}

	private static int getNodeIndex(List<UndirectedGraphNode> nodes, char label)
	{
		for (int i = 0; i < nodes.size(); i++)
		{
			UndirectedGraphNode one = nodes.get(i);
			if (one.label == (int) label)
				return i;
		}
		return -1;
	}

	static class Distance implements Comparable<Distance>
	{
		protected int preV;
		protected int curV;
		protected int distance;

		protected Distance(int v)
		{
			this.curV = v;
			this.preV = -1;
			this.distance = Integer.MAX_VALUE;
		}

		@Override
		public int compareTo(Distance other)
		{
			return distance - other.distance;
		}

	}
}
