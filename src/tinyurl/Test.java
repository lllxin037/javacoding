package tinyurl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test
{
	private static List<String> createLongURLs()
	{
		return Arrays.asList("/help_XXXXXXXXXXXX", "/index_AAAAAAAAAAAA",
				"/play_CCCCCCCCCCCC", "/download_DDDDDDDDDDDD",
				"/temp_KKKKKKKKKKKKKKK", "/marketing_MMMMMMMMMMM");
	}

	private static List<Node> createNodes(int count)
	{
		List<Node> nodes = new ArrayList<Node>();
		String nodeNamePre = "Node";
		for (int i = 1; i <= count; i++)
			nodes.add(new Node(nodeNamePre + i));
		return nodes;
	}

	public static void main(String[] args)
	{
		List<Node> nodes = createNodes(3);
		ConsistentHash<Node> ch = new ConsistentHash<Node>(50, nodes);

		List<String> longURLs = createLongURLs();
		List<String> shortURLs = new ArrayList<String>();

		TinyURL s1 = new TinyURL();

		for (String url : longURLs)
		{
			Node one = ch.get(url);
			long hash = ConsistentHash.md5HashingAlg(url);

			shortURLs.add(s1.produce(Util.toShortURLRangeHash(hash)));
			one.putURL(hash, url);

			System.out.println("##########################");
			System.out.println("url :" + url + "\t\t" + "short url:"
					+ s1.produce(Util.toShortURLRangeHash(hash)) + "\t\t Node:"
					+ one.getName() + "\t\t" + hash + "\t\t "
					+ Util.toShortURLRangeHash(hash));

		}

		System.out.println("\n\n\n");
		for (Node one : nodes)
			one.dump();
		System.out.println("\n\n\n");

		for (String url : shortURLs)
		{
			int hash = Util.toConsistentHash(s1.resolve(url));
			System.out.println("short url: " + url + "\t\t" + ch.find(hash));
		}
	}
}
