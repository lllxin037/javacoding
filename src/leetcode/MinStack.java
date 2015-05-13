package leetcode;

import java.util.EmptyStackException;
import java.util.Stack;

class MinStack {

	private Stack<Element> stack = new Stack<Element>();

	public void push(int x) {

		int min = Math.min((stack.isEmpty() ? x : stack.peek().min), x);
		stack.push(new Element(x, min));
	}

	public void pop() {

		if (stack.isEmpty())
			throw new EmptyStackException();

		stack.pop();
	}

	public int top() {
		if (stack.isEmpty())
			throw new EmptyStackException();

		return stack.peek().value;
	}

	public int getMin() {
		if (stack.isEmpty())
			throw new EmptyStackException();

		return stack.peek().min;
	}

	private static class Element {
		private int value;
		private int min;

		Element(int value, int min) {
			this.value = value;
			this.min = min;
		}
	}
}
