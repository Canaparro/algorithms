package com.example.demo.general.book.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ListOfDepth {

	public static List<LinkedList<Node>> getDepths(Node root) {
		List<LinkedList<Node>> result = new ArrayList<>();

		getDepthNodes( Set.of(root), result);

		return result;
	}

	private static void getDepthNodes( final Set<Node> nodes, final List<LinkedList<Node>> result ) {
		if( nodes.isEmpty() ) {
			return;
		}

		result.add( new LinkedList<>(nodes) );

		Set<Node> childrenNodes = new HashSet<>();

		for ( final Node node : nodes ) {
			if(node.left != null) {
				childrenNodes.add( node.left );
			}
			if(node.right != null) {
				childrenNodes.add( node.right );
			}
		}
		getDepthNodes( childrenNodes, result );
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
