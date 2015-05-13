package o1.data.structure;

public class Test
{

	public static void main(String[] args)
	{
		Solution s = new Solution();

		s.insert(Integer.valueOf(10));
		s.insert(Integer.valueOf(20));
		s.insert(Integer.valueOf(30));
		s.insert(Integer.valueOf(40));
		s.insert(Integer.valueOf(50));
		s.insert(Integer.valueOf(10));
		s.insert(Integer.valueOf(10));
		s.insert(Integer.valueOf(40));

		System.out.println("Random" + s.getRandom());
		System.out.println("Random" + s.getRandom());
		System.out.println("Random" + s.getRandom());
		
		s.remove(Integer.valueOf(10));
		s.remove(Integer.valueOf(40));
		s.remove(Integer.valueOf(20));

		System.out.println("Random" + s.getRandom());
		System.out.println("Random" + s.getRandom());
		System.out.println("Random" + s.getRandom());
		
		System.out.println("contains 20: " + s.contains(Integer.valueOf(20)));
		System.out.println("contains 40: " + s.contains(Integer.valueOf(40)));
		System.out.println("contains 10: " + s.contains(Integer.valueOf(10)));
	}
}
