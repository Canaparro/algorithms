package com.example.demo.general.book.string;

import java.util.HashMap;
import java.util.Map;

public class OneAway {

	public static boolean isOneAway(String s1, String s2) {
		int counter = 0;
		Map<Character, Integer> map = new HashMap<>();

		for ( final char c : s1.toCharArray() ) {
			map.compute( c, (k, v) -> v == null ? 1 : v+1);
		}

		for ( final char c : s2.toCharArray() ) {
			if(counter > 1) break;
			Integer characterCounter = map.get( c );
			if(characterCounter == null || characterCounter <= 0) {
				counter ++;
			} else {
				map.put( c, map.get( c ) - 1 );
			}
		}

		return counter <= 1;
	}
}
