package graph;

import java.util.ArrayList;
import java.util.List;

class UndirectedGraphNode
{
	protected int label;
	
	
	protected List<UndirectedGraphNode> neighbors;
	protected List<Integer> weight;
	
	UndirectedGraphNode(int x)
	{
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}
