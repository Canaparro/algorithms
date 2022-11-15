package com.example.demo.general.book.string;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IsPalindromePermutationTest {

	@Test
	@DisplayName("Given a string that is a palindrome permutation when testing should return true")
	void givenAStringThatIsAPalindromePermutation_whenTesting_shouldReturnTrue() {
		// Given
	    String string = "teten";
		// When
		boolean result = IsPalindromePermutation.test( string );
		// Then
		assertThat(result).isTrue();
	}

	@Test
	@DisplayName("Given a string that is not a palindrome permutation should return false")
	void givenAStringThatIsNotAPalindromePermutation_shouldReturnFalse() {
		// Given
		String string = "tetent";
		// When
		boolean result = IsPalindromePermutation.test( string );
		// Then
		assertThat(result).isFalse();

	}

}