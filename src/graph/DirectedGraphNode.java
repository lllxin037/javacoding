package graph;

import java.util.ArrayList;
import java.util.List;

class DirectedGraphNode
{
	protected int label;
	protected List<DirectedGraphNode> next;
	protected List<Integer> weight;
	
	DirectedGraphNode(int x)
	{
		label = x;
		next = new ArrayList<DirectedGraphNode>();
	}
}
