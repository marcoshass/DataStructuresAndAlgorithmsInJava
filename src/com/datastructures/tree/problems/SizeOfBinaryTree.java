package com.datastructures.tree.problems;

import com.datastructures.tree.BinaryTreeNode;

public class SizeOfBinaryTree {

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(1);
		BinaryTreeNode node2 = new BinaryTreeNode(2);
		BinaryTreeNode node3 = new BinaryTreeNode(3);
		BinaryTreeNode node4 = new BinaryTreeNode(4);
		BinaryTreeNode node5 = new BinaryTreeNode(5);
		BinaryTreeNode node6 = new BinaryTreeNode(6);
		BinaryTreeNode node7 = new BinaryTreeNode(7);
		root.setLeft(node2);
		root.setRight(node3);
		node2.setLeft(node4);
		node2.setRight(node5);
		node3.setLeft(node6);
		node3.setRight(node7);

		System.out.println("size:" + recursive(root));
	}

	static int recursive(BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}
		return recursive(root.getLeft()) + recursive(root.getRight()) + 1;
	}

}
