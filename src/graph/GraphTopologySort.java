package graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * *
 * 
 * <pre>
 * Given graph :
 * 
 * C1 → C3 ← C2
 * ↓    ↓    ↓
 * C8    C4   C5
 * ↓    ↓    ↓
 * C9 → C7 ← C6
 * 
 * </pre>
 * 
 * The graph doesn't have the loop.
 * 
 */

public class GraphTopologySort
{
	public static void topologySort(Map<Integer, DirectedGraphNode> maps)
	{
		int[] inDegrees = new int[maps.size()];
		Collection<DirectedGraphNode> nodes = maps.values();

		getInDegrees(nodes, inDegrees);

		boolean[] visited = new boolean[maps.size()];
		Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
		for (int i = 0; i < inDegrees.length; i++)
		{
			if (inDegrees[i] == 0)
				queue.add(maps.get(i + 1));
		}

		List<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>(
				maps.size());
		while (!queue.isEmpty())
		{
			DirectedGraphNode one = queue.poll();
			res.add(one);
			visited[one.label - 1] = true;

			for (DirectedGraphNode next : one.next)
			{
				if (visited[next.label - 1])
					break;

				if (--inDegrees[next.label - 1] == 0)
					queue.offer(next);
			}
		}

		for (DirectedGraphNode one : res)
			System.out.print(one.label + "   ");

		System.out.println();
	}

	private static void getInDegrees(Collection<DirectedGraphNode> nodes,
			int[] inDegrees)
	{
		for (DirectedGraphNode node : nodes)
		{
			if (node.next == null || node.next.isEmpty())
				continue;

			for (DirectedGraphNode next : node.next)
			{
				int index = next.label - 1;
				inDegrees[index]++;
			}
		}

	}

	public static void topologySortDFS(Map<Integer, DirectedGraphNode> maps)
	{
		Set<Integer> visited = new HashSet<Integer>();
		List<Integer> sorted = new ArrayList<Integer>();

		for (DirectedGraphNode node : maps.values())
			deepFirstTravel(node, visited, sorted);

		Collections.reverse(sorted);
		System.out.println(sorted);
	}

	private static void deepFirstTravel(DirectedGraphNode node,
			Set<Integer> visited, List<Integer> sorted)
	{
		if (node == null || visited.contains(node.label))
			return;

		visited.add(node.label);
		if (node.next != null || !node.next.isEmpty())
		{
			for (DirectedGraphNode next : node.next)
				deepFirstTravel(next, visited, sorted);
		}

		sorted.add(node.label);
	}

	private static void createGraph(Map<Integer, DirectedGraphNode> maps)
	{
		DirectedGraphNode node1 = new DirectedGraphNode(1);
		DirectedGraphNode node2 = new DirectedGraphNode(2);
		DirectedGraphNode node3 = new DirectedGraphNode(3);
		DirectedGraphNode node4 = new DirectedGraphNode(4);
		DirectedGraphNode node5 = new DirectedGraphNode(5);
		DirectedGraphNode node6 = new DirectedGraphNode(6);
		DirectedGraphNode node7 = new DirectedGraphNode(7);
		DirectedGraphNode node8 = new DirectedGraphNode(8);
		DirectedGraphNode node9 = new DirectedGraphNode(9);

		maps.put(1, node1);
		maps.put(2, node2);
		maps.put(3, node3);
		maps.put(4, node4);
		maps.put(5, node5);
		maps.put(6, node6);
		maps.put(7, node7);
		maps.put(8, node8);
		maps.put(9, node9);

		node1.next = new ArrayList<DirectedGraphNode>();
		node1.next.add(node3);
		node1.next.add(node8);

		node2.next = new ArrayList<DirectedGraphNode>();
		node2.next.add(node3);
		node2.next.add(node5);

		node3.next = new ArrayList<DirectedGraphNode>();
		node3.next.add(node4);

		node4.next = new ArrayList<DirectedGraphNode>();
		node4.next.add(node7);

		node5.next = new ArrayList<DirectedGraphNode>();
		node5.next.add(node6);

		node6.next = new ArrayList<DirectedGraphNode>();
		node6.next.add(node7);

		node8.next = new ArrayList<DirectedGraphNode>();
		node8.next.add(node9);

		node9.next = new ArrayList<DirectedGraphNode>();
		node9.next.add(node7);
	}

	public static void main(String[] args)
	{
		Map<Integer, DirectedGraphNode> maps = new HashMap<Integer, DirectedGraphNode>();
		createGraph(maps);
		topologySort(maps);

		topologySortDFS(maps);
	}
}
