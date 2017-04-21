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
	
	/**
	 * Find minimum node following the leftChild of the binary search tree.
	 */
	public Node minimum() {
		if (root == null) {
			return null;
		}

		Node current = root;
		while (current.leftChild != null) {
			current = current.leftChild;
		}
		return current;
	}
	
	/**
	 * Find the maximum node following the rightChild of the binary search tree.
	 */
	public Node maximum() {
		if (root == null) {
			return null;
		}
		
		Node current = root;
		while (current.rightChild != null) {
			current = current.rightChild;
		}
		return current;
	}
	
	//      > 50
	//       /  \
	//      30   60
	//     / \
	//    20  40
	//
	//                 50               50   
	//                /  \             /  \  
	//             l 30   60        > 30   60
	//              / \              / \
	//           c 20  40           20  40 
	//
	//                       50            50   
	//                      /  \          /  \  
	//                     30   60       30   60
	//                    / \           / \    
	//                 > 20  40        20  40 <               
	//

	/**
	 * Get information about the children of the specified node.
	 * 
	 * @return 0 node has no children
	 * 		   1 node has only the left child
	 * 		   2 node has only the right child
	 * 		   3 node has both children
	 */
	private int getChildrenInfo(Node node) {
		if (node == null) {
			throw new IllegalArgumentException("Node to get info cannot be null");
		} else if (node.leftChild == null & node.rightChild == null) {
			// has no children
			return 0;
		} else if (node.leftChild != null & node.rightChild == null) {
			// has only the left child
			return 1;
		} else if (node.rightChild != null & node.leftChild == null) {
			// has only the right child
			return 2;
		} else {
			// has both children
			return 3;
		}
	}
	
	/**
	 * Delete the node with the key specified from the binary search tree.
	 */
	public boolean delete(int key) {
		if (root == null) {
			// root is null, nothing to process
			return false;
		} else if (key == root.iData) {
			// delete root, remaining nodes will be garbage collected
			root = null;
			return true;
		} else {

			Node current = root;
			Node previous = current;

			// delete node other than root
			while (current != null) {
				if (key == current.iData) {
					if (previous.leftChild == current) {
						if (getChildrenInfo(current) == 1) {
							// current has only one left child, snap it to previous
							previous.leftChild = current.leftChild;
						} else if (getChildrenInfo(current) == 2) {
							// current has only one right child, snap it to previous
							previous.leftChild = current.rightChild;
						} else if (getChildrenInfo(current) == 0) {
							// current has no children
							previous.leftChild = null;
						} else {
							// current has both children
							throw new RuntimeException("Deletion of a node with both children not yet supported");
						}
					} else {
						if (getChildrenInfo(current) == 1) {
							// current has only one left child, snap it to previous
							previous.rightChild = current.leftChild;
						} else if (getChildrenInfo(current) == 2) {
							// current has only one right child, snap it to previous
							previous.rightChild = current.rightChild;
						} else if (getChildrenInfo(current) == 0) {
							// current has no children
							previous.rightChild = null;
						} else {
							// current has both children
							throw new RuntimeException("Deletion of a node with both children not yet supported");
						}
					}
					return true; // node was deleted
				} else if (key < current.iData) {
					// navigate to the left
					previous = current;
					current = current.leftChild;
				} else {
					// navigate to the right
					previous = current;
					current = current.rightChild;
				}
			}
			
		}

		return false;
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
	
	/**
	 * Postorder traversal of the tree.
	 */
	public void postOrder(Node node) {
		if (node == null)
			return;
		
		postOrder(node.leftChild);
		postOrder(node.rightChild);
		node.displayNode();
	}
	
	public static void main(String[] args) {
		Tree t = new Tree();
		t.root = t.buildTree();

		t.delete(30);
		
		Node node = t.find(20);
		if (node != null)
			System.out.println("Found node " + node.iData);
		else
			System.out.println("Node not found");
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
		//node30.rightChild = node40;
		
		return node50;
	}
	
}
