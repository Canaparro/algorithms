package com.example.demo.general.book.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RotateMatrixTest {

	@Test
	@DisplayName("test")
	void test() {
		// Given
		int[][] matrix = { { 1, 2, 3, 4 },
						   { 5, 6, 7, 8 },
						   { 9, 10, 11, 12 },
						   { 13, 14, 15, 16 } };
		// When
		RotateMatrix.rotatePixel( matrix );
		// Then
		assertThat( matrix ).isEqualTo( new int[][] { { 13, 9, 5, 1 },
													  { 14, 10, 6, 2 },
													  { 15, 11, 7, 3 },
													  { 16, 12, 8, 4 } } );
	}
}