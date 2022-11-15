package com.example.demo.general.book.graph;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MinimalTreeTest {

	@Test
	@DisplayName("Given an ordered array when creating tree shoudl return correct tree")
	void givenAnOrderedArray_whenCreatingTreeShoudlReturnCorrectTree() {
		// Given
	    int[] numbers = new int[]{1,3,4,5,7,8,9,10,12,15,17,18};

		// When
		MinimalTree.BinarySearchTree2 tree = MinimalTree.getTree(numbers);

		// Then
		System.out.println(tree);
	}

}