package com.example.demo.general;

public class IpsumLorenColumns {
	public static void main( String[] args ) {
		String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";


		breakIntoLines(text, 17);
	}

	private static void breakIntoLines( final String text, final int columns ) {
		StringBuffer buffer = new StringBuffer();

		int columnsCounter = 0;
		int nextIndexToAdd = 0;

		for(int i = 0; i < text.length(); i++) {
			char c = text.charAt( i );
			if(Character.isSpaceChar( c )) {
				//if word fits add it to buffer
				if(columnsCounter + (i - nextIndexToAdd) <= columns) {
					//add word
					buffer.append( text, nextIndexToAdd, i );
					//update nextIndexToAdd to last char before the space
					columnsCounter += i - nextIndexToAdd;
					nextIndexToAdd = i;

					// if word does not fit add new line char
				} else {
					buffer.append( "\n" );
					columnsCounter = 0;

					//add word ignoring space after previous word
					buffer.append( text, nextIndexToAdd + 1, i );
					//update nextIndexToAdd to last char before the space
					columnsCounter += i - nextIndexToAdd - 1;
					nextIndexToAdd = i;
				}
			}
		}

		System.out.println(buffer);
	}
}
