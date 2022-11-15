package com.example.demo.general.book.string;

public class StringRotation {

	public static boolean isRotation(String s1, String s2) {
		if(s1.length() != s2.length()) return false;

		char[] chars1 = s1.toCharArray();
		char[] chars2 = s2.toCharArray();

		Integer start = null;
		Integer end = null;
		int string2Index = 0;

		for ( int i = 0; i < chars1.length; i++ ) {
			if(chars1[i] == chars2[string2Index]) {
				if(start == null) {
					start = i;
				}
				end = i;
				string2Index++;
			}
		}

		if(start == null) {
			return false;
		}

		if(start == 0 && end == chars1.length) {
			return true;
		} else {
			return isSubstring( s1.substring( 0, start ), s2);
		}

	}

	private static boolean isSubstring(String s1, String s2) {
		return s2.contains( s1 );
	}
}
