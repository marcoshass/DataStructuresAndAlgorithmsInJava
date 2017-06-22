package com.datastructures.list;

import java.util.*;

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
		
		System.out.println("Odd quantity, middle is:" + findMiddleHashTable(node1).getData());
		
		node5.setNext(node6);
		System.out.println("Even quantity, middle is:" + findMiddleHashTable(node1).getData());
	}
	
	// time complexity: O(n)
	// space complexity: O(n)
	static ListNode findMiddleHashTable(ListNode head) {
		Hashtable<Integer,ListNode> nodes = new Hashtable();
		int numberOfNodes = 0;
		
		for (ListNode p = head; p != null; p = p.getNext()) { // O(n)
			numberOfNodes++;
			nodes.put(numberOfNodes, p); // O(n)
		}
		
		int position = 0;
		if (numberOfNodes%2.0 == 0) {
			position = numberOfNodes/2 + 1;
		} else {
			position = (int)Math.ceil(numberOfNodes/2.0);
		}

		ListNode middle = nodes.get(position);
		return middle;
	}
	
	// time complexity: O(n)
	// space complexity: O(1)
	static ListNode findMiddleOrderN(ListNode head) {
		int numberOfNodes = 0;
		for (ListNode p = head; p != null; p = p.getNext()) { // O(n)
			numberOfNodes++;
		}
		
		int position = 0;
		if (numberOfNodes%2.0 == 0) { // no remainder, middle+1
			position = numberOfNodes/2 + 1;
		} else {
			position = (int)Math.ceil(numberOfNodes/2.0);
		}

		ListNode middle = head;
		for (int i = 1; i < position; i++) { // O(n/2)
			middle = middle.getNext();
		}
		
		return middle;
	}
	
	// time complexity: O(n^2)
	// space complexity: O(1)
	static ListNode findMiddleBruteForce(ListNode head) {
		int i = 0;
		for (ListNode p = head; p != null; p = p.getNext()) {
			i++;

			int j = 0;
			for (ListNode p1 = p.getNext(); p1 != null; p1 = p1.getNext()) {
				j++;
			}
			
			int numberOfNodes = i + j;
			if (Math.ceil(numberOfNodes/2.0) == i) {
				// when there is no remainder return the next node
				if (numberOfNodes%2.0 == 0) {
					return p.getNext();
				} else {
					return p;
				}
			}
		}
		
		return null;
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
