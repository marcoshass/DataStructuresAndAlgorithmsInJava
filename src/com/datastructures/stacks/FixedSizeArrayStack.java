package com.datastructures.stacks;

public class FixedSizeArrayStack {
	
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
	
	// tests
	
	private static FixedSizeArrayStack createStack(int size) {
		FixedSizeArrayStack stack = new FixedSizeArrayStack(size); 
		for (int i = 0; i < size ; i++) {
			stack.push(i);
		}
		return stack;
	}
	
	private static void testStackSizeInvalid() {
		IllegalArgumentException exceptionZeroSize = null;
		IllegalArgumentException exceptionNegativeSize = null;
		
		try {
			FixedSizeArrayStack stack = new FixedSizeArrayStack(0);
		} catch(IllegalArgumentException ex) {
			exceptionZeroSize = ex;
		}

		try {
			FixedSizeArrayStack stack = new FixedSizeArrayStack(-1);
		} catch(IllegalArgumentException ex) {
			exceptionNegativeSize = ex;
		}

		assert(exceptionZeroSize instanceof IllegalArgumentException);
		assert(exceptionNegativeSize instanceof IllegalArgumentException);
	}
	
	private static void testUnderflowException() {
		FixedSizeArrayStack stack = new FixedSizeArrayStack(1);
		RuntimeException ex = null;
		
		try {
			stack.pop();
		} catch (StackUnderflowException ex1) {
			ex = ex1;
		}
		
		assert(ex instanceof StackUnderflowException);
	}
	
	private static void testOverflowException() {
		FixedSizeArrayStack stack = new FixedSizeArrayStack(1);
		RuntimeException ex = null;
		
		try {
			stack.push(0);
			stack.push(1);
		} catch (StackOverflowException ex1) {
			ex = ex1;
		}
		
		assert(ex instanceof StackOverflowException);
	}
	
	private static void testPeek(int size) {
		FixedSizeArrayStack stack = createStack(size);
		int peekValue = stack.peek();
		assert(peekValue == stack.getLength() - 1);
	}
	
	private static void testPop(int size) {
		FixedSizeArrayStack stack = createStack(size);
		for(int i = size - 1; i >= 0; i--) {
			int poppedValue = stack.pop();
			assert(poppedValue == i);
		}
		assert(stack.getLength() == 0);
	}
	
	private static void testPush(int size) {
		FixedSizeArrayStack stack = createStack(size);
		assert(stack.getLength() == size);
	}
	
	private static void unitTests() {
		int size = 1000000;
		testPush(size);
		testPop(size);
		testPeek(size);
		testOverflowException();
		testUnderflowException();
		testStackSizeInvalid();
	}
	
	public static void main(String[] args) {
		unitTests();
		System.out.println("You passed all tests!");
	}
	
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

