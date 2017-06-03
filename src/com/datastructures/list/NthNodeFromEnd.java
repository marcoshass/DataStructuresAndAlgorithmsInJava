package com.datastructures.list;

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
			ListNode nth = nthNodeFromEndBruteForce(list, 3);
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
	
	static ListNode nthNodeFromEndBruteForce(LinkedList list, int Nth) { // O(n^2)
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
			if (Nth == count)
				return p;			
		}
		return null;
	}

}
