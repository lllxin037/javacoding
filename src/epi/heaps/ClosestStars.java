package epi.heaps;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * How would you compute the k stars which are closest to the Earth? You have
 * only a few megabytes of RAM.
 * 
 */

public class ClosestStars
{
	public static List<Star> findClosestKStars(InputStream sin, int k)
	{
		PriorityQueue<Star> maxHeap = new PriorityQueue<Star>(k,
				new Comparator<Star>()
				{
					public int compare(Star s1, Star s2)
					{
						return s2.compareTo(s1);
					}
				});

		try
		{
			ObjectInputStream ois = new ObjectInputStream(sin);
			while (true)
			{
				Star one = (Star) ois.readObject();
				if (maxHeap.size() < k)
					maxHeap.offer(one);
				else
				{
					Star max = maxHeap.peek();
					if (one.compareTo(max) < 0)
					{
						maxHeap.poll();
						maxHeap.offer(one);
					}
				}
			}
		}
		catch (ClassNotFoundException e)
		{
			System.err.println("ClassNotFoundException: " + e.getMessage());
		}
		catch (IOException e)
		{

		}

		List<Star> ret = new ArrayList<Star>(k);
		while (!maxHeap.isEmpty())
			ret.add(maxHeap.poll());

		return ret;
	}

	private static class Star implements Serializable
	{
		private int id;
		private double x, y, z;

		Star(int id, double x, double y, double z)
		{
			this.id = id;
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public double distance()
		{
			return (x * x + y * y + z * z);
		}

		public int compareTo(Star s)
		{
			return Double.valueOf(distance()).compareTo(s.distance());
		}

		public String toString()
		{
			return "id " + id + " distance:" + distance();
		}
	}

	private static void selectK(List<Star> stars, int left, int right)
	{
		int index = partition(stars, left, right);
		if (left < index - 1)
			selectK(stars, left, index - 1);
		if (index < right)
			selectK(stars, index, right);
	}

	private static int partition(List<Star> stars, int left, int right)
	{
		int pivotIndex = (left + right) >> 1;

		// Get the pivot element
		double pivotDistance = stars.get(pivotIndex).distance();

		// Break when left is > right
		while (left <= right)
		{
			// increment the lower bound till you find the element more than the
			// pivot
			while (stars.get(left).distance() > pivotDistance)
				left++;
			// decrement the upper bound till you find the element less than the
			// pivot
			while (stars.get(right).distance() < pivotDistance)
				right--;

			// swap the values which are left by lower and upper bounds
			if (left <= right)
			{
				Star tmp = stars.get(left);
				stars.set(left, stars.get(right));
				stars.set(right, tmp);

				// increment left index and decrement right index
				left++;
				right--;
			}
		}
		return left;
	}

	public static void main(String[] args)
	{
		Random r = new Random();

		for (int times = 0; times < 3; ++times)
		{
			int num = r.nextInt(1000) + 1;
			int k = (r.nextInt(50) >> 1) + 2;

			List<Star> stars = new ArrayList<Star>();

			// randomly generate num of stars
			for (int i = 0; i < num; ++i)
			{
				stars.add(new Star(i, r.nextInt(1001), r.nextInt(1001), r
						.nextInt(1001)));
			}

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ByteArrayInputStream sin = null;
			try
			{
				ObjectOutputStream oos = new ObjectOutputStream(baos);
				for (Star s : stars)
				{
					oos.writeObject(s);
					// System.out.println(s.distance());
				}
				oos.close();
				sin = new ByteArrayInputStream(baos.toByteArray());
			}
			catch (IOException e)
			{
				System.out.println("IOException: " + e.getMessage());
				return;
			}

			System.out.println("k is " + k);
			List<Star> closestStars = findClosestKStars(sin, k);
			dumpStars("Closest Stars...", closestStars);

			selectK(stars, 0, stars.size() - 1);
			dumpStars("sorted stars...",
					stars.subList(stars.size() - k, stars.size()));
		}
	}

	private static void dumpStars(String dumpHeader, List<Star> stars)
	{
		System.out.println(dumpHeader);
		for (Star one : stars)
		{
			System.out.println(one.toString());
		}
	}
}
