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
	 * Constructs an empty list with the specified capacity.
	 */
	public UnrolledLinkedList(int nodeCapacity) throws IllegalArgumentException {
		if (nodeCapacity < 8) {
			throw new IllegalArgumentException("nodeCapacity < 8");
		}
		this.nodeCapacity = nodeCapacity;
		firstNode = new ListNode();
		lastNode = new ListNode();
	}

	public UnrolledLinkedList() {
		this(16);
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean contains(Object o) {
		return indexOf(o) != -1;
	}

	public Iterator<E> iterator() {
		return new ULLIterator(firstNode, 0, 0);
	}

	public boolean add(E e) {
		insertIntoNode(lastNode, lastNode.numElements, e);
	}

	private static final long serialVersionUID = -674052309103045211L;

	private class ListNode {
		ListNode next;
		ListNode previous;
		int numElements = 0;
		Object[] elements;

		ListNode() {
			elements = new Object[nodeCapacity];
		}
	}

}
