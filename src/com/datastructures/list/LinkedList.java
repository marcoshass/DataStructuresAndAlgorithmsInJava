package com.datastructures.list;

public class LinkedList {

	private int length = 0;
	
	private ListNode head;
	
	public LinkedList() {
	}
	
	public ListNode getHead() {
		return head;
	}
	
	// O(n)
	public int listLength() {
		int size = 0;
		if (head != null) {
			for (ListNode p = head; p != null; p = p.getNext()) {
				size++;
			}
		}
		return size;
	}
	
	// O(1)
	public ListNode removeFromBegin() {
		if (head == null)
			return null;
		
		ListNode p = head;
		head = p.getNext();
		p.setNext(null);

		length--;
		return p;
	}

	// O(n) 
	public ListNode removeFromEnd() {
		ListNode p = head;
		ListNode p1 = null;

		if (head == null) // empty list
			return null;
		else if (head.getNext() == null) { // single node list
			p1 = head;
			head = null;
		} else { // two or more nodes
			while (p1.getNext() != null) {
				p = p1;
				p1 = p1.getNext();
			}
			p.setNext(null);
		}

		length--;
		return p1;
	}
	
	public ListNode removeMatched(ListNode node) {
		ListNode p = head;
		ListNode p1 = null;
		
		if (head == null) // empty list
			return null;
		else if (node.equals(head)) { // match head
			p1 = head;
			head = p1.getNext();
			length--;
		} else { // two or more nodes
			while (p1.getNext() != null) {
				if (p1.equals(node)) { // node found
					p.setNext(p1.getNext());
					p1.setNext(null);
					length--;
				} else {
					p = p1;
					p1 = p1.getNext();
				}
			}
		}
		return p1;
	}
	
	// O(1)
	public void insertAtBegin(ListNode node) {
		node.setNext(head);
		head = node;
		length++;
	}

	// O(n)
	public void insertAtEnd(ListNode node) {
		ListNode p = head;
		if (p != null) {
			// Traverse the list until the last node O(n)
			while(p.getNext() != null)
				p = p.getNext();
			
			p.setNext(node);
		} else {
			// List is empty, node becomes head O(1)
			head = node;
		}
		length++;
	}
	
	// O(n)
	public void insert(int data, int position) {
		// Fix the position
		if (position < 0)
			position = 0;
		
		if (position > length)
			position = length;

		ListNode newNode = new ListNode(data);
		if (head == null || position == 0) { // Empty list or add head node O(1)
			newNode.setNext(head);
			head = newNode;
		} else { // Advance one position before insertion O(n) 
			ListNode p = head;
			int i = 0;
			while (p.getNext() != null && i < position) {
				p = p.getNext();
			}
			
			newNode.setNext(p.getNext());
			p.setNext(newNode);
		}
		length++;
	}
	
}
