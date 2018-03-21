package com.practice.leetcode;

import java.util.*;

public class LongestSubstring {

	public static void main(String[] args) {
		System.out.println("Length of the longest: " + lengthOfLongestSubstring("abcabb"));
	}

	static int lengthOfLongestSubstring(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int ans = 0, i = 0, j = 0;
		while (i < n && j < n) {
			// try to extend the range [i, j]
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				ans = Math.max(ans, j - i);
			} else {
				set.remove(s.charAt(i++));
			}
		}
		return ans;
	}

}
