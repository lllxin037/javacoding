package leetcode.simplify.path;

import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * <pre>
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * 
 * 
 * click to show corner cases.
 * Corner Cases:
 * 
 *     Did you consider the case where path = "/../"?
 *     In this case, you should return "/".
 *     Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 *     In this case, you should ignore redundant slashes and return "/home/foo".
 * </pre>
 * 
 */

public class Solution
{
	public String simplifyPath(String path)
	{
		if (path == null || path.isEmpty() || path.length() == 1)
			return path;

		Stack<String> paths = new Stack<String>();

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < path.length(); i++)
		{
			char c = path.charAt(i);
			if (c != '/')
			{
				sb.append(c);
				if (i != path.length() - 1)
					continue;
			}

			// handle one item.

			if (sb.length() == 0)
				continue;

			if (".".equalsIgnoreCase(sb.toString()))
			{
				sb.setLength(0);
				continue;
			}

			if ("..".equalsIgnoreCase(sb.toString()))
			{
				if (!paths.isEmpty())
					paths.pop();

				sb.setLength(0);
				continue;
			}

			paths.add(sb.toString());
			sb.setLength(0);
		}

		sb.setLength(0);
		if (paths.isEmpty())
			return "/";
		else
		{
			while (!paths.isEmpty())
			{
				sb.insert(0, "/" + paths.pop());
			}
		}
		return sb.toString();
	}
}