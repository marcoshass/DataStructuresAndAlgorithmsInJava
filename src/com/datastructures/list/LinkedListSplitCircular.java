package com.datastructures.list;

public class LinkedListSplitCircular {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
//		ListNode node6 = new ListNode(6);
		
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node1);
		
		ListNode ret = splitCircular(node1);
		System.out.println("Ok");
	}
	
	// time complexity: O(n)
	// space complexity: O(1)
	static ListNode splitCircular(ListNode head) {
		ListNode slowPtr = head;
		ListNode fastPtr = head;

		// null or single element lists are no supported
		if (head == null || head.getNext() == null) {
			return null;
		}

		while (true) { // O(n)
			fastPtr = fastPtr.getNext().getNext();
	
			if (fastPtr == head) {
				break;
			} else if (fastPtr.getNext() == head) {
				slowPtr = slowPtr.getNext();
				break;
			} else {
				slowPtr = slowPtr.getNext();
			}
			
		}
		
		// build the second list pointing to itself
		ListNode secondList = slowPtr.getNext();
		ListNode p = secondList;
		while (p.getNext() != head) { // O(n)
			p = p.getNext();
		}
		p.setNext(secondList);

		// break the first list loop
		slowPtr.setNext(head);
		return secondList;
	}

}
