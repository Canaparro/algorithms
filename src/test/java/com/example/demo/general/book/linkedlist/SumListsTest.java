package com.example.demo.general.book.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.demo.datastructures.CustomLinkedList;

class SumListsTest {

	@Test
	@DisplayName(
			"Given two linked lists representing numbers when summing should return the correct sum")
	void givenTwoLinkedListsRepresentingNumbers_whenSumming_shouldReturnTheCorrectSum() {
		// Given
		CustomLinkedList<Integer> firstList = new CustomLinkedList<>( 6, 1, 2, 4 );
		CustomLinkedList<Integer> secondList = new CustomLinkedList<>( 3, 5, 8, 3 );

		// When
		int sum = SumLists.backwardOrderSum( firstList, secondList );

		// Then
		assertThat( sum ).isEqualTo( 8069 );
	}

	@Test
	@DisplayName(
			"Given two linked lists representing numbers in forward order when summing should return the correct sum")
	void givenTwoLinkedListsRepresentingNumbersInForwardOrder_whenSumming_shouldReturnTheCorrectSum() {
		// Given
		CustomLinkedList<Integer> firstList = new CustomLinkedList<>( 6, 1, 2, 4 );
		CustomLinkedList<Integer> secondList = new CustomLinkedList<>( 3, 5, 8, 3 );

		// When
		int sum = SumLists.forwardOrderSum( firstList, secondList );

		// Then
		assertThat( sum ).isEqualTo( 9707 );
	}

	@Test
	@DisplayName("some test")
	void someTest() {
		// Given
		CustomLinkedList<Integer> firstList = new CustomLinkedList<>( 6, 1, 2, 4 );
		CustomLinkedList<Integer> secondList = new CustomLinkedList<>( 5, 8, 3 );

		// When
		CustomLinkedList<Integer> result = SumLists.sumBackwardsLists( firstList, secondList );

		// Then
		assertThat( result.toArray() ).containsExactly( 1, 0, 6, 4 );

	}

	@Test
	@DisplayName("some test")
	void someTest2() {
		// Given
		CustomLinkedList<Integer> firstList = new CustomLinkedList<>( 6, 1, 2, 4 );
		CustomLinkedList<Integer> secondList = new CustomLinkedList<>( 5, 8, 3 );

		// When
		CustomLinkedList<Integer> result = SumLists.sumBackwardsLists( firstList, secondList );

		// Then
		assertThat( result.toArray() ).containsExactly( 1, 0, 6, 4 );

	}

}