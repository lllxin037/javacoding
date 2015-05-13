import java.text.MessageFormat;

public class MessageFormatTest
{

	public static void main(String[] args)
	{
		
		MessageFormat mf = new MessageFormat(" {0} {0,choice,1#file was|1<files were} not found in {1,choice,1#the target storage location|1<any target storage location}.");
		
		int file = 2;
		int location = 2;
		Object[] testArgs = {new Long(file), new Integer(location)};
		
		System.out.println(mf.format(testArgs));

	}

}
