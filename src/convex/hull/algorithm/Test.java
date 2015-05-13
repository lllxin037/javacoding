package convex.hull.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test
{
	private static void onecase(int[][] coordinates)
	{
		Solution s = new Solution();
		List<Point> chPoints = s.Graham_scan(createPoints(coordinates));
		
		System.out.println("#############################");
		for (Point one : chPoints)
			System.out.println(one.toString());
		System.out.println("#############################");
	}

	private static List<Point> createPoints(int[][] coordinates)
	{
		if (coordinates == null || coordinates.length == 0)
			return Collections.<Point> emptyList();

		List<Point> points = new ArrayList<Point>();
		for (int i = 0; i < coordinates.length; i++)
			points.add(new Point(coordinates[i][0], coordinates[i][1]));

		return points;

	}

	public static void main(String[] args)
	{
		onecase(new int[][]
		{
		{0,0},
		{3,0},
		{4,0},
		{2,3},
		{1,1}});

		onecase(new int[][]
		{
		{2,2},
		{4,2},
		{0,3},
		{3,4},
		{1,4},
		{0,4},
		{1,1},
		{3,3},
		{4,4},
		{4,2}
		});
	}
}
