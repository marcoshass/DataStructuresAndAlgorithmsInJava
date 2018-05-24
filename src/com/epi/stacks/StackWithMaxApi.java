package com.epi.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

import com.epi.linkedlist.*;

public class StackWithMaxApi {

	public static void main(String[] args) {
		ListNode<Integer> head = new ListNode<>(0); 
		ListNode<Integer> current = head;
		for (int i = 1; i <= 4; ++i) {
			current.next = new ListNode<Integer>(i);
			current = current.next;
		}
		printLinkedListInReverse(head);
	}

	static void printLinkedListInReverse(ListNode<Integer> head) {
		Deque<Integer> nodes = new ArrayDeque<>();
		while (head != null) {
			nodes.push(head.data); // 4 3 2 1 0
			head = head.next;
		}
		while (!nodes.isEmpty()) {
			System.out.printf("%d\n", nodes.poll());
		}
	}
}
