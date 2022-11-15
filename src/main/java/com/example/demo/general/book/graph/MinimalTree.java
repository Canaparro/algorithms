package com.example.demo.general.book.graph;

import java.util.Arrays;

public class MinimalTree {

	public static BinarySearchTree2 getTree( final int[] numbers ) {
		BinarySearchTree2 tree = new BinarySearchTree2();

		BinarySearchTree2.Node node = addMiddleElement( numbers, tree, 0, numbers.length - 1 );
		tree.root = node;

		return tree;
	}

	private static BinarySearchTree2.Node addMiddleElement( final int[] numbers, final BinarySearchTree2 tree,
			final int start, final int end ) {
		if(start > end) {
			return null;
		}

		int middleIndex = (end + start) / 2;
		BinarySearchTree2.Node node = new BinarySearchTree2.Node( numbers[middleIndex] );

		node.leftChild = addMiddleElement( numbers, tree, start, middleIndex - 1 );

		node.rightChild = addMiddleElement( numbers, tree, middleIndex + 1, end );

		return node;
	}

	static class BinarySearchTree2 {

		Node root = null;

		public void add(Integer value) {
			Node node = new Node( value );

			if(root == null) {
				root = node;
			} else {
				processPosition(root, node);
			}

		}

		private void processPosition( final Node currentNode, final Node newNode ) {
			if(newNode.value > currentNode.value) {
				if(currentNode.rightChild == null) {
					currentNode.rightChild = newNode;
				} else {
					processPosition( currentNode.rightChild, newNode );
				}
			} else {
				if(currentNode.leftChild == null) {
					currentNode.leftChild = newNode;
				} else {
					processPosition( currentNode.leftChild, newNode );
				}
			}
		}

		static class Node {
			int value;
			Node leftChild;
			Node rightChild;

			public Node( final Integer value ) {
				this.value = value;
			}
		}

	}

}
