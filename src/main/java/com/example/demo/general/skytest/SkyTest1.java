package com.example.demo.general.skytest;

import java.util.Objects;

public class SkyTest1 {

	public static void main( String[] args ) {
		new SkyTest1().solution( null );
	}

	public int solution(String G) {
		// write your code in Java SE 8

		if(G == null) {
			return 0;
		}

		int rockPoints = 0;
		int paperPoints = 0;
		int scissorsPoints = 0;

		for ( final char c : G.toCharArray() ) {
			rockPoints += getPoints( 'R', c );
			paperPoints += getPoints( 'P', c );
			scissorsPoints += getPoints( 'S', c );
		}

		return Math.max( scissorsPoints, Math.max( rockPoints, paperPoints ));
		
	}
	
	private int getPoints(char s1, char s2) {
		
		if(s1 == s2) {
			return 1;
		} else if( ((s1 == 'P' ) && ( s2 == 'R' )) ||
				(( s1 == 'R' ) && ( s2 == 'S' )) ||
				(( s1 == 'S' ) && ( s2 == 'P' ))) {
			return 2;
		} else {
			return 0;
		}
		
	}
}
