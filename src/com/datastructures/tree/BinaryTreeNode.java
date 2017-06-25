package com.datastructures.tree;

public class BinaryTreeNode {

	BinaryTreeNode left;
	BinaryTreeNode right;
	int data;
	
	public BinaryTreeNode(int data) {
		this(data, null);
	}
	
	public BinaryTreeNode(int data, BinaryTreeNode left) {
		this(data, left, null);
	}
	
	public BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public void setLeft(BinaryTreeNode value) {
		this.left = value;
	}
	
	public BinaryTreeNode getLeft() {
		return this.left;
	}
	
	public void setRight(BinaryTreeNode value) {
		this.right = value;
	}
	
	public BinaryTreeNode getRight() {
		return this.right;
	}

	public void setData(int value) {
		this.data = value;
	}
	
	public int getData() {
		return this.data;
	}
	
}
