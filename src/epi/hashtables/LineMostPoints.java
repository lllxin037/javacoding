package epi.hashtables;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Let P be a set of n points in the plane. Each point has integer coordinates.
 * Design an efficient algorithm for computing a line that contains the maximum
 * number of points in P.
 * 
 */

public class LineMostPoints
{

	public static Line findLineWithMostPoints(List<Point> P)
	{
		if (P == null || P.isEmpty())
			return null;

		Map<Line, Integer> table = new HashMap<Line, Integer>();

		int maxCount = 0;
		Line maxPoints = null;

		for (int i = 0; i < P.size(); i++)
		{
			for (int j = i + 1; j < P.size(); j++)
			{
				Line newLine = new Line(P.get(i), P.get(j));
				System.out.println(newLine.hashCode());

				Integer counter = table.get(newLine);
				if (counter == null)
					counter = 0;

				counter++;
				table.put(newLine, counter);

				if (counter > maxCount)
					maxPoints = newLine;

				maxCount = Math.max(maxCount, counter);
			}
		}

		System.out.println("number of max points: " + maxCount);
		return maxPoints;
	}

	public static void main(String args[])
	{
		Point[] points =
		{ new Point(1, 1), new Point(2, 2), new Point(3, 3) };
		System.out.println(findLineWithMostPoints(Arrays.asList(points)));

		points = new Point[]
		{ new Point(0, 0), new Point(1, 1), new Point(0, 0) };
		System.out.println(findLineWithMostPoints(Arrays.asList(points)));

		points = new Point[]
		{ new Point(0, 0) };
		System.out.println(findLineWithMostPoints(Arrays.asList(points)));

		points = new Point[]
		{ new Point(0, 0), new Point(0, 1) };
		System.out.println(findLineWithMostPoints(Arrays.asList(points)));

		points = new Point[]
		{ new Point(40, -23), new Point(9, 138), new Point(429, 115),
				new Point(50, -17), new Point(-3, 80), new Point(-10, 33),
				new Point(5, -21), new Point(-3, 80), new Point(-6, -65),
				new Point(-18, 26), new Point(-6, -65), new Point(5, 72),
				new Point(0, 77), new Point(-9, 86), new Point(10, -2),
				new Point(-8, 85), new Point(21, 130), new Point(18, -6),
				new Point(-18, 26), new Point(-1, -15), new Point(10, -2),
				new Point(8, 69), new Point(-4, 63), new Point(0, 3),
				new Point(-4, 40), new Point(-7, 84), new Point(-8, 7),
				new Point(30, 154), new Point(16, -5), new Point(6, 90),
				new Point(18, -6), new Point(5, 77), new Point(-4, 77),
				new Point(7, -13), new Point(-1, -45), new Point(16, -5),
				new Point(-9, 86), new Point(-16, 11), new Point(-7, 84),
				new Point(1, 76), new Point(3, 77), new Point(10, 67),
				new Point(1, -37), new Point(-10, -81), new Point(4, -11),
				new Point(-20, 13), new Point(-10, 77), new Point(6, -17),
				new Point(-27, 2), new Point(-10, -81), new Point(10, -1),
				new Point(-9, 1), new Point(-8, 43), new Point(2, 2),
				new Point(2, -21), new Point(3, 82), new Point(8, -1),
				new Point(10, -1), new Point(-9, 1), new Point(-12, 42),
				new Point(16, -5), new Point(-5, -61), new Point(20, -7),
				new Point(9, -35), new Point(10, 6), new Point(12, 106),
				new Point(5, -21), new Point(-5, 82), new Point(6, 71),
				new Point(-15, 34), new Point(-10, 87), new Point(-14, -12),
				new Point(12, 106), new Point(-5, 82), new Point(-46, -45),
				new Point(-4, 63), new Point(16, -5), new Point(4, 1),
				new Point(-3, -53), new Point(0, -17), new Point(9, 98),
				new Point(-18, 26), new Point(-9, 86), new Point(2, 77),
				new Point(-2, -49), new Point(1, 76), new Point(-3, -38),
				new Point(-8, 7), new Point(-17, -37), new Point(5, 72),
				new Point(10, -37), new Point(-4, -57), new Point(-3, -53),
				new Point(3, 74), new Point(-3, -11), new Point(-8, 7),
				new Point(1, 88), new Point(-12, 42), new Point(1, -37),
				new Point(2, 77), new Point(-6, 77), new Point(5, 72),
				new Point(-4, -57), new Point(-18, -33), new Point(-12, 42),
				new Point(-9, 86), new Point(2, 77), new Point(-8, 77),
				new Point(-3, 77), new Point(9, -42), new Point(16, 41),
				new Point(-29, -37), new Point(0, -41), new Point(-21, 18),
				new Point(-27, -34), new Point(0, 77), new Point(3, 74),
				new Point(-7, -69), new Point(-21, 18), new Point(27, 146),
				new Point(-20, 13), new Point(21, 130), new Point(-6, -65),
				new Point(14, -4), new Point(0, 3), new Point(9, -5),
				new Point(6, -29), new Point(-2, 73), new Point(-1, -15),
				new Point(1, 76), new Point(-4, 77), new Point(6, -29) };

		System.out.println(findLineWithMostPoints(Arrays.asList(points)));
	}

