package com.example.demo.general.skytest;

public class SkyTest3 {

	public static void main( String[] args ) {
		System.out.println(new SkyTest3().solution( "pak", "cage", "package" ));
		System.out.println(new SkyTest3().solution( "car", "rib", "careib" ));
		System.out.println(new SkyTest3().solution( "car", "rib", "crarib" ));
	}

	public boolean solution(String S, String T, String U) {
		// write your code in Java SE 8

		if(S.length() + T.length() != U.length()) {
			return false;
		}

		int indexOfS = 0;
		int indexOfT = 0;

		for ( int i = 0; i < U.length(); i++ ) {

			char c = U.charAt( i );

			if(indexOfS < S.length() && c == S.charAt( indexOfS )) {
				indexOfS++;
			} else if(indexOfT < T.length() && c == T.charAt( indexOfT )) {
				indexOfT++;
			} else {
				return false;
			}

		}

		return true;

	}
}
