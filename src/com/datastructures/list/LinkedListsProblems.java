package com.datastructures.list;

public class LinkedListsProblems {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(3);
		ListNode node6 = new ListNode(5);
		ListNode node7 = new ListNode(6);
		ListNode node8 = new ListNode(7);
		ListNode node9 = new ListNode(8);
		ListNode node10 = new ListNode(8);
		ListNode node11 = new ListNode(8);
		
		LinkedList source = new LinkedList();
		source.insertAtEnd(node1);
		source.insertAtEnd(node2);
		source.insertAtEnd(node3);
		source.insertAtEnd(node4);
		source.insertAtEnd(node5);
		source.insertAtEnd(node6);
		
		
		removeDuplicates(source);
		System.out.println(source);
	}
	
	// 1->2->3->3->3->5->6->7->8->8->8->null
	//    ^  ^
	//   p0  p1
	//
	// 1->2->3------->5->6->7->8->8->8->null
	//       ^        ^
	//      p0        p1
	//
	// 1->2->3------->5->6->7->8  8->8->null
	//                         ^        ^
	//                        p0        p1
	
	/**
	 * Remove duplicates from the ordered linked list.
	 */
	static void removeDuplicates(LinkedList source) {
		if (source == null)
			throw new IllegalArgumentException("Linked list to remove duplicates cannot be null");
		
		if (source.getHead() == null)
			throw new IllegalArgumentException("Linked list to remove duplicates cannot be empty");
		
		if (source.getHead().getNext() == null) // one node list
			return;
		
		// reset pointers
		ListNode p0 = source.getHead();
		ListNode p1 = p0.getNext();

		while (p1 != null) {
			if (p0.getData() == p1.getData()) {
				if (p0.getNext() != null) { // we didn't start to move p1
					p0.setNext(null);
					p1 = p1.getNext();
				} else { // move p1 until a different node
					p1 = p1.getNext();
				}
			} else {
				if (p0.getNext() != null) {
					p1 = p1.getNext();
					p0 = p0.getNext();
				} else {
					// connect p0 to the different node p1
					p0.setNext(p1);

					// move both pointers
					p1 = p1.getNext();
					p0 = p0.getNext();
				}
			}
		}
		
	}

	/**
	 * Split a source linked list into two lists. If the number
	 * of items is odd the additional item is held on the first. 
	 */
	static void frontBackSplit(LinkedList source, LinkedList frontRef, LinkedList backRef) { // O(n)
		ListNode slow = null;
		ListNode fast = null;
		
		// Lists cannot be null
		if (source == null || frontRef == null || backRef == null)
			throw new IllegalArgumentException("Lists cannot be null");

		// Source list cannot be empty
		if (source.getHead() == null)
			throw new IllegalArgumentException("Source list cannot be empty");
		
		// Target lists must be empty
		if (frontRef.getLength() != 0 || backRef.getLength() != 0)
			throw new IllegalArgumentException("Target lists must be empty");
		
		slow = fast = source.getHead();

		// Adjust the backRef
		backRef.setHead(slow);
		
		while (fast != null) {
			fast = fast.getNext(); // move fast
			if (fast == null) {
				break;
			}
			
			fast = fast.getNext(); // move fast again
			if (fast != null) {
				slow = slow.getNext();	
			}
		}
		
		// Adjust the frontRef
		frontRef.setHead(slow.getNext());
		slow.setNext(null);
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
