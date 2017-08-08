package com.datastructures.queue;

public class FixedSizeArrayQueue {

	private int[] queue;

	private int size;

	private int front;

	private int rear;

	public FixedSizeArrayQueue(int capacity) {
		this.queue = new int[capacity];
		reset();
	}

	public void enqueue(int value) {
		if (front == -1 && rear == 0) {
			queue[++front] = value;
		} else {
			rear = (rear + 1) % queue.length;
			if (rear == front) {
				// cannot enqueue if front is at the next position
				throw new FullQueueException();
			}
			queue[rear] = value;
		}
		size++;
	}

	public int dequeue() {
		int dequeueValue = 0;

		// cannot dequeue is queue is empty
		if (isReseted()) {
			throw new EmptyQueueException();
		}

		dequeueValue = queue[front];
		if (front == rear) {
			reset();
		} else {
			front = (front + 1) % queue.length;
			size--;
		}

		return dequeueValue;
	}

	private void reset() {
		size = 0;
		front = -1;
		rear = 0;
	}

	private boolean isReseted() {
		return size == 0 && front == -1 && rear == 0;
	}

	// tests

	private static final int CAPACITY = 8;

	private static FixedSizeArrayQueue createQueue() {
		FixedSizeArrayQueue queue = new FixedSizeArrayQueue(CAPACITY);
		for (int i = 1; i <= CAPACITY; i++) {
			queue.enqueue(i);
		}
		return queue;
	}
	
	private static void testFullQueueException() {
		FixedSizeArrayQueue queue = createQueue();
		Exception ex = null;
		
		try {
			queue.enqueue(9);
		} catch(Exception ex1) {
			ex = ex1;
		}
		assert(ex instanceof FullQueueException);
		
	}
	
	private static void testEmptyQueueException() {
		FixedSizeArrayQueue queue = new FixedSizeArrayQueue(CAPACITY);
		Exception ex = null;
		
		try {
			queue.dequeue();
		} catch(Exception ex1) {
			ex = ex1;
		}
		assert(ex instanceof EmptyQueueException);
		
	}

	private static void testRolloverDequeue() {
		FixedSizeArrayQueue queue = createQueue();
		
		queue.dequeue();
		queue.enqueue(9);

		int lastValue = 0;
		for (int i = 0; i < CAPACITY; i++) {
			lastValue = queue.dequeue();
		}
		
		assert(lastValue == 9);
	}

	private static void testRolloverEnqueue() {
		FixedSizeArrayQueue queue = createQueue();

		queue.dequeue();
		assert(queue.size == CAPACITY-1);
		
		queue.enqueue(9);
		assert(queue.rear == 0);
		assert(queue.size == CAPACITY);
	}

	private static void testFullDequeue() {
		FixedSizeArrayQueue queue = createQueue();
		for (int i = 0; i < CAPACITY; i++) {
			assert (i + 1 == queue.dequeue());
		}

		assert (queue.front == -1);
		assert (queue.rear == 0);
		assert (queue.size == 0);
	}

	private static void testFullEnqueue() {
		FixedSizeArrayQueue queue = createQueue();
		assert (queue.front == 0);
		assert (queue.rear == CAPACITY - 1);
		assert (queue.size == CAPACITY);
	}

	private static void unitTests() {
		testFullEnqueue();
		testFullDequeue();
		testRolloverEnqueue();
		testRolloverDequeue();
		testEmptyQueueException();
		testFullQueueException();
	}

	public static void main(String[] args) {
		unitTests();
		System.out.println("Your passed all tests!");
	}

}

class FullQueueException extends RuntimeException {

}

class EmptyQueueException extends RuntimeException {

}
