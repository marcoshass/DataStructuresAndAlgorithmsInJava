package com.epi.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

class MaxWithCount {
	public Integer max;

	public Integer count;

	public MaxWithCount(Integer max, Integer count) {
		this.max = max;
		this.count = count;
	}
}

public class Stack2 {
	private Deque<MaxWithCount> element = new ArrayDeque<>();

	private Deque<MaxWithCount> cachedMaxWithCount = new ArrayDeque<>();

	boolean empty() {
		return element.isEmpty();
	}

	Integer max() {
		if (empty()) {
			throw new IllegalStateException("max(): empty stack");
		}
		return cachedMaxWithCount.peek().max;
	}

	MaxWithCount pop() {
		if (empty()) {
			throw new IllegalStateException("pop(): empty stack");
		}
		
		MaxWithCount popElement = element.pop();
		if (popElement.max == cachedMaxWithCount.peek().max) {
			cachedMaxWithCount.peek().count--;
			if (cachedMaxWithCount.peek().count <= 0) {
				cachedMaxWithCount.pop();
			}
		}
		return popElement;
	}

	void push(MaxWithCount x) {
		element.push(x);		
		if (cachedMaxWithCount.isEmpty() || x.max > cachedMaxWithCount.peek().max) {
			cachedMaxWithCount.push(new MaxWithCount(x.max, 1));
		} else {
			if (x.max == max()) {
				cachedMaxWithCount.peek().count++;
			}
		}
	}
}
