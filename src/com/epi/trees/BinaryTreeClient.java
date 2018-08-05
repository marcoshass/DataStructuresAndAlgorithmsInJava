package com.epi.trees;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeClient {

	public static void main(String[] args) {
		Map<Character, BinaryTreeNode<Character>> nodes = new HashMap<>();
		List<Character> alphabet = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P');		
		alphabet.forEach(item -> nodes.put(item, new BinaryTreeNode<>(item)));

		nodes.get('A').left = nodes.get('B');		//				   A
		nodes.get('A').right = nodes.get('K');		//				/     \
													//			 B           K
		nodes.get('B').left = nodes.get('C');		//		   /   \        / \
		nodes.get('B').right = nodes.get('H');		//        C     H      L   O
													//		 / \   / \    / \
		nodes.get('C').left = nodes.get('D');		//      D   G I   J  M   N
		nodes.get('C').right = nodes.get('G');      //     / \
													//    E   F
		nodes.get('D').left = nodes.get('E');
		nodes.get('D').right = nodes.get('F');
		
		nodes.get('H').left = nodes.get('I');
		nodes.get('H').right = nodes.get('J');
		
		nodes.get('K').left = nodes.get('L');
		nodes.get('K').right = nodes.get('O');
		
		nodes.get('L').left = nodes.get('M');
		nodes.get('L').right = nodes.get('N');

		System.out.printf("(height)=%d", height(nodes.get('A'))-1);
		System.out.printf("\n(balanced)=%b", isBalanced(nodes.get('A')));
	}

	static boolean isBalanced(BinaryTreeNode<Character> root) {
		return Math.abs(height(root.left) - height(root.right)) <= 1;
	}
	
	static int height(BinaryTreeNode<Character> root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(height(root.left), height(root.right));
	}
}
