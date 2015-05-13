package leetcode.simplify.path;

public class Test
{

	private static void oneCase(String path)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		System.out.println(s1.simplifyPath(path));

		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		/**/
		oneCase("/");
		oneCase("/.");
		oneCase("/home");
		oneCase("/home/");
		oneCase("/a/./b/../../c/");
		oneCase("/../");
		oneCase("/home//foo/");
		oneCase("/home/");
	}

}
