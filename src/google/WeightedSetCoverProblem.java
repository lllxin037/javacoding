package google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * You are given a list of items / combo_items with their price list. And you
 * are given list of items to buy. Now you are asked to find which combination
 * to buy so that it costs you minimum. It doesnt matter if you are getting some
 * extra items if it costs less.
 * 
 * <pre>
 * Sr.No Price | Items/Combo_Items 
 * 1.	5	|	Burger 
 * 2.	4	|	French_Frice 
 * 3.	8	|	Coldrink 
 * 4.	12	|	Burger, French_Frice, Coldrink 
 * 5.	14 | Burger, Coldrink 
 * 
 * 
 * Input Items to Buy: 
 * Coldrink 
 * 
 * Output(Sr.No) 
 * 3 
 * 
 * Input Items to Buy: 
 * Burger Coldrink 
 * 
 * Output(Sr.No) 
 * 4 
 * 
 * Input Items to Buy: 
 * Burger French_Frice 
 * 
 * Output(Sr.No) 
 * 1,2
 * </pre>
 * 
 */

public class WeightedSetCoverProblem
{
	public static List<Bundle> resolve(List<Bundle> inventory,
			List<String> itemsToBuy, List<Bundle> bundlesBought)
	{
		if (itemsToBuy.isEmpty())
			return bundlesBought;

		List<Bundle> bestBundles = new ArrayList<Bundle>();

		String firstItem = itemsToBuy.get(0);
		List<Bundle> bundlesWithItem0 = getBundleWithItem(inventory, firstItem);

		int minPrice = Integer.MAX_VALUE;
		for (Bundle bundle : bundlesWithItem0)
		{
			List<String> toBuy = new ArrayList<String>(itemsToBuy);
			for (String s : bundle.items)
				toBuy.remove(s);

			List<Bundle> bought = new ArrayList<Bundle>(bundlesBought);
			bought.add(bundle);

			List<Bundle> bundlesBoughtR = resolve(inventory, toBuy, bought);

			int price = getPrice(bundlesBoughtR);
			if (price < minPrice)
			{
				minPrice = price;
				bestBundles = bundlesBoughtR;
			}
		}

		return bestBundles;
	}

	private static int getPrice(List<Bundle> bundlesBoughtCopy)
	{
		int price = 0;
		for (Bundle bundle : bundlesBoughtCopy)
		{
			price += bundle.price;
		}
		return price;
	}

	private static List<Bundle> getBundleWithItem(List<Bundle> inventory,
			String firstItem)
	{
		List<Bundle> bundlesWithItems = new ArrayList<Bundle>();
		for (Bundle bundle : inventory)
		{
			if (bundle.items.contains(firstItem))
			{
				bundlesWithItems.add(bundle);
			}
		}
		return bundlesWithItems;
	}

	public static void main(String[] args)
	{
		Set<String> names = new HashSet<String>();
		names.add("Burger");

		List<Bundle> bundles = new ArrayList<Bundle>();
		bundles.add(new Bundle(1, names, 5));

		names = new HashSet<String>();
		names.add("French_Frice");
		bundles.add(new Bundle(2, names, 4));

		names = new HashSet<String>();
		names.add("Coldrink");
		bundles.add(new Bundle(3, names, 8));

		names = new HashSet<String>();
		names.add("Burger");
		names.add("French_Frice");
		names.add("Coldrink");
		bundles.add(new Bundle(4, names, 12));

		names = new HashSet<String>();
		names.add("Burger");
		names.add("Coldrink");
		bundles.add(new Bundle(5, names, 14));

		List<String> items = new ArrayList<String>();
		items.add("Burger");
		items.add("French_Frice");
		System.out.println(resolve(bundles, items, new ArrayList<Bundle>()));

		items.clear();
		items.add("Coldrink");
		System.out.println(resolve(bundles, items, new ArrayList<Bundle>()));

		items.clear();
		items.add("Burger");
		items.add("Coldrink");
		System.out.println(resolve(bundles, items, new ArrayList<Bundle>()));
	}

	private static class Bundle
	{
		private int id;
		private Set<String> items;
		private int price;

		Bundle(int id, Set<String> items, int price)
		{
			this.id = id;
			this.items = new HashSet<String>();
			this.items.addAll(items);

			this.price = price;
		}

		public String toString()
		{
			return "Bundle [id=" + id + ", items=" + items + ", price=" + price
					+ "]";
		}
	}

}
