package com.datastructures.tree;

public class Tree {

	private Node root; // the only data field in Tree

	public Tree(Node root) {
		this.root = root;
	}

	// O(logN)
	public Node find(int key) {
		Node current = root;

		while (current != null) {
			if (key == current.iData)
				return current;
			else if (key < current.iData)
				current = current.leftChild;
			else
				current = current.rightChild;
		}

		return null;
	}

	public void insert(int id, double dd) {
		Node newNode = new Node(id, dd);
		Node current = root;

		// newNode on empty tree
		if (current == null) {
			root = newNode;
			return;
		}

		while (true) { // exits internally
			if (current.iData == newNode.iData)
				throw new IllegalArgumentException("Binary tree doesn't support duplicated key:" + id);

			// leftChild
			if (newNode.iData < current.iData) {
				if (current.leftChild == null) {
					current.leftChild = newNode;
					break;
				} else {
					current = current.leftChild; // move left
				}
			} else { // rightChild
				if (current.rightChild == null) {
					current.rightChild = newNode;
					break;
				} else {
					current = current.rightChild; // move right
				}
			}
		}
		
	}

	public void delete(int key) {
		Node current = root;

		if (current == null)
			throw new IllegalArgumentException("Root node cannot be null");
		else if (key == current.iData) { // root node delete
			root = null;
			return;
		}
		
		// search the node
		while (current != null) {
			if (key < current.iData) {
				// leftChild
				if (key == current.leftChild.iData) {
					current.leftChild = null;
					break;
				} else {
					current = current.leftChild;
				}
			} else {
				// rightChild
				if (key == current.rightChild.iData) {
					current.rightChild = null;
					break;
				} else { 
					current = current.rightChild;
				}
			}
		}
		
	}
	
	
	//      9*                             9*
	//    /   \                          /   \
	//   8     11                       8     11
	//  / \   / \                      / \   / \
	// 7  20 5   13                   7  20 5   13
	//			   \                 /           \ 
	//              9               9             9            
	//            /   \           /   \         /   \
	//           8*    11        8*    11      8     11*
	//          / \   / \       / \   / \     / \   / \
	//         7  20 5   13    7  20 5   13  7  20 5   13
	//                    \               \
	//               	   9               9             
	//             	     /   \           /   \   
	//            		8     11        8     11  
	//           	   / \   / \       / \    / \ 
	//          	  7* 20 5   13    7  20* 5   13
	//               / \                 / \
	//            null null          null   null
	//
	public void inOrder(Node localRoot) {
		if (localRoot != null) {
			inOrder(localRoot.leftChild);
			System.out.println(localRoot.iData);
			inOrder(localRoot.rightChild);
		}
	}

	public Node minimum() {
		Node current = root;
		
		if (current == null)
			throw new IllegalArgumentException("Root not cannot be null");
		
		while (current.leftChild != null) {
			current = current.leftChild;
		}
		
		return current;
	}
	
	public Node maximum() {
		Node current = root;
		
		if (current == null)
			throw new IllegalArgumentException("Root not cannot be null");
		
		while (current.rightChild != null) {
			current = current.rightChild;
		}
		
		return current;
	}

	
}
