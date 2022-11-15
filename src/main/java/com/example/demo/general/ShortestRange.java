package com.example.demo.general;

public class ShortestRange {
	public static void main( String[] args ) {
		int[] list1 = { 4, 10, 15, 24 };
		int[] list2 = { 0, 9, 12, 20 };
		int[] list3 = { 5, 18, 22, 30 };

		int lowerRange = Integer.MIN_VALUE;
		int highRange = Integer.MAX_VALUE;
		int currentRangeSize = Integer.MAX_VALUE;

		int pointer1 = 0;
		int pointer2 = 0;
		int pointer3 = 0;

		while ( pointer1 < list1.length && pointer2 < list2.length && pointer3 < list3.length ) {
			int value1 = list1[pointer1];
			int value2 = list2[pointer2];
			int value3 = list3[pointer3];

			int min = Math.min( Math.min( value1, value2 ), value3 );
			int max = Math.max( Math.max( value1, value2 ), value3 );

			int range = max - min;
			if ( range < currentRangeSize ) {
				lowerRange = min;
				highRange = max;
				currentRangeSize = range;
			}
			if ( min == value1 ) {
				pointer1++;
			}
			if ( min == value2 ) {
				pointer2++;
			}
			if ( min == value3 ) {
				pointer3++;
			}
		}

		System.out.println( "[" + lowerRange + "," + highRange + "]" );
	}
}
