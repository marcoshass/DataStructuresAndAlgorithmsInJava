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
		
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node6);
		node6.setNext(node4);
		
		LinkedList list = new LinkedList();
		list.setHead(node1);
		
		ListNode loopNode = findBeginOfLoop(list);
		if (loopNode == null)
			System.out.println("List does not have a loop");
		else 
			System.out.println("Loop is at node:" + loopNode.getData());
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
	
	// time complexity: O(n)
	// space complexity: O(1)
	static boolean hasLoopTurtleHare(LinkedList list) {
		if (list == null || list.getHead() == null)
			throw new IllegalArgumentException("List cannot be null or empty");

		if (list.getHead().getNext() == null) // one element list
			return false;
		
		ListNode slow = list.getHead().getNext();
		ListNode fast = list.getHead().getNext().getNext();
		
		while (slow != fast) {
			if (fast == null || fast.getNext() == null)
				return false;
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		
		return true;
	}
	
	static boolean isEligibleList(LinkedList list) {
		if (list == null || list.getHead() == null)
			return false;
		
		if (list.getHead().getNext() == null)
			return false;
		
		if (list.getHead().getNext().getNext() == null)
			return false;
		
		return true;
	}
	
	// time complexity: O(n)
	// space complexity: O(1)
	static ListNode findBeginOfLoop(LinkedList list) {
		if (!isEligibleList(list)) 
			return null;
		
		ListNode slow = list.getHead().getNext();
		ListNode fast = slow.getNext(); 
		
		while (slow != fast) {
			if (fast.getNext() == null || fast.getNext().getNext() == null)
				return null;
			
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		
		// (slow==fast) move each node one position to the find loop node 
		slow = list.getHead();
		while (slow != fast) {
			slow = slow.getNext();
			fast = fast.getNext();
		}
		
		return slow;
	}
	
}
