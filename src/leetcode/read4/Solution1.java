package leetcode.read4;

import java.io.IOException;

/**
 * The API: int read4(char *buf) reads 4 characters at a time from a file. The
 * return value is the actual number of characters read. For example, it returns
 * 3 if there is only 3 characters left in the file. By using the read4 API,
 * implement the function int read(char *buf, int n) that reads n characters
 * from the file.
 * 
 * Note: The read function will only be called once for each test case.
 * 
 */

public class Solution1 extends Reader4 {

	public int read(char[] buf, int n) throws IOException {

		int toRead = Math.min(buf.length, n);
		if (toRead <= 0)
			return 0;

		int readCount = 0;
		boolean eof = false;
		char[] tmpBuf = new char[4];

		while (readCount < toRead && !eof) {

			int tmpCount = read4(tmpBuf);
			if (tmpCount < 4)
				eof = true;

			int copyCount = Math.min(toRead - readCount, tmpCount);
			System.arraycopy(tmpBuf, 0, buf, readCount, copyCount);

			readCount += copyCount;
		}

		return readCount;

	}
}
