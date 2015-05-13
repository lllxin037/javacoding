package leetcode.read4;

import java.io.IOException;

/**
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * 
 * The return value is the actual number of characters read. For example, it
 * returns 3 if there is only 3 characters left in the file.
 * 
 * By using the read4 API, implement the function int read(char *buf, int n)
 * that reads n characters from the file.
 * 
 * Note: The read function will only be called once for each test case.
 * 
 */

/*
 * The read4 API is defined in the parent class Reader4. int read4(char[] buf);
 */

public class Solution extends Reader4
{

	public Solution(String s)
	{
		super(s);
	}

	/**
	 * @param buf
	 *            Destination buffer
	 * @param n
	 *            Maximum number of characters to read
	 * @return The number of characters read
	 */
	public int read(char[] buf, int n) throws IOException
	{
		char[] data = new char[4];
		int readBytes = 0;
		boolean eof = false;

		while (readBytes < n && !eof)
		{
			int read = read4(data);

			// no more data;
			if (read < 4)
				eof = true;
			// To make sure that the buffer is not copied more than n bytes,
			// copy the remaining bytes (n ¨C readBytes) or the number of bytes
			// read, whichever is smaller.

			read = Math.min(read, n - readBytes);

			System.arraycopy(data, 0, buf, readBytes, read);
			readBytes += read;
		}

		return readBytes;
	}
}
