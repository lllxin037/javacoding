package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Given a 2D array of black and white entries representing a maze with
 * designated entrance and exit points, find a path from the entrance to the
 * exit, if one exists.
 * 
 */

public class MazeSearch
{
	// DFS method with recursion

	// 0 in matrix is the white space; 1 in matrix is the black wall.
	public static void findPath(int[][] matrix, Coordinate s, Coordinate e)
	{
		List<Coordinate> path = new ArrayList<Coordinate>();

		if (!findPath(matrix, s, e, path))
		{
			System.out.println("no solution.");
			return;
		}

		for (Coordinate one : path)
			System.out.println(one);
	}

	private static int[][] calculateOffset(Coordinate s, Coordinate e)
	{
		if (Math.abs(e.x - s.x) >= Math.abs(e.y - s.y))
		{
			// move x first
			if (e.x - s.x >= 0)
			{
				return new int[][]
				{
				{ 1, 0 },
				{ -1, 0 },
				{ 0, 1 },
				{ 0, -1 } };
			}
			else
			{
				return new int[][]
				{
				{ -1, 0 },
				{ 1, 0 },
				{ 0, 1 },
				{ 0, -1 } };
			}
		}
		else
		{
			// move y first
			if (e.y - s.y >= 0)
			{
				return new int[][]
				{
				{ 0, 1 },
				{ 0, -1 },
				{ 1, 0 },
				{ -1, 0 } };
			}
			else
			{
				return new int[][]
				{
				{ 0, -1 },
				{ 0, 1 },
				{ -1, 0 },
				{ 1, 0 } };
			}
		}
	}

	private static boolean findPath(int[][] matrix, Coordinate s, Coordinate e,
			List<Coordinate> path)
	{
		if (s.equals(e))
		{
			path.add(e);
			return true;
		}

		// choose the next step nearest to e first, then with two other
		// directions.
		path.add(s);
		matrix[s.x][s.y] = 1;

		int[][] offset = calculateOffset(s, e);

		for (int i = 0; i < offset.length; i++)
		{
			Coordinate news = new Coordinate(s.x + offset[i][0], s.y
					+ offset[i][1]);
			if (news.x < 0 || news.x >= matrix.length)
				continue;
			if (news.y < 0 || news.y >= matrix[0].length)
				continue;

			if (matrix[news.x][news.y] == 1)
				continue;

			if (findPath(matrix, news, e, path))
				return true;
		}

		path.remove(path.size() - 1);
		matrix[s.x][s.y] = 0;
		return false;
	}

	public static void main(String[] args)
	{
		int[][] matrix = new int[][]
		{
		{ 1, 0, 0, 0, 0, 0, 1, 1, 0, 0 },
		{ 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
		{ 1, 0, 1, 0, 0, 1, 1, 0, 1, 1 },
		{ 0, 0, 0, 1, 1, 1, 0, 0, 1, 0 },
		{ 0, 1, 1, 0, 0, 0, 0, 0, 0, 0 },
		{ 0, 1, 1, 0, 0, 1, 0, 1, 1, 0 },
		{ 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
		{ 1, 0, 1, 0, 1, 0, 1, 0, 0, 0 },
		{ 1, 0, 1, 1, 0, 0, 0, 1, 1, 1 },
		{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 0 } };

		findPath(matrix, new Coordinate(9, 0), new Coordinate(0, 9));
		System.out.println("*************************************");

		Random r = new Random();
		int count = 0;

		while (count < 2)
		{

			int n, m;
			n = r.nextInt(7) + 5;
			m = r.nextInt(7) + 5;

			int[][] maze = new int[n][m];
			for (int i = 0; i < n; ++i)
			{
				for (int j = 0; j < m; ++j)
					maze[i][j] = r.nextInt(2);
			}
			List<Coordinate> white = new ArrayList<Coordinate>();
			for (int i = 0; i < n; ++i)
			{
				for (int j = 0; j < m; ++j)
				{
					if (maze[i][j] == 0)
					{
						white.add(new Coordinate(i, j));
					}
					System.out.print(maze[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();

			if (white.size() != 0)
			{
				System.out.println("*************************************");

				int start = r.nextInt(white.size());
				int end = r.nextInt(white.size());

				System.out.println("start position: " + white.get(start));
				System.out.println("end position: " + white.get(end));
				System.out.println();

				findPath(maze, white.get(start), white.get(end));

				count++;
			}
		}
	}

	private static class Coordinate
	{
		private int x, y;

		protected Coordinate(int x, int y)
		{
			this.x = x;
			this.y = y;
		}

		public boolean equals(Object o)
		{
			if (!(o instanceof Coordinate))
				return false;

			Coordinate c1 = (Coordinate) o;
			return (c1.x == x && c1.y == y);
		}

		public String toString()
		{
			return x + "," + y;
		}
	}
}
