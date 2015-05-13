package six.bits.stream;

import java.io.CharArrayReader;
import java.io.IOException;

public class Test
{
	private static String getFullBinaryString(char value, int len)
	{
		String s = Integer.toBinaryString(value);
		while (value < 0 && s.length() > len)
			s = s.substring(1);

		while (s.length() < len)
			s = "0" + s;
		return s;
	}

	public static void main(String[] args) throws IOException
	{
		char[] buf = new char[]
		{ 0x7fff, 0xadbc, 0x0048, 0x78, 0xff00, 0x2050, 0x1027, 0x0002, 0x7900, 0x8080 };

		System.out.println("the original: ");
		for (int i = 0; i < buf.length; i++)
			System.out.print(getFullBinaryString(buf[i], 16) + "    ");
		System.out.println();
		System.out.println("***************************");

		CharArrayReader car = new CharArrayReader(buf);

		BitInputStream bitIs = new BitInputStream(car);
		char[] converted = new char[(int) Math.ceil(buf.length * 16 / 6)];
		bitIs.readCharacters(converted);

		System.out.println("the converted: ");
		for (int i = 0; i < converted.length; i++)
			System.out.print(getFullBinaryString(converted[i], 6) + "    ");
		System.out.println();
	}
}
