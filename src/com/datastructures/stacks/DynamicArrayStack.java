package com.datastructures.stacks;

public class DynamicArrayStack implements IStack {

	private int[] stack;

	private int top;

	private int size;

	public DynamicArrayStack() {
		this.stack = new int[1];
		this.top = -1;
		this.size = 0;
	}

	@Override
	public void push(int value) {
		if (top == stack.length - 1)
			stack = expandArray();

		size++;
		stack[++top] = value;
	}

	@Override
	public int pop() {
		if (top < 0)
			throw new StackUnderflowException("cannot pop element from empty stack");

		if (top+1 <= stack.length/4) {
			stack = shrinkArray();
		}

		size--;
		return stack[top--];
	}

	@Override
	public int peek() {
		if (top < 0)
			throw new StackUnderflowException("cannot peek element from empty stack");

		return stack[top];
	}

	@Override
	public int getLength() {
		return size;
	}

	public int getRawLength() {
		return stack.length;
	}

	private int[] expandArray() {
		int[] doubleArray = new int[stack.length * 2];
		System.arraycopy(stack, 0, doubleArray, 0, stack.length);
		return doubleArray;
	}

	private int[] shrinkArray() {
		int[] halfArray = new int[stack.length / 2];
		System.arraycopy(stack, 0, halfArray, 0, top+1);
		return halfArray;
	}

}
