package google;
/**
 * http://www.careercup.com/question?id=5181899328716800
 * 
 */

public class WinePyramid
{
	public static double getQuantityOfWine(int bottles, int level, int number)
	{
		double[][] influx = new double[level][];

		influx[0] = new double[1];
		influx[0][0] = bottles * 750;

		for (int i = 1; i < level; i++)
		{
			influx[i] = new double[influx[i - 1].length + i + 1];

			// influx[level-1][number-1] goes to: influx[level][number-1];
			// influx[level][number-1+ (level-1)]; influx[level][number-1+
			// (level-1) + 1]

			for (int shift = 1, source = 0; shift < i + 1; shift++)
			{
				for (int j = 0; j < shift; j++, source++)
				{
					double residual = Math.max(
							(influx[i - 1][source] - 250) / 3.0, 0);

					influx[i][source] += residual;
					influx[i][source + shift] += residual;
					influx[i][source + shift + 1] += residual;
				}
			}
		}

		double target = influx[level - 1][number - 1];
		return (target > 250 ? 250 : target);
	}

	public static void main(String[] args) throws java.io.FileNotFoundException
	{
		java.util.Scanner sc = new java.util.Scanner(new java.io.File(
				"influx.txt"));
		int count = sc.nextInt();
		for (int i = 1; i <= count; i++)
		{
			System.out.println(String
					.format("Case #%d: %.3f",
							i,
							getQuantityOfWine(sc.nextInt(), sc.nextInt(),
									sc.nextInt())));
		}
	}

}
