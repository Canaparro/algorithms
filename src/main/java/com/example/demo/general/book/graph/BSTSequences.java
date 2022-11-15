package com.example.demo.general.book.graph;

import java.util.ArrayList;
import java.util.List;

public class BSTSequences {

	public static void print(Node node) {

		List<List<Integer>> result = new ArrayList<>();

		result.add( getLeftFirst( node ) );

		result.add( getRightFirst( node ) );

		System.out.println(result);
	}

	private static List<Integer> getRightFirst( final Node node ) {
		List<Integer> array = new ArrayList<>();
		array.add( node.value );
		array.add( node.right.value );
		array.add( node.left.value );
		return array;
	}

	private static List<Integer> getLeftFirst( final Node node ) {
		List<Integer> array = new ArrayList<>();
		array.add( node.value );
		array.add( node.left.value );
		array.add( node.right.value );
		return array;
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
