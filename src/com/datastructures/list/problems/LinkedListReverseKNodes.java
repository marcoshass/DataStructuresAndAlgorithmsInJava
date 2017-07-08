package com.datastructures.list.problems;

import com.datastructures.list.*;

public class LinkedListReverseKNodes {

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
		
		LinkedList l = new LinkedList();
		
		l.setHead(node1);
		System.out.println(l);
		
		l.setHead(reverseKNodes(node1, 2));
		System.out.println(l);
	}
	
	// time complexity: O(n)
	// space complexity: O(1)
	static ListNode reverseKNodes(ListNode head, int k) {
		ListNode newHead = null;
		
		ListNode A = null;
		ListNode B = head;
		ListNode C = null;
		ListNode D = null;
		
		// protections
		if (head == null || head.getNext() == null)
			return head;
		
		
		while (B != null) {
			// loop to get C and D
			C = B;
			for (int i = 1; i < k; i++) {
				if (C != null) {
					C = C.getNext();
				}
			}
			if (C == null)
				break;
			
			D = C.getNext();
			
			// break the list
			C.setNext(null);
		
			// save the newHead
			if (newHead == null)
				newHead = reverse(B);
			else
				reverse(B);
			
			// relink the list
			if (A != null)
				A.setNext(C);
			B.setNext(D);
			
			// move next
			A = B;
			B = D;
		}
		
		if (newHead == null)
			return head;
		else
			return newHead;
	}
	
	static ListNode reverse(ListNode head) {
		// cannot reverse single node list
		if (head == null || head.getNext() == null)
			return head;
		
		ListNode A = null;
		ListNode B = head;
		ListNode C = B.getNext();
		
		while (B != null) {
			// point to previous
			B.setNext(A);
			
			// move next
			A = B;
			B = C;
			if (C != null) {
				C = C.getNext();
			}
		}
		
		return A;
	}

}
