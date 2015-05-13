package leetcode.read4.ii;

import java.io.IOException;

import leetcode.read4.Reader4;

public class Solution1 extends Reader4 {

	private char[] localBuf = new char[4];

	// from 0 to 3.
	private int localOffset = -1;
	private int localSize = 0;

	public int read(char[] buf, int n) throws IOException {

		int size = Math.min(buf.length, n);
		if (size <= 0)
			return 0;

		int readCount = 0;
		boolean eof = false;

		while (!eof && readCount < size) {

			if (localSize == 0) {
				localSize = read4(localBuf);
				if (localSize < 4)
					eof = true;
				localOffset = 0;
			}

			int copyCount = Math.min(size - readCount, localSize);
			System.arraycopy(localBuf, localOffset, buf, readCount, copyCount);

			readCount += copyCount;
			localSize = localSize - copyCount;
			localOffset = (localOffset + copyCount) % 4;

		}

		return readCount;
	}
}
