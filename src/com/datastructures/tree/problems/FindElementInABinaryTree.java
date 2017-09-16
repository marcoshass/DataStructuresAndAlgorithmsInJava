package com.datastructures.tree.problems;

import java.util.LinkedList;
import java.util.Queue;

import com.datastructures.tree.*;

public class FindElementInABinaryTree {

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

		System.out.println(findNonRecursive(root, 7));
	}

	static boolean find(BinaryTreeNode root, int data) {
		if (root != null) {
			if (root.getData() == data) {
				return true;
			}
			return find(root.getLeft(), data) | find(root.getRight(), data);
		}

		return false;
	}

	static boolean findNonRecursive(BinaryTreeNode root, int data) {
		if (root == null)
			return false;

		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			BinaryTreeNode cur = queue.poll();
			if (cur.getData() == data) {
				return true;
			}
			if (cur.getLeft() != null) {
				queue.offer(cur.getLeft());
			}
			if (cur.getRight() != null) {
				queue.offer(cur.getRight());
			}
		}

		return false;
	}

}
