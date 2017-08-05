package com.datastructures.stacks;

public interface IStack {

	void push(int value);
	
	int pop();
	
	int peek();
	
	int getLength();
	
}

class StackOverflowException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public StackOverflowException(String message) {
		super(message);
	}

}

class StackUnderflowException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public StackUnderflowException(String message) {
		super(message);
	}
	
}