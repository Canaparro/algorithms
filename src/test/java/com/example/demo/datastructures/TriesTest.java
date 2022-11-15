package com.example.demo.datastructures;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TriesTest {

	private Tries tries;

	@BeforeEach
	void setUp() {
		tries = new Tries();
	}

	@Test
	@DisplayName("Given an empty tries when adding a null value should throw")
	void givenAnEmptyTries_whenAddingANullValue_shouldThrow() {
		// When
		ThrowableAssert.ThrowingCallable throwingCallable = () -> tries.addWord( null );
		// Then
		assertThatThrownBy( throwingCallable ).isInstanceOf( IllegalArgumentException.class )
				.hasMessage( "Cannot add empty String or null" );
	}

	@Test
	@DisplayName("Given an empty tries when adding a string with two words should throw")
	void givenAnEmptyTries_whenAddingAStringWithTwoWords_shouldThrow() {
		// When
		ThrowableAssert.ThrowingCallable throwingCallable = () -> tries.addWord( "first second" );
		// Then
		assertThatThrownBy( throwingCallable ).isInstanceOf( IllegalArgumentException.class )
				.hasMessage( "String must be a single word" );
	}


	@Test
	@DisplayName("Given an empty tries when adding words should add as expected")
	void givenAnEmptyTries_whenAddingWords_shouldAddAsExpected() {
		// Given
		tries.addWord( "car" );
		tries.addWord( "column" );
		tries.addWord( "bull" );
		tries.addWord( "bill" );
		tries.addWord( "couple" );
		tries.addWord( "cards" );
		// When
		String result = tries.getAllWords();
		// Then
		assertThat(result).contains( "car", "cards", "bull", "bill" );
	}
}