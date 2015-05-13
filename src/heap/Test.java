package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test
{
	private static void maxHeapTest()
	{
		List<Integer> array = new ArrayList<Integer>(Arrays.asList(null, 45,
				36, 18, 53, 72, 30, 48, 93, 15, 35));
		MaxHeap heap = MaxHeap.adjust(array);
		heap.dumpHeapInArray();
		heap.insert(80);// 堆中插入
		heap.dumpHeapInArray();
		heap.delete(2);// 堆中删除80的元素
		heap.dumpHeapInArray();
		heap.delete(2);// 堆中删除72的元素
		heap.dumpHeapInArray();

	}

	private static void stockPriceTest()
	{
		StockMediaPrice sp = new StockMediaPrice();
		sp.addNumber(6);
		sp.addNumber(4);
		sp.addNumber(3);
		sp.addNumber(10);
		sp.addNumber(12);

		sp.dumpHeaps();
		System.out.println("media: " + sp.getMedian());

		sp.addNumber(5);
		sp.dumpHeaps();
		System.out.println("media: " + sp.getMedian());

		sp.addNumber(7);
		sp.addNumber(8);
		sp.dumpHeaps();
		System.out.println("media: " + sp.getMedian());

	}

	private static void minMaxHeapTest()
	{
		MinMaxHeap<Integer> heap = new MinMaxHeap<Integer>(new Integer[]
		{ 12, 7, 9, 70, 40, 30, 45, 50, 10, 15, 20 });
		
		heap.dumpHeapInArray();
	}

	public static void main(String[] args)
	{
		// maxHeapTest();
		//stockPriceTest();
		minMaxHeapTest();
	}
}
