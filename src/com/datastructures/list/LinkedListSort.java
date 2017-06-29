package com.datastructures.list;

import java.util.*;

public class LinkedListSort {

	public static void main(String[] args) {
		int[] arrayToSort = { 5, 4, 3, 2, 1 };		
		selectionSort(arrayToSort);
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
