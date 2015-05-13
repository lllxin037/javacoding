package leetcode.lrucache;

import leetcode.lrucache.LRUCache.DoubleLinkedNode;
import leetcode.lrucache.LRUCache1.LRUList;
import leetcode.lrucache.LRUCache1.QueueNode;

/**
 * 
 */

public class Test
{
	static void dumpLRUList(LRUCache cache)
	{
		DoubleLinkedNode head = cache.head;
		while (head.next != null)
		{
			System.out.print("[" + head.key + "   " + head.value + "], ");
			head = head.next;
		}
	}

	private static void oneCase1()
	{

		// Input: 2,[get(2),set(2,6),get(1),set(1,5),set(1,2),get(1),get(2)]
		// Output: [-1,-1,2,-1]
		// Expected: [-1,-1,2,6]

		LRUCache cache = new LRUCache(2);
		System.out.print(cache.get(2));
		cache.set(2, 6);
		System.out.print(cache.get(1));
		cache.set(1, 5);
		cache.set(1, 2);
		System.out.print(cache.get(1));
		System.out.print(cache.get(2));
	}

	private static void oneCase2()
	{
		// 1,[set(2,1),get(2),set(3,2),get(2),get(3)]
		// [1,-1,2]
		LRUCache cache = new LRUCache(1);
		cache.set(2, 1);
		System.out.print(cache.get(2));
		cache.set(3, 2);
		System.out.print(cache.get(2));
		System.out.print(cache.get(3));
	}

	private static void oneCase3()
	{
		// 2,[set(2,1),set(1,1),get(2),set(4,1),get(1),get(2)]
		// Expected: [1,-1,1]

		LRUCache cache = new LRUCache(2);
		cache.set(2, 1);
		cache.set(1, 1);
		System.out.print(cache.get(2));
		cache.set(4, 1);
		System.out.print(cache.get(1));
		System.out.print(cache.get(2));
	}

	private static void oneCase4()
	{

		// Input: 2,[set(2,1),set(1,1),set(2,3),set(4,1),get(1),get(2)]
		// Output: [1,-1]
		// Expected: [-1,3]
		
		LRUCache cache = new LRUCache(2);
		cache.set(2, 1);
		cache.set(1, 1);
		cache.set(2, 3);
		cache.set(4, 1);
		System.out.print(cache.get(1));
		System.out.print(cache.get(2));
	}

	public static void main(String[] args)
	{
		oneCase4();
		System.out.println();
		oneCase1();
		System.out.println();
		oneCase2();
		System.out.println();
		oneCase3();

	}
}