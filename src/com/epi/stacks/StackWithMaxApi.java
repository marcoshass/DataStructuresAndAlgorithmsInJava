package com.epi.stacks;

import java.util.Deque;
import java.util.LinkedList;

public class StackWithMaxApi {
	public static void main(String[] args) {
		Stack<Integer>stack = new Stack<>();
		stack.push(new ElementWithCachedMax<>(6));
		stack.push(new ElementWithCachedMax<>(4));
		stack.push(new ElementWithCachedMax<>(3));
		stack.push(new ElementWithCachedMax<>(7));
		
		printMax(stack);
		stack.pop();
		printMax(stack);
		stack.pop();
		printMax(stack);
		stack.pop();
		printMax(stack);
	}
	
	static void printMax(Stack<Integer> s) {
		System.out.println(s.max());		
	}
}

class ElementWithCachedMax<T extends Comparable<T>> {
	public T value;

	public T max;

	public ElementWithCachedMax(T element) {
		this(element, null);
	}

	public ElementWithCachedMax(T element, T max) {
		this.value = element;
		this.max = max;
	}
}

class Stack<T extends Comparable<T>> {
	private Deque<ElementWithCachedMax<T>> elementWithCachedMax = 
			new LinkedList<>();

	boolean empty() {
		return elementWithCachedMax.isEmpty();
	}

	T max() {
		if (empty()) {
			throw new IllegalStateException("max(): empty stack");
		}
		return elementWithCachedMax.peek().max;
	}

	ElementWithCachedMax<T> pop() {
		if (empty()) {
			throw new IllegalStateException("pop(): empty stack");
		}
		return elementWithCachedMax.pop();
	}

	void push(ElementWithCachedMax<T> element) {
		element.max = element.value;
		if (!elementWithCachedMax.isEmpty()) {
			T currentMax = elementWithCachedMax.peek().max;
			element.max = element.value.compareTo(currentMax) > 0 ? element.value : currentMax;
		}
		elementWithCachedMax.push(element);
	}
}
