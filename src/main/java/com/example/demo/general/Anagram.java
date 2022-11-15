package com.example.demo.general;

public class Anagram {

	public static int howManyToRemoveForAnagram(String s1, String s2) {

		int[] count1 = getCharCount(s1);
		int[] count2 = getCharCount(s2);

		return delta(count1, count2);
	}

	private static int delta( final int[] count1, final int[] count2 ) {
		int count = 0;

		int maxlength = Math.max( count1.length, count2.length );

		for(int i = 0; i < maxlength; i++) {
			if(i >= count1.length) {
				count += count2[i];
			}
			if(i >= count2.length) {
				count += count1[i];
			}

			count += Math.abs( count1[i]  - count2[i]);
		}

		return count;
	}

	private static int[] getCharCount( final String s1 ) {
		int offset = 'a';
		int letterCount = 26;

		int[] array = new int[letterCount];

		for ( final char c : s1.toCharArray() ) {
			array[c - offset]++;
		}
		return array;
	}
}
