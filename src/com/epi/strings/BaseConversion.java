package com.epi.strings;

public class BaseConversion {

	public static void main(String[] args) {
		System.out.println(convertBase("615", 7, 13));
	}

	public static String convertBase(String numAsString, int sourceBase, int targetBase) {
		return decimalToTargetBase(toDecimal(numAsString, sourceBase), targetBase);
	}

	static int toDecimal(String numAsString, int sourceBase) {
		int result = 0, power = numAsString.length() - 1;
		for (int i = 0; i < numAsString.length(); i++, power--) {
			result += (numAsString.charAt(i) - '0') * Math.pow(sourceBase, power);
		}
		return result;
	}

	static String[] digitsOver10 = { "A", "B", "C", "D", "E", "F", "H" };

	static String decimalToTargetBase(int numAsDecimal, int targetBase) {
		StringBuilder sb = new StringBuilder("");
		while (numAsDecimal > 0) {
			int remainder = numAsDecimal % targetBase;
			sb.insert(0, remainder >= 10 ? digitsOver10[remainder - 10] : remainder);
			numAsDecimal /= targetBase;
		}
		return sb.toString();
	}
}
