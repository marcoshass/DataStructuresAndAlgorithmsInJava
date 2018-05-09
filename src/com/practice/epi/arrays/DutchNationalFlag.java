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
		for (int i = 0; i < A.size(); ++i) {
			for (int j = i + 1; j < A.size(); ++j) {
				if (A.get(j).ordinal() < pivot.ordinal()) {
					Collections.swap(A,  i, j);
					break;
				}
			}
		}
		
		for (int i = A.size() -1; i >= 0 && A.get(i).ordinal() >= pivot.ordinal(); --i) {
			for (int j = i - 1;  j >= 0 && A.get(j).ordinal() >= pivot.ordinal(); --j) {
				if (A.get(j).ordinal() > pivot.ordinal()) {
					Collections.swap(A, i, j);
					break;
				}
			}
		}
		
		System.out.println(A);
	}

}
