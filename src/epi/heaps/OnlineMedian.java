package epi.heaps;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Design an algorithm for computing the running median of a sequence. The time
 * complexity should be O(log n) per element read in, where n is the number of
 * values read in up to that element.
 * 
 */

public class OnlineMedian
{

	public static void compute(InputStream is) throws IOException
	{
		// constructs a minheap to save [median ... max value]
		// and a maxheap [min value ... median]

		// keep maxHeap.size = minHeap.size + 0/1;

		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(32,
				new Comparator<Integer>()
				{
					public int compare(Integer o1, Integer o2)
					{
						return o1.compareTo(o2);
					}
				});

		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(32,
				new Comparator<Integer>()
				{
					public int compare(Integer o1, Integer o2)
					{
						return o2.compareTo(o1);
					}
				});

		DataInputStream dis = new DataInputStream(is);
		while (true)
		{
			try
			{
				int value = dis.readInt();

				if (!maxHeap.isEmpty() && value > maxHeap.peek())
					minHeap.add(value);
				else
					maxHeap.add(value);

				if (maxHeap.size() > minHeap.size() + 1)
					minHeap.add(maxHeap.poll());
				else if (minHeap.size() >= maxHeap.size() + 1)
					maxHeap.add(minHeap.poll());

				System.out.println("max heap size " + maxHeap.size()
						+ "   min heap size " + minHeap.size());
				if (minHeap.size() == maxHeap.size())
					System.out.println("two medians :" + minHeap.peek() + " "
							+ maxHeap.peek());
				else
					System.out.println("one median :" + maxHeap.peek());
			}
			catch (EOFException e)
			{
				break;
			}

			dis.close();
		}
	}

	public static void main(String[] args) throws IOException
	{
		Random r = new Random();
		int num = r.nextInt(20) + 1;

		List<Integer> stream = new ArrayList<Integer>();
		for (int i = 0; i < num; ++i)
			stream.add(r.nextInt(1000) + 1);

		System.out.println("stream integers:" + stream);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream osw = new DataOutputStream(baos);
		try
		{
			for (Integer aStream : stream)
			{
				osw.writeInt(aStream);
			}
			osw.close();
		}
		catch (IOException e)
		{
			System.out.println("IOException: " + e.getMessage());
		}
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		compute(bais);

		Collections.sort(stream);
		System.out.println("sorted stream integers:" + stream);
	}
}
