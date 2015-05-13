package convex.hull.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution
{
	public List<Point> Graham_scan(List<Point> points)
	{
		if (points == null || points.size() < 3)
			return Collections.<Point> emptyList();

		Collections.sort(points, new Comparator<Point>()
		{
			@Override
			public int compare(Point o1, Point o2)
			{
				return (new Integer(o1.x)).compareTo(new Integer(o2.x));
			}
		});

		int n = points.size();
		Point[] upper = new Point[n];

		upper[0] = points.get(0);
		upper[1] = points.get(1);
		int upperSize = 2;

		// find the upper hull that goes to right turn -- clockwise
		for (int i = 2; i < n; i++)
		{
			upper[upperSize++] = points.get(i);
			while (upperSize > 2
					&& !rightTurn(upper[upperSize - 3], upper[upperSize - 2],
							upper[upperSize - 1]))
			{
				upper[upperSize - 2] = upper[upperSize - 1];
				upperSize--;
			}
		}

		// find the lower hull that goes to right turn
		Point[] lower = new Point[n];

		lower[0] = points.get(n - 1);
		lower[1] = points.get(n - 2);
		int lowerSize = 2;

		// find the upper hull that goes to right turn -- clockwise
		for (int i = n - 3; i >= 0; i--)
		{
			lower[lowerSize++] = points.get(i);
			while (lowerSize > 2
					&& !rightTurn(lower[lowerSize - 3], lower[lowerSize - 2],
							lower[lowerSize - 1]))
			{
				lower[lowerSize - 2] = lower[lowerSize - 1];
				lowerSize--;
			}
		}

		ArrayList<Point> result = new ArrayList<Point>();

		for (int i = 0; i < upperSize; i++)
		{
			result.add(upper[i]);
		}

		for (int i = 1; i < lowerSize - 1; i++)
		{
			result.add(lower[i]);
		}

		return result;
	}

	/**
	 * <pre>
	 * 	  -->
	 * 	  AB = ( Xb-Xa, Yb-Ya, 0);
	 * 
	 * 	  -->
	 * 	  AC = ( Xc-Xa, Yc-Ya, 0);
	 * 
	 * 	     -->  -->
	 * 	  求 AB X AC ( X为向量叉乘 )
	 * 	     = (Xb-Xa)*(Yc-Ya) - (Yb-Ya)*(Xc-Xa)
	 * 
	 * 	                      -->
	 * 	  若结果为正则 C 点在 AB 的左侧, 反之在右侧,
	 * 	                       -->
	 * 	  若结果为 0 则 C 点在 AB 上.
	 * </pre>
	 */
	private boolean rightTurn(Point p1, Point p2, Point pp)
	{
		return ((p2.x - p1.x) * (pp.y - p1.y) - (p2.y - p1.y) * (pp.x - p1.x)) < 0;
	}
}
