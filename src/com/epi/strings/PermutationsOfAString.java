package com.epi.strings;

public class PermutationsOfAString {

	public static void main(String[] args) {
		permutate("abcd");
	}
	
	static void permutate(String str) {
		permutate("", str);
	}
	
	static void permutate(String prefix, String str) {
		if (str.length() == 0) {
			System.out.println(prefix);
		} else {
			for (int i = 0; i < str.length(); i++) {
				permutate(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1));
			}
		}
	}

}
