package com.example.demo.general.book.string;

public class IsUnique {

	private static int[] array = new int[Character.MAX_VALUE];

	public static boolean test( String string ) {
		for ( final char c : string.toCharArray() ) {
			int charValue = c;
			if ( array[charValue] == 1 ) {
				return false;
			} else {
				array[charValue] = 1;
			}
		}
		return true;
	}
}
