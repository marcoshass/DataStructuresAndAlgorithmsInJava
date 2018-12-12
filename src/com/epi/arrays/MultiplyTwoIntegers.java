package com.epi.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MultiplyTwoIntegers {

	public static void main(String[] args) {
		List<Integer> result = multiply(
				Arrays.asList(new Integer[] { 1, 2, 3 }),
				Arrays.asList(new Integer[] { 9, 8, 7 })
			);
		System.out.printf("%s\nsize=%d", result, result.size());
	}

	static List<Integer> multiply(List<Integer> num1, List<Integer> num2) {
		final int sign = num1.get(0) < 0 ^ num2.get(0) < 0 ? -1 : 1;
		List<Integer> result = new ArrayList<>(Collections.nCopies(num1.size() + num2.size(), 0)); // set all elements to zero
		for (int i = num1.size() - 1; i >= 0; --i) {
			for (int j = num2.size() - 1; j >= 0; --j) {
				// add the carry (in the current position) with the product of the
				// pointed digits and store the result in the right place
				result.set(i + j + 1, result.get(i + j + 1) + num1.get(i) * num2.get(j));
				
			}
		}
		

		return result;
	}
	
}
