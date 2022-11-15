package com.example.demo.ctw;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

class Result {

	public static void main( String[] args ) {
//		System.out.println(getAnagrams( "Code? aaagmnrs, doce and anagrams" ));
//		System.out.println(getAnagrams( "Sample text without any anagrams" ));
//		System.out.println(getAnagrams( "Words are a sword in our era" ));
		StringBuffer buffer = new StringBuffer();
		for ( int i = 0; i < 10_000; i++ ) {
			buffer.append( "some word emos Word " );
		}

		long start = System.currentTimeMillis();
		System.out.println(getAnagrams( buffer.toString() ));
		System.out.println(System.currentTimeMillis() - start);
	}

	/*
	 * Complete the 'getAnagrams' function below.
	 *
	 * The function is expected to return a STRING_ARRAY.
	 * The function accepts STRING text as parameter.
	 */

	public static List<String> getAnagrams(String text) {

		List<String> words = extractWords( text );

		Set<String> results = new TreeSet<>();

		for ( final String word : words ) {
			for ( final String wordToCompare : words ) {
				if(word.equalsIgnoreCase( wordToCompare )) {
					continue;
				}
				if(isAnnagram(word, wordToCompare)) {
					results.add( wordToCompare );
					results.add( word );
				}
			}
		}
		
		return results.stream()
				.sorted( Comparator.comparing( String::length )
						.thenComparing( String::compareTo ).reversed() )
				.collect( Collectors.toList() );

	}

	private static boolean isAnnagram( final String word, final String wordToCompare ) {
		Map<Character, Long> letterCountMap = new HashMap<>();

		if(word.length() != wordToCompare.length()) {
			return false;
		}

		for ( final char c : word.toLowerCase().toCharArray() ) {
			if( letterCountMap.containsKey(c) ) {
				Long currentCounter = letterCountMap.get( c );
				letterCountMap.put( c, currentCounter + 1 );
			} else {
				letterCountMap.put( c, 1L );
			}
		}

		for ( final char c : wordToCompare.toLowerCase().toCharArray() ) {
			Long currentCounter = letterCountMap.getOrDefault( c, 0L );
			if(currentCounter == 0) {
				return false;
			} else {
				letterCountMap.put( c, currentCounter - 1 );
			}
		}

		return true;
	}

	private static List<String> extractWords( final String text ) {
		List<String> words = new ArrayList<>();

		StringBuilder buffer = new StringBuilder();

		for ( int i = 0; i < text.length(); i++ ) {
			char c = text.charAt( i );
			if(Character.isAlphabetic( c )) {
				buffer.append( c );
			} else if(!buffer.isEmpty()) {
				words.add( buffer.toString() );
				buffer = new StringBuilder();
			}
		}

		if( !buffer.isEmpty() ) {
			words.add( buffer.toString() );
		}

		return words;
	}

}