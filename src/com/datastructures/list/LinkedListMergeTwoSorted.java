package com.datastructures.list;

public class LinkedListMergeTwoSorted {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		node1.setNext(node2);
		node2.setNext(node3);
		
		LinkedList list1 = new LinkedList();
		list1.setHead(node1);
		
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		node4.setNext(node5);
		node5.setNext(node6);
		
		LinkedList list2 = new LinkedList();
		list2.setHead(node4);
		
		System.out.println(merge(list1, list2));
	}
	
	// time complexity: O(n)
	// space complexity: O(1)
	static LinkedList merge(LinkedList list1, LinkedList list2) {
		if (list1 == null || list1.getHead() == null)
			return list2;
		if (list2 == null || list2.getHead() == null)
			return list1;

		ListNode current;
		ListNode nextNode;
		LinkedList mergedList;
		
		if (list1.getHead().getData() < list2.getHead().getData()) {
			mergedList = list1;
			current = list1.getHead();
			nextNode = list2.getHead();
		} else {
			mergedList = list2;
			current = list2.getHead();
			nextNode = list1.getHead();
		}
		
		while (current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(nextNode);
		
		return mergedList;
	}

}
