package com.example.demo.general.book.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.demo.datastructures.CustomLinkedList;

class KthToLastTest {

	@Test
	@DisplayName("Given a linked list and a position when finding should return correctly")
	void givenALinkedListAndAPosition_whenFinding_shouldReturnCorrectly() {
		// Given
		CustomLinkedList<Integer> list = new CustomLinkedList<>( 1, 2, 3, 5, 6,
				4, 9, 7 );
		// When
		Integer result = KthToLast.find( 3, list );

		// Then
		assertThat(result).isEqualTo( 4 );
	}

	@Test
	@DisplayName("Given a linked list and a position from last when finding without size info should return correctly")
	void givenALinkedListAndAPositionFromLast_whenFindingWithoutSizeInfo_shouldReturnCorrectly() {
		// Given
		CustomLinkedList<Integer> list = new CustomLinkedList<>( 1, 2, 3, 5, 6,
				4, 9, 7 );
		// When
		Integer result = KthToLast.findWithoutSize( 3, list );

		// Then
		assertThat(result).isEqualTo( 4 );

	}

}