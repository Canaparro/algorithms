package com.example.demo.datastructures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph<T> {

	private final Map<T, Node> nodeMap = new HashMap<>();

	class Node {
		private final T id;
		private final Set<Node> children = new HashSet<>();

		public Node( final T id ) {
			this.id = id;
		}
	}

	public void addNode( T id ) {
		if ( nodeMap.containsKey( id ) ) {
			throw new IllegalArgumentException( "Node already exists" );
		}
		nodeMap.put( id, new Node( id ) );
	}

	public void addEdge( T source, T destination ) {
		Node sourceNode = nodeMap.get( source );
		Node destinationNode = nodeMap.get( destination );
		sourceNode.children.add( destinationNode );
	}

	public boolean hasPathDepthFirstSearch( T source, T destination ) {
		Node sourceNode = nodeMap.get( source );
		return hasPathDepthFirstSearch( sourceNode, destination, new HashSet<>() );
	}

	public boolean hasPathDepthFirstSearch( Node node, T destination, Set<Node> visited ) {
		if ( visited.contains( node ) ) {
			return false;
		}
		visited.add( node );
		if ( node.id.equals( destination ) ) {
			return true;
		}
		for ( final Node child : node.children ) {
			boolean result = hasPathDepthFirstSearch( child, destination, visited );
			if ( result ) {
				return true;
			}
		}
		return false;
	}

	public boolean hasPathBreadthFirstSearch(T source, T destination) {
		Node node = nodeMap.get( source );
		return hasPathBreadthFirstSearch( Set.of(node), destination, new HashSet<>() );
	}

	public boolean hasPathBreadthFirstSearch( Set<Node> nodes, T destination, Set<Node> visited) {
		if(nodes.isEmpty()) {
			return false;
		}

		Set<Node> children = new HashSet<>();
		for ( final Node node : nodes ) {
			if(visited.contains( node )) {
				continue;
			}
			if(node.id.equals( destination )) {
				return true;
			}
			visited.add( node );
			children.addAll( node.children );
		}

		return hasPathBreadthFirstSearch( children, destination, visited );
	}
}
