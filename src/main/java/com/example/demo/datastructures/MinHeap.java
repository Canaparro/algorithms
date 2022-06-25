package com.example.demo.datastructures;

import java.util.Arrays;

public class MinHeap {

	private int[] heap = new int[0];

	public void addElement( int element ) {
		incrementSize();
		heap[heap.length - 1] = element;
		heapfyUp( heap.length - 1 );
	}

	public int removeElement() {
		int removedElement = heap[0];
		if ( heap.length == 1 ) {
			decrementSize();
		} else {
			swap( 0, heap.length - 1 );
			decrementSize();
			heapfyDown( 0 );
		}
		return removedElement;
	}

	private void heapfyDown( final int index ) {
		int leftChildrenIndex = getLeftChildrenIndex( index );
		if ( leftChildrenIndex < heap.length ) {
			int minIndex = leftChildrenIndex;
			int rightChildrenIndex = getRightChildrenIndex( index );
			if(rightChildrenIndex < heap.length) {
				int min = Math.min( heap[leftChildrenIndex], heap[rightChildrenIndex] );
				if(min == heap[rightChildrenIndex]) {
					minIndex = rightChildrenIndex;
				}
			}
			if(heap[minIndex] < heap[index]) {
				swap( minIndex, index );
			}
			heapfyDown( minIndex );
		}
	}

	private int getLeftChildrenIndex( int index ) {
		return ( index * 2 ) + 1;
	}

	private int getRightChildrenIndex( int index ) {
		return ( index * 2 ) + 2;
	}

	private void heapfyUp( int index ) {
		if ( index > 0 ) {
			int parentIndex = getParentIndex( index );
			if ( heap[index] < heap[parentIndex] ) {
				swap( index, parentIndex );
				heapfyUp( parentIndex );
			}
		}
	}

	private void swap( final int index, final int parentIndex ) {
		int temp = heap[index];
		heap[index] = heap[parentIndex];
		heap[parentIndex] = temp;
	}

	private int getParentIndex( int index ) {
		return ( index - 1 ) / 2;
	}

	private void incrementSize() {
		heap = Arrays.copyOf( heap, heap.length + 1 );
	}

	private void decrementSize() {
		heap = Arrays.copyOf( heap, heap.length - 1 );
	}

}
