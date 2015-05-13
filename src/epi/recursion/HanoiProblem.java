package epi.recursion;

public class HanoiProblem
{
	public static void moveTowerHanoi(int n)
	{
		move(1, 2, 3, n);
	}

	private static void move(int fromPeg, int toPeg, int helperPeg, int n)
	{
		if (n == 1)
		{
			System.out.println("move disk " + n + " from peg " + fromPeg
					+ " to peg " + toPeg);
			return;
		}
		// move 1 to n - 1 P3
		move(fromPeg, helperPeg, toPeg, n - 1);

		System.out.println("move disk " + n + " from peg " + fromPeg
				+ " to peg " + toPeg);

		move(helperPeg, toPeg, fromPeg, n - 1);
	}

	public static void main(String[] args)
	{
		moveTowerHanoi(3);
	}
}
