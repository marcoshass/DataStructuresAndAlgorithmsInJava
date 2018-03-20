package com.practice.leetcode;

import java.util.Hashtable;

public class LongestSubstring {

	public static void main(String[] args) {
		System.out.println("Length of the longest: " + lengthOfLongestSubstring("c"));
	}

	static int lengthOfLongestSubstring(String s) {
		String longest = "", acum = "";
		Hashtable<Character, Integer> letters = new Hashtable<>();

		for (int i = 0; i < s.length(); i++) {
			if (letters.containsKey(s.charAt(i)) || i == s.length() - 1) {
				longest = acum.length() > longest.length() ? acum : longest;
				acum = String.valueOf(s.charAt(i));
				letters.clear();
				letters.put(s.charAt(i), i);
			} else {
				letters.put(s.charAt(i), i);
				acum += s.charAt(i);
			}
		}
		return longest.length();
	}

}
