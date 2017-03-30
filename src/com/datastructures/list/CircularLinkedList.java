package com.datastructures.list;

public class CircularLinkedList {

	private CLLNode head;
	private int length;

	/**
	 * Constructs a new circular list.
	 */
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
	 * Adds data to beginning of list.
	 */
	public void add(int data) {
		addToHead(data);
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
	
	/**
	 * Returns data at the head of list. 
	 */
	public int peek() { // O(1)
		// empty list
		if (head == null) {
			return 0;
		} else {
			return head.getData();
		}
	}
	
	/**
	 * Returns data at tail of list. 
	 */
	public int tailPeek() { // O(n)
		if (head == null){
			// empty list
			return 0;
		} else if (head.getNext() == head) {
			// one node list
			return head.getData();
		} else {
			// two or more nodes
			CLLNode p = head;
			while (p.getNext() != head) {
				p = p.getNext();
			}
			return p.getData(); 
		}
	}

	/**
	 * Returns and removes data from head of list. 
	 */
	public int removeFromHead() { // O(n)
		
		int data = 0;
		if (head == null) {
			return 0;
		} else if (head.getNext() == head) {
			// one node list
			data = head.getData();
			head.setNext(null);
			head = null;
			length--;
		} else {
			// two or more nodes
			CLLNode p = head;
			while (p.getNext() != head) {
				p = p.getNext();
			}
			data = p.getData();

			// adjust pointers
			p.setNext(head.getNext());
			head.setNext(null);
			head = p;
			
			length--;
		}
		
		return data;
	}
	
	/**
	 * Returns and removes data from tail of list.
	 */
	public int removeFromTail() { // O(n)
		int data = 0;
		
		// empty list
		if (head == null) {
			return 0;
		} else if (head.getNext() == head) {
			// one node list
			data = head.getData();
			head.setNext(null);
			head = null;
			length--;
		} else {
			// two or more nodes
			CLLNode p = head;
			CLLNode p1 = p.getNext();

			while (p1.getNext() != head) {
				p1 = p1.getNext();
				p = p.getNext();
			}

			// adjust pointers
			p.setNext(p1.getNext());
			p1.setNext(null);
			length--;
		}
		
		return data;
	}

	/**
	 * Returns true if list contains data, else otherwise.
	 */
	public boolean contains(int data) { // O(n)
		// empty list
		if (head == null) {
			return false;
		} else if (head.getData() == data) {
			// head contains data
			return true;
		} else {
			// search for data after head
			CLLNode p = head.getNext();
			while (p != head) {
				if (p.getData() == data)
					return true; // found
				
				p = p.getNext();
			}
		}
		return false;
	}
	
	/**
	 * Removes and returns element equal to data, or zero.
	 */
	public int remove(int data) { // O(n)
		int found = 0;
		
		// empty list
		if (head == null) {
			return 0;
		} else if (head.getData() == data) {
			found = data;
			length--;

			// adjust pointers
			CLLNode temp = head;
			head = head.getNext();
			temp.setNext(null);
		} else {
			// search after head
			CLLNode p = head;
			CLLNode p1 = p.getNext();
			while (p1 != head) {
				if (p1.getData() == data) {
					found = p1.getData();
					length--;

					// adjust pointers
					p.setNext(p1.getNext());
					p1.setNext(null);
					break;
				} else {
					// move both pointers
					p = p1;
					p1 = p1.getNext();
				}
			}
		}
		
		return found;
	}
	
	/**
	 * Return the current length of the CLL.
	 */
	public int size() {
		return length;
	}
	
	/**
	 * Return the current length of the CLL.
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Returns true if there are no elements in the list.
	 */
	public boolean isEmpty() {
		return head == null;
	}
	
	/**
	 * Remove everything from the CLL.
	 */
	public void clear() {
		head = null;
		length = 0;
	}
	
	/**
	 * Return a string representation of this collection, in the form: ["str1", "str2", ...].
	 */
	public String toString() {
		String result = "[";
		if (head == null)
			return result + "]";
		
		result += head.getData();
		CLLNode temp = head.getNext();
		while (temp != null) {
			result += "," + temp.getData();
			temp = temp.getNext();
		}
		return result += "]";
	}
	
}
