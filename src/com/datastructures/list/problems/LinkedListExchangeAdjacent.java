package com.datastructures.list.problems;

import com.datastructures.list.LinkedList;
import com.datastructures.list.ListNode;

public class LinkedListExchangeAdjacent {

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
		
		ListNode ret = exchangeAdjacentNodes(node1);
		LinkedList list = new LinkedList();
		list.setHead(ret);
		
		System.out.println(list);
	}
	
	// time complexity: O(n)
	// space complexity: O(1)
	static ListNode exchangeAdjacentNodes(ListNode head) {
		if (head == null || head.getNext() == null)
			return head;
		
		ListNode newHead = null;
		ListNode a = null;
		ListNode b = head;
		ListNode c = b.getNext();
		
		while (b != null && c != null) {
			// adjust pointers
			b.setNext(c.getNext());
			c.setNext(b);
			if (a != null)
				a.setNext(c);
			else 
				newHead = c;

			// move next
			a = b;
			b = b.getNext();
			if (b != null)
				c = b.getNext();
		}
		
		return newHead;
	}

}
