package com.practice.epi.arrays;

import java.util.Arrays;

public class EvenOdd {

	public static void main(String[] args) {
		int[] arrayToSort = new int[] {5, 4, 3, 2, 8, 9 };
		
		int[] array1 = arrayToSort.clone();
		evenOdd(array1);
		System.out.printf("myv=%s", Arrays.toString(array1));
		
		evenOdd1(arrayToSort);
		System.out.printf("\nepi=%s", Arrays.toString(arrayToSort));
	}
	
	// 1:: my version
	static void evenOdd(int[] a) {
		int nextEven = 0, nextOdd = a.length - 1;
		while (nextEven < nextOdd) {
			if (!isEven(a[nextEven])) {
				int temp = a[nextEven];
				a[nextEven] = a[nextOdd];
				a[nextOdd] = temp;
			}

			nextEven += isEven(a[nextEven]) ? 1 : 0;
			nextOdd -= isOdd(a[nextOdd]) ? 1 : 0;
		}
	}
	
	// 2:: epi version
	static void evenOdd1(int[] A) {
		int nextEven = 0, nextOdd = A.length - 1;
		while (nextEven < nextOdd) {
			if (A[nextEven] % 2 == 0) {
				nextEven++;
			} else {
				int temp = A[nextEven];
				A[nextEven] = A[nextOdd];
				A[nextOdd--] = temp;
			}
		}
	}
	
	static boolean isEven(int number) {
		return number % 2 == 0;
	}

	static boolean isOdd(int number) {
		return !isEven(number);
	}

}
