package com.datastructures.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

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
		
		print(root);
	}

	static void print(BinaryTreeNode root) {
		if (root == null)
			throw new IllegalArgumentException("Root can't be null");

		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			BinaryTreeNode cur = queue.poll();
			System.out.print(cur.getData() + " ");
			if (cur.getLeft() != null)
				queue.offer(cur.left);
			if (cur.getRight() != null)
				queue.offer(cur.getRight());
		}
	}

}
