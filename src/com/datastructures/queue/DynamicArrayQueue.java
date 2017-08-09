package com.datastructures.queue;

public class DynamicArrayQueue implements Queue {

	private int[] queue;

	private int size;

	private int front;

	private int rear;

	public DynamicArrayQueue(int capacity) {
		this.queue = new int[capacity];
		reset();
	}

	@Override
	public void enqueue(int value) {
		if (front == -1 && rear == 0) {
			queue[++front] = value;
		} else {
			rear = (rear + 1) % queue.length;
			if (rear == front) {
				// expand if front is at the next position
				queue = expand();
			}
			queue[rear] = value;
		}
		size++;
	}

	private int[] expand() {
		int[] expandedArray = new int[queue.length * 2];

		for (int i = 0; i < getSize(); i++) {
			expandedArray[i] = dequeue();
		}

		// adjust pointers
		front = 0;
		rear = getSize();

		return expandedArray;
	}

	private int[] shrink() {
		int[] shrinkedArray = new int[queue.length / 2];

		int j = 0;
		for (int i = front; i <= rear; i++) {
			shrinkedArray[j++] = queue[i];
		}

		// adjust pointers
		front = 0;
		rear = j-1;		
		
		return shrinkedArray;
	}

	@Override
	public int dequeue() {
		int dequeueValue = 0;

		// cannot dequeue is queue is empty
		if (isReseted()) {
			throw new EmptyQueueException();
		}

		dequeueValue = queue[front];
		if (front == rear) {
			reset();
			return dequeueValue;
		} else {
			front = (front + 1) % queue.length;
			size--;
		}

		// shrink when only 1/4 of queue is full
		if (size <= queue.length / 4) {
			queue = shrink();
		}

		return dequeueValue;
	}

	@Override
	public int getSize() {
		return size;
	}

	public int getRawSize() {
		return queue.length;
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

	private static Queue createFullQueue() {
		Queue queue = new DynamicArrayQueue(CAPACITY);
		for (int i = 1; i <= CAPACITY; i++) {
			queue.enqueue(i);
		}
		return queue;
	}
	
	private static void testShrinkQueue() {
		Queue queue = createFullQueue();
		assert (queue.getSize() == CAPACITY);

		for (int i = CAPACITY; i > CAPACITY/4; i--) {
			queue.dequeue();
		}
		
		assert (queue.getRawSize() == CAPACITY/2);
	}

	private static void testExpandQueue() {
		Queue queue = createFullQueue();
		assert (queue.getSize() == CAPACITY);

		queue.enqueue(0);
		assert (queue.getRawSize() == CAPACITY * 2);
	}

	private static void unitTests() {
		testExpandQueue();
		testShrinkQueue();
	}

	public static void main(String[] args) {
		unitTests();
		System.out.println("You passed all tests!");
	}

}
