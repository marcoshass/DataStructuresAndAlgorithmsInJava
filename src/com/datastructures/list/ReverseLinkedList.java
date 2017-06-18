package com.datastructures.list;

public class ReverseLinkedList {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);

//		ListNode newHead = reverseListIterative(node1);
		reverseLinkedListRecursive(null, node1);
		LinkedList list  = new LinkedList();
		list.setHead(node5);

		// print the reversed list
//		list.setHead(newHead);
		System.out.println(list.toString());
	}
	
	// time complexity:  O(n)
	// space complexity: O(1)
	static ListNode reverseListIterative(ListNode head) {
		ListNode prev = null;
		ListNode cur = head;
		
		while (cur != null) {
			ListNode tmp = cur.getNext();
			cur.setNext(prev);
			
			// move next
			prev = cur;
			cur = tmp;
		}

		return prev;
	}
	
	// time complexity: O(n)
	// space complexity: O(n)
	static void reverseLinkedListRecursive(ListNode prev, ListNode cur) {
		if (cur != null) {
			reverseLinkedListRecursive(cur, cur.getNext());
			cur.setNext(prev);
		}
	}

}
