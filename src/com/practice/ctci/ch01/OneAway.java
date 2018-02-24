package com.practice.ctci.ch01;

public class OneAway {

	public static void main(String[] args) {
		System.out.println(oneEditAway("pale", "ple"));
		System.out.println(oneEditAway("pales", "pale"));
		System.out.println(oneEditAway("pale", "bale"));
		System.out.println(oneEditAway("pale", "bae"));
	}
	
	static boolean oneEditAway(String first, String second) {
	    if (first.length() == second.length()) {
	        return oneEditReplace(first, second);
	    } else if (first.length()+1 == second.length()) { // aple   apple
	        return oneEditInsert(first, second);
	    } else if (first.length()-1 == second.length()) { // apple  aple
	        return oneEditInsert(second, first);
	    }
	    return false;
	}

	// both strings have the same length and are ordered
	static boolean oneEditReplace(String s1, String s2) {
	    boolean foundDifference = false;
	    for (int i = 0; i < s1.length(); i++) {
	        if (s1.charAt(i) != s2.charAt(i)) {
	            if (foundDifference) {
	                return false;
	            }
	            foundDifference = true;
	        }
	    }
	    return true;
	}

	// s1 is shorter than s2, aple and appla
	//	                      ^^^^     ^^!^! 
	static boolean oneEditInsert(String s1, String s2) {
	    int index1 = 0;
	    int index2 = 0;

	    while (index2 < s2.length() && index1 < s1.length()) {
	        if (s1.charAt(index1) != s2.charAt(index2)) {
	            if (index1 != index2) {
	                return false;
	            }
	            index2++;
	        } else {
	            index1++;
	            index2++;
	        }
	    }

	    return true;
	}

}
