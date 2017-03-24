package com.algorithms.sort;

import java.util.Arrays;

public class MergeSort {

	// 0  1  2  3  4 5  6  7  8  9
	// 23 47 81 95 7 14 39 55 62 74
	// p        q   			  
	//            q+1			 r
	public static void main(String[] args) {
		int[] A = {23, 47, 81, 95};
		int[] B = {7, 14, 39, 55, 62, 74};
		int[] C = new int[A.length + B.length];
		
		//merge(A, A.length, B, B.length, C);
		//System.out.println(Arrays.toString(C));
		
		int[] M = {23, 47, 81, 95, 7, 14, 39, 55, 62, 74};
		mergeSort(M, 0, 9);
		System.out.println(Arrays.toString(M));
	}
	
	//            0      7
	//            p      r
	//            65318724
	//           /        \
	//         6531      8724
	//         / \       / \  
	//        65 31     87 24
	//        /\  /\    /\  /\
	//       6 5  3 1  8 7  2 4
	static void mergeSort(int[] A, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(A, p, q);
			mergeSort(A, q + 1, r);
			merge(A, p, q, r);
		}
	}
	
	// Time: O(n)
	// Space: O(2n) ? 
	static void merge(int[] A, int p, int q, int r) {
		int[] L = new int[q + 1];
		int[] R = new int[r - q];
		
		// feed L
		for (int i = 0; i <= q; i++) {
			L[i] = A[i];
		}
		
		// feed R
		int r1 = 0;
		for (int i = q + 1; i <= r; i++) {
			R[r1++] = A[i];
		}
		
		// merge
		int a = 0, b = 0;
		for (int i = 0; i <= r; i++) {
			if (b > R.length - 1) {
				A[i] = L[a++];
			} else if (a > L.length - 1) {
				A[i] = R[b++];
			} else {
				if (L[a] < R[b])
					A[i] = L[a++];
				else if (R[b] < L[a])
					A[i] = R[b++];
			}
		}
	}

	 // O(n)
	static void merge(int[] arrayA, int sizeA, int[] arrayB, int sizeB, int[] arrayC) {
		int a = 0, b = 0;
		
		for (int i = 0; i < arrayC.length; i++) {
			if (b > sizeB - 1) {
				arrayC[i] = arrayA[a++];
			} else if (a > sizeA - 1) {
				arrayC[i] = arrayB[b++];
			} else { // not over limits
				if (arrayA[a] < arrayB[b])
					arrayC[i] = arrayA[a++];
				else if (arrayB[b] < arrayA[a])
					arrayC[i] = arrayB[b++];
			}
		}
	}

}
