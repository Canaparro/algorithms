package com.example.demo.general.book.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.demo.datastructures.CustomLinkedList;

class PartitionTest {

	@Test
	@DisplayName("Given a partition element when paritioning should return correctly")
	void givenAPartitionElement_whenParitioning_shouldReturnCorrectly() {
		// Given
		CustomLinkedList<Integer> list = new CustomLinkedList<>( 3, 5, 8, 5, 10, 2, 1 );
		// When
		Partition.apply( 5 , list);
		// Then
		assertThat( list.toArray() ).containsExactly( 3, 1, 2, 10, 5, 5, 8 );
	}

}