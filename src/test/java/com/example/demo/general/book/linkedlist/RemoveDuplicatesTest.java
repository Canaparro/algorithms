package com.example.demo.general.book.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.demo.datastructures.CustomLinkedList;

class RemoveDuplicatesTest {

	@Test
	@DisplayName("Given a linked list with duplicates when removing them should return a list with unique values")
	void givenALinkedListWithDuplicates_whenRemovingThem_shouldReturnAListWithUniqueValues() {
		// Given
		CustomLinkedList<Integer> list = new CustomLinkedList<>(1,1,4,5,3,6,5,7,5,8);
		// When
		RemoveDuplicates.remove( list );
		// Then
		assertThat(list.toArray()).containsExactly(1,4,5,3,6,7,8);
	}

	@Test
	@DisplayName("Given a linked list with duplicates when dumb removing them should return a list with unique values")
	void givenALinkedListWithDuplicates_whenDumbRemovingThem_shouldReturnAListWithUniqueValues() {
		// Given
		CustomLinkedList<Integer> list = new CustomLinkedList<>(1,1,4,5,3,6,5,7,5,8);
		// When
		RemoveDuplicates.dumbRemove( list );
		// Then
		assertThat(list.toArray()).containsExactly(1,4,5,3,6,7,8);

	}


}