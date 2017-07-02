package com.datastructures.list;

import java.util.*;

public class LinkedListSort {

	public static void main(String[] args) {
		ListNode node5 = new ListNode(5);
		ListNode node4 = new ListNode(4);
		ListNode node6 = new ListNode(6);
		ListNode node2 = new ListNode(2);
		
		node5.setNext(node4);
		node4.setNext(node6);
		node6.setNext(node2);
		
		ListNode ret = mergeSortLinkedList(node5);
		LinkedList list = new LinkedList();
		list.setHead(ret);
		System.out.println(list);
	}

	/** LinkedList merge sort.
	 *	  time complexity O(nlogn)
	 *	  space complexity O(n). 
	 */
	static ListNode mergeSortLinkedList(ListNode head) {
		if (head != null && head.getNext() != null) {
			ListNode slowPtr = head;
			ListNode fastPtr = slowPtr;

			// fill 1st first half O(n)
			LinkedList firstHalf = new LinkedList();
			while (true) {
				fastPtr = fastPtr.getNext().getNext();
				
				if (fastPtr == null) {
					firstHalf.insertAtEnd(new ListNode(slowPtr.getData()));
					break;
				} else if (fastPtr.getNext() == null) {
					firstHalf.insertAtEnd(new ListNode(slowPtr.getData()));
					slowPtr = slowPtr.getNext();
					firstHalf.insertAtEnd(new ListNode(slowPtr.getData()));
					break;
				} else {
					firstHalf.insertAtEnd(new ListNode(slowPtr.getData()));
					slowPtr = slowPtr.getNext();
				}
			}

			// fill 2nd half O(n)
			LinkedList secondHalf = new LinkedList();
			for (ListNode p = slowPtr.getNext(); p != null; p = p.getNext()) {
				secondHalf.insertAtEnd(new ListNode(p.getData()));
			}
			
			ListNode ret1 = mergeSortLinkedList(firstHalf.getHead());
			ListNode ret2 = mergeSortLinkedList(secondHalf.getHead());
			return merge(ret1, ret2);
			
		}
		return head;
	}
	
	static ListNode merge(ListNode firstHalf, ListNode secondHalf) {
		ListNode head = new ListNode(-1);
		ListNode tmp = head;
		
		while (true) {
			if (secondHalf == null) {
				head.setNext(firstHalf);
				break;
			} else if (firstHalf == null) {
				head.setNext(secondHalf);
				break;
			} else if (firstHalf.getData() < secondHalf.getData()) {
				head.setNext(new ListNode(firstHalf.getData()));
				firstHalf = firstHalf.getNext();
			} else  { // secondHalf < firstHalf
				head.setNext(new ListNode(secondHalf.getData()));
				secondHalf = secondHalf.getNext();
			}
			head = head.getNext();
		}
		
		return tmp.getNext();
	}
	
	/**
	 * Array merge sort.
	 */
	static void mergeSort(int[] listToSort) {
		split(listToSort);
	}
	
	// time complexity: O(nlogn)
	// space complexity: O(n)
	static void split(int[] source) {
		if (source.length > 1) { // base case
			int firstLength = source.length / 2 + source.length % 2;
			int secondLength = source.length - firstLength;

			int[] firstHalf = new int[firstLength];
			int[] secondHalf = new int[secondLength];

			for (int index = 0; index < source.length; index++) {
				if (index < firstHalf.length) {
					firstHalf[index] = source[index];
				} else {
					secondHalf[index - firstHalf.length] = source[index];
				}
			}
			
			split(firstHalf);
			split(secondHalf);
			merge(source, firstHalf, secondHalf);
		}
	}
	
	static void merge(int[] target, int[] firstHalf, int[] secondHalf) {
		int firstPtr, secondPtr, targetPtr;
		firstPtr = secondPtr = targetPtr = 0;
		
		while (targetPtr < target.length) {
			if (firstPtr < firstHalf.length & secondPtr < secondHalf.length) {
				// both pointers are valid
				if (firstHalf[firstPtr] < secondHalf[secondPtr]) {
					target[targetPtr++] = firstHalf[firstPtr++]; 
				} else {
					target[targetPtr++] = secondHalf[secondPtr++];
				}
			} else if (firstPtr >= firstHalf.length & secondPtr < secondHalf.length) {
				// firstPtr hit the end, secondPtr valid
				target[targetPtr++] = secondHalf[secondPtr++];
			} else if (secondPtr >= secondHalf.length & firstPtr < firstHalf.length) { 
				// secondPtr hit the end, first valid
				target[targetPtr++] = firstHalf[firstPtr++];
			}
		}
		
	}
	
	// time complexity: O(n^2)
	// space cmplexity: O(1)
	static void selectionSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				System.out.println(Arrays.toString(a));
				if (a[i] > a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(a));
	}
	
	// time complexity: O(n^2)
	// space complexity: O(1)
	static void bubbleSort(int[] a) {
		for (int i = a.length - 1; i >= 0; i--) {
			for (int j = 0; j <= i - 1; j++) {
				System.out.println(Arrays.toString(a));
				if (a[j] > a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(a));
	}
	
	// time complexity: O(n^2)
	// space complexity: O(1)
	static void bubbleSortOptimized(int[] a) {
		boolean swap = true;
		for (int i = a.length - 1; i >= 0 && swap; i--) {
			swap = false;
			for (int j = 0; j <= i - 1; j++) {
				System.out.println(Arrays.toString(a));
				if (a[j] > a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					swap = true;
				}
			}
		}
		System.out.println(Arrays.toString(a));
	}

}
