package com.epi.stacks;

import java.util.Deque;
import java.util.LinkedList;

public class StackWithMaxApi {

	public static void main(String[] args) {
		StackWithMax<Integer> myStack = new StackWithMax<>();
		myStack.push(1);
		printMax(myStack); // 1

		myStack.push(3);
		printMax(myStack); // 3
		
		myStack.push(0);
		printMax(myStack); // 3
		
		myStack.push(8);
		printMax(myStack); // 8
		
		myStack.push(2);
		printMax(myStack); // 8
	}
	
	static void printMax(StackWithMax stack) {
		System.out.println(stack.max());
	}
}

class StackWithMax<T extends Comparable<T>> {
	private Deque<T> wrappedStack = new LinkedList<>();
	private Deque<T> maxStack = new LinkedList<>();
	
	public boolean empty() {
		return wrappedStack.isEmpty();
	}
	
	public T max() {
		return maxStack.peek();
	}
	
	public T pop() {
		maxStack.pop();
		return wrappedStack.pop();
	}
	
	public void push(T x) {
		wrappedStack.push(x);
		T maxValue = max() == null ? x : max();
		maxStack.push(x.compareTo(maxValue) > 0 ? x : maxValue);
	}
}
