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

				// ��pos���ұ�Ϊ1��bit����
				// Ҳ����Ϊ��ȡ��һ�ε����ҿ�����ʹ����׼����
				// ����������ݵ����λ�ü�����̽
				// clear the far right bit that is 1.
				pos -= p;

				// row + p������ǰ����1����ʾ��¼��λʺ���õ��С�
				// (ld + p) << 1����ǵ�ǰ�ʺ�������ڵ��в�������һ���ʺ���á�
				// (ld + p) >> 1����ǵ�ǰ�ʺ��ұ����ڵ��в�������һ���ʺ���á�
				// �˴�����λ����ʵ�����Ǽ�¼�Խ����ϵ����ƣ�ֻ����Ϊ���ⶼ����
				// ��һ������������������Ա�ʾΪ�е����ƾͿ����ˡ���Ȼ��������λ
				// ��ÿ��ѡ����֮ǰ���У�ԭ��N��N������ĳ���ѷ��õĻʺ������Խ���
				// �ϲ��������ƶ�����¼������
				sum += totalHelper(row + p, (ld + p) << 1, (rd + p) >> 1, n);
			}
		}
		else
		{
			// row������λ��Ϊ1�����ҵ���һ���ɹ��Ĳ��֣�����
			sum++;
		}

		return sum;
	}

}