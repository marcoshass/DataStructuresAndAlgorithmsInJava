package com.datastructures.list;

import java.util.*;

public class LinkedListSort {

	public static void main(String[] args) {
		int[] arrayToSort = { 4, 3, 2, 1 };
		bubbleSort(arrayToSort);
		System.out.println(Arrays.toString(arrayToSort));
	}
	
	// time complexity: O(n^2)
	// space complexity: O(1)
	static void bubbleSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - i; j++) {
				if (j < a.length - i - 1 && a[j+1] < a[j]) { // swap until last-1
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}

}
