package com.example.demo.general.book.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ZeroMatrixTest {

	@Test
	@DisplayName("Given a matrix with zeroes when zeroing should change matrix accordingly")
	void givenAMatrixWithZeroes_whenZeroing_shouldChangeMatrixAccordingly() {
		// Given
		int[][] matrix = { { 1, 2, 3, 4 },
						   { 0, 6, 0, 8 },
						   { 9, 10, 11, 12 },
						   { 13, 14, 15, 0 } };

		// When
		ZeroMatrix.apply( matrix );

		// Then
		assertThat(matrix).isEqualTo( new int[][]{ { 0, 2, 0, 0 },
												   { 0, 0, 0, 0 },
												   { 0, 10, 0, 0 },
												   { 0, 0, 0, 0 } } );
	}

}