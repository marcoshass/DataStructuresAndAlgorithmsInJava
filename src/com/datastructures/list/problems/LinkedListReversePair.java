package com.datastructures.list.problems;

import com.datastructures.list.LinkedList;
import com.datastructures.list.ListNode;

public class LinkedListReversePair {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		ListNode node8 = new ListNode(8);
		ListNode node9 = new ListNode(9);
		
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node6);
		node6.setNext(node7);
		node7.setNext(node8);
		node8.setNext(node9);
		
		ListNode ret = reversePairRecursive(node1);
		LinkedList list = new LinkedList();
		list.setHead(ret);
		
		System.out.println(list);
	}
	
	// time complexity: O(n)
	// space complexity: O(n)
	static ListNode reversePairRecursive(ListNode head) {
		if (head == null) {
			return null;
		} else if (head.getNext() == null) {
			return head;
		} else { // 1st and 2nd are not null
			ListNode node1 = head;
			ListNode node2 = node1.getNext();
			ListNode ret = reversePairRecursive(node2.getNext());
			
			node1.setNext(ret); // A
			node2.setNext(node1); // B
			return node2; // C
		}
	}
	
	// time complexity: O(n)
	// space complexity: O(1)
	static ListNode reversePairIterative(ListNode head) {
		ListNode newHead = null;
		ListNode previous = null;
		ListNode current = head;
		ListNode next = current.getNext();
		
		while (current != null && next != null) {
			if (previous != null)
				previous.setNext(next); 		// A
			
			current.setNext(next.getNext());    // B
			next.setNext(current);				// C
			
			// save to return
			if (newHead == null && previous == null)
				newHead = next;
			
			// move to right					// D
			previous = current;
			if (previous != null)
				current = previous.getNext();
			if (current != null)
				next = current.getNext();
		}
		
		return newHead;
	}

}
