package com.datastructures.tree.problems;

import com.datastructures.tree.*;

public class MaximumElementInBinaryTree {

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(8);
		BinaryTreeNode node4 = new BinaryTreeNode(4);
		BinaryTreeNode node10 = new BinaryTreeNode(10);
		BinaryTreeNode node2 = new BinaryTreeNode(2);
		BinaryTreeNode node6 = new BinaryTreeNode(6);
		BinaryTreeNode node20 = new BinaryTreeNode(20);

		root.setLeft(node4);
		root.setRight(node10);
		node4.setLeft(node20);
		node4.setRight(node6);
		node10.setRight(node20);
		System.out.println(getMaxWithRecursion(root));
	}

	static int getMaxWithRecursion(BinaryTreeNode root) {
		if (root != null) {
			int maxLeft = getMaxWithRecursion(root.getLeft());
			int maxRight = getMaxWithRecursion(root.getRight());

			int value = maxLeft > maxRight ? maxLeft : maxRight;
			return root.getData() > value ? root.getData() : value;
		}
		return 0;
	}

}
