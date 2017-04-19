package com.datastructures.list;

public class UnrolledLinkedList {

	/**
	 * The maximum number of elements that can be stored in a single node.
	 */
	private int nodeCapacity;
	
	/**
	 * The current size of this list.
	 */
	private int size = 0;
	
	/**
	 * The first node of this list.
	 */
	private ListNode firstNode;
	
	/**
	 * The last node of this list.
	 */
	private ListNode lastNode;
	
	/**
	 * Constructs an empty list with the specified
	 * {@link UnrolledLinkedList#nodeCapacity nodeCapacity}. For performance
	 * reasons <tt>nodeCapacity</tt> must be greater than or equal to 8.
	 * 
	 * @param nodeCapacity The maximum number of elements
	 * 		  that can be stored in a single node.
	 * @throws IllegalArgumentException if <tt>nodeCapacity</tt> is less than 8
	 */
	public UnrolledLinkedList(int nodeCapacity) throws IllegalArgumentException {
		
		if (nodeCapacity < 8) {
			throw new IllegalArgumentException("nodeCapacity < 8");
		}
		this.nodeCapacity = nodeCapacity;
		firstNode = new ListNode();
		lastNode = firstNode;
	}
	
	/**
	 * Constructs an empty list with
	 * {@link UnrolledLinkedList#nodeCapacity nodeCapacity} of 16.
	 */
	public UnrolledLinkedList() {
		this(16);
	}
	
	/**
	 * Returns the number of elements in this list.
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Returns <tt>true</tt> if this list contains no elements.
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns <tt>true</tt> if this list contains the specified element.
	 * More formally, returns <tt>true</tt> if and only if this list contains
	 * at least one element <tt>e</tt> such that
	 * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
	 * 
	 * @param o element whose presence in this list is to be tested
	 * @return <tt>true</tt> if this list contains the specified element
	 */
	public boolean contains(Object o) {
		return indexOf(o) != -1;
	}
	
	/**
	 * Returns the index of the first occurrence of the specified element
	 * in this list, or -1 if this list does not contain the element.
	 * More formally, returns the lowest index <tt>i</tt> such that
	 * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
	 * or -1 if there is no such index.
	 * 
	 * @param o element to search for
	 * @return the index of the first occurrrence of the specified element in
	 * 		   this list, or -1 if this list does not contain the element
	 */
	public int indexOf(Object o) {
		ListNode current = firstNode;
		
		while (current != null) {
			for (int i = 0; i < current.numElements; i++) {
				if (current.elements[i] == null) {
					break;
				} else if (o.equals(current.elements[i])) {
					return i;
				}
			}
		}
		
		return -1;
	}
	
	private class ListNode {
		ListNode next;
		ListNode previous;
		int numElements = 0;
		Object[] elements;
		
		/**
		 * Constructs a ListNode with a default number of array elements.
		 */
		ListNode() {
			elements = new Object[nodeCapacity];
		}
	}
	
}
