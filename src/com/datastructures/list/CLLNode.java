package com.datastructures.list;

public class CLLNode {

	private int data;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	private CLLNode next;

	public CLLNode getNext() {
		return next;
	}

	public void setNext(CLLNode next) {
		this.next = next;
	}
	
	public CLLNode(int data) {
		this.data = data;
	}

}