	/**
	 * // Line function of two points , a and b, and the equation is
	 * 
	 * <pre>
	 * slope: 
	 * (y - a.y)/(x- a.x) = (b.y - a.y)/(b.x - a.x) ==>
	 * y - a.y = (b.y - a.y) * (x - a.x) /(b.x - a.x) ==>
	 * y = (b.y - a.y) * (x - a.x) /(b.x - a.x) + a.y ==>
	 * y = (b.y*x - b.y*a.x - a.y*x + a.y* a.x) / (b.x - a.x) + a.y ==>
	 * y = (b.y*x - a.x*b.y - a.y*x + a.y*a.x + a.y*b.x - a.x*a.y) / (b.x - a.x) ==>
	 * y = (b.y*x - a.y*x - a.x*b.y + a.y*a.x + a.y*b.x - a.x*a.y) / (b.x - a.x) ==>
	 * y = (b.y*x - a.y*x - a.x*b.y + a.y*b.x)/ (b.x - a.x) ==>
	 * y = x(b.y - a.y)/(b.x - a.x) + (b.x * a.y - a.x * b.y )/ (b.x - a.x)
	 * 
	 * </pre>
	 * 
	 * <pre>
	 *   y = x(b.y - a.y) / (b.x - a.x) + (b.x * a.y - a.x * b.y) / (b.x - a.x).
	 * </pre>
	 */

	static class Line
	{
		Slope slope;
		Point intercept;

		public Line(Point a, Point b)
		{
			if (b.x != a.x)
			{
				slope = new Slope(b.x - a.x, b.y - a.y);
				// when y = 0;
				intercept = new Intercept(b.x * a.y - a.x * b.y, a.x - b.x);
				gcd(slope);
				gcd(intercept);
			}
			else
			{
				slope = new Slope(1, 0);
				intercept = new Intercept(a.x, 1);
			}

		}

		private void gcd(Point one)
		{
			BigInteger a = BigInteger.valueOf(one.x);
			int gcd = a.gcd(BigInteger.valueOf(one.y)).intValue();

			one.x = one.x / gcd;
			one.y = one.y / gcd;

			if (one.y < 0)
			{
				one.x = -one.x;
				one.y = -one.y;
			}
		}

		public boolean equals(Object o)
		{
			if (o instanceof Line)
			{
				Line l = (Line) o;
				return slope.equals(l.slope) && intercept.equals(l.intercept);
			}
			return false;
		}

		public int hashCode()
		{
			int result = 0;
			result = result * 31 + slope.hashCode();
			result = result * 31 + intercept.hashCode();

			return result;
		}

		public String toString()
		{
			return ("slope: " + slope + "   intercept: " + intercept);
		}
	}

	static class Slope extends Point
	{
		Slope(int deltaX, int deltaY)
		{
			super(deltaX, deltaY);
		}
	}

	static class Intercept extends Point
	{
		Intercept(int deltaX, int deltaY)
		{
			super(deltaX, deltaY);
		}
	}

	static class Point
	{
		int x;
		int y;

		Point()
		{
			x = 0;
			y = 0;
		}

		Point(int a, int b)
		{
			x = a;
			y = b;
		}

		public int hashCode()
		{
			int result = 0;
			result += 31 * result + x;
			result += 31 * result + y;

			return result;
		}

		public boolean equals(Object o)
		{
			if (o instanceof Point)
			{
				Point l = (Point) o;
				return x == l.x && y == l.y;
			}
			return false;
		}

		public String toString()
		{
			return ("(" + x + ", " + y + ")");
		}
	}
}
