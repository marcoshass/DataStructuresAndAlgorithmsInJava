package com.epi.trees;

public class BinaryTreeIsSymmetric {

	public static void main(String[] args) {
		System.out.printf("(symmetric)=%b", isSymmetric(buildSymTree()));
	}

	static BinaryTreeNode<Integer> buildSymTree() {
		BinaryTreeNode<Integer> a = new BinaryTreeNode<>(314);
		BinaryTreeNode<Integer> b = new BinaryTreeNode<>(6);
		BinaryTreeNode<Integer> e = new BinaryTreeNode<>(6);
		BinaryTreeNode<Integer> c = new BinaryTreeNode<>(2);
		BinaryTreeNode<Integer> f = new BinaryTreeNode<>(2);
		BinaryTreeNode<Integer> p = new BinaryTreeNode<>(3);
		BinaryTreeNode<Integer> g = new BinaryTreeNode<>(3);
		
		a.left = b;
		a.right = e;
		b.right = c;
		e.left = f;
		c.right = p;
		f.left = g;
		return a;
	}
	
	static boolean isSymmetric(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return true;
		}
		return checkTree(root.left, root.right);
	}
	
	static boolean checkTree(BinaryTreeNode<Integer> subtree0, BinaryTreeNode<Integer> subtree1) {
		if (subtree0 == null && subtree1 == null) {
			return true;
		} else if (subtree0 != null && subtree1 != null) {
			return subtree0.data == subtree1.data
					&& checkTree(subtree0.left, subtree1.right) 
					&& checkTree(subtree0.right, subtree1.left);
		}
		return false;
	}
}
