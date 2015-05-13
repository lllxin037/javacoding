package leetcode.gray.code;

import java.util.ArrayList;

public class Test
{
	private static void oneCase(int n)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		ArrayList<Integer> codes = s1.grayCode(n);
		System.out.println(codes);

		System.out.print("[");
		for (int i = 0; i < codes.size(); i++)
		{
			System.out.print(Integer.toBinaryString(codes.get(i)) + ",");
		}

		System.out.print("]\n");
		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		oneCase(0);
		oneCase(1);
		oneCase(2);
		oneCase(3);
	}
}
