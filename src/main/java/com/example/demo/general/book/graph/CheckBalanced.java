package com.example.demo.general.book.graph;

import java.util.HashSet;
import java.util.Set;

public class CheckBalanced {

	public static boolean check(Node node) {

		return checkNextLevel( Set.of(node));

	}

	private static boolean checkNextLevel( final Set<Node> nodes ) {
		if( nodes.isEmpty() ) {
			return true;
		}

		Set<Node> children = new HashSet<>();

		Boolean populationHasGrandchild = null;

		for ( final Node node : nodes ) {

			boolean leftCheck = checkForGrandChild( node.left, children);
			boolean rightCheck = checkForGrandChild( node.right, children);

			if(rightCheck != leftCheck) {
				return false;
			}

			if(populationHasGrandchild == null) {
				populationHasGrandchild = (rightCheck || leftCheck);
			} else if(populationHasGrandchild != rightCheck || populationHasGrandchild != leftCheck) {
				return false;
			}
		}

		return checkNextLevel( children );
	}

	private static boolean checkForGrandChild( final Node node, final Set<Node> children) {
		if( node != null) {
			children.add( node );
			return node.left != null || node.right != null;
		}
		return false;
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
