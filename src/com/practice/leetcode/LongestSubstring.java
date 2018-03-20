package com.practice.leetcode;

import java.util.Hashtable;

public class LongestSubstring {

	public static void main(String[] args) {
		System.out.println("Length of the longest: " + lengthOfLongestSubstring("dvdf"));
	}

	static int lengthOfLongestSubstring(String s) {
		String longest = "", acum = "";
		Hashtable<Character, Integer> letters = new Hashtable<>();

		for (int i = 0; i < s.length(); i++) {
			if (!letters.containsKey(s.charAt(i))) {
				letters.put(s.charAt(i), i);
				acum += s.charAt(i);
				if (i == s.length() - 1) {
					longest = getMaxString(acum, longest);
				}

			} else {
				longest = getMaxString(acum, longest);
				acum = String.valueOf(s.charAt(i));
				letters.clear();
				letters.put(s.charAt(i), i);
			}
		}
		return longest.length();
	}

	static String getMaxString(String s1, String s2) {
		return s1.length() > s2.length() ? s1 : s2;
	}

}
