package epi.recursion;

import java.util.Arrays;

public class SudokuSolver
{
	public static boolean solveSudoku(int[][] A)
	{
		return sudokuHelper(A, 0, 0);
	}

	private static boolean sudokuHelper(int[][] A, int i, int j)
	{
		if (j == A.length)
		{
			j = 0;
			if (++i == A.length)
				return true; // reach the (8,8) in the board
		}

		if (A[i][j] != 0)
			return sudokuHelper(A, i, j + 1);

		for (int k = 1; k <= A.length; k++)
		{
			if (canPlace(i, j, A, k))
			{
				A[i][j] = k;
				if (sudokuHelper(A, i, j + 1))
					return true;
			}
		}
		A[i][j] = 0;
		return false;
	}

	private static boolean canPlace(int x, int y, int[][] A, int val)
	{
		// check horizontal
		for (int i = 0; i < A.length; i++)
		{
			if (A[x][i] == val)
				return false;
			if (A[i][y] == val)
				return false;
		}

		// check small cube, there are 9 cubes totally.
		int xstart = (x / 3) * 3;
		int ystart = (y / 3) * 3;
		for (int i = xstart; i < xstart + 3; i++)
		{
			for (int j = ystart; j < ystart + 3; j++)
			{
				if (A[i][j] == val)
					return false;
			}
		}

		return true;
	}

	public static void main(String[] args)
	{
		int[][] A = new int[9][];
		A[0] = new int[]
		{ 0, 2, 6, 0, 0, 0, 8, 1, 0 };
		A[1] = new int[]
		{ 3, 0, 0, 7, 0, 8, 0, 0, 6 };
		A[2] = new int[]
		{ 4, 0, 0, 0, 5, 0, 0, 0, 7 };
		A[3] = new int[]
		{ 0, 5, 0, 1, 0, 7, 0, 9, 0 };
		A[4] = new int[]
		{ 0, 0, 3, 9, 0, 5, 1, 0, 0 };
		A[5] = new int[]
		{ 0, 4, 0, 3, 0, 2, 0, 5, 0 };
		A[6] = new int[]
		{ 1, 0, 0, 0, 3, 0, 0, 0, 2 };
		A[7] = new int[]
		{ 5, 0, 0, 2, 0, 4, 0, 0, 9 };
		A[8] = new int[]
		{ 0, 3, 8, 0, 0, 0, 4, 6, 0 };
		System.out.println(solveSudoku(A));

		for (int i = 0; i < A.length; i++)
		{
			System.out.println(Arrays.toString(A[i]));
		}
	}
}
