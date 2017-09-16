package com.datastructures.tree.problems;

import java.util.*;
import com.datastructures.tree.*;

public class InsertElementInABinaryTree {

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(1);
		BinaryTreeNode node2 = new BinaryTreeNode(2);
		BinaryTreeNode node3 = new BinaryTreeNode(3);
		BinaryTreeNode node4 = new BinaryTreeNode(4);
		BinaryTreeNode node5 = new BinaryTreeNode(5);

		root.setLeft(node2);
		root.setRight(node3);
		node2.setLeft(node4);
		node3.setLeft(node5);

		insertRec(root, 18);
		System.out.println(find(root, 18));
	}

	// iterative version (level order)
	static void insert(BinaryTreeNode root, int data) {
		if (root == null) {
			return;
		}

		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			BinaryTreeNode cur = queue.poll();
			if (cur.getLeft() == null) {
				cur.setLeft(new BinaryTreeNode(data));
				return;
			} else if (cur.getRight() == null) {
				cur.setRight(new BinaryTreeNode(data));
				return;
			} else {
				if (cur.getLeft() != null)
					queue.offer(cur.getLeft());
				if (cur.getRight() != null)
					queue.offer(cur.getRight());
			}
		}
	}

	// recursive version
	static void insertRec(BinaryTreeNode root, int data) {
		if (root == null) {
			root = new BinaryTreeNode(data);
			return;
		}

		if (root.getLeft() == null) {
			root.setLeft(new BinaryTreeNode(data));
			return;
		} else if (root.getRight() == null) {
			root.setRight(new BinaryTreeNode(data));
			return;
		} else {
			// trigger recursion
			if (root.getLeft() != null) {
				insertRec(root.getLeft(), data);
			} else if (root.getRight() != null) {
				insertRec(root.getRight(), data);
			}
		}
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

}
