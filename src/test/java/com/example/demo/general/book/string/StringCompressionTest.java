package com.example.demo.general.book.string;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCompressionTest {

	@Test
	@DisplayName("Given a string when compressing should return compressed value")
	void givenAString_whenCompressing_shouldReturnCompressedValue() {
		// Given
		String s = "aabcccccaaa";
		// When
		String result = StringCompression.compress( s );
		// Then
		assertThat(result).isEqualTo( "a2b1c5a3" );
	}

	@Test
	@DisplayName("Given a string when compressed should return itself")
	void givenAString_whenCompressed_shouldReturnItself() {
		// Given
	    String s = "abcdefg";
		// When
		String result = StringCompression.compress( s );
		// Then
		assertThat(result).isEqualTo( s );
	}
}