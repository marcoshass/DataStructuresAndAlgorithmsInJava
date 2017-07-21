package com.datastructures.list.problems;

import com.datastructures.list.ListNode;

public class LinkedListFindModularNodeFromEnd {

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
		
		ListNode ret = modularNodeFromEnd(node1, 3);
		if (ret != null) {
			ret.setNext(null);
			System.out.println(ret.getData());
		} else {
			System.out.println("Node not found!");
		}
	}
	
	// time complexity: O(n)
	// space complexity: O(1)
	static ListNode modularNodeFromEnd(ListNode head, int k) {
		if (head == null)
			return head;
		
		ListNode slow = head;
		
		for (int i = 1; i <= k; i++) {
			if (head == null)
				throw new IllegalArgumentException("k is greater than the list length");

			head = head.getNext();
		}
		
		while (head != null) {
			head = head.getNext();
			slow = slow.getNext();
		}

		return slow;
	}

}
