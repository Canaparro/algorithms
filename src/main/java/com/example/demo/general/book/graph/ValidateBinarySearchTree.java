package com.example.demo.general.book.graph;

public class ValidateBinarySearchTree {

	public static boolean check(Node node) {

		return isValidBST( node, Integer.MIN_VALUE, Integer.MAX_VALUE );
	}

	private static boolean isValidBST( final Node node, final int minValue, final int maxValue ) {
		if(node.value < minValue || node.value > maxValue) return false;

		boolean leftValid = true;
		boolean rightValid = true;
		if(node.left != null) {
			leftValid = isValidBST(node.left, minValue, node.value);
		}
		if(node.right != null) {
			rightValid = isValidBST(node.right, node.value, maxValue);
		}

		return leftValid && rightValid;
	}

	static class Node {
		int value;
		Node left;
		Node right;

		public Node( final int value ) {
			this.value = value;
		}
	}
}
