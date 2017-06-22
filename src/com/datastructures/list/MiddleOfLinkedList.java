package com.datastructures.list;

public class MiddleOfLinkedList {

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
		
		System.out.println("Odd quantity, middle is:" + findMiddleOptimal(node1).getData());
		
		node5.setNext(node6);
		System.out.println("Even quantity, middle is:" + findMiddleOptimal(node1).getData());
	}
	
	// time complexity: O(n)
	// space complexity: O(1)
	static ListNode findMiddleOptimal(ListNode head) {
		ListNode p = head;
		ListNode p1 = p;
		
		while (p1 != null && p1.getNext() != null) {
			p = p.getNext();
			p1 = p1.getNext().getNext();
		}
		
		return p;
	}

}
