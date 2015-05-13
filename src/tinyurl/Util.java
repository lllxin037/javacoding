package tinyurl;

public class Util
{
	/**
	 * Hashcode range is between MAX_VALUE and MIN_VALUE
	 * 
	 * @param hashcode
	 * @return
	 */

	public static long toShortURLRangeHash(long hashcode)
	{
		if (hashcode < 0)
			return ((long) -hashcode + Integer.MAX_VALUE);

		return hashcode;
	}

	/**
	 * HashCode range is between 0 and MAX_VALUE
	 * 
	 * @param hashcode
	 * @return
	 */

	public static int toConsistentHash(long hashcode)
	{
		if (hashcode > Integer.MAX_VALUE)
			return (int) -(hashcode - Integer.MAX_VALUE);

		return (int) hashcode;
	}

}
