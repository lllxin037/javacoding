package leetcode.lrucache;
import java.util.HashMap;
import java.util.Map;

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

public class LRUCache1
{
	private int capacity;
	
	LRUList nodes = null;

	// save LRU cached items.	
	private Map<Integer, CacheItem> cache = null;
	
	public LRUCache1(int capacity)
	{
		this.capacity = capacity;
		cache = new HashMap<Integer, CacheItem>(capacity);
		nodes = new LRUList();
	}

	public int get(int key)
	{
		// hit the map.
		CacheItem one = cache.get(Integer.valueOf(key));
		if (one == null)
		{
			return -1;
		}

		// touch the existing key/value by remove first then add again.
		nodes.touch(one.node);
		return one.value;
	}

	public void set(int key, int value)
	{
		// consider the case that put (1,2), (1,5). Shouldn't remove/add anything in such case.
		CacheItem one = cache.get(Integer.valueOf(key));
		if (one != null)
		{
			one = new CacheItem(value, one.node);			
			cache.put(Integer.valueOf(key), one);
			
			nodes.touch(one.node);
			return;
		}
		
		int currentSize = cache.size();
		if (currentSize < capacity)
		{
			// add to the LRUList then insert to the map.
			one = new CacheItem(value, nodes.add(key));
			cache.put(Integer.valueOf(key), one);
			return;
		}
		
		// get first item from nodes. the head of LRUList is the least used one.

		QueueNode head = nodes.remove();
		cache.remove(head.key);

		// add to the LRUList then insert to the map.
		cache.put(Integer.valueOf(key), new CacheItem(value, nodes.add(key)));
	}
	
	/**
	 * The list to record the least/most recently used key. The head of the list is least one. 
	 * The tail of the list is the most used one.
	 * 
	 * The list  is a two-way linked one.
	 */
	
	static class LRUList
	{
		protected QueueNode head;
		protected QueueNode tail;

		public QueueNode add(int key)
		{
			QueueNode item = new QueueNode(key);
			return add(item);
		}

		/**
		 * 
		 */
		
		private QueueNode add(QueueNode e)
		{
			if (head == null)
			{
				head = tail = e;
			}
			else
			{
				tail.next = e;
				e.previous = tail;
				tail = e;

				if (tail.previous == null)
				{
					tail.previous = head;
					head.next = tail;
				}
			}

			return tail;
		}

		private QueueNode remove(QueueNode e)
		{
			if (e.previous == null)
				head = e.next;
			else
				e.previous.next = e.next;

			if (e.next == null)
				tail = e.previous;
			else
				e.next.previous = e.previous;

			//clear the related fields
			e.previous = null;
			e.next = null;
			return e;
		}

		public QueueNode remove()
		{
			return remove(head);
		}

		public void touch(QueueNode e)
		{
			moveToTail(e);
		}

		private void moveToTail(QueueNode e)
		{
			remove(e);
			add(e);
		}
	}
	
	static class QueueNode
	{
		protected int key;
		protected QueueNode previous;
		protected QueueNode next;

		public QueueNode(int key)
		{
			this.key = key;
		}
	}
	
	/**
	 * The value in the map. Used to save value and node in LRUList.
	 *
	 */
	private static class CacheItem
	{
		private int value;
		private QueueNode node;

		CacheItem(int value, QueueNode node)
		{
			this.value = value;
			this.node = node;
		}
	}
}