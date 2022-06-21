package com.example.demo.sorting;

import java.util.Arrays;

public class MergeSort {

	public int[] mergeSort(int[] array) {
		if(array.length == 1) return array;

		int middle = array.length / 2;

		int[] firstHalf = mergeSort( Arrays.copyOfRange( array, 0, middle ) );
		int[] secondHalf = mergeSort( Arrays.copyOfRange( array, middle, array.length ) );

		return merge( firstHalf, secondHalf );
	}

	private int[] merge( final int[] firstHalf, final int[] secondHalf ) {
		int firstHalfIndex = 0;
		int secondHalfIndex = 0;
		int resultIndex = 0;

		int[] result = new int[firstHalf.length + secondHalf.length];

		while(firstHalfIndex < firstHalf.length && secondHalfIndex < secondHalf.length) {
			if( firstHalf[firstHalfIndex] < secondHalf[secondHalfIndex]) {
				result[resultIndex] = firstHalf[firstHalfIndex];
				firstHalfIndex++;
			} else {
				result[resultIndex] = secondHalf[secondHalfIndex];
				secondHalfIndex++;
			}
			resultIndex++;
		}
		while ( firstHalfIndex < firstHalf.length ) {
			result[resultIndex] = firstHalf[firstHalfIndex];
			firstHalfIndex++;
			resultIndex++;
		}

		while ( secondHalfIndex < secondHalf.length ) {
			result[resultIndex] = secondHalf[secondHalfIndex];
			secondHalfIndex++;
			resultIndex++;
		}
		return result;
	}

}
