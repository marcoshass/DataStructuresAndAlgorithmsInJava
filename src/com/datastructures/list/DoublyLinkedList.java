package com.datastructures.list;

public class DoublyLinkedList {

	private DLLNode head;
	private int length;
	
	public DoublyLinkedList() {
	}
	
	/**
	 * Insert a new value to the front of the DLL.
	 */
	public void insert(int newValue) { // O(1)
		DLLNode newNode = new DLLNode(newValue);

		if (head != null) { // not empty
			head.setPrev(newNode);
		}
		
		newNode.setNext(head);
		head = newNode;
		length++;
	}
	
	/**
	 * Add a new value to the rear of the list.
	 */
	public void insertTail(int newValue) { // O(n)
		DLLNode newNode = new DLLNode(newValue);

		if (head == null) { // empty list
			head = newNode;
		} else { // non empty list
			DLLNode p = head;
			while (p.getNext() != null) { // move until the last node
				p = p.getNext();
			}
			p.setNext(newNode);
			newNode.setPrev(p);
		}
		
		length++;
	}
	
	/**
	 * Add a new value to the list at a given position.
	 * All values at that position to the end move over to make room. 
	 */
	public void insert(int data, int position) { // O(n)
		// Fix the position
		if (position < 0)
			position = 0;
		
		if (position > length)
			position = length;

		DLLNode newNode = new DLLNode(data);
		if (head == null) { // empty list
			head = newNode;
		} else if (position == 0) { // insert as head node
			head.setPrev(newNode);
			newNode.setNext(head);
			head = newNode;
		} else { // insert after head 
			DLLNode p = head;
			int i = 0;
			while (p.getNext() != null && i < position) {
				p = p.getNext();
				i++;
			}

			newNode.setNext(p.getNext());
			if (p.getNext() != null) // next position is not null
				p.getNext().setPrev(newNode);
			p.setNext(newNode);
			newNode.setPrev(p);
		}
		
		length++;
	}
	
	/**
	 * Remove the head value from the list. If the list is empty do nothing. 
	 */
	public int removeHead() { // O(1)
		int data = 0;
		DLLNode p = null;
		
		if (head != null) {
			data = head.getData();
			p = head.getNext();
			
			if (p != null)
				p.setPrev(null);
			
			head.setNext(null);
			head = p;
			length--;
		}
		
		return data;
	}

	/**
	 * Remove the tail value from the list. If the list is empty, do nothing. 
	 */
	public int removeTail() {
		int data = 0;

		 // list is not empty
		if (head != null) {
			if (head.getNext() == null) {
				// remove head
				data = head.getData();
				head = null;
			} else {
				// remove other than head
				DLLNode p = head;
				while (p.getNext() != null) {
					p = p.getNext();
				}
			
				// get data, adjust pointers
				data = p.getData();
				p.getPrev().setNext(null);
				p.setPrev(null);
			}
			
			length--;
		}

		return data;
	}
	
	// null
	// 1->null
	// 1->2->null
	//    ^
	//    1
	
	/**
	 * Remove the value at a given position.
	 * If the position is less than 0, remove value at position 0.
	 * If the position is greather than length, remove the value at the last position. 
	 */
	public int remove(int position) { // O(n)
		int data = 0;
		DLLNode p = null;
		
		if (position < 0)
			position = 0;
		
		if (position > length)
			position = length;
		
		 // empty list
		if (head == null)
			return 0;
		else if (position == 0) {
			// remove head
			data = head.getData();
			p = head.getNext();
			
			if (p != null)
				p.setPrev(null);

			head.setNext(null);
			head = p;
			length--;
		} else {
			p = head.getNext();
			int i = 1;
			while (p != null) {
				if (i == position) {
					data = p.getData();
					// adjust pointers
					p.getPrev().setNext(p.getNext());
					if (p.getNext() != null)
						p.getNext().setPrev(p.getPrev());
					
					p.setPrev(null);
					p.setNext(null);
					length--;
				} else {
					p = p.getNext();
					i++;
				}
			}
		}
		
		return data;
	}
	
}
