package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class PaintBooleanMatrix
{
	// floor algorithm
	public static void flipColor(boolean[][] A, int x, int y)
	{
		if (A == null || A.length == 0)
			return;
		// iteratively.
		int n = A.length;
		int m = A[0].length;

		if (x < 0 || x >= n)
			return;
		if (y < 0 || y >= m)
			return;

		boolean source = A[x][y];
		int[][] offset = new int[][]
		{
		{ 0, 1 },
		{ 0, -1 },
		{ 1, 0 },
		{ -1, 0 } };

		Queue<Position> remaining = new LinkedList<Position>();
		remaining.add(new Position(x, y));

		while (!remaining.isEmpty())
		{
			Position one = remaining.poll();
			A[one.x][one.y] = !source;

			for (int i = 0; i < offset.length; i++)
			{
				Position another = new Position(one.x + offset[i][0], one.y
						+ offset[i][1]);
				if (another.x < 0 || another.x >= n || another.y < 0
						|| another.y >= m)
					continue;
				if (A[another.x][another.y] == source)
					remaining.add(another);
			}
		}
	}

	private static class Position
	{
		private int x, y;

		Position(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args)
	{
		int n;
		Random gen = new Random();
		n = gen.nextInt(3) + 3;

		boolean[][] A = new boolean[n][n];
		for (int i = 0; i < n; ++i)
		{
			for (int j = 0; j < n; ++j)
			{
				A[i][j] = gen.nextBoolean();
			}
		}
		int i = gen.nextInt(n), j = gen.nextInt(n);
		System.out.println("color = " + i + " " + j + " " + A[i][j]);
		printMatrix(A);
		flipColor(A, i, j);
		System.out.println();
		printMatrix(A);
	}

	private static void printMatrix(boolean[][] A)
	{
		for (boolean[] element : A)
			System.out.println(Arrays.toString(element));

	}
}
