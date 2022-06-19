package com.example.demo.search;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BinarySearchTest {

	@DisplayName("Given an ordered array when searching should return correct index")
	@ParameterizedTest
	@CsvSource({ "10, 6", "4, 3", "0, 0", "6, 4" })
	void givenAnOrderedArray_whenSearching_shouldReturnCorrectIndex( int target, int index ) {
		// Given
		int[] array = { 1, 2, 3, 5, 6, 7 };

		// When
		int searchResult = BinarySearch.search( array, target );

		// Then
		assertThat( searchResult ).isEqualTo( index );
	}

	@Test
	@DisplayName("Given an empty array when searching for an element should return first index")
	void givenAnEmptyArray_whenSearchingForAnElement_shouldReturnFirstIndex() {
		// Given
		int[] array = new int[0];

		// When
		int index = BinarySearch.search( array, 0 );

		// Then
		assertThat( index ).isZero();
	}
}