package com.datastructures.queue;

public interface Queue {
	
	void enqueue(int value);
	
	int dequeue();
	
	int getSize();

	int getRawSize();
	
}
