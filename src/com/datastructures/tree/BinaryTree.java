package com.datastructures.tree;

import com.datastructures.list.*;

public class BinaryTree {
	
	BinaryTreeNode root;

	public static void main(String[] args) {
		BinaryTreeNode node10 = new BinaryTreeNode(10);
		BinaryTreeNode node12 = new BinaryTreeNode(12);
		BinaryTreeNode node15 = new BinaryTreeNode(15);
		BinaryTreeNode node25 = new BinaryTreeNode(25);
		BinaryTreeNode node30 = new BinaryTreeNode(30);
		BinaryTreeNode node36 = new BinaryTreeNode(36);

		node10.left = node12;
		node10.right = node15;
		node12.left = node25;
		node12.right = node30;
		node15.left = node36;
		
		BinaryTree tree = new BinaryTree(node10);
		DoublyLinkedList dll = new DoublyLinkedList();
		tree.toDoublyLinkedList(node10, dll);
		
		System.out.println(dll);
	}
	
	public BinaryTree(BinaryTreeNode root) {
		this.root = root;
	}
	
	public void preOrder(BinaryTreeNode root) {
		if (root != null) {
			System.out.print(root.getData() + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	public void inOrder(BinaryTreeNode root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.getData() + " ");
			inOrder(root.right);
		}		
	}
	
	public void toDoublyLinkedList(BinaryTreeNode root, DoublyLinkedList list) {
		if (root != null) {
			toDoublyLinkedList(root.left, list);
			list.insertTail(root.data); // insert always to the tail
			toDoublyLinkedList(root.right, list);
		}
	}
	
}
