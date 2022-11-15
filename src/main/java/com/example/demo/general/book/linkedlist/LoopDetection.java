package com.example.demo.general.book.linkedlist;

import java.util.HashSet;

import com.example.demo.datastructures.CustomLinkedList;

public class LoopDetection {

	public static <T> CustomLinkedList.Node<T> detectLoop(CustomLinkedList<T> list) {
		HashSet<CustomLinkedList.Node<T>> visitedNodes = new HashSet<>();

		CustomLinkedList.Node<T> current = list.getFirst();

		while ( current != null ) {
			if(visitedNodes.contains( current )) {
				return current;
			}
			visitedNodes.add( current );
			current = current.getNext();
		}

		return null;
	}

	public static <T> CustomLinkedList.Node<T> detectLoopSmart(CustomLinkedList<T> list) {

		CustomLinkedList.Node<T> fast = list.getFirst();
		CustomLinkedList.Node<T> slow = list.getFirst();

		while ( fast != null && fast.getNext() != null ) {

			slow = slow.getNext();
			fast = fast.getNext().getNext();

			if(slow == fast) {
				break;
			}
		}

		if(fast == null || fast.getNext() == null) {
			return null;
		}

		slow = list.getFirst();
		while ( fast != slow ) {
			fast = fast.getNext();
			slow = slow.getNext();
		}

		return fast;
	}
}
