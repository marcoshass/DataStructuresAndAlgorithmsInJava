package com.practice.codility;

public class BinaryGap {

	public static void main(String[] args) {
		System.out.println(solution(1041));
	}

	static int solution(int N) {
		int count, maxCount;
		boolean flagOne = false;
		count = maxCount = 0;

		while (N != 0) {
			if ((N & 1) == 0 & flagOne) {
				count++;
			} else if ((N & 1) == 1 & !flagOne) {
				flagOne = true;
			} else if ((N & 1) == 1 & flagOne) {
				if (count > maxCount) {
					maxCount = count;
				}
				count = 0;
			}
			N >>>= 1;
		}

		return maxCount;
	}

}
