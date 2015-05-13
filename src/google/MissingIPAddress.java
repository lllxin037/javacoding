package google;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class MissingIPAddress
{
	private static final int INTEGER_BIT_LENS = 16;
	private static final int HALF_INTEGER_BIT_LENS = INTEGER_BIT_LENS >> 1;

	public static int findMissingElement(InputStream is) throws IOException
	{

		int[] counter = new int[1 << HALF_INTEGER_BIT_LENS];

		is.mark(Integer.MAX_VALUE);
		Scanner s = new Scanner(is);

		while (s.hasNext())
			++counter[s.nextInt() >> HALF_INTEGER_BIT_LENS];

		for (int i = 0; i < counter.length; ++i)
		{
			if (counter[i] < (1 << HALF_INTEGER_BIT_LENS))
			{
				is.reset();
				BitSet bitVec = new BitSet(1 << HALF_INTEGER_BIT_LENS);

				s = new Scanner(is);
				while (s.hasNext())
				{
					int value = s.nextInt();

					// Gets the lower 16 bits of x.
					if ((value >> HALF_INTEGER_BIT_LENS) == i)
						bitVec.set(((1 << HALF_INTEGER_BIT_LENS) - 1) & value);
				}

				is.close();

				for (int j = 0; j < (1 << HALF_INTEGER_BIT_LENS); ++j)
				{
					if (!bitVec.get(j))
					{
						return (i << HALF_INTEGER_BIT_LENS) | j;
					}
				}
			}

		}

		throw new RuntimeException("no missing element");
	}

	public static void main(String[] args)
	{
		int n = (1 << 16);
		Random r = new Random();

		File missingFile = new File("missing.txt");
		FileOutputStream ofs = null;

		int missing = r.nextInt(n);
		Set<Integer> hash = new HashSet<Integer>();
		hash.add(missing);

		System.out.println("missing: " + missing);

		try
		{
			try
			{
				ofs = new FileOutputStream(missingFile);
				OutputStreamWriter osw = new OutputStreamWriter(ofs);

				while (hash.size() < n )
				{
					int x = r.nextInt(n);
					if (hash.contains(x))
						continue;

					hash.add(x);
					osw.write(x + "\n");
				}
				osw.flush();
				osw.close();
			}
			finally
			{
				if (ofs != null)
				{
					ofs.close();
				}
			}

			FileInputStream ifs = null;
			try
			{
				ifs = new FileInputStream(missingFile);
				BufferedInputStream bis = new BufferedInputStream(ifs);

				System.out.println("missing: " + missing + " and found: "
						+ findMissingElement(bis));
			}
			finally
			{
				if (ifs != null)
				{
					ifs.close();
				}
			}
		}
		catch (IOException e)
		{
			System.out.println("IOException: " + e.getMessage());
		}
		finally
		{
			// Remove file after the execution.
			missingFile.delete();
		}
	}
}
