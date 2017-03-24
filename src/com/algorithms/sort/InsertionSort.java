package com.algorithms.sort;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] data = new int[] { 31, 41, 59, 26, 41, 58 };
		insertionSort(data);
		System.out.println(Arrays.toString(data)); // increasing
		
		insertionSortDecreasing(data);
		System.out.println(Arrays.toString(data)); // descreasing
		
		int v = 26;
		System.out.println("Number:" + v + " found at:" + linearSearch(data, v));
	}

// technique 01 - cormen

	 // O(n^2)
	static void insertionSort(int[] A) {
		for (int i = 1; i < A.length; i++) {
			int temp = A[i]; // 1 2 3 4 5 6			temp=3
							 //   j       i
			int j = i - 1;
			while (j > -1 && A[j] > temp) {
				A[j + 1] = A[j];
				j--;
			}
			A[j + 1] = temp;
		}
	}

// Exercise 2.1-1
//
// 31 41 59 26 41 58 t=41
// j  i
//
//   31 41 59 26 41 58 t=59
//      j  i
//
//     31 41 59 26 41 58 t=26
//           j  i
//
//       31 41 59 59 41 58 t=26
//			j     i
//
//         31 41 41 59 41 58 t=26
//         j        i
//
//           31 31 41 59 41 58 t=26
//         j          i
//
//             26 31 41 59 41 58 t=26
//           j          i
//
//             26 31 41 59 41 58 t=41
//                      j  i
//
//               26 31 41 59 59 58 t=41
//                     j     i
//
//               26 31 41 41 59 58 t=41
//  				   j     i
//
//                 26 31 41 41 59 58 t=58
//							   j  i
//
//  			     26 31 41 41 59 59 t=58
//				              j     i
//
//  				   26 31 41 41 58 59 t=58
//    							j     i
	
// Exercise 2.1-2
	static void insertionSortDecreasing(int[] A) {
		for (int i = A.length - 2; i > -1; i--) {
			int temp = A[i]; // 59 58 41 41 31 26
							 //                     
			int j = i + 1;
			while (j <= A.length -1 && A[j] > temp) {
				A[j - 1] = A[j];
				j++;
			}
			A[j - 1] = temp;
		}
	}
	
// Exercise 2.1-3
	
	static int linearSearch(int[] A, int v) {
		for (int i = 0; i < A.length; i++) {
			if (A[i] == v)
				return i;
		}
		return 0;
	}
	
}
