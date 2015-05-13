package leetcode.nqueens.ii;

/**
 * Follow up for N-Queens problem.
 * 
 * Now, instead outputting board configurations, return the total number of
 * distinct solutions.
 * 
 */

public class Solution
{
	public int totalNQueens(int n)
	{
		if (n == 0)
			return 0;

		return totalHelper(0, 0, 0, n);
	}

	int totalHelper(long row, long ld, long rd, int n)
	{
		// make all bits to 1.
		long upperlim = (1 << n) - 1;
		int sum = 0;
		if (row != upperlim)
		{
			// to get the position that can be placed.
			long pos = upperlim & ~(row | ld | rd);
			// pos = 0 means no more place for the queen
			while (pos > 0)
			{
				// can also be long p = pos & -pos;
				// get the far right bit that is 1.
				// see http://blog.csdn.net/hackbuteer1/article/details/6657109
				long p = pos & (~pos + 1);

				// 将pos最右边为1的bit清零
				// 也就是为获取下一次的最右可用列使用做准备，
				// 程序将来会回溯到这个位置继续试探
				// clear the far right bit that is 1.
				pos -= p;

				// row + p，将当前列置1，表示记录这次皇后放置的列。
				// (ld + p) << 1，标记当前皇后左边相邻的列不允许下一个皇后放置。
				// (ld + p) >> 1，标记当前皇后右边相邻的列不允许下一个皇后放置。
				// 此处的移位操作实际上是记录对角线上的限制，只是因为问题都化归
				// 到一行网格上来解决，所以表示为列的限制就可以了。显然，随着移位
				// 在每次选择列之前进行，原来N×N网格中某个已放置的皇后针对其对角线
				// 上产生的限制都被记录下来了
				sum += totalHelper(row + p, (ld + p) << 1, (rd + p) >> 1, n);
			}
		}
		else
		{
			// row的所有位都为1，即找到了一个成功的布局，回溯
			sum++;
		}

		return sum;
	}

}