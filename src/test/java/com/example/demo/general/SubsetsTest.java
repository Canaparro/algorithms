package com.example.demo.general;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SubsetsTest {

	@Test
	@DisplayName("Given an array of integers when getting subset should return correctly")
	void givenAnArrayOfIntegers_whenGettingSubset_shouldReturnCorrectly() {
		// Given
		int[] array = { 1, 2, 3 };

		// When
		List<List<Integer>> result = Subsets.get( array );

		// Then
		assertThat( result ).containsExactlyInAnyOrder( List.of(), List.of( 1 ), List.of( 1, 2 ),
				List.of( 1, 3 ), List.of( 1, 2, 3 ), List.of( 2 ), List.of( 2, 3 ), List.of( 3 ) );
	}

}