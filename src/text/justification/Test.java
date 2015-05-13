package text.justification;

import java.util.ArrayList;

public class Test
{
	private static void oneCase(String[] words, int L)
	{
		System.out.println("#########################");
		Solution s1 = new Solution();

		ArrayList<String> ret = s1.fullJustify(words, L);
		for (int i = 0; i < ret.size(); i++)
		{
			System.out.print("[");
			System.out.print(ret.get(i));
			System.out.println("]");
		}

		System.out.println("#########################\n\n");
	}

	public static void main(String args[])
	{
		/**/
		oneCase(new String[]
		{ "This", "is", "an", "example", "of", "text", "justification." }, 16);

		oneCase(new String[]
		{ "This", "this", "this" }, 6);

		oneCase(new String[]
		{ "This", "is", "an" }, 5);

		oneCase(new String[]
		{ "This", "is", "an" }, 4);

		oneCase(new String[]
		{ "" }, 0);

		oneCase(new String[]
		{ "a", "b", "c", "d", "e" }, 3); 

		oneCase(new String[]
		{ "What", "must", "be", "shall", "be." }, 12);

		oneCase(new String[]
		{ "Listen", "to", "many,", "speak", "to", "a", "few." }, 6);

		/**
		 * <pre>
		 * Input:  ["What","must","be","shall","be."], 12
		 * Output: ["What must be","shall    be."]
		 * Expected:   ["What must be","shall be.   "]
		 * 
		 * 
		 * 
		 * Input:  ["Listen","to","many,","speak","to","a","few."], 6
		 * Output: ["Listen","to    ","many, ","speak ","to  a ","few.  "]
		 * Expected:   ["Listen","to    ","many, ","speak ","to   a","few.  "]
		 * 
		 * </pre>
		 */
	}
}
