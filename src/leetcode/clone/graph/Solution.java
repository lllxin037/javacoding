package leetcode.clone.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import leetcode.graph.UndirectedGraphNode;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list
 * of its neighbors.
 * 
 * 
 * OJ's undirected graph serialization: Nodes are labeled uniquely.
 * 
 * We use # as a separator for each node, and , as a separator for node label
 * and each neighbor of the node. As an example, consider the serialized graph
 * {0,1,2#1,2#2,2}.
 * 
 * The graph has a total of three nodes, and therefore contains three parts as
 * separated by #.
 * 
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2. Second node
 * is labeled as 1. Connect node 1 to node 2. Third node is labeled as 2.
 * Connect node 2 to node 2 (itself), thus forming a self-cycle. Visually, the
 * graph looks like the following:
 * 
 * 
 * <pre>
 *        1
 *       / \
 *      /   \
 *     0 --- 2
 *          / \
 *          \_/
 * </pre>
 */

/**
 * Definition for undirected graph.
 */
public class Solution
{
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node)
	{
		return cloneBSF(node);
	}

	private UndirectedGraphNode cloneBSF(UndirectedGraphNode root)
	{
		if (root == null)
			return null;

		Deque<UndirectedGraphNode> que = new ArrayDeque<UndirectedGraphNode>();
		que.addLast(root);

		Map<Integer, UndirectedGraphNode> visited = new HashMap<Integer, UndirectedGraphNode>();
		UndirectedGraphNode newRoot = new UndirectedGraphNode(root.label);
		visited.put(root.label, newRoot);

		while (!que.isEmpty())
		{
			UndirectedGraphNode one = que.removeFirst();
			UndirectedGraphNode newOne = visited.get(one.label);
			for (UndirectedGraphNode neighbor : one.neighbors)
			{
				if (visited.containsKey(neighbor.label))
				{
					newOne.neighbors.add(visited.get(neighbor.label));
				}
				else
				{
					UndirectedGraphNode newNeighbor = new UndirectedGraphNode(neighbor.label);
					visited.put(neighbor.label, newNeighbor);					
					newOne.neighbors.add(newNeighbor);
					
					que.add(neighbor);
				}
			}
		}

		return newRoot;
	}
}