package com.practice.epi.strings;

public class InterconvertStringInteger {

	public static void main(String[] args) {
		int x = 2048;
		String s = "2048";

		System.out.printf("original:%d, toString:\"%s\"", x, intToString(x));
		System.out.printf("\noriginal:\"%s\" toInt:%d", s, stringToInt(s));
	}
	
	public static String intToString(int x) {
		final boolean isNegative = x < 0;
		StringBuilder s = new StringBuilder(x == 0 ? "0" : "");
		while (x != 0) {
			s.append(Math.abs(x % 10));	
			x /= 10;
		}
		return s.append(isNegative ? "-" : "").reverse().toString();
	}
	
	public static int stringToInt(String s) {
		final boolean isNegative = s.startsWith("-");
		int result = 0;
		for (int i = isNegative ? 1 : 0; i < s.length(); i++) {
			result = (result * 10) + Integer.valueOf(s.substring(i,i+1));
		}
		return isNegative ? result * -1 : result;
	}

	// brute force:: multiply by powers of 10
	public static int stringToInt1(String s) {
		final boolean isNegative = s.startsWith("-");
		int result = 0;
		for (int exp = 0, i = s.toCharArray().length - 1; i >= (isNegative ? 1 : 0); i--, exp++) {
			result += Integer.valueOf(s.substring(i,i+1)) * Math.pow(10, exp);
		}
		return isNegative ? result * -1 : result;
	}
	
}
