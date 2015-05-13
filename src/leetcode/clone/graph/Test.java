package leetcode.clone.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import leetcode.graph.UndirectedGraphNode;

public class Test
{
	private static UndirectedGraphNode onecase(String str)
	{
		Solution1 s = new Solution1();		
		
		UndirectedGraphNode original = createGraphNode(str);
		UndirectedGraphNode cloned =  s.cloneGraph(original);
		
		System.out.println("*********************");
		dumpGraph(original);
		dumpGraph(cloned);
		System.out.println("*********************\n\n\n\n");
		
		return cloned;
	}
		
	private static void dumpGraph(UndirectedGraphNode node)
	{
		Set<Integer> visitedNodes = new HashSet<Integer>();
		
		Stack<UndirectedGraphNode> nodeStack = new Stack<UndirectedGraphNode>();
		if (node == null)
			return;
		
		nodeStack.push(node);
		
		System.out.println("#####################");
		
		while (!nodeStack.isEmpty())
		{
			UndirectedGraphNode one = nodeStack.pop();
			
			if (visitedNodes.contains(Integer.valueOf(one.label)))
				continue;
			
			System.out.print(one.label + "(" + one.toString() + ")");			
			visitedNodes.add(Integer.valueOf(one.label));
			
			for (int i = 0; i < one.neighbors.size(); i++)
			{
				System.out.print(", " + one.neighbors.get(i).label + "(" + one.neighbors.get(i).toString() + ")");
			}
			
			System.out.println("#");
			for (int i = one.neighbors.size() - 1; i >=0 ; i --)
			{
				nodeStack.push(one.neighbors.get(i));
			}
		}
		
		System.out.println("#####################");
	}
	
	private static UndirectedGraphNode createGraphNode(String s)
	{
		//{0,1,2#1,2#2,2}
		
		Integer headNode = null; 
		
		String[] array = s.split("#");
		
		Map<Integer, UndirectedGraphNode> newNodes = new HashMap<Integer, UndirectedGraphNode>();
		
		for (int i = 0; i < array.length; i++)
		{
			String one = array[i];			
			String[] values = one.split(",");
			
			if (values[0].isEmpty())
			{
				return null;
			}
			if (i == 0)
			{
				headNode = Integer.valueOf(values[0]);
			}
			UndirectedGraphNode newNode = newNodes.get(Integer.valueOf(values[0]));
			if (newNode == null)
			{
				newNode = new UndirectedGraphNode(Integer.valueOf(values[0]).intValue());
				newNodes.put(Integer.valueOf(values[0]), newNode);
			}
			
			if (values.length > 1)
			{
				// handle neighbours
				for (int j = 1; j < values.length; j++)
				{
					String neightbor = values[j];
					UndirectedGraphNode newNeighbor = newNodes.get(Integer.valueOf(neightbor));
					if (newNeighbor == null)
					{
						newNeighbor= new UndirectedGraphNode(Integer.valueOf(neightbor).intValue());
						newNodes.put(Integer.valueOf(neightbor), newNeighbor);
					}			
					newNode.neighbors.add(newNeighbor);
				}
			}
		}
		
		return newNodes.get(headNode);
	}
	public static void main(String[] args)
	{
		onecase("");
		onecase("0") ;
		onecase("0,0") ;
		onecase("0,0,0");		
		onecase("0,1,2#1,2#2,2");
		
		onecase("0,1,5#1,2,5#2,3#3,4,4#4,5,5#5");
	}
}
