package com.example.demo.general.book.string;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.demo.general.book.string.IsPermutation;

class IsPermutationTest {

	@Test
	@DisplayName("Given two strings with same characters when testing should return true")
	void givenTwoStringsWithSameCharacters_whenTesting_shouldReturnTrue() {
		// Given
	    String string1 = "brak";
		String string2 = "bark";

		// When
		boolean result = IsPermutation.test( string1, string2 );
		// Then
		assertThat(result).isTrue();
	}

	@Test
	@DisplayName("Given two strings with different characters when testing should return false")
	void givenTwoStringsWithDifferentCharacters_whenTesting_shouldReturnFalse() {
		// Given
		String string1 = "brak";
		String string2 = "barka";

		// When
		boolean result = IsPermutation.test( string1, string2 );
		// Then
		assertThat(result).isFalse();
	}

}