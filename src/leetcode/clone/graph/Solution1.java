package leetcode.clone.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import leetcode.graph.UndirectedGraphNode;

public class Solution1 {

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;

		// BFS
		Queue<UndirectedGraphNode> nodes = new LinkedList<>();
		nodes.add(node);

		UndirectedGraphNode newRoot = new UndirectedGraphNode(node.label);
		Map<Integer, UndirectedGraphNode> clonedNodes = new HashMap<>();
		clonedNodes.put(node.label, newRoot);

		while (!nodes.isEmpty()) {

			UndirectedGraphNode one = nodes.poll();
			UndirectedGraphNode newOne = clonedNodes.get(one.label);

			for (UndirectedGraphNode neighbor : one.neighbors) {

				UndirectedGraphNode newNeighbor = clonedNodes
						.get(neighbor.label);

				if (newNeighbor == null) {

					newNeighbor = new UndirectedGraphNode(neighbor.label);
					clonedNodes.put(neighbor.label, newNeighbor);

					nodes.add(neighbor);
				}

				if (newOne.neighbors == null)
					newOne.neighbors = new ArrayList<>();

				newOne.neighbors.add(newNeighbor);
			}
		}

		return newRoot;
	}
}
