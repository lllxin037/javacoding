package leetcode.two.sum.iii;

public class Test
{
	private static void oneCase()
	{
		// * add(1); add(3); add(5);
		// * find(4) -> true
		// * find(7) -> false

		TwoSum s = new TwoSum();
		s.add(1);
		s.add(3);
		s.add(5);

		System.out.println(s.find(4));
		System.out.println(s.find(7));

	}

	public static void main(String args[])
	{
		oneCase();
	}
}
