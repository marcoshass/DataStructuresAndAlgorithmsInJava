package com.algorithms.problems;

public class ThreePointerPattern {

	public static void main(String[] args) {
		printFibonacci(100);
	}

	static void printFibonacci(int limit) {
		int prev;
		int tmp;
		int cur;

		prev = cur = 0;
		while (cur <= limit) {
			if (cur == 0) {
				System.out.print(cur++ + " " + cur + " ");
			} else {
				tmp = cur;
				cur += prev;
				prev = tmp;
				System.out.print(cur + " ");
			}
		}

	}

}
