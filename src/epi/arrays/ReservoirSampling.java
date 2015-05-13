package epi.arrays;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Design an algorithm that reads packets and continuously maintains a uniform
 * random subset of size k of the packets after n >= k-th packets are read.
 * 
 */

public class ReservoirSampling
{
	public static List<Integer> reservoirSampling(InputStream sin, int k)
			throws IOException
	{
		List<Integer> samples = new ArrayList<Integer>(k);

		DataInputStream ois = new DataInputStream(sin);

		int readOne = ois.readInt();
		for (int i = 0; i < k && readOne != -1; i++)
		{
			samples.add(readOne);
			readOne = ois.readInt();
		}

		if (readOne == -1)
			return Collections.<Integer> emptyList();

		int total = k + 1;

		Random r = new Random();
		while (readOne != -1)
		{
			int chosen = r.nextInt(total);
			if (chosen < k)
				samples.set(chosen, readOne);

			try
			{
				readOne = ois.readInt();
			}
			catch (EOFException e)
			{
				break;
			}
			total++;
		}

		ois.close();
		return samples;
	}

	public static void main(String[] args) throws IOException
	{
		int n, k;
		Random gen = new Random();

		n = gen.nextInt(10000);
		k = gen.nextInt(n) + 1;

		List<Integer> A = new ArrayList<Integer>(n);
		for (int i = 0; i < n; ++i)
			A.add(i);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		for (Integer i : A)
			dos.writeInt(i);

		System.out.println(n + " " + k);

		ByteArrayInputStream sin = new ByteArrayInputStream(baos.toByteArray());
		List<Integer> ans = reservoirSampling(sin, k);

		assert ans.size() == k;

		baos.close();
		dos.close();

		System.out.println(ans);
	}
}
