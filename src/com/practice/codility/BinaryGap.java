package com.practice.codility;

public class BinaryGap {

	public static void main(String[] args) {
		int N = 529;
		System.out.println("BinaryGap of (" + N + "): " + solution(N));
	}

	static int solution(int N) {
		int maxGap = 0;
		int count = 0;
		boolean started = false;

		while (N > 0) {
			if ((N & 1) > 0) {
				if (started & count > maxGap) {
					maxGap = count;
				}
				started = true;
				count = 0;
			} else {
				count++;
			}
			N >>>= 1;
		}

		return maxGap;
	}

}
