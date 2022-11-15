package com.example.demo.datastructures;

import java.util.Arrays;

public class MaxHeap {

	private static int[] heap = new int[0];

	public static void main( String[] args ) {

		addElement( 5 );
		addElement( 2 );
		addElement( 3 );
		addElement( 7 );
		addElement( 6 );
		addElement( 9 );

		System.out.println( removeBiggestElement() );
		System.out.println( removeBiggestElement() );
		System.out.println( removeBiggestElement() );
		System.out.println( removeBiggestElement() );
		System.out.println( removeBiggestElement() );
		System.out.println( removeBiggestElement() );

		// should throw
		System.out.println( removeBiggestElement() );

	}

	private static void addElement( int number ) {
		increaseCapacity();
		heap[heap.length - 1] = number;
		heapfyUp( heap.length - 1 );
	}

	private static void increaseCapacity() {
		heap = Arrays.copyOf( heap, heap.length + 1 );
	}

	private static void decreaseCapacity() {
		heap = Arrays.copyOf( heap, heap.length - 1 );
	}

	private static void heapfyUp( final int index ) {
		if(index == 0) {
			return;
		}
		int currentElement = heap[index];
		int parentElement = getParentElement( index );
		if ( currentElement > parentElement ) {
			swapElements( index, getParentElementIndex( index ) );
			heapfyUp( getParentElementIndex( index ) );
		}
	}

	private static void swapElements( final int firstIndex, final int secondIndex ) {
		int temp = heap[firstIndex];
		heap[firstIndex] = heap[secondIndex];
		heap[secondIndex] = temp;
	}

	private static Integer getParentElement( final int elementIndex) {

		return heap[ getParentElementIndex( elementIndex ) ];
	}

	private static int getChildLeftElementIndex( int parentIndex ) {
		return ( 2 * parentIndex ) + 1;
	}

	private static int getChildRightElementIndex( int parentIndex ) {
		return ( 2 * parentIndex ) + 2;
	}

	private static int getParentElementIndex( final int elementIndex ) {
		return ( elementIndex - 1 ) / 2;
	}

	private static int removeBiggestElement() {
		if ( heap.length == 0 ) {
			throw new IllegalStateException( "Heap has no elements!" );
		}
		int biggestElement = heap[ 0 ];

		swapElements( 0, heap.length - 1 );

		decreaseCapacity();

		heapfyDown( 0 );

		return biggestElement;
	}

	private static void heapfyDown( int index ) {
		while ( index < heap.length && getChildLeftElementIndex( index ) < heap.length ) {

			int leftChild = heap[ getChildLeftElementIndex( index ) ];

			int max = leftChild;

			if ( getChildRightElementIndex( index ) < heap.length ) {
				int rightChild = heap[ getChildRightElementIndex( index ) ];
				max = Math.max( leftChild, rightChild );
			}

			if ( max > heap[ index ] ) {
				if ( max == leftChild ) {
					swapElements( index, getChildLeftElementIndex( index ) );
				} else {
					swapElements( index, getChildRightElementIndex( index ) );
				}
				index++;
			} else {
				break;
			}
		}

	}
}
