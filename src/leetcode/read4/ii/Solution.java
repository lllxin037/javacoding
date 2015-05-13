package leetcode.read4.ii;

import java.io.IOException;

import leetcode.read4.Reader4;

/**
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * 
 * The return value is the actual number of characters read. For example, it
 * returns 3 if there is only 3 characters left in the file.
 * 
 * By using the read4 API, implement the function int read(char *buf, int n)
 * that reads n characters from the file.
 * 
 * Note: The read function may be called multiple times.
 * 
 */

public class Solution extends Reader4
{
	private char[] data = new char[4];

	// should be <= 4.
	private int dataSize = 0;
	private int dataOffset = 0;

	
	public Solution(String s)
	{
		super(s);
	}

	public int read(char[] buf, int n) throws IOException
	{
		int readBytes = 0;
		boolean eof = false;

		while (readBytes < n && !eof)
		{
			if (dataSize == 0)
			{
				dataSize = read4(data);
				dataOffset = 0;
				eof = (dataSize < 4);
			}

			int read = Math.min(dataSize, n - readBytes);
			System.arraycopy(data, dataOffset, buf, readBytes, read);

			dataOffset = (dataOffset + read) % 4;
			dataSize = dataSize - read;

			readBytes += read;
		}

		return readBytes;
	}
}
