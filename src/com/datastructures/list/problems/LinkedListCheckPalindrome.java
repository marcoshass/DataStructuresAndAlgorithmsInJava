package com.datastructures.list.problems;

import com.datastructures.list.ListNode;

public class LinkedListCheckPalindrome {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);

		ListNode node5 = new ListNode(4);
		ListNode node6 = new ListNode(3);
		ListNode node7 = new ListNode(2);
		ListNode node8 = new ListNode(1);
		
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node6);
		node6.setNext(node7);
		node7.setNext(node8);
		
		System.out.println(isPalindrome(node1));
	}
	
	// time complexity: O(n)
	// space complexity: O(1)
	static boolean isPalindrome(ListNode head) {
		if (head == null || head.getNext() == null) 
			throw new IllegalArgumentException("Single node list can't be a palindrome");
		
		ListNode slowPtr = head;
		ListNode fastPtr = slowPtr;
		
		// split the list on the middle
		while (true) {
			fastPtr = fastPtr.getNext().getNext();
			if (fastPtr == null) {
				break;
			} else if (fastPtr.getNext() == null) {
				// list has an odd quantity of nodes
				return false;
			} else {
				slowPtr = slowPtr.getNext();
			}
		}
		
		// break the lists
		ListNode p1 = slowPtr.getNext();
		slowPtr.setNext(null);
		
		// invert the second list
		ListNode p0 = null;
		ListNode p2 = p1.getNext();
		
		while (p1 != null) {
			// point to previous node
			p1.setNext(p0);
			
			// shift right the pointers
			p0 = p1;
			p1 = p2;
			if (p2 != null) {
				p2 = p2.getNext();
			}
		}
		
		// compare both list nodes (they have the same length)
		while (head != null & p0 != null) {
			if (head.getData() != p0.getData()) {
				return false;
			} else {
				head = head.getNext();
				p0 = p0.getNext();
			}
		}
		
		return true;
	}

}
