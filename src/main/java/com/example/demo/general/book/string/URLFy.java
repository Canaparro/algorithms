package com.example.demo.general.book.string;

public class URLFy {

	public static String urlfy(char[] string) {
		for ( int i = 0; i < string.length; i++ ) {
			if(string[i] == ' ') {
				replaceWithEncodedSpace(string, i);
			}
		}

		return String.valueOf( string );
	}

	private static void replaceWithEncodedSpace( final char[] string, int index ) {
		char[] toAdd = "%20".toCharArray();

		for ( int i = string.length - 3; i > index; i-- ) {
			string[i + 2] = string[i];
		}

		for ( int i = 0; i < toAdd.length; i++ ) {
			string[index] = toAdd[i];
			index++;
		}
	}
}
