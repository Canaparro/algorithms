package com.example.demo.search;

public class BinarySearch {

	private BinarySearch(){}

	public static int search( int[] array, int value ) {

		if(array.length == 0) {
			return 0;
		}

		int start = 0;
		int end = array.length - 1;

		while ( start <= end ) {
			int pivot = start + ( ( end - start ) / 2 );
			if ( array[pivot] == value ) {
				return pivot;
			}
			if ( array[pivot] > value ) {
				end = pivot - 1;
			} else {
				start = pivot + 1;
			}
		}
		return start;
	}

}
