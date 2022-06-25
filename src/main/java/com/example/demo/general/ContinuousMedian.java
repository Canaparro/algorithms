package com.example.demo.general;

import com.example.demo.datastructures.MinHeap;

public class ContinuousMedian {

	public static double get( int[] array, int size ) {
		MinHeap heap = new MinHeap();

		for ( int i = 0; i < size; i++ ) {
			heap.addElement( array[i] );
		}

		int[] result = new int[size];

		for ( int i = 0; i < size; i++ ) {
			result[i] = heap.removeElement();
		}

		int middleIndex = result.length / 2;
		if ( size % 2 > 0 ) {
			return result[middleIndex];
		} else {
			return ( ( 1.0 ) * result[middleIndex - 1] + result[middleIndex] ) / 2;
		}
	}
}
