package leetcode.lrucache;
import leetcode.lrucache.LRUCache1.LRUList;
import leetcode.lrucache.LRUCache1.QueueNode;

/**
 * Has one map to save the cached items. Uses another self-developed LRUList -- a linked list to record
 * the least recent used "key" in the order. The head of the list is the least  used one. The latest
 * used one always in the tail.
 * 
 * Idea goes like this:
 * 1. when insert the new key/value pair: a) add new pair to the map; 
 * b) append the QueueNode to LRUList;
 * 
 * 2. when get the value: a) hit the map for the value; b) remove then add the corresponding 
 * QueueNodeo to LRUList.
 * 
 */

public class LocalLRUCache
{	
	static void dumpLRUList(LRUList list)
	{
		QueueNode p = list.head;
		
		System.out.print("LRU list: ");
		while (p != null)
		{
			System.out.print(p.key + "    ");
			p = p.next;
		}
		System.out.print("\n");
	}
	
	static void dumpGet(int value)
	{
		System.out.print(value + ",");
	}
	
	public static void main(String[] args)
	{
		LRUCache1 cache = new LRUCache1(10);
		
		cache.set(10,13);
		cache.set(3,17);
		cache.set(6,11);
		cache.set(10,5);
		cache.set(9,10);
		dumpGet(cache.get(13) );
		cache.set(2,19);
		dumpGet(cache.get(2) );
		dumpGet(cache.get(3) );
		cache.set(5,25);
		dumpGet(cache.get(8));
		cache.set(9,22);
		cache.set(5,5);
		cache.set(1,30);
		dumpGet(cache.get(11));
		cache.set(9,12);
		dumpGet(cache.get(7));
		dumpGet(cache.get(5));
		dumpGet(cache.get(8));
		dumpGet(cache.get(9));
		cache.set(4,30);
		cache.set(9,3);
		dumpGet(cache.get(9));
		dumpGet(cache.get(10));
		dumpGet(cache.get(10));
		cache.set(6,14);
		cache.set(3,1);
		dumpGet(cache.get(3));
		cache.set(10,11);
		dumpGet(cache.get(8));
		cache.set(2,14);
		dumpGet(cache.get(1));dumpGet(cache.get(5));
		dumpGet(cache.get(4));cache.set(11,4);cache.set(12,24);
		cache.set(5,18);dumpGet(cache.get(13));cache.set(7,23);
		dumpGet(cache.get(8));dumpGet(cache.get(12));cache.set(3,27);
		cache.set(2,12);dumpGet(cache.get(5));cache.set(2,9);
		cache.set(13,4);cache.set(8,18);cache.set(1,7);
		dumpGet(cache.get(6));cache.set(9,29);
		cache.set(8,21);dumpGet(cache.get(5));cache.set(6,30);cache.set(1,12);
		dumpGet(cache.get(10));cache.set(4,15);cache.set(7,22);
		cache.set(11,26);cache.set(8,17);cache.set(9,29);
		dumpGet(cache.get(5));
		cache.set(3,4);cache.set(11,30);dumpGet(cache.get(12));
		cache.set(4,29);dumpGet(cache.get(3));
		dumpGet(cache.get(9));
		dumpGet(cache.get(6));cache.set(3,4);dumpGet(cache.get(1));
		dumpGet(cache.get(10));
		cache.set(3,29);cache.set(10,28);
		
		cache.set(1,20);cache.set(11,13);dumpGet(cache.get(3));
		cache.set(3,12);cache.set(3,8);cache.set(10,9);
		cache.set(3,26);dumpGet(cache.get(8));
		dumpGet(cache.get(7));dumpGet(cache.get(5));cache.set(13,17);cache.set(2,27);
		cache.set(11,15);dumpGet(cache.get(12));
		cache.set(9,19);cache.set(2,15);cache.set(3,16);dumpGet(cache.get(1));
		cache.set(12,17);cache.set(9,1);cache.set(6,19);dumpGet(cache.get(4));
		dumpGet(cache.get(5));dumpGet(cache.get(5));
		cache.set(8,1);cache.set(11,7);
		cache.set(5,2);cache.set(9,28);dumpGet(cache.get(1));cache.set(2,2);
		cache.set(7,4);cache.set(4,22);
		cache.set(7,24);cache.set(9,26);cache.set(13,28);cache.set(11,26);

		

	}
}