package com.example.demo.general.book.string;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OneAwayTest {

	@Test
	@DisplayName("Given two strings one character away from each other when checking should return true")
	void givenTwoStringsOneCharacterAwayFromEachOther_whenChecking_shouldReturnTrue() {
		// Given
	    String s1 = "pale";
		String s2 = "ale";
		// When
		boolean result = OneAway.isOneAway( s1, s2 );

		// Then
		assertThat(result).isTrue();
	}

	@Test
	@DisplayName("Given two equal strings when checking should return true")
	void givenTwoEqualStrings_whenChecking_shouldReturnTrue() {
		// Given
		String s1 = "pale";
		String s2 = "pale";
		// When
		boolean result = OneAway.isOneAway( s1, s2 );

		// Then
		assertThat(result).isTrue();

	}
	
	@Test
	@DisplayName("Given two strings two character away from each other when checking should return false")
	void givenTwoStringsTwoCharacterAwayFromEachOther_whenChecking_shouldReturnFalse() {
		// Given
		String s1 = "pale";
		String s2 = "bake";
		// When
		boolean result = OneAway.isOneAway( s1, s2 );

		// Then
		assertThat(result).isFalse();
		
	}

}