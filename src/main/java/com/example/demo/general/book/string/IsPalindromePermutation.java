package com.example.demo.general.book.string;

import java.util.HashMap;

public class IsPalindromePermutation {

	public static boolean test(String string) {
		HashMap<Character, Integer> charMap = new HashMap<>();
		for ( final char c : string.toCharArray() ) {
			charMap.compute( c, (k, v) -> v == null ? 1 : v+1);
		}
		int oddCharacters = 0;

		for ( final Integer value : charMap.values() ) {
			if(value % 2 != 0) oddCharacters++;
		}

		return oddCharacters <= 1;
	}
}
