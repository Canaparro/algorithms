package com.example.demo.datastructures;

public class CheckBinarySearchTree {

	record Node(int value, Node leftChild, Node rightChild) {}

	public static boolean check( Node node ) {
		return check( node, Integer.MIN_VALUE, Integer.MAX_VALUE );
	}

	private static boolean check( final Node node, final int minValue, final int maxValue ) {
		if ( node == null ) {
			return true;
		}
		if ( node.value < minValue || node.value > maxValue ) {
			return false;
		}

		return check( node.leftChild, minValue, node.value - 1 ) &&
				check( node.rightChild, node.value + 1, maxValue );
	}
}
