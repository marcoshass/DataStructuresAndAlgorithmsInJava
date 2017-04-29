package com.datastructures.list;

public class LinkedListsProblems {

	public static void main(String[] args) {
		LinkedList a = new LinkedList();
		a.insertAtEnd(new ListNode(1));
		a.insertAtEnd(new ListNode(5));
		a.insertAtEnd(new ListNode(7));

		LinkedList b = new LinkedList();
		b.insertAtEnd(new ListNode(4));
		b.insertAtEnd(new ListNode(6));
		b.insertAtEnd(new ListNode(8));

		System.out.println(appendSecondList(a, b));
	}
	
	static boolean isNullOrEmpty(LinkedList list) {
		return list == null || list.getLength() == 0;
	}
	
	static void copyElements(LinkedList target, LinkedList source) {
		ListNode current = source.getHead();
		while (current != null) {
			target.insertAtEnd(new ListNode(current.getData()));
			current = current.getNext();
		}
	}
	
	// O(n)
	static LinkedList appendSecondList(LinkedList a, LinkedList b) {
		LinkedList newList = new LinkedList();
		
		// special conditions
		if (isNullOrEmpty(a) & isNullOrEmpty(b)) {
			return null;
		} else if (!isNullOrEmpty(a) & isNullOrEmpty(b)) {
			// in case of just the a list is filled we're done
			copyElements(newList, a);
		} else if (isNullOrEmpty(a) & !isNullOrEmpty(b)) {
			// copy elements from b to a
			copyElements(newList, b);
		} else {
			// both lists contain data, stop at the last node 
			// from a and connect it to the first node of b
			ListNode currentA = a.getHead();
			while (currentA.getNext() != null) {
				currentA = currentA.getNext();
			}
			currentA.setNext(b.getHead());
			copyElements(newList, a);
		}

		return newList;
	}

	// O(n)
	static int getLength(ListNode head) {
		int length = 0;
		while (head != null) {
			head = head.getNext();
			length++;
		}
		return length;
	}
	
	// O(n)
	static ListNode getNthNode(ListNode head, int n) {
		if (n < 0) 
			throw new IllegalArgumentException("Invalid search position.");

		for (int i = 0; i <= n; i++) {
			if (head == null) {
				break;
			} else if (i == n) {
				return head;
			} else {
				head = head.getNext();
			}
		}
		
		// position is after the last node
		return null;
	}
	
	/**
	 * Appends data to the end of the linked list.
	 */
	static void appendData(LinkedList list, int data) {
		if (list == null)
			throw new IllegalArgumentException("List to append cannot be null.");
		
		ListNode newNode = new ListNode(data);
		
		// new node becomes the head
		if (list.getHead() == null) {
			list.insertAtBegin(newNode);
		} else {
			ListNode current = list.getHead();
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(newNode);
		}
		
	}
	
	/**
	 * Pop a linked list element as if it was a stack. 
	 */
	static ListNode pop(LinkedList list) {
		if (list == null)
			throw new IllegalArgumentException("List to pop element cannot be null.");
		
		return list.removeFromBegin();
	}
	
	
}
