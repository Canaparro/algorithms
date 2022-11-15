package com.example.demo.general.book.graph;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ListOfDepthTest {

	@Test
	@DisplayName("Given a binary tree when getting depth nodes then should return correctly")
	void givenABinaryTree_whenGettingDepthNodesThen_shouldReturnCorrectly() {
		// Given
		ListOfDepth.Node node1 = new ListOfDepth.Node(1);
		ListOfDepth.Node node2 = new ListOfDepth.Node(2);
		ListOfDepth.Node node3 = new ListOfDepth.Node(3);
		ListOfDepth.Node node4 = new ListOfDepth.Node(4);
		ListOfDepth.Node node5 = new ListOfDepth.Node(5);
		ListOfDepth.Node node6 = new ListOfDepth.Node(6);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node4.left = node5;
		node4.right = node6;

		// When
		List<LinkedList<ListOfDepth.Node>> depths = ListOfDepth.getDepths( node1 );

		// Then
		assertThat(depths).hasSize( 4 );
		assertThat(depths.get( 0 )).contains( node1 );
		assertThat(depths.get( 1 )).contains( node2, node3 );
		assertThat(depths.get( 2 )).contains( node4 );
		assertThat(depths.get( 3 )).contains( node5, node6 );
	}
}