package com.datastructures.list.problems;

import java.util.Hashtable;

import com.datastructures.list.ListNode;

public class LinkedListClone {

	public static void main(String[] args) {
		RandomListNode node1 = new RandomListNode(1);
		RandomListNode node2 = new RandomListNode(2);
		RandomListNode node3 = new RandomListNode(3);

		node1.setNext(node2);
		node2.setNext(node3);
		node1.setRandom(node3);

		ListNode ret = copyRandomList(node1);
		System.out.println(ret);
	}

	static ListNode copyRandomList(RandomListNode head) {
		Hashtable<RandomListNode, RandomListNode> hashTable = new Hashtable<>();
		RandomListNode current = head;
		RandomListNode clonedHead = null;

		// feed the hashtable
		while (current != null) {
			RandomListNode newNode = new RandomListNode(current.getData());
			if (clonedHead == null) {
				clonedHead = newNode;
			}
			hashTable.put(current, newNode);

			current = (RandomListNode) current.getNext();
		}

		// scan the linkedlist again and set the pointers
		current = head;
		while (current != null) {
			RandomListNode newNode = hashTable.get(current);
			
			if (current.getNext() != null) {
				newNode.setNext(hashTable.get((RandomListNode) current.getNext()));
			}
			
			if (current.getRandom() != null) {
				newNode.setRandom(hashTable.get((RandomListNode) current.getRandom()));
			}

			current = (RandomListNode) current.getNext();
		}

		return clonedHead;
	}

}

class RandomListNode extends ListNode {

	private ListNode random;

	public RandomListNode(int data) {
		this(data, null);
	}

	public RandomListNode(int data, ListNode randomNode) {
		super(data);
		this.random = randomNode;
	}

	public void setRandom(ListNode randomNode) {
		this.random = randomNode;
	}

	public ListNode getRandom() {
		return this.random;
	}

	@Override
	public boolean equals(Object o) {
		return super.equals(o);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

}