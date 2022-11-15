package com.example.demo.general.skytest;

public class SkyTest2 {

	public static void main( String[] args ) {
		System.out.println(new SkyTest2().solution( "aabab" )); //3
		System.out.println(new SkyTest2().solution( "dog" )); //8
		System.out.println(new SkyTest2().solution( "aa" )); //0
		System.out.println(new SkyTest2().solution( "baaaa" )); //-1
		System.out.println(new SkyTest2().solution( "aba" )); //2
		System.out.println(new SkyTest2().solution( "a" )); //1
		System.out.println(new SkyTest2().solution( "b" )); //4
		System.out.println(new SkyTest2().solution( "aaa" )); // -1
		System.out.println(new SkyTest2().solution( "aaab" )); // -1
	}

	public int solution(String S) {
		// write your code in Java SE 8

		int repetitionCounter = 0;
		int possibleInsertions = 0;

		for ( int i = 0; i < S.length(); i++ ) {

			char c = S.charAt( i );

			// looking for insertions before character
			if(c != 'a') {
				if( i == 0) {
					//can insert two 'a' before first letter
					possibleInsertions += 2;
				} else {
					if( S.charAt( i - 1 ) != 'a' ) {
						possibleInsertions += 2;
					} else if( i == 1 || S.charAt( i - 2 ) != 'a' ) {
						possibleInsertions++;
					}
					// otherwise no insertions can be made
				}
				repetitionCounter = 0;
			} else {
				repetitionCounter++;
			}

			if(repetitionCounter == 3) {
				return -1;
			}
		}

		// looking for insertions after last character
		if(S.charAt( S.length() - 1 ) != 'a') {
			possibleInsertions += 2;
		} else if( S.length() - 2 > 0 && S.charAt( S.length() - 2 ) != 'a' ) {
			possibleInsertions++;
		}

		return possibleInsertions;

	}
}
