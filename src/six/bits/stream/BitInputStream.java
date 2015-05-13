package six.bits.stream;

import java.io.CharArrayReader;
import java.io.IOException;
import java.io.Reader;

/**
 * 一个bit的stream， 每次读取6个bit。转化成char。
 * 
 * 
 */

public class BitInputStream
{
	private static final int CHAR_BITS = 16;
	private static final int EXPECTED_BITS = 6;
	private static final int EXPECTED_MASK = 0x3f;
	private static final char INVALID_LAST = (char) -1;
	private Reader is;

	private int nextBitPos;
	private char last;

	public BitInputStream(CharArrayReader aIs)
	{
		this.is = aIs;

	}

	/**
	 * Reads characters in count.
	 * 
	 * @param count
	 * @return
	 */

	public int readCharacters(char[] c) throws IOException
	{
		last = INVALID_LAST;
		nextBitPos = 0;

		int value = 0;
		int count = c.length;
		for (int i = 0; i < count; i++)
		{
			int one = read();
			c[i] = (char) one;
		}
		return value;
	}

	private int read() throws IOException
	{
		int value = 0;
		int toReadBits = EXPECTED_BITS;
		if (last != INVALID_LAST && (nextBitPos > 0 && nextBitPos < CHAR_BITS))
		{
			value = ((last >> nextBitPos) & EXPECTED_MASK);
			toReadBits = EXPECTED_BITS - (CHAR_BITS - nextBitPos);
		}

		// just finished.
		if (toReadBits == 0)
		{
			last = INVALID_LAST;
			nextBitPos = 0;
			return value;
		}

		if (toReadBits < 0)
		{
			nextBitPos = nextBitPos + EXPECTED_BITS;
			return value;
		}

		int oneByte = is.read();
		if (oneByte == -1)
			return value;

		// tricky part to make sure high bits are 0, low bits are 1.
		int mask = (-1 & 0xFFFF);
		mask = (mask >> (CHAR_BITS - toReadBits));

		value = ((oneByte & mask) << (EXPECTED_BITS - toReadBits)) | value;

		nextBitPos = toReadBits;
		if (nextBitPos > 0)
			last = (char) oneByte;

		return (byte) value;
	}
}
