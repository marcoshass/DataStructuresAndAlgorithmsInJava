package com.practice.epi.strings;

public class LookAndSay {

	public static void main(String[] args) {
		for (int i = 1; i <= 8; i++) {
			System.out.println(lookAndSay(i));
		}
	}

	public static String lookAndSay(int number) {
		String s = "1";
		for (int i = 1; i < number; ++i) {
			s = nextNumber(s);
		}
		return s;
	}

	private static String nextNumber(String param) {
		StringBuilder result = new StringBuilder();
		int count = 1;
		for (int i = 0; i < param.length(); i++) {
			// last character or the next one is different
			if (i == param.length() - 1 || param.charAt(i) != param.charAt(i + 1)) {
				result.append(String.valueOf(count) + param.charAt(i));
				count = 1;
			} else {
				count++;
			}
		}
		return result.toString();
	}

}
