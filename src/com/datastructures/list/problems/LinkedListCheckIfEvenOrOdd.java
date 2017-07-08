package com.datastructures.list.problems;

import com.datastructures.list.ListNode;

public class LinkedListCheckIfEvenOrOdd {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		System.out.println("Is even: " + isEven(node1)); // false
		
		node5.setNext(node6);
		System.out.println("Is even: " + isEven(node1)); // true
	}
	
	// time complexity: O(n)
	// space complexity: O(1)
	static boolean isEven(ListNode head) {
		ListNode p = head;
		ListNode p1 = p;
		
		while (p1 != null && p1.getNext() != null) {
			p = p.getNext();
			p1 = p1.getNext().getNext();
		}
		
		if (p1 == null) {
			return true;
		} else {
			return false; // p1.getNext() is null (odd)	
		}
	}

}
