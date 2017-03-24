package com.algorithms.strings;

public class AnagramApp {

	public static void main(String[] args) {
		AnagramApp app = new AnagramApp();
		app.printAnagram("cats");
	}

// technique 01 (my own)
	
	public void printAnagram(String word) {
		char[] arr = word.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			printAnagram(getRemainingChars(arr, i), String.valueOf(arr[i]));
		}
	}

	private void printAnagram(char[] word, String acum) {
		// stop condition
		if (word.length == 1) {
			System.out.println(acum + word[0]);
			return;
		}
		
		for (int i = 0; i < word.length; i++) {
			printAnagram(getRemainingChars(word, i), acum + word[i]);
		}
	}

	char[] getRemainingChars(char[] array, int position) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			if (i != position)
				sb.append(array[i]);
		}
		return sb.toString().toCharArray();
	}

}
