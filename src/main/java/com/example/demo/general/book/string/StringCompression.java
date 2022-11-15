package com.example.demo.general.book.string;

public class StringCompression {

	public static String compress(String string) {
		StringBuilder buffer = new StringBuilder();
		Character previousCharacter = null;
		int characterCount = 0;
		for ( final char c : string.toCharArray() ) {
			if(previousCharacter == null) {
				previousCharacter = c;
				characterCount ++;
			} else if(previousCharacter == c) {
				characterCount ++;
			} else {
				buffer.append( previousCharacter );
				buffer.append( characterCount );
				characterCount = 1;
				previousCharacter = c;
			}
		}
		buffer.append( previousCharacter );
		buffer.append( characterCount );
		if(buffer.length() >= string.length()) {
			return string;
		} else {
			return buffer.toString();
		}
	}
}
