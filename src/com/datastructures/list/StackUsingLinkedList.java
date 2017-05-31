package com.datastructures.list;

public class StackUsingLinkedList {

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack);
		
		System.out.println("popped: " + stack.pop());
		System.out.println("popped: " + stack.pop());
		System.out.println(stack);
	}

}

/**
 * Stack implemented using a linked list as backend.
 */
class Stack {

	private LinkedList list;
	
	public Stack() {
		list = new LinkedList();
	}
	
	/**
	 * Push the element to the stack.
	 */
	public void push(int data) {
		ListNode newNode = new ListNode(data);
		list.insertAtBegin(newNode);
	}

	/**
	 * Pop the first element from the stack.
	 */
	public int pop() {
		ListNode removed = list.removeFromBegin();
		if (removed == null) {
			throw new RuntimeException("Cannot pop element from an empty stack.");
		}
		
		return removed.getData();
	}
	
	@Override
	public String toString() {
		return list.toString();
	}
	
	
}
