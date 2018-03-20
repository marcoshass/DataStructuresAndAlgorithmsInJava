package com.practice.leetcode;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class AddTwoNumbers {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		l1.next = l2;
		l2.next = l3;

		ListNode l4 = new ListNode(5);
		ListNode l5 = new ListNode(6);
		ListNode l6 = new ListNode(4);
		l4.next = l5;
		l5.next = l6;

		ListNode sumOfNodes = addTwoNumbers(l1, l4);
		System.out.println("");
	}

	// input: (9) + (9)
	static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode output = null, root = null;

		while (l1 != null | l2 != null) {
			int result = carry + (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);

			if (result >= 10) {
				carry = result / 10;
				result = result % 10;
			} else {
				carry = 0;
			}

			if (output == null) {
				output = new ListNode(result);
				root = output;
			} else {
				output.next = new ListNode(result);
				output = output.next;
			}

			l1 = l1 != null ? l1.next : null;
			l2 = l2 != null ? l2.next : null;

			// put the carry in the next digit
			if (l1 == null && l2 == null && carry > 0) {
				output.next = new ListNode(carry);
			}
		}

		return root;
	}

}
