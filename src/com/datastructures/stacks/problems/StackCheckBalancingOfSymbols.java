package com.datastructures.stacks.problems;

import java.util.Stack;

public class StackCheckBalancingOfSymbols {

	public static void main(String[] args) {
		String formula = "((A+B)+[C-D]}";
		System.out.println(isBalanced(formula));
	}

	// time complexity: O(n)
	// space complexity: O(n)
	static boolean isBalanced(String formula) {
		char[] chars = formula.toCharArray();
		Stack<Character> symbolsStack = new Stack<Character>();

		for (int i = 0; i < chars.length; i++) {
			if (isOpeningFormulaSymbol(chars[i])) {
				symbolsStack.push(chars[i]);
			} else if (isClosingFormulaSymbol(chars[i])) {
				// more closing symbols than opening symbols
				if (symbolsStack.empty()) {
					return false;
				}
				
				char openSymbol = symbolsStack.pop();
				if (!isMatch(openSymbol, chars[i])) {
					return false;
				}
			}
		}

		return symbolsStack.isEmpty();
	}

	static boolean isOpeningFormulaSymbol(char symbol) {
		switch (symbol) {
		case ('('):
			return true;
		case ('['):
			return true;
		case ('{'):
			return true;
		default:
			return false;
		}
	}

	static boolean isClosingFormulaSymbol(char symbol) {
		switch (symbol) {
		case (')'):
			return true;
		case (']'):
			return true;
		case ('}'):
			return true;
		default:
			return false;
		}
	}

	static boolean isMatch(char openSymbol, char closeSymbol) {
		boolean match = false;

		switch (openSymbol) {
		case ('('):
			match = closeSymbol == ')';
			break;
		case ('['):
			match = closeSymbol == ']';
			break;
		case ('{'):
			match = closeSymbol == '}';
			break;
		}

		return match;
	}

}
