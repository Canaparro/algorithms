package com.example.demo.datastructures;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {

	private BinarySearchTree binarySearchTree;

	@BeforeEach
	public void setUp() {
		binarySearchTree = new BinarySearchTree();
	}


	@Test
	@DisplayName("Given an element exists in tree when doing contains should return true")
	void givenAnElementExistsInTree_whenDoingContains_shouldReturnTrue() {
		// Given
		binarySearchTree.add( 5 );
		binarySearchTree.add( 10 );
		binarySearchTree.add( 3 );

		// Then
		assertThat( binarySearchTree.contains( 3 )).isTrue();
	}

	@Test
	@DisplayName("Given an element dos not exist in tree when doing contains should return false")
	void givenAnElementDosNotExistInTree_whenDoingContains_shouldReturnFalse() {
		// Given
		binarySearchTree.add( 5 );
		binarySearchTree.add( 10 );
		binarySearchTree.add( 3 );

		// Then
		assertThat( binarySearchTree.contains( 17 )).isFalse();
	}

	@Test
	@DisplayName("Given an empty tree when doing contains should return false")
	void givenAnEmptyTree_whenDoingContains_shouldReturnFalse() {
		// Then
		assertThat( binarySearchTree.contains( 1 )).isFalse();
	}

	@Test
	@DisplayName("Given a populated tree when getting ordered should return all elements ordered")
	void givenAPopulatedTree_whenGettingOrdered_shouldReturnAllElementsOrdered() {
		// Given
		binarySearchTree.add( 5 );
		binarySearchTree.add( 10 );
		binarySearchTree.add( 3 );
		binarySearchTree.add( 15 );
		binarySearchTree.add( 7 );

		// When
		List<Integer> elements = binarySearchTree.getOrdered();

		// Then
		assertThat(elements).containsExactly( 3, 5, 7, 10, 15 );
	}

}