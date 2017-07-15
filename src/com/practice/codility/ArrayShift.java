package com.practice.codility;

import java.util.Arrays;

public class ArrayShift {

	public static void main(String[] args) {
		int[] arrayToShift = { 3, 8, 9, 7, 6 };
		int k = 3;
		
		System.out.println(Arrays.toString(solution(arrayToShift, k)));
	}
	
	static int[] solution(int[] A, int K) {
		int[] newArray = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			newArray[(i + K) % A.length] = A[i];
		}
		return newArray;
    }

}
