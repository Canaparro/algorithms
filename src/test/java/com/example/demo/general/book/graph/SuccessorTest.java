package com.example.demo.general.book.graph;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SuccessorTest {

	@Test
	@DisplayName("Given a BST when getting next should return correct node")
	void givenABST_whenGettingNext_shouldReturnCorrectNode() {
		// Given
		Successor.Node node8 = new Successor.Node(8);
		Successor.Node node3 = new Successor.Node(3);
		Successor.Node node9 = new Successor.Node(9);
		Successor.Node node11 = new Successor.Node(11);
		Successor.Node node12 = new Successor.Node(12);
		Successor.Node node13 = new Successor.Node(13);
		Successor.Node node14 = new Successor.Node(14);
		Successor.Node node15 = new Successor.Node(15);
		Successor.Node node16 = new Successor.Node(16);

		node8.left = node3;
		node3.parent = node8;
		node8.right = node15;
		node15.parent = node8;

		node15.left = node13;
		node13.parent = node15;
		node15.right = node16;
		node16.parent = node15;

		node13.left = node11;
		node11.parent = node13;
		node13.right = node14;
		node14.parent = node13;

		node11.left = node9;
		node9.parent = node11;
		node11.right = node12;
		node12.parent = node11;
		
		// When
		Successor.Node result = Successor.getNext( node8 );

		// Then
		assertThat(result).isEqualTo( node9 );
	}

	@Test
	@DisplayName("Given a BST node without right children when getting nest should return correct parent")
	void givenABSTNodeWithoutRightChildren_whenGettingNest_shouldReturnCorrectParent() {
		// Given
		Successor.Node node8 = new Successor.Node(8);
		Successor.Node node3 = new Successor.Node(3);
		Successor.Node node9 = new Successor.Node(9);
		Successor.Node node11 = new Successor.Node(11);
		Successor.Node node12 = new Successor.Node(12);
		Successor.Node node13 = new Successor.Node(13);
		Successor.Node node14 = new Successor.Node(14);
		Successor.Node node15 = new Successor.Node(15);
		Successor.Node node16 = new Successor.Node(16);

		node8.left = node3;
		node3.parent = node8;
		node8.right = node15;
		node15.parent = node8;

		node15.left = node13;
		node13.parent = node15;
		node15.right = node16;
		node16.parent = node15;

		node13.left = node11;
		node11.parent = node13;
		node13.right = node14;
		node14.parent = node13;

		node11.left = node9;
		node9.parent = node11;
		node11.right = node12;
		node12.parent = node11;

		// When
		Successor.Node result = Successor.getNext( node14 );

		// Then
		assertThat(result).isEqualTo( node15 );
	}
}