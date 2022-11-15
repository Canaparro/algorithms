package com.example.demo.general.book.string;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.demo.general.book.string.IsUnique;

class IsUniqueTest {

	@Test
	@DisplayName("Given a unique string when testing should return true")
	void givenAUniqueString_whenTesting_shouldReturnTrue() {
		// Given
	    String string = "Blue";

		// When
		boolean result = IsUnique.test( string );
		// Then
		assertThat(result).isTrue();

	}

	@Test
	@DisplayName("Given a non unique string when testing should return false")
	void givenANonUniqueString_whenTesting_shouldReturnFalse() {
		// Given
		String string = "Yellow";

		// When
		boolean result = IsUnique.test( string );
		// Then
		assertThat(result).isFalse();

	}
}