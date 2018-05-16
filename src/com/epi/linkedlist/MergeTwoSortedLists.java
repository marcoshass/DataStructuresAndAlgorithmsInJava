package com.epi.linkedlist;

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		ListNode<Integer> n5 = new ListNode<>(5, new ListNode<Integer>(7));
		ListNode<Integer> n2 = new ListNode<>(2, n5);
		ListNode<Integer> n3 = new ListNode<>(3, new ListNode<Integer>(11));
		System.out.println(mergeTwoSortedLists(n2, n3));
	}

	public static ListNode<Integer> mergeTwoSortedLists(ListNode<Integer> L1, ListNode<Integer> L2) {
		ListNode<Integer> dummyHead = null;
		ListNode<Integer> current = new ListNode<>(0);
		while (L1 != null && L2 != null) {
			if (L1.data < L2.data) {
				current.next = L1;
				L1 = L1.next;
			} else {
				current.next = L2;
				L2 = L2.next;
			}
			dummyHead = dummyHead == null ? current : dummyHead; // approach different from the book
			current = current.next;
		}
		
		current.next = L1 != null ? L1 : L2;
		return dummyHead.next;
	}
}

class ListNode<T> {
	public T data;
	public ListNode<T> next;

	public ListNode(T data) {
		this.data = data;
	}

	public ListNode(T data, ListNode<T> next) {
		this(data);
		this.next = next;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (ListNode<T> p = this; p != null; p = p.next) {
			sb.append(p.data);
			sb.append("->");
		}
		sb.append("null");
		return sb.toString();
	}
}
