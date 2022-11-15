package com.example.demo.general.book.linkedlist;

import com.example.demo.datastructures.CustomLinkedList;

public class Partition {
	public static void apply( final int partition, final CustomLinkedList<Integer> list ) {
		CustomLinkedList.Node<Integer> current = list.getFirst();

		CustomLinkedList.Node<Integer> lastSmaller = null;

		CustomLinkedList.Node<Integer> previous = null;

		while ( current != null ) {

			if ( current.getValue() < partition ) {

				if ( lastSmaller == null ) {
					//move as new head
					if ( previous != null ) {
						CustomLinkedList.Node<Integer> head = list.getFirst();
						previous.setNext( current.getNext() );
						current.setNext( head );
						list.setHead( current );
					} else {
						previous = current;
					}
				} else {
					//move in front of last smaller
					previous.setNext( current.getNext() );
					current.setNext( lastSmaller.getNext() );
					lastSmaller.setNext( current );
				}
				lastSmaller = current;
				current = previous;
			}
			previous = current;
			current = previous.getNext();

		}

	}
}
