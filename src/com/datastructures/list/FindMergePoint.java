package com.datastructures.list;

import java.util.Hashtable;

public class FindMergePoint {

	public static void main(String[] args) {
		ListNode node5 = new ListNode(5);
		ListNode node4 = new ListNode(4);
		ListNode node7 = new ListNode(7);
		ListNode node8 = new ListNode(8);
		
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		
		node5.setNext(node4);
		node4.setNext(node7);
		node7.setNext(node8);
		
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node7);
		
		ListNode mergeNode = findMergePointHashTable(node5, node1);
		System.out.println("Intersection node:" + mergeNode.getData());
	}
	
	// time complexity: O(m*n)
	// space complexity: O(1)
	static ListNode findMergePointBruteForce(ListNode head1, ListNode head2) {
		for (ListNode p = head1; p != null; p = p.getNext()) { // O(m)
			for (ListNode p1 = head2; p1 != null; p1 = p1.getNext()) { // O(n)
				if (p.getData() == p1.getData()) {
					return p;
				}
			}
		}
		
		return null;
	}
	
	// time complexity: O(m+n)
	// space complexity: O(n), n being the longest list
	static ListNode findMergePointHashTable(ListNode head1, ListNode head2) {
		Hashtable<Integer, ListNode> hash = new Hashtable();
		
		// O(m)
		for (ListNode p = head1; p != null; p = p.getNext()) {
			hash.put(p.getData(), p);
		}
		
		// O(n)
		for (ListNode p1 = head2; p1 != null; p1 = p1.getNext()) {
			if (hash.containsKey(p1.getData())) {
				return p1;
			}
		}
		
		return null;
	}

}
