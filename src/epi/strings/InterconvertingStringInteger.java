package epi.strings;

public class InterconvertingStringInteger
{

	public static int toInteger(String s)
	{
		if (s == null)
			throw new IllegalArgumentException();

		String str = s.trim();
		if (s.length() == 0)
			throw new IllegalArgumentException();

		int limit = Integer.MAX_VALUE;
		boolean positive = true;
		if (str.charAt(0) == '-')
		{
			positive = false;
			limit = -Integer.MIN_VALUE;
			if (str.length() == 1)
				throw new IllegalArgumentException();
		}

		// make sure value * 10 won't be overflow
		int multmin = limit / 10;

		int value = 0;
		int index = (positive ? 0 : 1);

		// only check valid digits and stops
		while (index < str.length() && str.charAt(index) >= '0'
				&& str.charAt(index) <= '9')
		{
			if (positive && value > multmin)
				throw new IllegalArgumentException();

			value = value * 10;
			int digit = (str.charAt(index) - '0');
			if (value > limit - digit)
				throw new IllegalArgumentException();
			value += digit;
			index++;
		}

		// not a valid value.
		if (index == (positive ? 0 : 1))
			throw new IllegalArgumentException();

		return (positive ? value : -value);
	}

	public static String toString(int n)
	{
		// handle in positive, 2147483648 is larger than MAX_VALUE
		if (n == Integer.MIN_VALUE)
			return "-2147483648";

		StringBuilder sb = new StringBuilder();

		boolean negative = (n < 0);
		if (negative)
			n = -n;

		while (n > 0)
		{
			int next = n / 10;
			int digit = n - (next << 3) - (next << 1) + '0';
			sb.append((char) digit);

			n = next;
		}

		if (sb.length() == 0)
			return "0";
		
		if (negative)
			sb.append('-');

		return sb.reverse().toString();
	}

	public static void main(String[] args)
	{
		System.out.println(toInteger("473"));
		System.out.println(toInteger("2147483647"));
		System.out.println(toInteger("-2147483648"));

		System.out.println(toInteger(" -214abc   "));
		System.out.println(toInteger("0"));

		// overflow
		try
		{
			toInteger("2147483648");
		}
		catch (IllegalArgumentException e)
		{
			System.out.println("2147483648 is overflow");
		}

		// overflow
		try
		{
			toInteger("-2147483649");
		}
		catch (IllegalArgumentException e)
		{
			System.out.println("-2147483649 is overflow");
		}

		System.out.println("**********************");

		System.out.println(toString(473));
		System.out.println(toString(2147483647));
		System.out.println(toString(-2147483648));
		System.out.println(toString(-214));
		System.out.println(toString(0));
	}

}
