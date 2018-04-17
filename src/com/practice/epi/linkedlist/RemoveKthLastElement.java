package com.practice.epi.linkedlist;

public class RemoveKthLastElement {

	public static void main(String[] args) {
		final Integer numberOfNodes = 8;
		ListNode currentNode = new ListNode(1);
		ListNode head = currentNode;

		for (int i = 2; i <= numberOfNodes; i++) {
			ListNode newNode = new ListNode(i);
			currentNode.setNext(newNode);
			currentNode = newNode;
		}

		removeKthLast(head, 7);
	}

	static ListNode removeKthLast(ListNode l, int k) {
		if (l == null || k < 0)
			throw new IllegalArgumentException("Illegal arguments, head is null or kth node < 0");

		// pseudo-node used to avoid off-by-one errors
		ListNode pseudoHead = new ListNode(-1);
		pseudoHead.setNext(l);

		ListNode kthNode = pseudoHead, frontRunner = l;

		for (int i = 1; i < k; i++) {
			if (frontRunner.getNext() == null) {
				throw new IllegalArgumentException("Kth node greater than list size");
			}
			frontRunner = frontRunner.getNext();
		}

		do {
			frontRunner = frontRunner.getNext();
			kthNode = kthNode.getNext();
		} while (frontRunner != null);

		System.out.printf("kth=%d", kthNode.getData());
		return null;
	}

}

class ListNode {
	Integer data;

	ListNode next;

	ListNode(Integer data) {
		this.data = data;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}
}
