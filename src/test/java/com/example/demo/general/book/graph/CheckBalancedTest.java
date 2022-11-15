package com.example.demo.general.book.graph;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CheckBalancedTest {

	@Test
	@DisplayName("Given balanced tree when checking should return true")
	void givenBalancedTree_whenChecking_shouldReturnTrue() {
		// Given
		CheckBalanced.Node node1 = new CheckBalanced.Node(1);
		CheckBalanced.Node node2 = new CheckBalanced.Node(2);
		CheckBalanced.Node node3 = new CheckBalanced.Node(3);
		CheckBalanced.Node node4 = new CheckBalanced.Node(4);
		CheckBalanced.Node node5 = new CheckBalanced.Node(5);
		CheckBalanced.Node node6 = new CheckBalanced.Node(6);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node3.left = node5;
		node3.right = node6;

		// When
		boolean check = CheckBalanced.check( node1 );

		// Then
		assertThat(check).isTrue();

	}

	@Test
	@DisplayName("Given non balanced tree when checking should return false")
	void givenNonBalancedTree_whenChecking_shouldReturnFalse() {
		// Given
		CheckBalanced.Node node1 = new CheckBalanced.Node(1);
		CheckBalanced.Node node2 = new CheckBalanced.Node(2);
		CheckBalanced.Node node3 = new CheckBalanced.Node(3);
		CheckBalanced.Node node4 = new CheckBalanced.Node(4);
		CheckBalanced.Node node5 = new CheckBalanced.Node(5);
		CheckBalanced.Node node6 = new CheckBalanced.Node(6);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node4.left = node5;
		node4.right = node6;

		// When
		boolean check = CheckBalanced.check( node1 );

		// Then
		assertThat(check).isFalse();
	}
}