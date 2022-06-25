package com.example.demo.datastructures;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MinHeapTest {

	private MinHeap heap;

	@BeforeEach
	void setUp() {
		heap = new MinHeap();
	}

	@Test
	@DisplayName("Given an minHeap with existing integers when removing them should return in natural order")
	void givenAnMinHeapWithExistingIntegers_whenRemovingThem_shouldReturnInNaturalOrder() {
		// Given
		int[] array = { 7, 2, 8, 4, 3, 6, 9 };
		for ( final int i : array ) {
			heap.addElement( i );
		}
		// When
		List<Integer> result = new LinkedList<>();
		for ( int i = 0; i < array.length; i++ ) {
			result.add( heap.removeElement() );
		}
		// Then
		assertThat( result ).hasSize( array.length ).isSorted();
	}
}