/**
 * 
 * Output top N positive integer in string comparison order. For example, let's
 * say N=1000, then you need to output in string comparison order as below: 1,
 * 10, 100, 1000, 101, 102, ... 109, 11, 110, ...
 * 
 */

public class PrintIntegers
{

	public static void main(String[] args)
	{
		// solution1(1000);
		solution2(1000);
	}

	public static void solution1(int N)
	{
		for (int i = 1; i < 10; i++)
			print(i, N);
	}

	private static void print(int s, int max)
	{
		if (s > max)
			return;

		System.out.println(s);
		for (int i = 0; i < 10; i++)
			print(s * 10 + i, max);
	}

	public static void solution2(int N)
	{
		int value = 1;

		int counter = 0;
		while (counter < N)
		{
			counter++;
			System.out.println(value);
			if (value * 10 <= N)
				value = value * 10;
			else
			{
				if (value + 1 > N)
					value = value / 10 + 1;
				else
				{
					if ((value + 1) % 10 == 0)
					{
						value++;
						while (value % 10 == 0)
							value = value / 10;
					}
					else
						value++;
				}
			}
		}
	}
}
