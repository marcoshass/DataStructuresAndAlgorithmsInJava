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
			ListNode nth = nthFromEndWithRecursion(list.getHead(), 2);
			System.out.println("nth node:" + nth.getData());
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	static int aux = 1;
	
	static ListNode nthFromEndWithRecursion(ListNode p1, int nth) {
		if (p1.getNext() == null) {
			return p1;
		} else {
			ListNode temp = nthFromEndWithRecursion(p1.getNext(), nth); // T(n + 1)
			if (nth == aux) // O(1)
				return temp;
			else  
				aux++;
			
			return p1;
		}
	}
	
	// time complexity O(n)
	// space complexity O(1)
	static ListNode nthFromEndOnePass(LinkedList list, int nth) {
		if (list == null)
			throw new IllegalArgumentException("List cannot be null");
		if (nth < 0)
			throw new IllegalArgumentException("nth node cannot be less than zero");
		
		ListNode p1 = list.getHead();
		ListNode p = p1;
		
		int qtd = 1;
		while (p1.getNext() != null) {
			if (qtd == nth) {
				p1 = p1.getNext();
				p = p.getNext();
			} else {
				qtd++;
				p1 = p1.getNext();
			}
		}
		
		if (qtd < nth) 
			return null;
		
		return p;
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
