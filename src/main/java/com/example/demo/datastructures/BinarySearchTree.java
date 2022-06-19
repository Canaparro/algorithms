package com.example.demo.datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BinarySearchTree {

	private Node root;

	public void add( int value ) {
		Node node = new Node( value );
		if ( root == null ) {
			root = node;
		} else {
			root.add( node );
		}
	}

	public boolean contains( int value ) {
		if ( root == null ) {
			return false;
		}
		return root.contains( value );
	}

	public void printOrdered() {
		if(root != null) root.traverseOrdered(System.out::println);
	}

	public List<Integer> getOrdered() {
		ArrayList<Integer> list = new ArrayList<>();
		if(root != null)
			root.traverseOrdered( list::add );
		return list;
	}

	static class Node {

		private Node leftChild;
		private Node rightChild;

		private int value;

		public Node( final int value ) {
			this.value = value;
		}

		public Node getLeftChild() {
			return leftChild;
		}

		public void setLeftChild( final Node leftChild ) {
			this.leftChild = leftChild;
		}

		public Node getRightChild() {
			return rightChild;
		}

		public void setRightChild( final Node rightChild ) {
			this.rightChild = rightChild;
		}

		public int getValue() {
			return value;
		}

		public void setValue( final int value ) {
			this.value = value;
		}

		private void add( Node node ) {
			if ( node.getValue() > value ) {
				if ( rightChild == null ) {
					rightChild = node;
				} else {
					rightChild.add( node );
				}
			} else {
				if ( leftChild == null ) {
					leftChild = node;
				} else {
					leftChild.add( node );
				}
			}
		}

		private boolean contains( int value ) {
			if ( value == this.value ) {
				return true;
			} else if ( value < this.value ) {
				if ( leftChild == null ) {
					return false;
				}
				return leftChild.contains( value );
			} else {
				if ( rightChild == null ) {
					return false;
				}
				return rightChild.contains( value );
			}
		}

		private void traverseOrdered( Consumer<Integer> consumer) {
			if(leftChild != null) {
				leftChild.traverseOrdered(consumer);
			}
			consumer.accept( value );
			if(rightChild != null) {
				rightChild.traverseOrdered(consumer);
			}
		}
	}
}
