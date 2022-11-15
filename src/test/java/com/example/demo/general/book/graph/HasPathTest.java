package com.example.demo.general.book.graph;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.demo.datastructures.Graph2;

class HasPathTest {

	// 1 > 2 > 3 > 4 > 7 > 2
	// 				 > 5 > 6 > 3
	@Test
	@DisplayName("Given a path exists when checking should return true")
	void givenAPathExists_whenChecking_shouldReturnTrue() {
		// Given
		Graph2<Integer> graph = new Graph2<>();
		graph.addNode( 1 );
		graph.addNode( 2 );
		graph.addNode( 3 );
		graph.addNode( 4 );
		graph.addNode( 5 );
		graph.addNode( 6 );
		graph.addNode( 7 );

		graph.addPath( 1, 2 );
		graph.addPath( 2, 3 );
		graph.addPath( 3, 4 );
		graph.addPath( 4, 7 );
		graph.addPath( 7, 2 );
		graph.addPath( 4, 5 );
		graph.addPath( 5, 6 );
		graph.addPath( 6, 3 );

		// When
		boolean check = HasPath.check( graph, 6, 1 );

		// Then
		assertThat(check).isTrue();
	}
}