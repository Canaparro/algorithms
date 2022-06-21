package com.example.demo.datastructures;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class GraphTest {

	private Graph<Integer> graph;

	@BeforeEach
	void setUp() {
		graph = new Graph<>();
		graph.addNode( 1 );
		graph.addNode( 2 );
		graph.addNode( 3 );
		graph.addNode( 4 );
		graph.addNode( 5 );
		graph.addNode( 6 );

		graph.addEdge( 2, 1 );
		graph.addEdge( 2, 5 );
		graph.addEdge( 3, 1 );
		graph.addEdge( 3, 2 );
		graph.addEdge( 4, 2 );
		graph.addEdge( 5, 4 );
	}

	@Nested
	class HasPathDepthFirstSearchTests {

		@Test
		@DisplayName("Given a graph and a path connecting two nodes when searching should find a path")
		void givenAGraphAndAPathConnectingTwoNodes_whenSearching_shouldFindAPath() {
			// When
			boolean result = graph.hasPathDepthFirstSearch( 4, 1 );

			// Then
			assertThat(result).isTrue();
		}

		@Test
		@DisplayName("Given a graph and no path connecting two nodes when searching should return false")
		void givenAGraphAndNoPathConnectingTwoNodes_whenSearching_shouldReturnFalse() {
			// When
			boolean result = graph.hasPathDepthFirstSearch( 4, 3 );

			// Then
			assertThat(result).isFalse();
		}
	}

	@Nested
	class BreadthFirstSearchTests {
		@Test
		@DisplayName("Given a graph and a path connecting two nodes when searching should find a path")
		void givenAGraphAndAPathConnectingTwoNodes_whenSearching_shouldFindAPath() {
			// When
			boolean result = graph.hasPathBreadthFirstSearch( 4, 1 );

			// Then
			assertThat(result).isTrue();
		}

		@Test
		@DisplayName("Given a graph and no path connecting two nodes when searching should return false")
		void givenAGraphAndNoPathConnectingTwoNodes_whenSearching_shouldReturnFalse() {
			// When
			boolean result = graph.hasPathBreadthFirstSearch( 4, 3 );

			// Then
			assertThat(result).isFalse();
		}
	}
}