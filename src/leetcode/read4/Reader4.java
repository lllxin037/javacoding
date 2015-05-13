package leetcode.read4;

import java.io.IOException;
import java.io.StringReader;

public class Reader4 {
	private StringReader sr = null;

	public Reader4() {

	}

	public Reader4(String s) {
		if (s == null)
			throw new IllegalArgumentException();

		this.sr = new StringReader(s);
	}

	public int read4(char[] buf) throws IOException {
		int count = sr.read(buf);
		if (count == -1)
			return 0;

		return count;
	}

	public void setInputSource(String s) {
		
		if (this.sr != null) {

			sr.close();
			sr = null;
		}

		this.sr = new StringReader(s);

	}

}
