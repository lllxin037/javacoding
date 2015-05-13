package google;

import java.util.Arrays;
import java.util.Stack;

public class DoubleLinkedList
{
	private Stack<Integer> prefix;
	private Stack<Integer> suffix;

	private int count;

	public DoubleLinkedList()
	{
		count = 0;
		prefix = new Stack<Integer>();
		suffix = new Stack<Integer>();
	}

	public void insertInBeginning(int data)
	{
		while (!prefix.isEmpty())
			suffix.push(prefix.pop());

		prefix.push(data);
		count++;
	}

	public void insertAtEnd(int data)
	{
		while (!suffix.isEmpty())
			prefix.push(suffix.pop());

		suffix.push(data);
		count++;
	}

	public void moveForward()
	{
		while (!suffix.isEmpty())
		{
			int temp = suffix.pop();
			prefix.push(temp);
		}
	}

	public void moveBackward()
	{
		while (!prefix.isEmpty())
		{
			int temp = prefix.pop();
			suffix.push(temp);
		}
	}

	public void delete(int data)
	{
		while (!prefix.isEmpty())
		{
			suffix.push(prefix.pop());
		}
		while (!suffix.isEmpty())
		{
			if (suffix.peek() == data)
			{
				suffix.pop();
				count--;
				return;
			}
			else
			{
				prefix.push(suffix.pop());
			}
		}
	}

	public void deleteFirst()
	{
		while (!prefix.isEmpty())
		{
			int tmp = prefix.pop();
			if (prefix.isEmpty())
			{
				count--;
				return;
			}

			suffix.push(tmp);
		}
	}

	public void deleteLast()
	{
		while (!suffix.isEmpty())
		{
			int tmp = suffix.pop();
			if (suffix.isEmpty())
			{
				count--;
				return;
			}

			prefix.push(tmp);
		}
	}

	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		sb.append(Arrays.asList(prefix.toArray()).toString());
		sb.append(Arrays.asList(suffix.toArray()).toString());

		return sb.toString();
	}

	public static void main(String args[])
	{
		DoubleLinkedList list = new DoubleLinkedList();
		list.insertInBeginning(4);
		list.insertInBeginning(3);
		list.insertInBeginning(2);
		list.insertInBeginning(1);

		System.out.println(list.toString());
		
		list.insertAtEnd(5);
		list.insertAtEnd(6);
		list.insertAtEnd(7);

		System.out.println(list.toString());

		list.moveBackward();
		list.moveForward();

		list.delete(5);

		System.out.println(list.toString());
		list.moveBackward();
		list.moveForward();

		System.out.println(list.toString());
	}
}
