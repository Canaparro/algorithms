package com.example.demo.general.book.linkedlist;

import com.example.demo.datastructures.CustomLinkedList;

public class RemoveMiddleishNode {

	public static void remove( CustomLinkedList.Node<Integer> nodeToRemove ) {
		CustomLinkedList.Node<Integer> next = nodeToRemove.getNext();
		nodeToRemove.setValue( next.getValue() );
		nodeToRemove.setNext( next.getNext() );
	}
}
