package com.datastructures.list.problems;

import com.datastructures.list.LinkedList;
import com.datastructures.list.ListNode;

public class LinkedListModularNodes {

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
		
		ListNode ret = modularNodes(node1, 3);
		LinkedList l = new LinkedList();
		l.setHead(ret);
		
		System.out.println(l);
	}
	
	// time complexity: O(n)
	// space complexity: O(1)
	static ListNode modularNodes(ListNode head, int k) {
		if (head == null || head.getNext() == null)
			return head;
		
		int i = 1;
		ListNode modularNode = null;
		
		for(; head != null; head = head.getNext()) {
			if (i%k == 0) {
				modularNode = head;
			}
			i++;
		}

		return modularNode;
	}

}
