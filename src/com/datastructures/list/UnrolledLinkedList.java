package com.datastructures.list;

import java.util.*;
import java.io.Serializable;

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
	private ListNode firstNode;
	
	/**
	 * The last node of this list.
	 */
	private ListNode lastNode;
	
	/**
	 * Constructs an empty list with the specified capacity. 
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
	 * Default constructor (unrolled linked list with 16 items).
	 */
	public UnrolledLinkedList() {
		this(16);
	}
	
	@Override
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * Returns true if this list contains the specified element.
	 */
	public boolean contains(Object o) {
		return indexOf(o) != -1;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	private static final long serialVersionUID = -674052309103045211L;
	
	/**
	 * Unrolled linked list node.
	 */
	private class ListNode {
		ListNode next;
		ListNode previous;
		
		int numElements = 0;
		Object[] elements;
		
		ListNode() {
			elements = new Object[nodeCapacity];
		}
	}
	
	/**
	 * Unrolled linked list iterator.
	 */
//	private class ULLIterator implements ListIterator<E> {
//		ListNode currentNode;
//		int ptr;
//		int index;
//		private int expectedModCount = modCount
//	}
}


