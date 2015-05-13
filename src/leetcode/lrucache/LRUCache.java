package leetcode.lrucache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache
{
	private Map<Integer, DoubleLinkedNode> cache;
	protected DoubleLinkedNode head;
	private DoubleLinkedNode tail;

	private int capacity;

	public LRUCache(int capacity)
	{
		cache = new HashMap<Integer, DoubleLinkedNode>(capacity);
		this.capacity = capacity;
		head = null;
		tail = null;
	}

	public int get(int key)
	{
		if (!cache.containsKey(key))
			return -1;

		DoubleLinkedNode node = cache.get(key);
		touch(node);

		return node.value;
	}

	// move the given node to the head of the list.
	private void touch(DoubleLinkedNode node)
	{
		if (node == head)
			return;

		// adjust tail.
		if (node == tail)
			tail = tail.prev;

		if (node.prev != null)
			node.prev.next = node.next;
		if (node.next != null)
			node.next.prev = node.prev;

		// move node to head
		node.prev = null;
		node.next = head;

		head.prev = node;
		head = node;
	}

	public void set(int key, int value)
	{
		int size = cache.size();
		if (!cache.containsKey(key) && size == capacity && tail != null)
		{
			// remove the tail
			DoubleLinkedNode prev = tail.prev;
			if (prev != null)
				prev.next = null;

			cache.remove(tail.key);

			tail.prev = null;
			tail = prev;
			if (tail == null)
				head = null;
		}

		DoubleLinkedNode node = cache.get(key);
		if (node == null)
		{
			node = new DoubleLinkedNode(key, value);

			// insert into head.
			if (head != null)
				head.prev = node;

			node.next = head;
			head = node;
			if (tail == null)
				tail = head;
			cache.put(key, node);

			return;
		}

		touch(node);
		node.value = value;
	}

	protected static class DoubleLinkedNode
	{
		DoubleLinkedNode prev;
		DoubleLinkedNode next;
		int value;
		int key;

		public DoubleLinkedNode(int key, int value)
		{
			this.key = key;
			this.value = value;
		}

	}
}
