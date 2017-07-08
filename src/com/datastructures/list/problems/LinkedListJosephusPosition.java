package com.datastructures.list.problems;

import com.datastructures.list.ListNode;

public class LinkedListJosephusPosition {

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
		node5.setNext(node6);
		node6.setNext(node1);
		
		ListNode josephusNode = getJosephusPosition(node1);
		System.out.println("Last player left standing (Josephus position) is " + josephusNode.getData());
	}
	
	// time complexity: O(n)
	// space complexity: O(1)
	static ListNode getJosephusPosition(ListNode head) {
		ListNode current = head;
		
		while (current.getNext() != current) {
			// drop the next node
			ListNode droppedNode = current.getNext();
			current.setNext(droppedNode.getNext());
			droppedNode.setNext(null);
			
			// move next
			current = current.getNext();
		}
		
		return current;
	}

}
