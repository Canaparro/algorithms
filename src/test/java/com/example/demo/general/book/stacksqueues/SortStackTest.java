package com.example.demo.general.book.stacksqueues;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.demo.datastructures.CustomStack;

class SortStackTest {

	@Test
	@DisplayName("Given a unordered stack when ordering should return a new ordered stack")
	void givenAUnorderedStack_whenOrdering_shouldReturnANewOrderedStack() {
		// Given
		CustomStack<Integer> stack = new CustomStack<>();
		stack.push( 5 );
		stack.push( 2 );
		stack.push( 3 );
		stack.push( 1 );
		stack.push( 7 );

		// When
		CustomStack<Integer> orderedStack = SortStack.order( stack );

		// Then
		assertThat(orderedStack.pop()).isEqualTo( 1 );
		assertThat(orderedStack.pop()).isEqualTo( 2 );
		assertThat(orderedStack.pop()).isEqualTo( 3 );
		assertThat(orderedStack.pop()).isEqualTo( 5 );
		assertThat(orderedStack.pop()).isEqualTo( 7 );
	}
}