package com.datastructures.stacks;

public class StackFixture {

	// FixedSizeArrayStack

	private static IStack createStack(int size) {
		IStack stack = new FixedSizeArrayStack(size);
		for (int i = 0; i < size; i++) {
			stack.push(i);
		}
		return stack;
	}

	private static void testStackSizeInvalid() {
		IllegalArgumentException exceptionZeroSize = null;
		IllegalArgumentException exceptionNegativeSize = null;

		try {
			IStack stack = new FixedSizeArrayStack(0);
		} catch (IllegalArgumentException ex) {
			exceptionZeroSize = ex;
		}

		try {
			IStack stack = new FixedSizeArrayStack(-1);
		} catch (IllegalArgumentException ex) {
			exceptionNegativeSize = ex;
		}

		assert (exceptionZeroSize instanceof IllegalArgumentException);
		assert (exceptionNegativeSize instanceof IllegalArgumentException);
	}

	private static void testUnderflowException() {
		IStack stack = new FixedSizeArrayStack(1);
		RuntimeException ex = null;

		try {
			stack.pop();
		} catch (StackUnderflowException ex1) {
			ex = ex1;
		}

		assert (ex instanceof StackUnderflowException);
	}

	private static void testOverflowException() {
		IStack stack = new FixedSizeArrayStack(1);
		RuntimeException ex = null;

		try {
			stack.push(0);
			stack.push(1);
		} catch (StackOverflowException ex1) {
			ex = ex1;
		}

		assert (ex instanceof StackOverflowException);
	}

	private static void testStackSize() {
		IStack stack = new FixedSizeArrayStack(1);
		assert (stack.getLength() == 0);

		stack = createStack(1000);
		assert (stack.getLength() == 1000);
	}

	private static void testPeek(int size) {
		IStack stack = createStack(size);
		int peekValue = stack.peek();
		assert (peekValue == stack.getLength() - 1);
	}

	private static void testPop(int size) {
		IStack stack = createStack(size);
		for (int i = size - 1; i >= 0; i--) {
			int poppedValue = stack.pop();
			assert (poppedValue == i);
		}
		assert (stack.getLength() == 0);
	}

	private static void testPush(int size) {
		IStack stack = createStack(size);
		assert (stack.getLength() == size);
	}

	// DynamicArrayStack

	private static void testShrinkArray() {
		DynamicArrayStack stack = new DynamicArrayStack();
		for (int i = 1; i <= 16; i++) {
			stack.push(i);
		}
		
		assert(stack.getLength() == 16);
		
		for(int i = 0; i < 12; i++) {
			stack.pop();
		}
		
		assert(stack.getLength() == 4);

		stack.pop();
		assert(stack.getRawLength() == 8);
	}
	
	private static void testDoubleArray() {
		DynamicArrayStack stack = new DynamicArrayStack();

		stack.push(1);
		assert (stack.peek() == 1 && stack.getRawLength() == 1);

		stack.push(2);
		assert (stack.peek() == 2 && stack.getRawLength() == 2);

		stack.push(3);
		assert (stack.peek() == 3 && stack.getRawLength() == 4);

		stack.push(4);
		assert (stack.peek() == 4 && stack.getRawLength() == 4);

		stack.push(5);
		assert (stack.peek() == 5 && stack.getRawLength() == 8);
	}

	private static void unitTests() {
		int size = 1000000;
		testPush(size);
		testPop(size);
		testPeek(size);
		testStackSize();
		testOverflowException();
		testUnderflowException();
		testStackSizeInvalid();
		testDoubleArray();
		testShrinkArray();
	}

	public static void main(String[] args) {
		unitTests();
		System.out.println("You passed all tests!");
	}

}
