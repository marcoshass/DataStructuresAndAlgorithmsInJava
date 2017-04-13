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
		return size == 0;
	}
	
	/**
	 * Returns <tt>true</tt> if this list contains the specified element.
	 * More formally, returns <tt>true</tt> if and only if this list contains
	 * at least one element <tt>e</tt> such that
	 * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;;o.equals(e))</tt>.
	 * 
	 * @param o element whose present in this list is to be tested
	 * @return <tt>true</tt> if this list contains the specified element
	 */
	@Override
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
	 * @return the index of the first occurrence of the specified element in
	 * 		   this list, or -1 if this list does not contain the element
	 */
	@Override
	public int indexOf(Object o) {
		int index = 0;
		Node node = firstNode;
		
		if (o == null) {
			while (node != null) {
				for (int ptr = 0; ptr < node.numElements; ptr++) {
					if (node.elements[ptr] == null) {
						return index + ptr;
					}
				}
				index += node.numElements;
				node = node.next;
			}
		} else {
			
		}
		
		return -1;
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
			numElements = nodeCapacity;
			elements = new Object[numElements];
		}
		
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		UnrolledLinkedList<Integer> l = new UnrolledLinkedList();
		l.indexOf(null);
	}
	
}
