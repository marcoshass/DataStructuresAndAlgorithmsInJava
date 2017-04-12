package com.datastructures.list;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.List;

//ref https://github.com/l-tamas/Unrolled-linked-list/blob/master/src/org/megatherion/util/collections/UnrolledLinkedList.java

public class UnrolledLinkedList<E> extends AbstractList<E> implements List<E>, Serializable {

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
	private Node firstNode;
	
	/**
	 * The last node of this list.
	 */
	private Node lastNode;

	/**
	 * Constructs an empty list with the specified
	 * {@link UnrolledLinkedList#nodeCapacity nodeCapacity}. For performance
	 * reasons <tt>nodeCapacity</tt> must be greater tha or equal to 8.
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
		firstNode = new Node();
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
		return (size == 0);
	}
	
	

	private class Node {
		
		/**
		 * The next node.
		 */
		Node next;
		
		/**
		 * The previous node.
		 */
		Node previous;
		
		/**
		 * The number of elements store in this node.
		 */
		int numElements = 0;
		
		/**
		 * The array in which the elements are stored.
		 */
		Object[] elements;
		
		/**
		 * Constructs a new node based on the unrolled linked list capacity.
		 */
		Node() {
			elements = new Object[nodeCapacity];
		}
		
	}
	
}
