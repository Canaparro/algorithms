package com.example.demo.general.book.string;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringRotationTest {

	@Test
	@DisplayName("Given a string is rotation of another when testing should return true")
	void givenAStringIsRotationOfAnother_whenTesting_shouldReturnTrue() {
		// Given
	    String s1 = "waterbottle";
		String s2 = "erbottlewat";
		// When
		boolean result = StringRotation.isRotation( s1, s2 );

		// Then
		assertThat(result).isTrue();
	}

	@Test
	@DisplayName("Given string is similar but not a rotation when testing should return false")
	void givenStringIsSimilarButNotARotation_whenTesting_shouldReturnFalse() {
		// Given
		String s1 = "waterbottle";
		String s2 = "erbottlevat";
		// When
		boolean result = StringRotation.isRotation( s1, s2 );

		// Then
		assertThat(result).isFalse();

	}

	@Test
	@DisplayName("Given string is not rotation of another when testing should return false")
	void givenStringIsNotRotationOfAnother_whenTesting_shouldReturnFalse() {
		// Given
		String s1 = "waterbottle";
		String s2 = "somepotetol";
		// When
		boolean result = StringRotation.isRotation( s1, s2 );

		// Then
		assertThat(result).isFalse();

	}

}