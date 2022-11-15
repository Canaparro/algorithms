package com.example.demo.memoization;

import java.util.HashMap;
import java.util.Map;

public class CanSum {
	public static void main( String[] args ) {

		System.out.println( canSum( 7, new int[] { 2, 3 } ) );
		System.out.println( canSum( 7, new int[] { 5, 4, 2, 7 } ) );
		System.out.println( canSum( 7, new int[] { 2, 4 } ) );
		System.out.println( canSum( 8, new int[] { 2, 3, 5 } ) );
		System.out.println( canSum( 300, new int[] { 7, 14 } ) );
	}

	private static boolean canSum( final int i, final int[] array ) {
		return canSum( i, array, new HashMap<>() );
	}

	private static boolean canSum( final int i, final int[] array, Map<Integer, Boolean> memo ) {
		if ( memo.get( i ) != null ) {
			return memo.get( i );
		}
		if ( i == 0 ) {
			return true;
		}
		if ( i < 0 ) {
			return false;
		}

		for ( int number : array ) {
			if ( canSum( i - number, array, memo ) ) {
				memo.putIfAbsent( i, true );
				return true;
			}
		}
		memo.putIfAbsent( i, false );
		return false;
	}
}
