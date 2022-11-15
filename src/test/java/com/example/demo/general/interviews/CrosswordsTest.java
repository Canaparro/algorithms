package com.example.demo.general.interviews;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CrosswordsTest {

	@Test
	@DisplayName("some test")
	void someTest() {
		// Given
		char[][] matrix = new char[][] { { 's', 'm', 't', 'i', 'x' },
										 { 'y', 'a', 'z', 'w', 'f' },
										 { 'l', 's', 'k', 'h', 'q' },
										 { 's', 'k', 'd', 'u', 'g' },
										 { 'k', 'y', 'f', 'p', 'f' }, };

		// When
		boolean result = new Solution().findWord( "sky", matrix );

		// Then
		assertThat( result ).isTrue();
	}

	@Test
	@DisplayName("some test")
	void someTest2() {
		// Given
		char[][] matrix = new char[][] { { 's', 'm', 't', 'i', 'x' },
										 { 'y', 'a', 'z', 'w', 'f' },
										 { 'l', 's', 'k', 'y', 'q' },
										 { 's', 't', 'd', 'u', 'g' },
										 { 'k', 'y', 'f', 'p', 'f' }, };

		// When
		boolean result = new Solution().findWord( "sky", matrix );

		// Then
		assertThat( result ).isTrue();
	}

	@Test
	@DisplayName("some test")
	void someTest3() {
		// Given
		char[][] matrix = new char[][] { { 's', 'm', 't', 'i', 'x' },
										 { 'y', 'a', 'z', 'w', 'f' },
										 { 'l', 's', 'k', 'h', 'q' },
										 { 's', 't', 'd', 'u', 'g' },
										 { 'k', 'y', 'f', 'p', 'f' }, };

		// When
		boolean result = new Solution().findWord( "sky", matrix );

		// Then
		assertThat( result ).isFalse();
	}

	class Solution {

		public boolean findWord( String word, char[][] matrix ) {
			boolean result = false;
			for ( int i = 0; i < matrix.length; i++ ) {
				for ( int j = 0; j < matrix[i].length; j++ ) {
					if ( findWordHorizontally( word, matrix, i, j ) ) {
						return true;
					}
					if ( findWordVertically( word, matrix, i, j ) ) {
						return true;
					}
				}
			}

			return result;
		}

		private boolean findWordVertically( final String word, final char[][] matrix, final int i,
				final int j ) {

			if ( i + word.length() > matrix.length ) {
				return false;
			}

			boolean result = true;
			for ( int k = 0; k < word.length(); k++ ) {
				if ( matrix[i + k][j] != word.charAt( k ) ) {
					result = false;
					break;
				}
			}
			return result;
		}

		private boolean findWordHorizontally( final String word, final char[][] matrix, final int i,
				final int j ) {

			if ( j + word.length() > matrix[i].length ) {
				return false;
			}

			boolean result = true;
			for ( int k = 0; k < word.length(); k++ ) {
				if ( matrix[i][j + k] != word.charAt( k ) ) {
					result = false;
					break;
				}
			}
			return result;
		}

	}
}
