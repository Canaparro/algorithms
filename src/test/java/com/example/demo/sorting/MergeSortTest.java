package com.example.demo.sorting;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MergeSortTest {

	private MergeSort mergeSort = new MergeSort();

	@Test
	@DisplayName("Given an unordered array when sorting should return the sorted array")
	void givenAnUnorderedArray_whenSorting_shouldReturnTheSortedArray() {
		// Given
	    int[] array = {5, 3, 4, 1, 2};

		// When
		int[] result = mergeSort.mergeSort( array );
		// Then
		assertThat(result).isSorted().contains( array );
	}
}