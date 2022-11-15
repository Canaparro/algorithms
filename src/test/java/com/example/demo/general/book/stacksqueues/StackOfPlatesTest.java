package com.example.demo.general.book.stacksqueues;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StackOfPlatesTest {

	@Test
	@DisplayName("Given a a list of elements added when popping should return in the reverse order")
	void givenAAListOfElementsAdded_whenPopping_shouldReturnInTheReverseOrder() {
		// Given
		StackOfPlates<Integer> stack = new StackOfPlates<>( 2 );
		stack.push( 1 );
		stack.push( 2 );
		stack.push( 3 );
		stack.push( 4 );
		stack.push( 5 );

		// When
		Integer first = stack.pop();
		Integer second = stack.pop();
		Integer third = stack.pop();
		Integer forth = stack.pop();
		Integer fifth = stack.pop();

		// Then
		assertThat(first).isEqualTo( 5 );
		assertThat(second).isEqualTo( 4 );
		assertThat(third).isEqualTo( 3 );
		assertThat(forth).isEqualTo( 2 );
		assertThat(fifth).isEqualTo( 1 );
	}

}