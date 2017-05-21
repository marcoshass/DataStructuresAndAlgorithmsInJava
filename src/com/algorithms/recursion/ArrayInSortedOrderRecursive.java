package com.algorithms.recursion;

public class ArrayInSortedOrderRecursive {

	public static void main(String[] args) {
		int[] array = new int[] {5, 6, 7, 8, 9};
		System.out.println(isArrayInSortedOrder(array, 0));
	}

	static boolean isArrayInSortedOrder(int[] a, int index) {
		if (a == null)
			throw new IllegalArgumentException("Array cannot be null");
		if (index < 0)
			throw new IllegalArgumentException("Array index cannot be less than zero");
		if (index > a.length - 1)
			throw new IllegalArgumentException("Array subscript out of range");
		
		if (index == a.length - 1)
			return true;
		else {
			if (a[index] <= a[index + 1]) {
				return isArrayInSortedOrder(a, index + 1);
			} else {
				return false;
			}
		}
		
	}

}
