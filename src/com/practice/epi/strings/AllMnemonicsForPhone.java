package com.practice.epi.strings;

import java.util.ArrayList;
import java.util.List;

public class AllMnemonicsForPhone {

	// The mapping from digit to corresponding characters
	private static final String[] MAPPING = { "0", "1", "ABC", "DEF", "ghi", "JKL", "MNO", "PQRS", "TUV", "WXYZ" };

	public static void main(String[] args) {
		List<String> mnemonics = phoneMnemonic("2276696");
		System.out.printf("combinations:%d %s", mnemonics.size(), mnemonics);
	}
	
	static List<String> phoneMnemonic(String phoneNumber) {
		List<String> mnemonics = new ArrayList<>();
		phoneMnemonicHelper("", phoneNumber, mnemonics);
		return mnemonics;
	}

	static void phoneMnemonicHelper(String prefix, String suffix, List<String> mnemonics) {
		if (suffix.equals("")) {
			mnemonics.add(prefix);
		} else {
			String digits = MAPPING[Integer.valueOf(suffix.substring(0, 1))];
			for (int i = 0; i < digits.length(); i++) {
				phoneMnemonicHelper(prefix + String.valueOf(digits.charAt(i)), suffix.substring(1), mnemonics);
			}
		}
	}

}
