package com.datastructures.list.problems;

import com.datastructures.list.ListNode;

public class LinkedListFindFractionalNode {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		ListNode node8 = new ListNode(8);
		ListNode node9 = new ListNode(9);
		ListNode node10 = new ListNode(10);
		ListNode node11 = new ListNode(11);
		ListNode node12 = new ListNode(12);
		ListNode node13 = new ListNode(13);
		ListNode node14 = new ListNode(14);
		ListNode node15 = new ListNode(15);
		ListNode node16 = new ListNode(16);
		ListNode node17 = new ListNode(17);
		ListNode node18 = new ListNode(18);

		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node6);
		node6.setNext(node7);
		node7.setNext(node8);
		node8.setNext(node9);
		node9.setNext(node10);
		node10.setNext(node11);
		node11.setNext(node12);
		node12.setNext(node13);
		node13.setNext(node14);
		node14.setNext(node15);
		node15.setNext(node16);
		node16.setNext(node17);
		node17.setNext(node18);

		int k = 3;
		ListNode ret = findFractionalNode(node1, k);
		if (ret != null)
			System.out.println("node:" + ret.getData());
	}

	// time complexity: O(n)
	// space complexity: O(1)
	static ListNode findFractionalNode(ListNode head, int k) {
		ListNode fractionalNode = null;

		int i = 1;
		for (ListNode p = head; p != null; p = p.getNext()) {
			if (i++ % k == 0) {
				if (fractionalNode == null) {
					fractionalNode = head;
				} else {
					fractionalNode = fractionalNode.getNext();
				}
			}
		}

		return fractionalNode;
	}

}
