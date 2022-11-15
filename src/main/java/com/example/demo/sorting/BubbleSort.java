package com.example.demo.sorting;

public class BubbleSort {

	public static void sort( int[] array ) {
		for ( int i = 0; i < array.length; i++ ) {
			for ( int j = i; j < array.length; j++ ) {
				if(array[i] > array[j]) {
					swap( array, i, j );
				}
			}
		}
	}

	public static void swap( int[] array, int index1, int index2 ) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}
