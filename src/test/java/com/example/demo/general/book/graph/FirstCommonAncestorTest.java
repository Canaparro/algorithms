package com.example.demo.general.book.graph;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FirstCommonAncestorTest {
	
	@Test
	@DisplayName("Given existing common parents when searching should return correct parent")
	void givenExistingCommonParents_whenSearching_shouldReturnCorrectParent() {
		// Given
		FirstCommonAncestor.Node<String> nodeA = new FirstCommonAncestor.Node<>( "A" );
		FirstCommonAncestor.Node<String> nodeB = new FirstCommonAncestor.Node<>( "B" );
		FirstCommonAncestor.Node<String> nodeC = new FirstCommonAncestor.Node<>( "C" );
		FirstCommonAncestor.Node<String> nodeD = new FirstCommonAncestor.Node<>( "D" );
		FirstCommonAncestor.Node<String> nodeE = new FirstCommonAncestor.Node<>( "E" );
		FirstCommonAncestor.Node<String> nodeX = new FirstCommonAncestor.Node<>( "X" );
		FirstCommonAncestor.Node<String> nodeH = new FirstCommonAncestor.Node<>( "H" );
		FirstCommonAncestor.Node<String> nodeF = new FirstCommonAncestor.Node<>( "F" );
		FirstCommonAncestor.Node<String> nodeG = new FirstCommonAncestor.Node<>( "G" );

		nodeA.setLeft( nodeB );
		nodeA.setRight( nodeC );

		nodeC.setLeft( nodeD );
		nodeC.setRight( nodeE );

		nodeD.setLeft( nodeX );

		nodeE.setLeft( nodeH );
		nodeE.setRight( nodeF );

		nodeF.setLeft( nodeG );

		// When
		FirstCommonAncestor.Node<String> result = FirstCommonAncestor.find( nodeX, nodeG );

		// Then
		assertThat(result).isEqualTo( nodeC );
	}

	@Test
	@DisplayName("Given no common ancestor exist when checking should return null")
	void givenNoCommonAncestorExist_whenChecking_shouldReturnNull() {
		// Given
		// Given
		FirstCommonAncestor.Node<String> nodeA = new FirstCommonAncestor.Node<>( "A" );
		FirstCommonAncestor.Node<String> nodeB = new FirstCommonAncestor.Node<>( "B" );

		nodeA.setLeft( nodeB );

		// When
		FirstCommonAncestor.Node<String> result = FirstCommonAncestor.find( nodeA, nodeB );

		// Then
		assertThat(result).isNull();

	}
}