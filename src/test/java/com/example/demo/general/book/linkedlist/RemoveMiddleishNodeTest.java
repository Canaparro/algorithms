package com.example.demo.general.book.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.demo.datastructures.CustomLinkedList;

class RemoveMiddleishNodeTest {

	@Test
	@DisplayName("Given a linked list when removing middleish element should remove it correctly")
	void givenALinkedList_whenRemovingMiddleishElement_shouldRemoveItCorrectly() {
		// Given
		CustomLinkedList<Integer> list = new CustomLinkedList<>( 1, 2, 3, 4, 5, 6, 7, 8 );
		CustomLinkedList.Node<Integer> node = list.getFirst().getNext().getNext().getNext();
		// When
		RemoveMiddleishNode.remove( node );

		// Then
		assertThat(list.toArray()).containsExactly( 1, 2, 3, 5, 6, 7, 8, null );

	}

}