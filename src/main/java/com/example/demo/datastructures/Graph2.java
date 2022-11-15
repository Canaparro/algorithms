package com.example.demo.datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph2<T> {

	Map<T, Node<T>> nodes = new HashMap<>();

	public void addNode(T value) {
		if( nodes.containsKey(value) ) throw new IllegalArgumentException("Node already exists");
		nodes.put( value, new Node<>( value ) );
	}

	public void addPath(T source, T destination) {
		nodes.get( source ).addChild( nodes.get( destination ) );
	}

	public Node<T> getNode(T value) {
		return nodes.get( value );
	}

	public static class Node<T> {
		T value;
		List<Node<T>> children = new ArrayList<>();

		public Node( final T value ) {
			this.value = value;
		}

		public void addChild(Node<T> node) {
			children.add( node );
		}

		public T getValue() {
			return value;
		}

		public List<Node<T>> getChildren() {
			return children;
		}
	}

}
