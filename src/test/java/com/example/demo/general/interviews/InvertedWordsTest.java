package com.example.demo.general.interviews;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InvertedWordsTest {

	private final Solution solution = new Solution();

	@Test
	@DisplayName("some test")
	void someTest() {
		// Given
	    String phrase = "this potato is not raw";

		// When
		String result = solution.revertWords(phrase);

		// Then
		assertThat(result).isEqualTo( "raw not is potato this" );
	}

	@Test
	@DisplayName("with multiple spaces in the middle")
	void withMultipleSpacesInTheMiddle() {
		// Given
		String phrase = "this potato  is not raw";

		// When
		String result = solution.revertWords(phrase);

		// Then
		assertThat(result).isEqualTo( "raw not is potato this" );
	}

	@Test
	@DisplayName("with multiple spaces at end")
	void withMultipleSpacesAtEnd() {
		// Given
		String phrase = "this potato is not raw  ";

		// When
		String result = solution.revertWords(phrase);

		// Then
		assertThat(result).isEqualTo( "raw not is potato this" );
	}

	@Test
	@DisplayName("with multiple spaces at start")
	void withMultipleSpacesAtStart() {
		// Given
		String phrase = "   this potato is not raw";

		// When
		String result = solution.revertWords(phrase);

		// Then
		assertThat(result).isEqualTo( "raw not is potato this" );
	}

	@Test
	@DisplayName("empty string")
	void emptyString() {
		// Given
		String phrase = "    ";

		// When
		String result = solution.revertWords(phrase);

		// Then
		assertThat(result).isEqualTo( "" );
	}

	@Test
	@DisplayName("empty string 2")
	void emptyString2() {
		// Given
		String phrase = "";

		// When
		String result = solution.revertWords(phrase);

		// Then
		assertThat(result).isEqualTo( "" );
	}

	@Test
	@DisplayName("single word")
	void singleWord() {
		// Given
		String phrase = "  test  ";

		// When
		String result = solution.revertWords(phrase);

		// Then
		assertThat(result).isEqualTo( "test" );
	}

	class Solution {

		public String revertWords( final String phrase ) {
			StringBuilder stringBuilder = new StringBuilder();

			String phaseReplaced = phrase.stripLeading().stripTrailing();

			int lastAppend = phaseReplaced.length();

			for ( int i = phaseReplaced.length() - 1; i >= 0; i-- ) {
				if(Character.isSpaceChar( phaseReplaced.charAt( i ) ) ) {
					stringBuilder.append( phaseReplaced, i + 1, lastAppend );
					stringBuilder.append( " " );

					/// mover if spaces
					while(i >=0) {
						if(!Character.isSpaceChar( phaseReplaced.charAt( i - 1 ))) {
							break;
						}
						i--;
					}
					lastAppend = i;

				} else if( i == 0) {
					stringBuilder.append( phaseReplaced, i, lastAppend );
				}
			}

			return stringBuilder.toString();
		}
	}
}
