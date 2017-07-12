package com.practice.codility;

public class DemoTask {

	public static void main(String[] args) {
		int A[] = { -1, 3, -4, 5, 1, -6, 2, 1 };
		System.out.println(solution(A));
	}
	
	// time complexity: O(n)
	// space complexity: O(n)
	static int solution(int[] A) {
		if (A == null)
			return -1;
		if (A.length == 1)
			return 0;
		
		int[] lookup = new int[A.length];
		
		// feed lookup array O(n)
		int leftSum = 0;
		for (int i = 0; i < A.length; i++) {
			if (i == 0) {
				lookup[i] = 0;
			} else {
				leftSum += A[i-1];
				lookup[i] = leftSum;
			}
		}
		
		// lookup a match O(n)
		int rightSum = 0;
		for (int i = A.length - 1; i >= 0; i--) {
			if (i == A.length - 1) {
				rightSum = 0;
			} else {
				rightSum += A[i+1];
			}
			
			// look for a match
			if (lookup[i] == rightSum) {
				//System.out.println("lookup[" + i + "]=" + rightSum);
				return i;
			}
		}
		
        return -1;
    }
	
}
