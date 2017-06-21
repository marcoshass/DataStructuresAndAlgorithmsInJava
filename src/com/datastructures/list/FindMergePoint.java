package com.datastructures.list;

import java.util.*;

public class FindMergePoint {

	public static void main(String[] args) {
		ListNode node5 = new ListNode(5);
		ListNode node4 = new ListNode(4);
		ListNode node7 = new ListNode(7);
		ListNode node8 = new ListNode(8);
		
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		
		node5.setNext(node4);
		node4.setNext(node7);
		node7.setNext(node8);
		
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node7);
		
		ListNode mergeNode = findMergePointSort(node1, node5);
		System.out.println("Intersection node:" + mergeNode.getData());
	}
	
	// time complexity: O(m*n)
	// space complexity: O(1)
	static ListNode findMergePointBruteForce(ListNode head1, ListNode head2) {
		for (ListNode p = head1; p != null; p = p.getNext()) { // O(m)
			for (ListNode p1 = head2; p1 != null; p1 = p1.getNext()) { // O(n)
				if (p.getData() == p1.getData()) {
					return p;
				}
			}
		}
		
		return null;
	}
	
	// time complexity: O(m+n)
	// space complexity: O(n), n being the longest list
	static ListNode findMergePointHashTable(ListNode head1, ListNode head2) {
		Hashtable<Integer, ListNode> hash = new Hashtable();
		
		// O(m)
		for (ListNode p = head1; p != null; p = p.getNext()) {
			hash.put(p.getData(), p);
		}
		
		// O(n)
		for (ListNode p1 = head2; p1 != null; p1 = p1.getNext()) {
			if (hash.containsKey(p1.getData())) {
				return p1;
			}
		}
		
		return null;
	}
	
	// time complexity: O(m) + O(n)
	// space complexity: O(m) + O(n)
	static ListNode findMergePointStack(ListNode head1, ListNode head2) {
		java.util.Stack<ListNode> stack1 = new java.util.Stack();
		for (; head1 != null; head1 = head1.getNext()) { // O(m)
			stack1.push(head1);
		}
		
		java.util.Stack<ListNode> stack2 = new java.util.Stack();
		for (; head2 != null; head2 = head2.getNext()) { // O(n)
			stack2.push(head2);
		}
		
		ListNode tmp = null;
		while (!stack1.isEmpty() & !stack2.isEmpty()) { // O(m) or O(n) (which one is bigger)
			ListNode n1 = stack1.pop();
			ListNode n2 = stack2.pop();
			
			if (n1.getData() == n2.getData()) {
				tmp = n1;
			} else {
				break;
			}
		}
		
		return tmp;
	}
	
	// time complexity: O(m+n)
	// space complexity: O(m+n)
	static ListNode findMergePointArray(ListNode head1, ListNode head2) {
		int size = 100;
		
		ListNode[] array1 = new ListNode[size];
		for (int i = 0; head1 != null; head1 = head1.getNext()) {
			array1[i++] = head1;
		}
		
		ListNode[] array2 = new ListNode[size];
		for (int j = 0; head2 != null; head2 = head2.getNext()) {
			array2[j++] = head2;
		}
		
		ListNode tmp = null;
		int i = size - 1;
		int j = i;
		
		while (i >= 0 && j >= 0) {
			if (array1[i] == null || array2[j] == null) {
				if (array1[i] == null) {
					i--;
				}
				if (array2[j] == null) {
					j--;
				}
				continue;
			} else {
				if (array1[i].getData() == array2[j].getData()) {
					tmp = array1[i];
					i--;
					j--;
				} else {
					return tmp;
				}
			}
		}
		
		return null;
	}
	
	// time complexity: O(Max(nlogn, mlogm))
	// space complexity: O(Max(n,m))
	static ListNode findMergePointSort(ListNode head1, ListNode head2) {
		List<ListNode> list = new ArrayList<ListNode>();
		for (;head1 != null; head1 = head1.getNext()) { // O(n)
			list.add(head1);
		}

		// sort the elements fewer than O(n*logn)
		ListNode[] array1 = list.toArray(new ListNode[list.size()]);
		Arrays.sort(array1, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return Integer.valueOf(o1.getData()).compareTo(Integer.valueOf(o2.getData()));
			}
		});
		
		// iterate over the second list and binarysearch in the array O(n*logn)
		for (; head2 != null; head2 = head2.getNext()) {
			int retValue = Arrays.binarySearch(array1, head2, new Comparator<ListNode>(){
				@Override
				public int compare(ListNode o1, ListNode o2) {
					return Integer.valueOf(o1.getData()).compareTo(Integer.valueOf(o2.getData()));
				}
			});
			
			if (retValue >= 0) {
				return head2;
			}
		}
		
		return null;
	}

}
