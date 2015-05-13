package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 
 *
 */

public class MinimumSpanningTree
{
	private static int[][] adjacentMatrix1 = new int[][]
	{
	{ 'S', 'B', 8 },
	{ 'S', 'E', 3 },
	{ 'E', 'J', 6 },
	{ 'E', 'F', 2 },
	{ 'K', 'L', 1 },
	{ 'F', 'B', 3 },
	{ 'B', 'A', 4 },
	{ 'F', 'K', 1 },
	{ 'F', 'G', 6 },
	{ 'K', 'L', 1 },
	{ 'G', 'A', 1 },
	{ 'A', 'C', 2 },
	{ 'G', 'H', 7 },
	{ 'L', 'G', 1 },
	{ 'L', 'M', 3 },
	{ 'C', 'D', 7 },
	{ 'C', 'H', 2 },
	{ 'H', 'I', 2 },
	{ 'H', 'M', 1 },
	{ 'M', 'T', 3 },
	{ 'I', 'D', 5 },
	{ 'K', 'J', 5 },
	{ 'I', 'T', 2 } };

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

	public static Edge[] prim(List<UndirectedGraphNode> nodes)
	{
		int n = nodes.size();
		PriorityQueue<Edge> edges = new PriorityQueue<Edge>(n - 1);

		UndirectedGraphNode node = nodes.get(0);
		for (int i = 0; node.neighbors != null && i < node.neighbors.size(); i++)
			edges.add(new Edge(node, node.neighbors.get(i)));

		Edge[] ret = new Edge[n - 1];
		int edgeCounter = 0;

		Set<Integer> visited = new HashSet<Integer>();
		visited.add(node.label);

		while (edgeCounter < n && !edges.isEmpty())
		{
			Edge one = edges.poll();
			if (visited.contains(one.to.label))
				continue;

			visited.add(one.to.label);
			ret[edgeCounter++] = one;
			// add all edges within tonode.

			node = one.to;
			for (int i = 0; node.neighbors != null && i < node.neighbors.size(); i++)
			{
				// can't add already visit vertex, this may cause cycle
				if (!visited.contains(node.neighbors.get(i).label))
					edges.add(new Edge(node, node.neighbors.get(i)));
			}
		}

		return ret;
	}

	// search all edges, each time choose the least weight. If both nodes have
	// been visited, ignore it.
	// otherwise, add one or two nodes into visited. Stop when all node visited.
	// To use this way must union nodes. consider the case n1 --- 1 --- n2, n3
	// ---- 1 ---- n4. But still two partition -- subtree here. Need to union
	// them to one tree.

	// use min heap to choose edges.

	// TODO if the same edge is saved in both n1 and n2, treat them as the same
	// one. Don't have such case in this example since only list one edge in
	// UndirectedGraphNode

	// http://www.blogjava.net/javacap/archive/2007/12/14/167884.html
	public static Edge[] kruskal(List<UndirectedGraphNode> nodes)
	{
		int n = nodes.size();
		PriorityQueue<Edge> edges = new PriorityQueue<Edge>();
		for (UndirectedGraphNode node : nodes)
		{
			for (int i = 0; node.neighbors != null && i < node.neighbors.size(); i++)
				edges.add(new Edge(node, node.neighbors.get(i)));
		}

		ParentTree ptree = new ParentTree(n);

		Edge[] ret = new Edge[n - 1];
		int edgeCount = 0;
		while (ptree.numPartions() > 1)
		{
			Edge edge = edges.poll();
			if (ptree.union(getNodeIndex(nodes, edge.from.label),
					getNodeIndex(nodes, edge.to.label)))
				ret[edgeCount++] = edge;
		}

		return ret;
	}

	private static int getNodeIndex(List<UndirectedGraphNode> nodes, int label)
	{
		for (int i = 0; i < nodes.size(); i++)
		{
			UndirectedGraphNode one = nodes.get(i);
			if (one.label == label)
				return i;
		}
		return -1;
	}

	public static void main(String[] args)
	{
		Map<Integer, UndirectedGraphNode> map = createUnDirectedGraph(adjacentMatrix1);
		List<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
		nodes.addAll(map.values());

		Edge[] edges = prim(nodes);
		for (Edge edge : edges)
			System.out.println(edge);
		System.out.println("*************************");

		edges = kruskal(nodes);
		for (Edge edge : edges)
			System.out.println(edge);
		System.out.println("*************************");

	}

	private static class Edge implements Comparable<Edge>
	{
		private UndirectedGraphNode from;
		private UndirectedGraphNode to;

		Edge(UndirectedGraphNode from, UndirectedGraphNode to)
		{
			this.from = from;
			this.to = to;
		}

		public int compareTo(Edge another)
		{
			return Integer.valueOf(getWeight()).compareTo(
					Integer.valueOf(another.getWeight()));
		}

		// the edge can from -> to, as well as to -> from
		private int getWeight()
		{
			for (int i = 0; from.neighbors != null && i < from.neighbors.size(); i++)
			{
				UndirectedGraphNode node = from.neighbors.get(i);
				if (node == to)
					return from.weight.get(i);
			}

			for (int i = 0; to.neighbors != null && i < to.neighbors.size(); i++)
			{
				UndirectedGraphNode node = to.neighbors.get(i);
				if (node == from)
					return to.weight.get(i);
			}

			return -1;
		}

		public String toString()
		{
			return (char) (from.label) + "    to   " + (char) (to.label)
					+ "  weight: " + getWeight();
		}
	}

	static class ParentTree
	{
		private static class PTreeNode
		{
			int parentIndex = -1;
			int numChildren = 0;// only make sense in root

			void setParent(int i)
			{

				parentIndex = i;

			}
		}

		PTreeNode[] nodes;
		int numPartions;

		public ParentTree(int numNodes)
		{
			nodes = new PTreeNode[numNodes];
			numPartions = numNodes;
			for (int i = 0; i < numNodes; i++)
			{
				nodes[i] = new PTreeNode();
				nodes[i].parentIndex = -1;// means root

			}

		}

		/**
		 * use path compress
		 * 
		 * @param i
		 * @return
		 */
		public int find(int i)
		{
			if (nodes[i].parentIndex == -1)
			{
				return i;
			}
			else
			{
				nodes[i].setParent(find(nodes[i].parentIndex));// compress the
																// path
				return nodes[i].parentIndex;
			}
		}

		public int numPartions()
		{
			return numPartions;
		}

		public boolean union(int i, int j)
		{
			int pi = find(i);
			int pj = find(j);
			if (pi != pj)
			{
				if (nodes[pi].numChildren > nodes[pj].numChildren)
				{
					nodes[pj].setParent(pi);
					nodes[pj].numChildren += nodes[pi].numChildren;
					nodes[pi].numChildren = 0;

				}
				else
				{
					nodes[pi].setParent(pj);
					nodes[pi].numChildren += nodes[pj].numChildren;
					nodes[pj].numChildren = 0;
				}
				numPartions--;
				return true;
			}
			return false;
		}

	}
}
