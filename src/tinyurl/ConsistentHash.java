package tinyurl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHash<T> {
	protected final static String CHARSET = "ISO-8859-1";

	private final static long MAX_HASH_VALUE = Math.min((long) Math.pow(62, 6),
			Integer.MAX_VALUE);

	private final int numberOfReplicas;
	private final SortedMap<Long, T> circle = new TreeMap<Long, T>();

	public ConsistentHash(int replicas, Collection<T> nodes) {
		numberOfReplicas = replicas;

		for (T node : nodes)
			add(node);
	}

	public void add(T node) {
		for (int i = 0; i < numberOfReplicas; i++) {
			long hash = hashcode(node.toString() + i);
			circle.put(hash, node);
		}
	}

	public void remove(T node) {
		for (int i = 0; i < numberOfReplicas; i++) {
			circle.remove(hashcode(node.toString() + i));
		}
	}

	public T get(Object key) {
		if (circle.isEmpty())
			return null;

		return find(hashcode(key.toString()));
	}

	public T find(long hash) {
		if (circle.isEmpty())
			return null;

		long serverHashValue = 0;
		if (!circle.containsKey(hash)) {
			SortedMap<Long, T> tailMap = circle.tailMap(hash);
			serverHashValue = tailMap.isEmpty() ? circle.firstKey() : tailMap
					.firstKey();
		}
		return circle.get(serverHashValue);
	}

	public long hashcode(String s) {
		return md5HashingAlg(s);
	}

	public static Long md5HashingAlg(String key) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		}
		catch (NoSuchAlgorithmException e) {
			System.err.println("++++ no md5 algorythm found");
			throw new IllegalStateException("++++ no md5 algorythm found");
		}
		md5.reset();
		md5.update(key.getBytes());
		byte[] bKey = md5.digest();
		long res = ((long) (bKey[3] & 0xFF) << 24)
				| ((long) (bKey[2] & 0xFF) << 16)
				| ((long) (bKey[1] & 0xFF) << 8) | (long) (bKey[0] & 0xFF);
		return res;
	}

	public static void main(String[] args) {

		List<String> nodes = new ArrayList<String>();
		nodes.add("A");
		nodes.add("B");
		nodes.add("C");

		String[] values = { "1", "2", "3", "4", "5", "6", "7" };

		ConsistentHash<String> ch = new ConsistentHash<String>(50, nodes);
		for (String one : values)
			System.out.println(ch.get(one));

		System.out.println("*********************");
		ch.remove("C");
		for (String one : values)
			System.out.println(ch.get(one));

	}
}
