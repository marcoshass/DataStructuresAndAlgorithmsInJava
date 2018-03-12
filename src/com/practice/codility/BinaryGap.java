package com.practice.codility;

public class BinaryGap {

	public static void main(String[] args) {
		int N = 529;
		System.out.println("BinaryGap of (" + N + "): " + solution(N));
	}

	static int solution(int i) {
		int cnt = 0;
		int result = 0;
		boolean found_one = false;

		while (i > 0) {
			if ((i & 1) == 1) {
				if (!found_one) {
					found_one = true;
				} else {
					result = Math.max(result, cnt);
				}
				cnt = 0;
			} else {
				cnt++;
			}
			i >>>= 1;
		}

		return result;
	}

}
