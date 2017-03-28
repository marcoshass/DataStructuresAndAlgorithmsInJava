package com.datastructures.list;

public class CircularLinkedList {

	private CLLNode head;
	private int length;

	public CircularLinkedList() {
	}

	/**
	 * Check the length of the circular linked list. 
	 */
	public int circularListLength() { // O(n)
		int count = 0;
		
		// empty list
		if (head == null)
			return 0;
		else {
			// one or more items
			count = 1;
			CLLNode p = head.getNext();
			while (p != head) {
				p = p.getNext();
				count++;
			}
		}
		
		return count;
	}
	
	/**
	 * Print the content of the circular linked list.
	 */
	public void printCircularListData() { // O(n)
		// empty list
		if (head == null) {
			System.out.println("Empty list");
			return;
		} else {
			// one or more items
			System.out.print(head.getData());
			CLLNode p = head.getNext();
			while (p != head) {
				System.out.print("->" + p.getData());
				p = p.getNext();
			}
			System.out.print("->*");
		}
		
	}
	
	/**
	 * Adds element to head of list.
	 */
	public void addToHead(int data) { // O(n)
		CLLNode newNode = new CLLNode(data);
		
		// empty list
		if (head == null) {
			head = newNode;
			newNode.setNext(head);
		} else if (head.getNext() == head) {
			// one node list
			newNode.setNext(head);
			head.setNext(newNode);
			head = newNode;
		} else {
			// two or more nodes
			CLLNode p = head.getNext();
			while (p.getNext() != head) {
				p = p.getNext();
			}
			newNode.setNext(head);
			p.setNext(newNode);
			head = newNode;
		}
		
		length++;
	}
	
	/**
	 * Adds element to tail of a list.
	 */
	public void addToTail(int data) { // O(n)
		CLLNode newNode = new CLLNode(data);
		
		// empty list
		if (head == null) {
			head = newNode;
			newNode.setNext(head);
		} else if (head.getNext() == head) {
			// one node list
			newNode.setNext(head);
			head.setNext(newNode);
		} else {
			// two or more nodes
			CLLNode p = head.getNext();
			while (p.getNext() != head) {
				p = p.getNext();
			}
			newNode.setNext(head);
			p.setNext(newNode);
		}
		
		length++;
	}
	
	// Deleting the last node in a circular list ...

}
