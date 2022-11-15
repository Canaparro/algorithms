package com.example.demo.general.book.graph;

public class Successor {

	public static Node getNext( Node node ) {
		if(node == null) {
			return null;
		}
		if(node.right != null) {
			return getNextInternal( node.right );
		} else {
			// go up until parent > target Node
			int targetValue = node.value;
			Node current = node.parent;
			while (current != null && current.value < targetValue) {
				current = current.parent;
			}
			return current;
		}
	}

	private static Node getNextInternal( Node node ) {
		Node result = node;
		if ( node.left != null ) {
			result = getNextInternal( node.left );
		}
		return result;
	}

	static class Node {
		int value;
		Node left;
		Node right;
		Node parent;

		public Node( final int value ) {
			this.value = value;
		}
	}
}
