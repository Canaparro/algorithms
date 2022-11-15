package com.example.demo.general.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReformDateTest {

	private final Solution solution = new Solution();

	@Test
	@DisplayName("Given a date when converting should return corrrectly")
	void givenADate_whenConverting_shouldReturnCorrrectly() {
		// Given
		String date = "2th Oct 2052";

		// When
		String reformatedDate = solution.reformatDate( date );

		// Then
		assertThat( reformatedDate ).isEqualTo( "2052-10-02" );
	}

	static class Solution {

		public String reformatDate( String date ) {

			String day = null;
			String month = null;
			String year = null;

			int previousSpaceIndex = -1;

			for ( int i = 0; i < date.length(); i++ ) {

				char c = date.charAt( i );

				if ( Character.isSpaceChar( c ) ) {
					if ( day == null ) {
						day = String.format( "##", date.substring( 0, i - 2 ) );
					} else if ( month == null ) {
						month = Months.valueOf(
								date.substring( previousSpaceIndex + 1, i ).toUpperCase() ).number;
						year = date.substring( i + 1 );
					}
					previousSpaceIndex = i;
				}
			}

			return year + "-" + month + "-" + day;
		}

		enum Months {

			JAN( "01" ),
			FEB( "02" ),
			MAR( "03" ),
			APR( "04" ),
			MAY( "05" ),
			JUN( "06" ),
			JUL( "07" ),
			AUG( "08" ),
			SEP( "09" ),
			OCT( "10" ),
			NOV( "11" ),
			DEC( "12" );

			Months( final String number ) {
				this.number = number;
			}

			private String number;
		}
	}
}
