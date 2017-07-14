package com.algorithms.bitmanipulation;

public class BitManipulationGetNumberOfOnes {

	public static void main(String[] args) {
		int n = 1099;
		//System.out.println("Number of ones:" + getNumberOfOnes(n));
		printPositionOfOnes(n);
	}
	
	static int getNumberOfOnes(int n) {
		int count = 0;
		
		for (int i = 0; i <= 31; i++) {
			if ((n & 1<<i) > 0) {
				count++;
			}
		}
		
		return count;
	}
	
	static void printPositionOfOnes(int n) {
		System.out.println(Integer.toBinaryString(n));
		for (int i = 0; i <= 31; i++) {
			if ((n & 1<<i) > 0) {
				System.out.print(i + " ");
			}
		}
	}

}
