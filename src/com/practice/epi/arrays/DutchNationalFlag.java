package com.practice.epi.arrays;

import java.util.*;

public class DutchNationalFlag {

	public static void main(String[] args) {
		List<Color> A = new ArrayList<>();
		A.add(Color.ZERO); // {0, 1, 2, 0, 2, 1, 1}
		A.add(Color.ONE);  //           ^
		A.add(Color.TWO);
		A.add(Color.ZERO);
		A.add(Color.TWO);
		A.add(Color.ONE);
		A.add(Color.ONE);
		
		dutchFlagPartition(3, A);
	}
	
	public static enum Color { ZERO, ONE, TWO };
	
	public static void dutchFlagPartition(int pivotIndex, List<Color> A) {
		Color pivot = A.get(pivotIndex);
		int smaller = 0, equal = 0, larger = A.size();
		while (equal < larger) {
			if (A.get(equal).ordinal() < pivot.ordinal()) {
				Collections.swap(A, smaller++, equal++);
			} else if (A.get(equal).ordinal() == pivot.ordinal()) {
				++equal;
			} else { // A.get(equal) > pivot
				Collections.swap(A, equal++, --larger);
			}
		}
		System.out.println(A);
	}
}
