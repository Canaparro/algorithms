package com.example.demo.datastructures;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Tries {

	private static final String WHITE_SPACE = " ";
	private Node root = new Node();

	public void addWord( String word ) {
		if ( word == null || word.isBlank() ) {
			throw new IllegalArgumentException( "Cannot add empty String or null" );
		}

		word = word.trim();

		if ( word.contains( WHITE_SPACE ) ) {
			throw new IllegalArgumentException( "String must be a single word" );
		}
		root.addToChildren( word );
	}

	public String getAllWords() {
		if(root == null) return null;
		return root.getAllWords(new StringBuffer()).toString();
	}

	static class Node {

		private Character character;

		private boolean isCompleteWord;

		private final HashMap<Character, Node> children;

		public Node() {
			this.children = new HashMap<>();
		}

		public void addWord( String word ) {
			if ( word.length() == 0 ) {
				return;
			}
			this.character = word.charAt( 0 );

			String remainingWord = word.substring( 1 );

			if ( remainingWord.length() == 0 ) {
				isCompleteWord = true;
				return;
			}

			addToChildren( remainingWord );
		}

		public void addToChildren( final String word ) {
			char nextCharacter = word.charAt( 0 );
			children.computeIfAbsent( nextCharacter, k -> new Node() );
			children.get( nextCharacter ).addWord( word );
		}

		public StringBuffer getAllWords( StringBuffer stringBuffer ) {
			if(character != null) {
				stringBuffer.append( character );
			}

			if( children.isEmpty() ) {
				stringBuffer.append( "\n" );
				return stringBuffer;
			}

			List<StringBuffer> strings = new LinkedList<>();
			for ( final Node child : children.values() ) {
				StringBuffer newStringBuffer = new StringBuffer().append( stringBuffer );
				strings.add( child.getAllWords( newStringBuffer ) ) ;
			}
			StringBuffer buffer = new StringBuffer();

			if(isCompleteWord) {
				stringBuffer.append( "\n" );
				buffer.append( stringBuffer );
			}

			for ( final StringBuffer s : strings ) {
				buffer.append( s );
			}
			return buffer;
		}
	}

}
