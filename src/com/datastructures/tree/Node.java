package com.datastructures.tree;

/**
 * Binary tree node representation.
 */
class Node {
	
	/**
	 * Data used as key value.
	 */
	int iData;
	
	/**
	 * Other data.
	 */
	float fData;
	
	/**
	 * This node's left child;
	 */
	Node leftChild;
	
	/**
	 * This node's right child.
	 */
	Node rightChild;

	/**
	 * Constructs a node with the key specified.
	 */
	public Node(int iData) {
		this(iData, 0);
	}
	
	/**
	 * Constructs a node with the key and data parameters.
	 */
	public Node(int iData, float fData) {
		this.iData = iData;
		this.fData = fData;
	}

	/**
	 * Print a string representation of the node.
	 */
	public void displayNode() {
		
	}
	
}
