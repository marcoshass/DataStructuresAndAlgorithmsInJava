package com.datastructures.list;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

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
	 * Returns an iterator over the elements in this list in proper sequence.
	 */
	@Override
	public Iterator<E> iterator() {
		return new ULLIterator(firstNode, 0, 0);
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
			while (node != null) {
				for (int ptr = 0; ptr < node.numElements; ptr++) {
					if (o.equals(node.elements[ptr])) {
						return index + ptr;
					}
				}
				index += node.numElements;
				node = node.next;
			}			
		}
		
		return -1;
	}
	
	/**
	 * Appends the specified element to the end of this list.
	 * 
	 * @param e element to be appended to this list
	 * @return <tt>true</tt> (as specified by {@link Collection#add}}
	 */
	@Override
	public boolean add(E e) {
		insertIntoNode(lastNode, lastNode.numElements, e);
		return true;
	}
	
	/**
	 * Insert an element into the specified node. If the node is already full,
	 * a new node will be created and inserted into the list after
	 * the specified node.
	 * 
	 * @param node
	 * @param ptr the position at which the element should be inserted
	 * 		  into the <tt>node.elements</tt> array
	 * @param element the element to be inserted
	 */
	private void insertIntoNode(Node node, int ptr, E element) {
		
	}
	
	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private static final long serialVersionUID = -674052309103045211L;
	
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

	private class ULLIterator implements ListIterator<E> {
		Node currentNode;
		int ptr;
		int index;
		
		private int expectedModCount = modCount;
		
		ULLIterator(Node node, int ptr, int index) {
			this.currentNode = node;
			this.ptr = ptr;
			this.index = index;
		}
		
		@Override
		public boolean hasNext() {
			return index < size - 1;
		}
		
		public E next() {
			ptr++;
			if (ptr >= currentNode.numElements) {
				if (currentNode.next != null) {
					currentNode = currentNode.next;
					ptr = 0;
				} else {
					throw new NoSuchElementException();
				}
			}
			index++;
			checkForModification();
			return (E) currentNode.elements[ptr];
		}
		
		private void checkForModification() {
			
		}

		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public E previous() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void set(E e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void add(E e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
