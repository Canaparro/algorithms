package com.example.demo.sorting;

public class QuickSort {

	public static void sort( int[] array ) {
		sort( array, 0, array.length - 1 );
	}

	private static void sort( int[] array, int start, int end ) {
		if ( start < end ) {
			int pivotIndex = partition( array, start, end );
			sort( array, start, pivotIndex - 1 );
			sort( array, pivotIndex + 1, end );
		}
	}

	private static int partition( int[] array, int start, int end ) {

		int left = start;
		int right = end;

		while ( left != right ) {
			if ( array[right] > array[left] ) {
				right--;
			} else if ( array[left + 1] < array[left] ) {
				swapElements( array, left, left + 1 );
				left++;
			} else {
				swapElements( array, left + 1, right );
			}
		}

		return left;
	}

	private static void swapElements( int[] array, int first, int second ) {
		int temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}
}
