/**
 * 
 <pre>
 * Given a 2D matrix, print all elements of the given matrix in diagonal order.
 * For example, consider the following 5 X 4 input matrix.
 *     1     2     3     4
 *     5     6     7     8
 *     9    10    11    12
 *    13    14    15    16
 *    17    18    19    20
 * 
 * Diagonal printing of the above matrix is
 *     1
 *     5     2
 *     9     6     3
 *    13    10     7     4
 *    17    14    11     8
 *    18    15    12
 *    19    16
 *    20
 * </pre>
 * 
 */

public class DiagnalPrint
{
	public static void print(int[][] matrix)
	{
		if (matrix == null)
			return;

		// matrix is defined as m*n;
		int m = matrix.length;
		int n = matrix[0].length;

		for (int line = 1; line <= m + n - 1; line++)
		{
			/*
			 * Get column index of the first element in this line of output. The
			 * index is 0 for first ROW lines and line - ROW for remaining lines
			 */
			int startCol = Math.max(0, line - m);

			/*
			 * Get count of elements in this line. The count of elements is
			 * equal to minimum of line number, COL-start_col and ROW
			 */
			int count = Math.min(line, n - startCol);
			count = Math.min(count, m);

			for (int j = 0; j < count; j++)
				System.out
						.print(matrix[Math.min(m, line) - j - 1][startCol + j]
								+ " ");

			System.out.println();
		}
	}

	public static void main(String[] args)
	{
		print(new int[][]
		{
		{ 1, 2, 3, 4 },
		{ 5, 6, 7, 8 },
		{ 9, 10, 11, 12 },
		{ 13, 14, 15, 16 },
		{ 17, 18, 19, 20 } });

	}
}
