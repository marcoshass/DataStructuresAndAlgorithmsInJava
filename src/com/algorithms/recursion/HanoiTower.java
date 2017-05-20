package com.algorithms.recursion;

public class HanoiTower {

	public static void main(String[] args) {
		hanoi(4, 'A', 'B', 'C');
	}
	
	static void hanoi(int n, char from, char to, char aux) {
		if (n == 1) {
			System.out.println("Move disk from " + from + " to " + to);
		} else {
			hanoi(n - 1, from, aux, to);
			System.out.println("Move disk from " + from + " to " + to);
			hanoi(n - 1, aux, to, from);
		}
	}
	
}
