package com.datastructures.tree;

public class TreeApp {

	//      10*
	//     /
	//    5
	//   / \
	//  3   7
	public static void main(String[] args) {
		Node root = new Node(10);
		Node node5 = new Node(5);
		Node node3 = new Node(3);
		Node node7 = new Node(7);

		root.leftChild = node5;
		node5.leftChild = node3;
		node5.rightChild = node7;
		
		Tree theTree = new Tree(root);

		theTree.delete(7);
		
		// inOrder traversal
		theTree.inOrder(root);
		
		// find minimum & maximum
		//System.out.println("Minimim value is:" + theTree.minimum().iData);
		//System.out.println("Minimim value is:" + theTree.maximum().iData);
	}

}
