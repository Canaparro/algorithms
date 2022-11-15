package com.example.demo.sorting;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QuickSortTest {

	@Test
	@DisplayName("Given an unordered array when sorting should return the sorted array")
	void givenAnUnorderedArray_whenSorting_shouldReturnTheSortedArray() {
		// Given
	    int[] array = {7, 2, 8, 4, 3, 6, 9};

		// When
		QuickSort.sort( array );

		// Then
		assertThat(array).isSorted();
	}

}