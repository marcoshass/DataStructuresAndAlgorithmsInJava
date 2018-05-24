package com.epi.linkedlist;

public class ListNode<T> {
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
