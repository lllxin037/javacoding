import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Find the longest words in a given list of words that can be constructed from
 * a given list of letters. Your solution should take as its first argument the
 * name of a plain text file that contains one word per line. The remaining
 * arguments define the list of legal letters. A letter may not appear in any
 * single word more times than it appears in the list of letters (e.g., the
 * input letters 'a a b c k' can make 'back' and 'cab' but not 'abba').
 * 
 * <pre>
 * Here's an example of how it should work:
 * 
 * prompt> word-maker WORD.LST w g d a s x z c y t e i o b
 * ['azotised', 'bawdiest', 'dystocia', 'geotaxis', 'iceboats', 'oxidates', 'oxyacids', 'sweatbox', 'tideways']
 * </pre>
 * 
 * Tip: Just return the longest words which match, not all.
 * 
 */

public class WordMaker
{
	public static void main(String[] args)
	{
		if (args.length < 2)
		{
			// print out usage.
			return;
		}

		String fileName = args[0];
		char[] letters = new char[args.length - 1];
		for (int i = 1; i < args.length; i++)
			letters[i - 1] = args[i].charAt(0);

		byte[] target = new byte[256];
		for (char c : letters)
			target[c]++;

		List<String> selectedWords = new ArrayList<String>();
		int maxLen = 0;
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			
			String word = br.readLine();
			while (	word != null )
			{
				if (word.length() < maxLen)
				{
					word = br.readLine();
					continue;
				}
				
				byte[] tmp = new byte[256];
				boolean unmatched = false;
				for (int i = 0; i < word.length(); i++)
				{
					char c = word.charAt(i);
					if (target[c] == 0 || ++tmp[c] > target[c])
					{
						unmatched = true;
						break;
					}
				}
				
				if (!unmatched)
				{
					if (word.length() > maxLen)
					{
						selectedWords.clear();
						maxLen = word.length();
					}
					
					selectedWords.add(word);
				}
				
				word = br.readLine();
			}
			
			br.close();
		}
		catch (FileNotFoundException e)
		{
			System.err.println( e.getStackTrace() );
		}
		catch (IOException e)
		{
			System.err.println( e.getStackTrace() );
		}
		
		System.out.println(selectedWords);
	}
}
