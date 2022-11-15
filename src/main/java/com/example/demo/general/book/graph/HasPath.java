package com.example.demo.general.book.graph;

import java.util.HashSet;
import java.util.Set;

import com.example.demo.datastructures.Graph2;

public class HasPath {

	public static <T> boolean check( Graph2<T> graph, T source, T destination) {
		Set<T> visited = new HashSet<>();
		Graph2.Node<T> startNode = graph.getNode( source );
		return depthFirstSearch(visited, startNode, destination);
	}

	private static <T> boolean depthFirstSearch( final Set<T> visited,
			final Graph2.Node<T> currentNode, final T destination ) {
		if(currentNode.getValue() == destination) {
			return true;
		}
		visited.add( currentNode.getValue() );


		for ( final Graph2.Node<T> child : currentNode.getChildren() ) {
			if(!visited.contains( child.getValue() ) ) {
				boolean result = depthFirstSearch( visited, child, destination );
				if(result) {
					return true;
				}
			}
		}

		return false;
	}

}
