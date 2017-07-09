package com.algorithms.bitmanipulation;

public class BitManipulationTests {

	public static void main(String[] args) {
		int numberToCheck = 2147483647;
		int result = getNumberOfOnes(numberToCheck);
		System.out.println("the number of 1's is: " + result);
	}
	
	// time complexity: O(32) => O(1)
	static int getNumberOfOnes(int numberToCheck) {
		int counter = 0;
		int mask = 1<<31; // set leftmost bit to 1

		for (int i = 0; i <= 31; i++) {
			if (((mask>>>i) & (numberToCheck)) != 0) {
				counter++;
			}
			//printInt(mask>>>i);
		}

		return counter;
	}
	
	static void printInt(int value) {
		System.out.println("decimal:" + value + " binary:" + Integer.toBinaryString(value));
	}
	
	static int getNthBit(int num, int n	) {
		int checkBit = 1<<n;
		
		int andBit = num & checkBit;
		if (andBit == checkBit) {
			return 1;
		}
		
		return 0;
	}
	
	static int setNthBit(int num, int n) {
		int setBit = 1<<n;
		
		int orResult = num | setBit;
		
		return orResult;
	}
	
	static int setNthToZero(int num, int n) {
		// flip the mask from 00001000 to 11110111
		int flippedMask = 1<<n;
		flippedMask = ~flippedMask;
		
		// and the number with the flipped mask
		int andResult = num & flippedMask;
		return andResult;
	}
	
}
