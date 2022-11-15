package com.example.demo.general.book.graph;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidateBinarySearchTreeTest {

	@Test
	@DisplayName("Should return false")
	void shouldReturnFalse() {
		// Given
		ValidateBinarySearchTree.Node node1 = new ValidateBinarySearchTree.Node(10);
		ValidateBinarySearchTree.Node node2 = new ValidateBinarySearchTree.Node(8);
		ValidateBinarySearchTree.Node node3 = new ValidateBinarySearchTree.Node(14);
		ValidateBinarySearchTree.Node node4 = new ValidateBinarySearchTree.Node(5);
		ValidateBinarySearchTree.Node node5 = new ValidateBinarySearchTree.Node(7);
		ValidateBinarySearchTree.Node node6 = new ValidateBinarySearchTree.Node(17);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node3.left = node5;
		node3.right = node6;
		
		// When
		boolean check = ValidateBinarySearchTree.check( node1 );
		// Then
		assertThat(check).isFalse();
	}

	@Test
	@DisplayName("Should return true")
	void shouldReturnTrue() {
		// Given
		ValidateBinarySearchTree.Node node1 = new ValidateBinarySearchTree.Node(10);
		ValidateBinarySearchTree.Node node2 = new ValidateBinarySearchTree.Node(8);
		ValidateBinarySearchTree.Node node3 = new ValidateBinarySearchTree.Node(14);
		ValidateBinarySearchTree.Node node4 = new ValidateBinarySearchTree.Node(5);
		ValidateBinarySearchTree.Node node5 = new ValidateBinarySearchTree.Node(13);
		ValidateBinarySearchTree.Node node6 = new ValidateBinarySearchTree.Node(17);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node3.left = node5;
		node3.right = node6;

		// When
		boolean check = ValidateBinarySearchTree.check( node1 );
		// Then
		assertThat(check).isTrue();
	}
}