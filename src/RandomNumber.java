import java.util.Random;

/**
 * How would you implement a random number generator that generates a random
 * integer i between a and b, inclusive, given a random number generator that
 * produces either zero or one with equal probability? All generated values
 * should be equally likely.
 * 
 */

public class RandomNumber
{
	private int generateOneOrZero()
	{
		Random r = new Random();
		return r.nextInt(2);
	}

	/**
	 * @param a
	 * @param b
	 */

	public int generate(int a, int b)
	{
		if (a > b)
			return generate(b, a);

		// the value is in the scope of [0, a-b]. Total number will be a-b+ 1
		int max = b - a;

		// get the bit count that exactly samller than max
		int bitCount = 0;
		for (; (1 << bitCount) < max; bitCount++)
			;

		int v = 0;
		do
		{
			v = 0;
			for (int i = 0; i < bitCount; i++)
			{
				int oneBit = generateOneOrZero();
				v = ((v << 1) | oneBit);
			}
		}
		while (v > max);

		return v + a;
	}

	public static void main(String[] args)
	{
		RandomNumber random = new RandomNumber();
		System.out.println(random.generate(10, 20));
		System.out.println(random.generate(10, 20));
		System.out.println(random.generate(10, 20));
		System.out.println(random.generate(10, 20));
		System.out.println(random.generate(10, 20));
		
		//System.out.println(random.generate(10, 42));

	}
}
