package com.datastructures.tree;

public class Node {

	int iData; // data used as key value
	double fData; // other data
	Node leftChild; // this node's left child
	Node rightChild; // this node's right child
	
	public Node(int iData) {
		this.iData = iData;
	}

	public Node(int iData, double fData) {
		this.iData = iData;
		this.fData = fData;
	}
	
	public void displayNode() {
	}

}
