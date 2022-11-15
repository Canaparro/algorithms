package com.example.demo.general.book.linkedlist;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.example.demo.datastructures.CustomLinkedList;

public class RemoveDuplicates {

	public static void remove( CustomLinkedList<Integer> list ) {
		Set<Integer> uniques = new HashSet<>();

		CustomLinkedList.Node<Integer> currentNode = list.getFirst();
		CustomLinkedList.Node<Integer> previousNode = null;

		while ( currentNode.getNext() != null ) {
			Integer value = currentNode.getValue();
			if ( uniques.contains( value ) ) {
				list.removeNext( previousNode );
				currentNode = previousNode;
			} else {
				uniques.add( value );
			}
			previousNode = currentNode;
			currentNode = currentNode.getNext();
		}

	}

	public static void dumbRemove( CustomLinkedList<Integer> list ) {

		CustomLinkedList.Node<Integer> currentNode = list.getFirst();

		while ( currentNode != null ) {
			CustomLinkedList.Node<Integer> lookAhead = currentNode.getNext();
			CustomLinkedList.Node<Integer> previousFromLookAhead = currentNode;
			while ( lookAhead != null ) {
				if( Objects.equals( lookAhead.getValue(), currentNode.getValue() ) ) {
					list.removeNext( previousFromLookAhead );
					lookAhead = previousFromLookAhead.getNext();
				} else {
					previousFromLookAhead = lookAhead;
					lookAhead = lookAhead.getNext();
				}
			}
			currentNode = currentNode.getNext();
		}

	}
}
