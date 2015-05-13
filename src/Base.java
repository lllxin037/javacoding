public class Base
{
	protected int a;

	Base()
	{
		a = 10;
	}

	protected int getAPlus()
	{
		return 30;
	}

	static class Inheritance extends Base
	{
		Inheritance()
		{
			a = 20;
		}

		protected int getAPlus()
		{
			return 40;
		}
	}

	public static void main(String[] args)
	{
		char[] tmp = String.valueOf(56).toCharArray();
		
	}
}
