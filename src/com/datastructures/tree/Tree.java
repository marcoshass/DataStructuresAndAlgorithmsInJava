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
		Node current = root;
		Node nodeToInsert = new Node(key, dd);
		
		while (current != null) {
			if (key < current.iData) {
				if (current.leftChild == null) {
					current.leftChild = nodeToInsert;
					break;
				} else {
					current = current.leftChild;
				}
			} else {
				if (current.rightChild == null) {
					current.rightChild = nodeToInsert;
					break;
				} else {
					current = current.rightChild;
				}
			}
		}
		
	}
	
	public void delete(int id) {
		
	}

	public static void main(String[] args) {
		Tree theTree = new Tree();
		theTree.root = theTree.buildTree();
		
		theTree.insert(61, 0);
		
		Node nodeToFind = theTree.find(61);
		if (nodeToFind != null)
			System.out.println("Found node " + nodeToFind.iData);
		else
			System.out.println("Node not found");
	}
	
	private Node buildTree() {
		Node node63 = new Node(63);
		Node node27 = new Node(27);
		Node node80 = new Node(80);
		Node node13 = new Node(13);
		Node node51 = new Node(51);
		Node node70 = new Node(70);
		Node node92 = new Node(92);
		Node node26 = new Node(26);
		Node node33 = new Node(33);
		Node node58 = new Node(58);
		Node node82 = new Node(82);
		Node node57 = new Node(57);
		Node node60 = new Node(60);
		
		node63.leftChild = node27;
		node63.rightChild = node80;
		node27.leftChild = node13;
		node27.rightChild = node51;
		node80.leftChild = node70;
		node80.rightChild = node92;
		node13.rightChild = node26;
		node51.leftChild = node33;
		node51.rightChild = node58;
		node92.leftChild = node82;
		node58.leftChild = node57;
		node58.rightChild = node60;
		
		return node63;
	}
	
}
