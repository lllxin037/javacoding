package google;
/**
 * There are at most eight servers in a data center. Each server has got a
 * capacity/memory limit. There can be at most 8 tasks that need to be scheduled
 * on those servers. Each task requires certain capacity/memory to run, and each
 * server can handle multiple tasks as long as the capacity limit is not hit.
 * Write a program to see if all of the given tasks can be scheduled or not on
 * the servers?
 * 
 * <pre>
 * Ex: 
 * Servers capacity limits: 8, 16, 8, 32 
 * Tasks capacity needs: 18, 4, 8, 4, 6, 6, 8, 8 
 * For this example, the program should say 'true'. 
 * 
 * Ex2: 
 * Server capacity limits: 1, 3 
 * Task capacity needs: 4 
 * For this example, program should return false.
 * </pre>
 * 
 * Got some idea that this needs to be solved using dynamic programming concept,
 * but could not figure out exact solution.
 * 
 * 
 */

public class BinSort
{
	public static boolean canAssign(int[] servers, int[] tasks)
	{
		boolean finished = true;
		for (int i = 0; i < tasks.length; i++)
		{
			finished = (finished && tasks[i] == 0);
			if (!finished)
				break;
		}
		if (finished)
			return true;

		for (int i = 0; i < tasks.length; i++)
		{
			int curTask = tasks[i];
			if (curTask == 0)
				continue;

			for (int j = 0; j < servers.length; j++)
			{
				if (servers[j] >= curTask)
				{
					servers[j] = servers[j] - curTask;
					tasks[i] = 0;
					if (canAssign(servers, tasks))
						return true;

					servers[j] = servers[j] + curTask;
					tasks[i] = curTask;
				}
			}
		}

		return false;
	}

	public static void main(String[] args)
	{
		System.out.println(canAssign(new int[]
		{ 8, 16, 8, 32 }, new int[]
		{ 18, 4, 8, 4, 6, 6, 8, 8 }));

		System.out.println(canAssign(new int[]
		{ 1, 3 }, new int[]
		{ 4 }));

		System.out.println(canAssign(new int[]
		{ 8, 6, 2 }, new int[]
		{ 6, 4, 3, 2, 1 }));

	}
}
