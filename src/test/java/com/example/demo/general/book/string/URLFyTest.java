package com.example.demo.general.book.string;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class URLFyTest {

	@Test
	@DisplayName("Given an string with spaces when urlfy should return correctly")
	void givenAnStringWithSpaces_whenUrlfy_shouldReturnCorrectly() {
		// Given
	    char[] string = "Mr John Smith    ".toCharArray();

		// When
		String result = URLFy.urlfy( string );

		// Then
		assertThat(result).isEqualTo( "Mr%20John%20Smith" );
	}

}