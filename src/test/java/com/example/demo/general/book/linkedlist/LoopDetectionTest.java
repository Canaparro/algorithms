package com.example.demo.general.book.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.demo.datastructures.CustomLinkedList;

class LoopDetectionTest {

	@Test
	@DisplayName("Given a looped linked list when checking should return the looped node")
	void givenALoopedLinkedList_whenChecking_shouldReturnTheLoopedNode() {
		// Given
		CustomLinkedList<Integer> list = new CustomLinkedList<>( 1, 2, 3, 4, 5, 6 );

		CustomLinkedList.Node<Integer> current = list.getFirst();

		CustomLinkedList.Node<Integer> badNode = null;
		while ( current != null ) {
			if(current.getValue() == 3) {
				badNode = current;
			}
			if(current.getNext() == null) {
				current.setNext( badNode );
				break;
			}
			current = current.getNext();
		}

		// When
		CustomLinkedList.Node<Integer> node = LoopDetection.detectLoopSmart( list );

		// Then
		assertThat(node).isEqualTo( badNode );
	}

	@Test
	@DisplayName("Given a non looped linked list when checking should return null")
	void givenANonLoopedLinkedList_whenChecking_shouldReturnNull() {
		// Given
		CustomLinkedList<Integer> list = new CustomLinkedList<>( 1, 2, 3, 4, 5, 6 );

		// When
		CustomLinkedList.Node<Integer> node = LoopDetection.detectLoop( list );

		// Then
		assertThat(node).isNull();
	}

}