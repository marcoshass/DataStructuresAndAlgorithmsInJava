package com.datastructures.queue;

import com.datastructures.stacks.ListNode;

public class LinkedQueue implements Queue {

	private ListNode front;

	private ListNode rear;

	private int size;

	public LinkedQueue() {
		front = null;
		rear = null;
		size = 0;
	}

	@Override
	public void enqueue(int value) {
		ListNode newNode = new ListNode(value);
		if (isEmpty()) {
			front = newNode;
			rear = newNode;
		} else {
			rear.setNext(newNode);
			rear = newNode;
		}
		size++;
	}

	@Override
	public int dequeue() {
		int nodeValue = 0;

		if (isEmpty()) {
			throw new EmptyQueueException();
		}

		nodeValue = front.getData();
		if (size == 1) {
			front = null;
			rear = null;
		} else {
			ListNode tmp = front.getNext();
			front.setNext(null);
			front = tmp;
		}

		size--;
		return nodeValue;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public int getRawSize() {
		return size;
	}

	private boolean isEmpty() {
		return front == null && rear == null && size == 0;
	}

	// tests

	private static int CAPACITY = 8;

	private static Queue createQueue() {
		Queue queue = new LinkedQueue();
		for (int i = 0; i < CAPACITY; i++) {
			queue.enqueue(i);
		}
		return queue;
	}
	
	private static void testEnqueueDequeueGetSize() {
		Queue queue = new LinkedQueue();
		for (int i = 0; i < CAPACITY; i++) {
			queue.enqueue(i);
		}
		
		assert(queue.getSize() == CAPACITY);
		
		for (int i = 0; i < CAPACITY; i++) {
			queue.dequeue();
		}
		
		assert(queue.getSize() == 0);
	}

	private static void testDequeueFromMoreThanOneElementQueue() {
		Queue queue = createQueue();
		int expected = CAPACITY - 1;
		int actual = 0;

		for (int i = 0; i < CAPACITY; i++) {
			actual = queue.dequeue();
		}

		assert (expected == actual);
		assert (queue.getSize() == 0);
	}

	private static void testDequeueFromOneElementQueue() {
		Queue queue = new LinkedQueue();
		int expected = 1;

		queue.enqueue(expected);
		assert (expected == queue.dequeue());
		assert (queue.getSize() == 0);
	}

	private static void testDequeueFromEmptyQueue() {
		Queue queue = new LinkedQueue();
		Exception ex = null;
		try {
			queue.dequeue();
		} catch (Exception ex1) {
			ex = ex1;
		}

		assert (ex instanceof EmptyQueueException);
	}

	private static void testEnqueueIntoNonEmptyQueue() {
		Queue queue = createQueue();
		queue.enqueue(CAPACITY + 1);

		assert (queue.getSize() == CAPACITY + 1);
	}

	private static void testEnqueueIntoEmptyQueue() {
		LinkedQueue queue = new LinkedQueue();

		queue.enqueue(1);
		assert (queue.front == queue.rear);
		assert (queue.getSize() == 1);
	}

	private static void unitTests() {
		testEnqueueIntoEmptyQueue();
		testEnqueueIntoNonEmptyQueue();
		testDequeueFromEmptyQueue();
		testDequeueFromOneElementQueue();
		testDequeueFromMoreThanOneElementQueue();
		testEnqueueDequeueGetSize();
	}

	public static void main(String[] args) {
		unitTests();
		System.out.println("You passed all tests");
	}

}
