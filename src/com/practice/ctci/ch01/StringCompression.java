package com.practice.ctci.ch01;

public class StringCompression {

	public static void main(String[] args) {
		System.out.println(compress("aabcccccaaa"));
		System.out.println(compress("aabcccccaab"));
	}

	static String compress(String str) {
		/* check final length and return input string if it would be longer */
		int finalLength = countCompression(str);
		if (finalLength >= str.length())
			return str;

		/* initialize StringBuilder to its necessary capacity up-front */
		StringBuilder compressed = new StringBuilder(finalLength);
		int countConsecutive = 0;
		for (int i = 0; i < str.length(); i++) {
			countConsecutive++;
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressed.append(str.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return compressed.toString();
	}

	static int countCompression(String str) {
		int compressedLength = 0, countConsecutive = 0;
		for (int i = 0; i < str.length(); i++) {
			countConsecutive++;
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressedLength += 1 + String.valueOf(countConsecutive).length();
				countConsecutive = 0;
			}
		}
		return compressedLength;
	}

}
