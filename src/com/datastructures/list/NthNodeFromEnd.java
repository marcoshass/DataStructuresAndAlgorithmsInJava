package com.datastructures.list;

import java.util.Hashtable;

public class NthNodeFromEnd {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insertAtBegin(new ListNode(7));
		list.insertAtBegin(new ListNode(6));
		list.insertAtBegin(new ListNode(5));
		list.insertAtBegin(new ListNode(4));
		list.insertAtBegin(new ListNode(3));
		list.insertAtBegin(new ListNode(2));
		list.insertAtBegin(new ListNode(1));
		System.out.println(list);
		
		try {
			ListNode nth = nthNodeFromEndWithoutHash(list, 1);
			System.out.println("nth node:" + nth.getData());
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	// O(n)
	static ListNode nthFromEnd(LinkedList list, int position) {
		if (list == null)
			throw new IllegalArgumentException("List cannot be null");
		
		ListNode current = list.getHead();
		for (int i = 1; i <= position; i++) { // O(a)
			if (current == null) {
				throw new IllegalArgumentException("List length is not enough to return nth position");
			}
			current = current.getNext();
		}

		// move both nodes
		ListNode nthNode = list.getHead();
		while (current != null) { // O(b)
			current = current.getNext();
			nthNode = nthNode.getNext();
		}
		
		return nthNode;
	}
	
	static ListNode nthNodeFromEndBruteForce(LinkedList list, int nth) { // O(n^2)
		if (list == null)
			throw new IllegalArgumentException("List cannot be null");
		
		// iterate until the last node
		ListNode head = list.getHead();
		for (ListNode p = head; p != null; p = p.getNext()) {	   					
			int count = 0;
			for (ListNode p1 = p; p1 != null; p1 = p1.getNext()) {  					
				count++;
			}
			
			// check nth node
			if (nth == count)
				return p;			
		}
		return null;
	}
	
	// time complexity:  O(n)
	// space complexity: O(n)
	static ListNode nthNodeFromEndHash(LinkedList list, int nth) {
		if (list == null)
			throw new IllegalArgumentException("List cannot be null");

		Hashtable<Integer, ListNode> nodes = new Hashtable<>();
		int count = 0;
		for (ListNode p = list.getHead(); p != null; p = p.getNext()) {
			nodes.put(++count, p);
		}
		
		ListNode nthNode = nodes.get(count - nth + 1);
		return nthNode;
	}
	
	// time complexity: O(n)
	// space complexity: O(1)
	static ListNode nthNodeFromEndWithoutHash(LinkedList list, int nth) {
		if (list == null)
			throw new IllegalArgumentException("List cannot be null");
		
		int count = 0;
		ListNode p = list.getHead();
				
		for (; p != null; p = p.getNext()) {
			count++;
		}

		if (nth > count) 
			throw new IllegalArgumentException("nth node cannot be greater than the number of nodes");
		
		// set nth position from end
		nth = count - nth + 1;

		// reset p
		p = null;
		for (int i = 1; i <= nth; i++) {
			if (p == null)
				p = list.getHead();
			else
				p = p.getNext();
		}
		
		return p;
	}

}
