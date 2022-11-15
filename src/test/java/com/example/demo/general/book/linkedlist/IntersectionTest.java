package com.example.demo.general.book.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.demo.datastructures.CustomLinkedList;

class IntersectionTest {

	@Test
	@DisplayName("Given linked two intersected linked lists when checking should return true")
	void givenLinkedTwoIntersectedLinkedLists_whenChecking_shouldReturnTrue() {
		// Given
		CustomLinkedList<Integer> list1 = new CustomLinkedList<>( 1, 2, 3, 4, 5, 6, 7 );
		CustomLinkedList<Integer> list2 = new CustomLinkedList<>( 8, 9, 10 );


		CustomLinkedList.Node<Integer> currentList1 = list1.getFirst();
		CustomLinkedList.Node<Integer> currentList2 = list2.getFirst();

		for ( int i = 0; i < 3; i++ ) {
			currentList1 = currentList1.getNext();
		}
		currentList2.setNext( currentList1 );

		// When
		CustomLinkedList.Node<Integer> node = Intersection.isIntersectedSmart( list1, list2 );

		// Then
		assertThat(node).isEqualTo( currentList1 );
	}

	@Test
	@DisplayName("Given linked two non intersected linked lists when checking should return false")
	void givenLinkedTwoNonIntersectedLinkedLists_whenChecking_shouldReturnFalse() {
		// Given
		CustomLinkedList<Integer> list1 = new CustomLinkedList<>( 1, 2, 3, 4, 5, 6, 7 );
		CustomLinkedList<Integer> list2 = new CustomLinkedList<>( 5, 6, 7 );

		// When
		CustomLinkedList.Node<Integer> node = Intersection.isIntersectedSmart( list1, list2 );

		// Then
		assertThat(node).isNull();
	}
}