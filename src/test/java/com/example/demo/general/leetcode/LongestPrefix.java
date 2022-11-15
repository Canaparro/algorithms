package com.example.demo.general.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LongestPrefix {

	private Solution solution = new Solution();

	@Test
	@DisplayName("Some test")
	void someTest() {
		// Given
	    String[] strs = new String[]{"flower","flow","flight"};

		// When
		String result = solution.longestCommonPrefix( strs );

		// Then
		assertThat(result).isEqualTo( "fl" );
	}

	class Solution {
		public String longestCommonPrefix(String[] strs) {
			if(strs.length == 0) return "";

			String first = strs[0];
			StringBuilder builder = new StringBuilder();

			start: for ( int i = 0; i < first.length(); i++ ) {
				char c = first.charAt( i );
				for ( int j = 1; j < strs.length; j++ ) {
					if(i >= strs[j].length() || c != strs[j].charAt( i )) {
						break start;
					}
				}
				builder.append( c );


			}

			return builder.toString();
		}
	}
}
