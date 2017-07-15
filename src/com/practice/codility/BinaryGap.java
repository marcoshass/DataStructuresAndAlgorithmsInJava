package com.practice.codility;

public class BinaryGap {

	public static void main(String[] args) {
		System.out.println(solution(1041));
	}
	
	static int solution(int N) {
		int max = 0;
		int count = 0;
		
		int previous = 0;
		int current = 0;
		
		for (int i = 0; i <= 31; i++) {
			if (current > 0 & previous == 0) { // 1 0 (end)
				if (count > 0) {
					max = count > max ? count : max;
				}
				count = 0;
			}
			
			if (current == 0 & previous > 0) { // 0 1 (start)
				count++;
			}
			
			if (current == 0 & previous == 0) { // 0 0 (+1)
				if (count > 0) {
					count++;
				}
			}
			
			// move next
			previous = current;
			current = N & 1<<i;
		}
		
		return max;
	}

}
