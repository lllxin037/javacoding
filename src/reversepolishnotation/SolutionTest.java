package reversepolishnotation;



public class SolutionTest
{
	public static void main(String args[])
	{
		Solution sol = new Solution();
		
		String[] tokens1 = {"2", "1", "+", "3", "*"};		
		System.out.println( sol.evalRPN(tokens1) );
		
		String[] tokens2 = {"4", "13", "5", "/", "+"}; 
		System.out.println( sol.evalRPN(tokens2) );
	}
}
