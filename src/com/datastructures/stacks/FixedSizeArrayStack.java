package com.datastructures.stacks;

public class FixedSizeArrayStack implements IStack {
	
	private int[] stack;
	
	private int top;
	
	private int size;
	
	public FixedSizeArrayStack(int size) {
		if (size < 1)
			throw new IllegalArgumentException("stack size must be greater than zero");
		
		this.stack = new int[size];
		this.top = -1;
		this.size = 0;
	}
	
	public void push(int value) {
		if (top == stack.length - 1) 
			throw new StackOverflowException("cannot push element into a full stack"); 

		size++;
		stack[++top] = value;
	}
	
	public int pop() {
		if (top < 0)
			throw new StackUnderflowException("cannot pop element from empty stack");
		
		size--;
		return stack[top--];
	}
	
	public int peek() {
		if (top < 0)
			throw new StackUnderflowException("cannot peek element from empty stack");
		
		return stack[top];
	}
	
	public int getLength() {
		return size;
	}

}

