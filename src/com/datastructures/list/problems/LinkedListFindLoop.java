package com.datastructures.list.problems;

import java.util.Hashtable;

import com.datastructures.list.LinkedList;
import com.datastructures.list.ListNode;

public class LoopInLinkedList {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		
		node1.setNext(node2);
		node2.setNext(node4);
		node4.setNext(node5);
		
		LinkedList list = new LinkedList();
		list.setHead(node1);

		ListNode newNode = new ListNode(3); // insert node 3
		ListNode newNode1 = new ListNode(6); // insert node 6
		ListNode newNode3 = new ListNode(0); // insert node 0
		
		insertInSortedList(list, newNode);
		insertInSortedList(list, newNode1);
		insertInSortedList(list, newNode3);

		System.out.println(list);
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

	// time complexity: O(n)
	// space complexity: O(1)
	static int findLengthOfTheLoop(LinkedList list) {
		ListNode slow = list.getHead().getNext();
		ListNode fast = slow.getNext();
		
		while (slow != fast) {
			if (fast == null || fast.getNext() == null) 
				return 0;
			
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		
		// slow == fast and has loop
		int length = 1;
		fast = fast.getNext();
		while (slow != fast) {
			fast = fast.getNext();
			length++;
		}
		
		return length;
	}
	
	// time complexity: O(n)
	// space complexity: O(1)
	// assume that the list is not empty
	static ListNode insertInSortedList(LinkedList list, ListNode newNode) {
		ListNode current = list.getHead();
		
		// insert at head
		if (current.getData() > newNode.getData()) { 
			newNode.setNext(current);
			list.setHead(newNode);
			return newNode;
		}
		
		while (current != null) {
			// insert at tail
			if (current.getNext() == null) {
				current.setNext(newNode);
				break;
			} else {
				// insert at middle
				if (current.getNext().getData() > newNode.getData()) {
					newNode.setNext(current.getNext());
					current.setNext(newNode);
					break;
				} else {
					current = current.getNext();
				}
			}
		}
		
		return newNode;
	}
	
}
