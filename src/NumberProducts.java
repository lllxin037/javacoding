/**
 * Given an array of numbers, nums, return an array of numbers products, where
 * products[i] is the product of all nums[j], j != i.
 * 
 * <pre>
 * Input : [1, 2, 3, 4, 5]
 * Output: [(2*3*4*5), (1*3*4*5), (1*2*4*5), (1*2*3*5), (1*2*3*4)]
 *       = [120, 60, 40, 30, 24]
 * You must do this in O(N) without using division.
 * </pre>
 * 
 * 
 * 
 */

public class NumberProducts
{

	/**
	 * <pre>
	 * {              	   1,	a[0],    			a[0]*a[1],    	a[0]*a[1]*a[2], 	a[0]*a[1]*a[2]*a[3] }
	 * { a[1]*a[2]*a[3]*a[4],   a[2]*a[3]*a[4],     a[3]*a[4],		a[4],               1,  }
	 * </pre>
	 * 
	 * @param a
	 * @return
	 */
	public int[] getProducts(int[] a)
	{
		if (a == null || a.length == 0)
			return null;

		int[] products = new int[a.length];
		int p = 1;
		for (int i = 0; i < products.length; i++)
		{
			products[i] = p;
			p = p * a[i];
		}

		p = 1;
		for (int i = a.length - 1; i >= 0; i--)
		{
			products[i] = p * products[i];
			p = p * a[i];
		}

		return products;
	}
}
