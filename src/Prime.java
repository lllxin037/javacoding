/**
 * Write a method to return first five 10 digit prime numbers
 * 
 */

public class Prime
{
	public static void main(String[] args)
	{
		int value = 1000000001;
		int count = 0;

		while (count < 5)
		{
			if (isPrime(value))
			{
				System.out.println(value);
				count++;
			}

			value++;
		}
	}

	private static boolean isPrime(int value)
	{
		int upper = (int) Math.sqrt(value);
		for (int i = 2; i < upper + 1; i++)
		{
			if (value % i == 0)
				return false;
		}

		return true;
	}
}
