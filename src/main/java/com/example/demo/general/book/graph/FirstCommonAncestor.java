package com.example.demo.general.book.graph;

public class FirstCommonAncestor {

	public static <T> Node<T> find( Node<T> first, Node<T> second ) {

		//even height out
		if ( first.getHeight() > second.getHeight() ) {
			int heightDifference = first.getHeight() - second.getHeight();
			for ( int i = 0; i < heightDifference; i++ ) {
				first = first.parent;
			}
		} else {
			int heightDifference = second.getHeight() - first.getHeight();
			for ( int i = 0; i < heightDifference; i++ ) {
				second = second.parent;
			}
		}

		//get parents until they are the same
		Node<T> firstParent = first.parent;
		Node<T> secondParent = second.parent;
		while ( firstParent != secondParent ) {
			firstParent = firstParent.parent;
			secondParent = secondParent.parent;
		}

		return firstParent;
	}

	public static <T> Node<T> findNoParentLink( Node<T> node, Node<T> first, Node<T> second ) {

		if ( node == first || node == second ) {
			return node;
		}

		boolean firstIsOnLeft = covers( node.left, first );
		boolean secondIsOnLeft = covers( node.left, second );

		if(firstIsOnLeft != secondIsOnLeft) {
			return node;
		}

		Node<T> child = firstIsOnLeft ? node.left : node.right;

		return findNoParentLink( child, first, second );

	}

	private static <T> boolean covers( Node<T> node, Node<T> target ) {
		if ( node == null ) {
			return false;
		}
		if ( node == target ) {
			return true;
		}
		return covers( node.left, target ) || covers( node.right, target );
	}

	static class Node<T> {
		T value;
		private int height = 0;
		private Node<T> left;
		private Node<T> right;
		private Node<T> parent;

		public Node( final T value ) {
			this.value = value;
		}

		public int getHeight() {
			return height;
		}

		public void setLeft( final Node<T> node ) {
			node.height = this.height + 1;
			node.parent = this;
			this.left = node;
		}

		public void setRight( final Node<T> node ) {
			node.height = this.height + 1;
			node.parent = this;
			this.right = node;
		}
	}
}
