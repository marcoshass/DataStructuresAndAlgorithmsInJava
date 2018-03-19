package com.practice.leetcode;

import com.datastructures.list.*;

public class AddTwoNumbers {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		l1.setNext(l2);
		l2.setNext(l3);

		ListNode l4 = new ListNode(5);
		ListNode l5 = new ListNode(6);
		ListNode l6 = new ListNode(4);
		l4.setNext(l5);
		l5.setNext(l6);

		ListNode sumOfNodes = addTwoNumbers(l1, l4);
	}

	static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		
		while (l1 != null | l2 != null) {
			int result = carry + l1.getData() + l2.getData();
			if (result >= 10) {
				carry = 10 / result;
				result = 10 % result;
			}

			System.out.print(result + " ");
			
			
			l1 = l1.getNext();
			l2 = l2.getNext();
		}
		return null;
	}

}
