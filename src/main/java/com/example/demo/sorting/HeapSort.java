package com.example.demo.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapSort {

	public static void main( String[] args ) {
		List<Integer> heap = new ArrayList<>();

		List<Integer> numbers = Arrays.asList( 4, 10, 3, 5, 1 );

		List<Integer> result = new ArrayList<>();

		for ( final Integer number : numbers ) {
			addToHeap( heap, number );
		}

		for ( int i = 0; i < numbers.size(); i++ ) {
			heapSwap( heap, 0, heap.size() - 1 );
			Integer removed = heap.remove( heap.size() - 1 );
			heapfyDown( heap );
			result.add( 0, removed );
		}
		System.out.println( result );

	}

	public static void addToHeap( List<Integer> heap, int number ) {
		heap.add( number );
		heapfyUp( heap );
	}

	public static Integer getParentNodeIndex( int index ) {
		return index / 2;
	}

	public static Integer getParentNode( List<Integer> heap, int index ) {
		return heap.get( getParentNodeIndex( index ) );
	}

	public static void heapfyUp( final List<Integer> heap ) {
		int index = heap.size() - 1;

		Integer elementToMove = heap.get( index );

		while ( index > 0 && getParentNode( heap, index ) < elementToMove ) {

			Integer parentNodeIndex = getParentNodeIndex( index );

			heapSwap( heap, parentNodeIndex, index );

			index = parentNodeIndex;
		}
	}

	public static void heapfyDown( final List<Integer> heap ) {
		int index = 0;

		while ( index < heap.size() - 1 && getChildLeftNode( heap, index ) != null ) {

			if ( getChildLeftNode( heap, index ) != null && getChildLeftNode( heap,
					index ) > heap.get( index ) ) {
				heapSwap( heap, getLeftChildIndex( index ), index );
				index = getLeftChildIndex( index );
			} else if ( getChildRightNode( heap, index ) != null && getChildRightNode( heap,
					index ) > heap.get( index ) ) {
				heapSwap( heap, getRightChildIndex( index ), index );
				index = getRightChildIndex( index );
			} else {
				break;
			}
		}

	}

	private static Integer getChildLeftNode( final List<Integer> heap, final int index ) {
		if ( getLeftChildIndex( index ) > heap.size() - 1 ) {
			return null;
		}
		return heap.get( getLeftChildIndex( index ) );
	}

	private static Integer getChildRightNode( final List<Integer> heap, final int index ) {
		if ( getRightChildIndex( index ) > heap.size() - 1 ) {
			return null;
		}
		return heap.get( getRightChildIndex( index ) );
	}

	private static int getLeftChildIndex( final int index ) {
		return ( index * 2 ) + 1;
	}

	private static int getRightChildIndex( final int index ) {
		return ( index * 2 ) + 2;
	}

	private static void heapSwap( final List<Integer> heap, final Integer firstIndex,
			final int secondIndex ) {
		int temp = heap.get( secondIndex );
		heap.set( secondIndex, heap.get( firstIndex ) );
		heap.set( firstIndex, temp );
	}
}
