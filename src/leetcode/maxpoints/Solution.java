package leetcode.maxpoints;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import leetcode.maxpoints.SolutionTest.Point;

/**
 * Definition for a point.
 * 
 * 
 */
public class Solution
{
	static class Line
	{
		private int a, b, c;

		Line(Point p1, Point p2)
		{
			a = p1.y - p2.y;
			b = p1.x - p2.x;
			c = p2.x * p1.y - p1.x * p2.y;
			int gcd = gcd();
			a = a / gcd;
			b = b / gcd;
			c = c / gcd;

			if (a < 0 || a == 0 && b < 0)
			{ // normalized a to be non-negative or b to be non-negative when a
				// is 0
				a = -a;
				b = -b;
				c = -c;
			}
		}

		public int hashCode()
		{
			return this.a ^ this.b * this.c;
		}

		public int gcd()
		{
			BigInteger int1 = new BigInteger(Integer.toString(a));
			BigInteger int2 = new BigInteger(Integer.toString(b));
			BigInteger int3 = new BigInteger(Integer.toString(c));
			BigInteger gcd0 = int1.gcd(int2);
			BigInteger gcd = gcd0.gcd(int3);
			return gcd.intValue();
		}

		@Override
		public boolean equals(Object obj)
		{
			if (!(obj instanceof Line))
				return false;

			Line l1 = (Line) obj;
			return ( (l1.a == a) && (l1.b == b) &&  (l1.c == c) );

		}
	}

	public int maxPoints(Point[] points)
	{
		if (points == null)
			return 0;

		int maxCount = 0;
		for (int i = 0; i < points.length; i++)
		{
			int oneMaxCount = 1;
			int sameCount = 0;
			
			Point one = points[i];
			
			Map<Line, Integer> lines = new HashMap<Line, Integer>();
			
			for (int j = i + 1; j < points.length; j++)
			{
				Point two = points[j];

				if (one.x == two.x && one.y == two.y)
				{
					sameCount++;
					continue;
				}

				Line current = new Line(one, two);
				Integer countObj = lines.get(current);

				// for the first time, the initial value should be 2.
				if (countObj == null)
					countObj = Integer.valueOf(2);
				else
					countObj = Integer.valueOf(countObj.intValue() + 1);
				
				lines.put(current, countObj);
				oneMaxCount = Math.max(oneMaxCount, countObj.intValue());
			}
			
			maxCount = Math.max(maxCount, oneMaxCount + sameCount);
		}

		return maxCount;
	}
}