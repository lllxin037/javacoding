class ListNode
{
	int val;
	ListNode next;
};

public class Test
{
	// - Single linked list: Reverse it (iterative). Return the head.
	public ListNode reverseIterative(ListNode head)
	{
		if (head == null)
			return null;

		ListNode pre = null;
		while (head != null)
		{
			ListNode next = head.next;
			head.next = pre;
			pre = head;

			head = next;
		}

		return pre;
	}

	// - Single linked list: Reverse it (recursive). Return the head.
	public ListNode reverseRecursive(ListNode head)
	{
		ListNode newHead = null;
		if (head.next != null)
		{
			newHead = reverseRecursive(head.next);
			head.next.next = head;
			head.next = null;
		}
		else
			newHead = head;

		return newHead;
	}

	// - Single linked list: Detect a cycle. Return boolean
	public boolean detectCycle(ListNode head)
	{
		ListNode fast = head, slow = head;

		while (fast != null)
		{
			slow = slow.next;
			if (fast.next != null)
				fast = fast.next.next;
			else
				return false;

			if (slow == fast)
				return true;
		}

		return false;
	}

	/**
	 * Array of integers sorted in ASC order: Remove duplicates.
	 * 
	 * for example: input: 1, 1, 2, 3, 3 return: 3, the array changed to: 1, 2,
	 * 3, ?, ?
	 * 
	 * @param intArray
	 *            input values.
	 * @return the count of unique elements in the array.
	 */
	public int removeDuplicates(int[] intArray)
	{
		if (intArray == null || intArray.length == 0)
			return 0;

		int last = 0;

		for (int i = 1; i < intArray.length; i++)
		{
			if (intArray[last] != intArray[i])
			{
				last++;
				if (last != i)
					intArray[last] = intArray[i];
			}
		}

		return last + 1;
	}

	// - Reverse characters in an array, with no extra memory.
	public char[] reverseCharacters(char[] S2, int start, int end)
	{
		while (start < end)
		{
			char tmp = S2[start];
			S2[start] = S2[end];
			S2[end] = tmp;
			start++;
			end--;
		}
		return S2;
	}

	// - Reverse words in an sentence with no extra memory.
	public char[] reverseWordsInASentence(char[] S2)
	{
		// reverse S2;
		reverseCharacters(S2, 0, S2.length - 1);

		// reverse each word again.
		int start = -1;
		int end = -1;

		for (int i = 0; i < S2.length; i++)
		{
			if (start == -1 && S2[i] != ' ')
				start = i;

			if (end == -1 && S2[i] == ' ')
				end = i;

			if (start != -1 && end != -1)
			{
				// S2[end] is space for now.
				reverseCharacters(S2, start, end - 1);
				start = i;
				end = -1;
			}
		}

		return S2;
	}

	public void print(ListNode head)
	{
		while (head != null)
		{
			System.out.print(head.val + ",");
			head = head.next;
		}
		System.out.println();
	}

	public ListNode clone(ListNode head)
	{
		ListNode copyHead = new ListNode();
		ListNode copy = copyHead;

		while (head != null)
		{
			copy.val = head.val;
			if (head.next != null)
				copy.next = new ListNode();
			head = head.next;
			copy = copy.next;
		}

		return copyHead;
	}

	public void print(int[] array, int length)
	{
		for (int i = 0; i < length; i++)
			System.out.print(array[i] + ",");
		System.out.println();
	}

	public static void main(String[] args)
	{

		// Initialize
		ListNode ele1 = new ListNode();
		ListNode ele2 = new ListNode();
		ListNode ele3 = new ListNode();
		ListNode ele4 = new ListNode();
		ListNode ele5 = new ListNode();
		ele1.val = 1;
		ele2.val = 2;
		ele3.val = 3;
		ele4.val = 4;
		ele5.val = 5;
		ele1.next = ele2;
		ele2.next = ele3;
		ele3.next = ele4;
		ele4.next = ele5;
		ele5.next = null;

		String str = "Alice in Wonderland";

		Test test = new Test();

		// TEST 1- reversing singly linked list using iteration
		System.out.println("\n*********** reverseIterative ************ ");
		ListNode testEle = test.clone(ele1);
		System.out.print("BEFORE REVERSING --> ");
		test.print(testEle);

		ListNode reversed_ll = test.reverseIterative(testEle);
		System.out.print("AFTER REVERSING --> ");
		test.print(reversed_ll);
		System.out.println("Expected --> 5,4,3,2,1");

		// TEST 2- reversing singly linked list using recursion
		System.out.println("\n*********** reverseRecursive ************ ");
		testEle = test.clone(ele1);
		System.out.print("BEFORE REVERSING --> ");
		test.print(testEle);

		reversed_ll = test.reverseRecursive(testEle);
		System.out.print("AFTER REVERSING --> ");
		test.print(reversed_ll);
		System.out.println("Expected --> 5,4,3,2,1");

		// TEST 3- Detect a cycle. )
		System.out.println("\n*********** detectCycle ************ ");
		testEle = test.clone(ele1);

		System.out.println("Before : Cycle detected = "
				+ test.detectCycle(testEle));

		// add cycle
		ListNode head = testEle;
		while (head.next != null)
		{
			head = head.next;
		}
		head.next = testEle;

		System.out.println("After : Cycle detected = "
				+ test.detectCycle(testEle));
		System.out.println("Expected --> true");

		// TEST 4- - Array of integers sorted in ASC order: Remove duplicates.
		// Return the array. Return the new size.
		System.out.println("\n*********** removeDuplicates ************ ");
		int[] intArray =
		{ 1, 2, 3, 4, 4, 5, 6, 6, 7, 8 };
		System.out.print("Array before -->");
		test.print(intArray, intArray.length);

		int length = test.removeDuplicates(intArray);
		System.out.print("Array After -->");
		test.print(intArray, length);
		System.out.println("Expected --> 1,2,3,4,5,6,7,8,");

		// TEST 6- - Reverse characters in an array, with no extra memory.
		System.out.println("\n*********** reverseCharacters ************ ");
		char[] S2 = str.toCharArray();

		System.out.println("Char Array before --> " + new String(S2));
		test.reverseCharacters(S2, 0, S2.length - 1);
		System.out.println("Char Array after --> " + new String(S2));
		System.out.println("Expected --> dnalrednoW ni ecilA");

		// TEST 7- - Reverse words in an character array, with no extra memory.
		System.out
				.println("\n*********** reverseWordsInASentence ************ ");
		S2 = str.toCharArray();

		System.out.println("Char Array before --> " + new String(S2));
		test.reverseWordsInASentence(S2);
		System.out.println("Char Array after --> " + new String(S2));
		System.out.println("Expected --> Wonderland in Alice");
	}
}
