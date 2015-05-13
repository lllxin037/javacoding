package google;
/**
 * Given API: int Read4096(char* buf); It reads data from a file and records the
 * position so that the next time when it is called it read the next 4k chars
 * (or the rest of the file, whichever is smaller) from the file. The return is
 * the number of chars read.
 * 
 * Todo: Use above API to Implement API "int Read(char* buf, int n)" which reads
 * any number of chars from the file.
 * 
 */

public class Read4096
{
	public int read4096(char[] buf)
	{
		return 0;
	}

	public int read(char[] buf, int n)
	{
		if (buf == null || n == 0)
			return 0;

		int offset = 0;
		int maxLen = Math.min(buf.length, n);

		char[] internalBuf = new char[4096];
		boolean isEnd = false;
		while (!isEnd && offset < maxLen)
		{
			int readNum = read4096(internalBuf);
			if (readNum <= 0)
				break;
			else if (readNum < 4096)
				isEnd = true;

			if (offset + readNum > maxLen)
				readNum = n - offset;

			System.arraycopy(internalBuf, 0, buf, offset, readNum);
			offset += readNum;
		}
		return offset;
	}
}
