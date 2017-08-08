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
		int[] expandedArray = new int[queue.length*2];
		
		for (int i = 0; i < getSize(); i++) {
			expandedArray[i] = dequeue();
		}
		
		return expandedArray;
	}

	@Override
	public int dequeue() {

		return 0;
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

	private static Queue createQueue() {
		Queue queue = new DynamicArrayQueue(CAPACITY);
		for (int i = 1; i <= CAPACITY; i++) {
			queue.enqueue(i);
		}
		return queue;
	}
	
	private static void testExpandQueue() {
		Queue queue = createQueue();
		assert(queue.getSize() == CAPACITY);
		
		queue.enqueue(9);
		assert(queue.getRawSize() == CAPACITY*2);
	}
	
	private static void unitTests() {
		testExpandQueue();
	}
	
	public static void main(String[] args) {
		unitTests();
		System.out.println("You passed all tests!");
	}

}
