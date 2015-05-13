package epi.stackandqueues;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class StackWithMax {
	// record <maxvalue, occur_times>
	private LinkedList<Element> s = new LinkedList<Element>();

	public boolean isEmpty() {
		return s.isEmpty();
	}

	public void push(Integer v) {
		int max = Math.max((s.isEmpty() ? v.intValue() : s.getLast().max),
				v.intValue());
		s.addLast(new Element(v, max));
	}

	public Integer peek() {
		if (s.isEmpty())
			throw new EmptyStackException();

		return s.getLast().t;
	}

	public Integer pop() {
		if (s.isEmpty())
			throw new EmptyStackException();

		Integer v = s.removeLast().t;

		return v;
	}

	public Integer max() {
		if (s.isEmpty())
			throw new EmptyStackException();

		return s.getLast().max;

	}

	private static class Element {
		private Integer t;
		private int max;

		Element(Integer t, int max) {
			this.t = t;
			this.max = max;
		}
	}

	public static void main(String[] args) {
		StackWithMax s = new StackWithMax();
		s.push(2);
		s.push(2);
		System.out.println("max " + s.max()); // 2
		s.push(1);
		System.out.println("max " + s.max()); // 2
		s.push(4);
		System.out.println("max " + s.max()); // 4
		s.push(5);
		System.out.println("max " + s.max()); // 5
		s.push(5);
		System.out.println("max " + s.max()); // 5
		s.push(3);
		System.out.println("max " + s.max()); // 5

		s.pop(); // pop 3
		System.out.println("max " + s.max()); // 5
		s.pop(); // pop 5
		System.out.println("max " + s.max()); // 5
		s.pop(); // pop 5
		System.out.println("max " + s.max()); // 4
		s.pop(); // pop 4
		System.out.println("max " + s.max()); // 2

		s.push(0);
		System.out.println("max " + s.max()); // 2

		s.push(3);
		System.out.println("max " + s.max()); // 3

		s.pop(); // pop 3
		System.out.println("max " + s.max()); // 2

		s.pop(); // pop 0
		System.out.println("max " + s.max()); // 2

		s.pop(); // pop 1
		System.out.println("max " + s.max()); // 2

		s.pop(); // pop 2
		System.out.println("max " + s.max()); // 2

		s.pop(); // pop 2
		System.out.println("max " + s.max()); // exception

	}
}
