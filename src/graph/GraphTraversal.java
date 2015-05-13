package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * <pre>
 * For example, we have a graph:
 * 0->1 ->2
 * |  ^   |
 * v  |   v
 * 3  4   5
 * |  ^   |
 * v  |   v
 * 6->7 <-8
 * </pre>
 * 
 * here ,all weight is 0, its a DAG(Directed Acyclic Graph)
 */

public class GraphTraversal
{

	private static DirectedGraphNode createGraph()
	{
		DirectedGraphNode node0 = new DirectedGraphNode(0);
		DirectedGraphNode node1 = new DirectedGraphNode(1);
		DirectedGraphNode node2 = new DirectedGraphNode(2);
		DirectedGraphNode node3 = new DirectedGraphNode(3);
		DirectedGraphNode node4 = new DirectedGraphNode(4);
		DirectedGraphNode node5 = new DirectedGraphNode(5);
		DirectedGraphNode node6 = new DirectedGraphNode(6);
		DirectedGraphNode node7 = new DirectedGraphNode(7);
		DirectedGraphNode node8 = new DirectedGraphNode(8);

		node0.next = new ArrayList<DirectedGraphNode>();
		node0.next.add(node1);
		node0.next.add(node3);

		node1.next = new ArrayList<DirectedGraphNode>();
		node1.next.add(node2);

		node2.next = new ArrayList<DirectedGraphNode>();
		node2.next.add(node5);

		node3.next = new ArrayList<DirectedGraphNode>();
		node3.next.add(node6);

		node4.next = new ArrayList<DirectedGraphNode>();
		node4.next.add(node1);

		node5.next = new ArrayList<DirectedGraphNode>();
		node5.next.add(node8);

		node6.next = new ArrayList<DirectedGraphNode>();
		node6.next.add(node7);

		node7.next = new ArrayList<DirectedGraphNode>();
		node7.next.add(node4);

		node8.next = new ArrayList<DirectedGraphNode>();
		node8.next.add(node7);

		return node0;
	}

	public static void deepFirstTravel(DirectedGraphNode source,
			Set<Integer> visited)
	{
		if (source == null || visited.contains(source.label))
			return;

		System.out.print(source.label + "    ");
		visited.add(source.label);
		if (source.next != null || !source.next.isEmpty())
		{
			for (DirectedGraphNode next : source.next)
				deepFirstTravel(next, visited);
		}
	}

	public static void breathFirstTravel(DirectedGraphNode source)
	{
		Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
		queue.add(source);

		Set<Integer> visited = new HashSet<Integer>();
		while (!queue.isEmpty())
		{
			DirectedGraphNode one = queue.remove();
			if (visited.contains(one.label))
				continue;

			System.out.print(one.label + "    ");
			visited.add(one.label);

			if (one.next != null || !one.next.isEmpty())
			{
				for (DirectedGraphNode next : one.next)
					queue.add(next);
			}
		}

	}

	public static void main(String[] args)
	{
		DirectedGraphNode node = createGraph();
		Set<Integer> visited = new HashSet<Integer>();
		deepFirstTravel(node, visited);
		System.out.println();
		System.out.println("******************************");

		breathFirstTravel(node);
		System.out.println();
		System.out.println("******************************");

	}
}
