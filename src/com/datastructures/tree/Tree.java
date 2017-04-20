package com.datastructures.tree;

/**
 * Binary tree representation. 
 */
public class Tree {
	
	/**
	 * The only data field in the tree.
	 */
	private Node root;
	
	/**
	 * Find the node with the key specified.
	 * 
	 * @return <tt>null</tt> if the node was not found 
	 */
	public Node find(int key) {
		Node current = root;
		
		while (current != null) {
			if (key == current.iData) {
				return current;
			} else if (key < current.iData) {
				current = current.leftChild;
			} else {
				current = current.rightChild;
			}
		}
		
		return null;
	}
	
	/**
	 * Insert the node with specific key and value parameters.
	 */
	public void insert(int key, float dd) {
		Node newNode = new Node(key, dd);
		
		if (root == null) {
			root = newNode;
		} else {
			Node current = root;
			while (current != null) {
				if (key < current.iData) {
					if (current.leftChild == null) {
						current.leftChild = newNode;
						break;
					} else {
						// down to left
						current = current.leftChild;
					}
				} else {
					if (current.rightChild == null) {
						current.rightChild = newNode;
						break;
					} else {
						// down to right
						current = current.rightChild;
					}
				}
			}
		}
		
	}
	
	public void delete(int id) {
		
	}
	
	/**
	 * Inorder traversal of the tree, in a binary search tree
	 * the values are processed in ascending order.
	 */
	public void inOrder(Node node) {
		if (node == null)
			return;
		
		inOrder(node.leftChild);
		node.displayNode();
		inOrder(node.rightChild);
	}

	//      > 50
	//       /  \
	//      30   60
	//     / \
	//    20  40 // 50 30 20 40 60
	//
	//                 50               50   
	//                /  \             /  \  
	//             > 30   60        > 30   60
	//              / \              / \
	//             20  40           20  40 
	//
	//                       50            50   
	//                      /  \          /  \  
	//                     30   60       30   60
	//                    / \           / \    
	//                 > 20  40        20  40 <               
	//

	/**
	 * Preorder traversal of the tree.
	 */
	public void preOrder(Node node) {
		if (node == null)
			return;
		
		node.displayNode();
		preOrder(node.leftChild);
		preOrder(node.rightChild);
	}
	
	public static void main(String[] args) {
		Tree theTree = new Tree();
		theTree.root = theTree.buildTree();
		theTree.preOrder(theTree.root);
//		theTree.insert(61, 0);
//		
//		Node nodeToFind = theTree.find(61);
//		if (nodeToFind != null)
//			System.out.println("Found node " + nodeToFind.iData);
//		else
//			System.out.println("Node not found");
	}
	
	private Node buildTree() {
		Node node50 = new Node(50);
		Node node30 = new Node(30);
		Node node60 = new Node(60);
		Node node20 = new Node(20);
		Node node40 = new Node(40);
		
		node50.leftChild = node30;
		node50.rightChild = node60;
		node30.leftChild = node20;
		node30.rightChild = node40;
		
		return node50;
	}
	
}
