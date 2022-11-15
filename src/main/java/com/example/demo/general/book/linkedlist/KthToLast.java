package com.example.demo.general.book.linkedlist;

import com.example.demo.datastructures.CustomLinkedList;

public class KthToLast {

	public static <T> T find( int kthFromLast, CustomLinkedList<T> list ) {
		int elementPosition = list.getSize() - kthFromLast;
		int counter = 0;

		CustomLinkedList.Node<T> current = list.getFirst();
		while ( counter < elementPosition ) {
			if ( current == null ) {
				return null;
			}
			current = current.getNext();
			counter++;
		}
		return current.getValue();
	}

	public static <T> T findWithoutSize( int kthFromLast, CustomLinkedList<T> list ) {

		CustomLinkedList.Node<T> current = list.getFirst();
		CustomLinkedList.Node<T> kthFromCurrent = getKthFromNode( kthFromLast, current );

		while (kthFromCurrent.getNext() != null) {
			current = current.getNext();
			kthFromCurrent = kthFromCurrent.getNext();
		}

		return current.getValue();

	}

	private static <T> CustomLinkedList.Node<T> getKthFromNode( final int kthFromNode,
			final CustomLinkedList.Node<T> node ) {
		CustomLinkedList.Node<T> current = node;
		for ( int i = 0; i < kthFromNode - 1; i++ ) {
			current = current.getNext();
		}
		return current;
	}
}
