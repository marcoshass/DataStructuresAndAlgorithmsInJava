package com.datastructures.list;

public class ListNode {

	private int data;

	public ListNode(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	private ListNode next;

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof ListNode) {
			return this.getData() == ((ListNode) o).getData();
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return data;
	}

}
