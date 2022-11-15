package com.example.demo.general.book.string;

import java.util.Arrays;

public class IsPermutation {

	public static boolean test(String string1, String string2) {
		char[] a = string1.toCharArray();
		Arrays.sort( a );
		char[] b = string2.toCharArray();
		Arrays.sort( b );

		return new String(a).equals(new String(b));
	}
}
