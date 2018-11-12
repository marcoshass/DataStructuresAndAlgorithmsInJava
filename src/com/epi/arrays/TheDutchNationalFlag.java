package com.epi.arrays;

import java.util.*;

public class TheDutchNationalFlag {

	public static enum Color {
		RED, WHITE, BLUE
	};

	public static void dutchFlagPartition(int pivotIndex, List<Color> A) {
		Color pivot = A.get(pivotIndex);
		// make values less than pivot appear first
		for (int i = 0; i < A.size(); ++i) {
			for (int j = i + 1; j < A.size(); ++j) {
				if (A.get(j).ordinal() < pivot.ordinal()) {
					Collections.swap(A, i, j);
					break;
				}
			}
		}

		// make values greater then pivot on the tail
		// if we find a value at A.get(x) that's less than
		// pivot we can stop the loop (all will be < pivot)
		for (int i = A.size() - 1; i >= 0 && A.get(i).ordinal() > pivot.ordinal(); --i) {
			for (int j = i - 1; j >= 0 && A.get(j).ordinal() > pivot.ordinal(); --j) {
				if (A.get(j).ordinal() > pivot.ordinal()) {
					Collections.swap(A, i, j);
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		List<Color> colors = new ArrayList<Color>();
		colors.add(Color.RED);
		colors.add(Color.WHITE);
		colors.add(Color.BLUE);
		colors.add(Color.RED);
		colors.add(Color.BLUE);
		colors.add(Color.WHITE);
		colors.add(Color.WHITE);
		dutchFlagPartition(3, colors); // [0,1,2,0,2,1,1]
		System.out.println(colors); // [0,1,2,0,1,2,1]
	}
}
