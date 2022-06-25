package com.example.demo.general;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContinuousMedianTest {
	
	@Test
	@DisplayName("Given an array of integers and an even index when calculating the median should return correctly")
	void givenAnArrayOfIntegersAndAnEvenIndex_whenCalculatingTheMedian_shouldReturnCorrectly() {
		// Given
		int[] array = {7, 2, 8, 4, 3, 6, 9};
				
		// When
		double result = ContinuousMedian.get(array, 4);
				
		// Then
		assertThat(result).isEqualTo( 5.5 );
	}

	@Test
	@DisplayName("Given an array of integers and an odd index when calculating the median should return correctly")
	void givenAnArrayOfIntegersAndAnOddIndex_whenCalculatingTheMedian_shouldReturnCorrectly() {
		// Given
		int[] array = {7, 2, 8, 4, 3, 6, 9};

		// When
		double result = ContinuousMedian.get(array, 5);

		// Then
		assertThat(result).isEqualTo( 4 );
	}
}
