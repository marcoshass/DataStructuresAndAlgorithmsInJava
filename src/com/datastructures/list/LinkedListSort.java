package com.datastructures.list;

import java.util.*;

public class LinkedListSort {

	public static void main(String[] args) {
//		int[] arrayToSort = { 1, 2, 3, 5, 4 };
		int[] arrayToSort = { 1, 2, 3, 5, 4 };		
		bubbleSortVeryOptimized(arrayToSort);
		//System.out.println(Arrays.toString(arrayToSort));
	}
	
	// time complexity: O(n^2)
	// space complexity: O(1)
	static void bubbleSortNormal(int[] a) {
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
	static void bubbleSortVeryOptimized(int[] a) {
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

	
	// time complexity: O(n^2)
	// space complexity: O(1)
	static void bubbleSortOptimized(int[] a) {
		boolean swap = true;
		for (int i = 0; i < a.length && swap; i++) {
			swap = false;
			for (int j = 0; j < a.length - i; j++) {
				if (j < a.length - i - 1 && a[j+1] < a[j]) { // swap until last-1
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					swap = true;
				}
			}
		}
	}

}
