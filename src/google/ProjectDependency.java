package google;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * You are given a text file that has list of dependencies between (any) two
 * projects in the source code repository. Write an algorithm to determine the
 * build order ie. which project needs to be build first, followed by which
 * project..based on the dependencies. Bonus point: If you can detect any
 * circular dependencies and throw an exception if found.
 * 
 * <pre>
 * EX: ProjectDependencies.txt 
 * a -> b (means 'a' depends on 'b'..so 'b' needs to be built first and then 'a') 
 * b -> c 
 * b -> d 
 * c -> d 
 * 
 * Then the build order can be 
 * 
 * d , c, b, a in that order
 * </pre>
 * 
 */

public class ProjectDependency
{
	// assume project can be a to z only.
	private static Pattern p = Pattern.compile("([a-z]) -> ([a-z])\\s*");

	public static void main(String[] args) throws Exception
	{
		File f = new File("ProjectDependencies.txt");
		Scanner scan = new Scanner(f);

		// internally convert a - z to 1 - 26
		int[] inDegrees = new int[26 + 1];
		Arrays.fill(inDegrees, -1);

		// edges. key is one vertex like project1. Values are the end vertex.
		// Same word, values in the maps are projects that depend on the key
		// project

		Map<Integer, List<Integer>> edges = new HashMap<Integer, List<Integer>>();
		// setup the adjacent matrix;
		while (scan.hasNextLine())
		{
			String line = scan.nextLine();
			Matcher m = p.matcher(line);

			boolean b = m.matches();
			if (!b)
				break;

			int p1 = 0;
			int p2 = 0;

			String str = m.group(1);
			p1 = str.charAt(0) - 'a' + 1;
			str = m.group(2);
			p2 = str.charAt(0) - 'a' + 1;

			if (inDegrees[p1] == -1)
				inDegrees[p1] = 0;

			inDegrees[p1]++;
			inDegrees[p2] = 0;

			List<Integer> projectNames = edges.get(p2);
			if (projectNames == null)
			{
				projectNames = new ArrayList<Integer>();
				edges.put(p2, projectNames);
			}
			projectNames.add(p1);

			projectNames = edges.get(p1);
			if (projectNames == null)
			{
				projectNames = new ArrayList<Integer>();
				edges.put(p1, projectNames);
			}
		}

		// calculate from edges and inDegrees.

		PriorityQueue<Integer> que = new PriorityQueue<Integer>();
		// ignore those are -1;
		for (int i = 1; i < inDegrees.length; i++)
		{
			if (inDegrees[i] == 0)
				que.offer(i);
		}

		List<Integer> res = new ArrayList<Integer>();
		Set<Integer> visited = new HashSet<Integer>();

		while (!que.isEmpty())
		{
			int one = que.poll();
			res.add(one);

			visited.add(one);

			for (Integer vertex : edges.get(one))
			{
				if (visited.contains(vertex))
					throw new IllegalArgumentException();

				inDegrees[vertex]--;
				if (inDegrees[vertex] == 0)
					que.offer(vertex);
			}
		}

		for (int i = 0; i < res.size(); i++)
		{
			System.out.print((char) (res.get(i) + 'a' - 1)
					+ ((i < res.size() - 1) ? "  -->  " : ""));
		}

	}
}
