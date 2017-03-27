package com.datastructures.list;

public class DLLNode {

	private int data;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	private DLLNode prev;

	public DLLNode getPrev() {
		return prev;
	}

	public void setPrev(DLLNode prev) {
		this.prev = prev;
	}

	private DLLNode next;

	public DLLNode getNext() {
		return next;
	}

	public void setNext(DLLNode next) {
		this.next = next;
	}

	public DLLNode(int data) {
		this.data = data;
	}

	public DLLNode(int data, DLLNode prev) {
		this.data = data;
		this.prev = prev;
	}

	public DLLNode(int data, DLLNode prev, DLLNode next) {
		this.data = data;
		this.prev = prev;
		this.next = next;
	}

}
