package com.datastructures.list.problems;

import com.datastructures.list.ListNode;

public class LinkedListDisplayFromEnd {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		
		displayFromTheEnd(node1);
	}
	
	static void displayFromTheEnd(ListNode head) {
		if (head != null) {
			displayFromTheEnd(head.getNext());
			System.out.print(head.getData() + ",");
		}
	}

}
