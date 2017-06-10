package com.datastructures.list;

import java.util.Hashtable;

public class LoopInLinkedList {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node6);
		node6.setNext(node7);
		//node7.setNext(node6);
		
		LinkedList list = new LinkedList();
		list.setHead(node1);
		System.out.println("Has loop:" + hasLoopBruteForce(list));
	}
	
	// time complexity: O(n)
	// space complexity: O(n)
	static boolean hasLoopBruteForce(LinkedList list) {
		Hashtable<Integer, Boolean> hash = new Hashtable();

		ListNode current = list.getHead();
		while (current != null) {
			if (hash.getOrDefault(current.getData(), false)) {
				return true;
			} else {
				hash.put(current.getData(), true);
				current = current.getNext();
			}
		}
		
		return false;
	}

}
