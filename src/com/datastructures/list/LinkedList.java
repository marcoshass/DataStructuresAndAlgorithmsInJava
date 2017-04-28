package com.datastructures.list;

public class LinkedList {

	private int length = 0;
	
	private ListNode head;
	
	public LinkedList() {
	}
	
	public ListNode getHead() {
		return head;
	}
	
	public int getLength() {
		return length;
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
			p1 = p.getNext();
			while (p1.getNext() != null) {
				p = p1;
				p1 = p1.getNext();
			}
			p.setNext(null);
		}

		length--;
		return p1;
	}
	
	// O(n)
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
			p1 = p.getNext();
			while (p1.getNext() != null) {
				if (p1.equals(node)) { // node found
					p.setNext(p1.getNext());
					p1.setNext(null);
					length--;
				} else { // move next
					p = p1;
					p1 = p1.getNext();
				}
			}
		}
		
		return p1;
	}
	
	//
	// A->B->C->null
	//    n  t
	//
	
	/**
	 * Remove node from linked list in constant time. 
	 */
	public ListNode removeNode(ListNode node) { // O(1)
		ListNode removed = null;

		if (node == null || node.getNext() == null)
			throw new IllegalArgumentException("The node to be deleted or the next one cannot be null.");
		
		if (node == head) {
			// node is head
			length--;
			removed = node;
			head = node.getNext();
			node.setNext(null);
		} else {
			length--;
			removed = node;
			
			// adjust pointers
			ListNode tmp = node.getNext();
			
			node.setData(tmp.getData());
			node.setNext(tmp.getNext());
			tmp.setNext(null);
		}
		
		return removed;
	}
	
	// O(n)
	public ListNode remove(int position) {
		ListNode p = head;
		ListNode p1 = null;
		
		if (position < 0)
			position = 0;
		
		if (position > length)
			position = length;
		
		if (head == null) // empty list
			return null;
		else if (position == 0) { // remove head
			p1 = head;
			head = p1.getNext();
			length--;
		} else { // remove other than head
			p1 = p.getNext();
			int i = 1;
			while (p1.getNext() != null) {
				if (i == position) {
					p.setNext(p1.getNext());
					p1.setNext(null);
					length--;
				} else { // move next
					p = p1;
					p1 = p1.getNext();
					i++;
				}
			}
		}
		
		return p1;
	}
	
	// O(n)
	public int getPosition(int data) {
		if (head != null) {
			int i = 0;
			for (ListNode p = head; p != null; p = p.getNext())  {
				if (data == p.getData())
					return i;
				else 
					i++;
			}
		}
		
		return Integer.MIN_VALUE;
	}

	public void clearList() {
		head = null;
		length = 0;
	}
	
	public String toString() {
		String result = "[";
		if (head == null)
			return result + "]";
		
		result += head.getData();
		ListNode temp = head.getNext();
		while (temp != null) {
			result += "," + temp.getData();
			temp = temp.getNext();
		}
		return result += "]";
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
				i++;
			}
			
			newNode.setNext(p.getNext());
			p.setNext(newNode);
		}
		length++;
	}
	
}
