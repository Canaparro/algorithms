package com.example.demo.datastructures;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomStackTest {

	private CustomStack<Integer> stack;

	@BeforeEach
	public void setUp() {
		stack = new CustomStack<>();
	}

	@Test
	@DisplayName("Given an empty stack when adding an element on pop should return that element")
	void givenAnEmptyStack_whenAddingAnElementOnPop_shouldReturnThatElement() {
		// When
		int value = 5;
		stack.add( value );

		// Then
		assertThat( stack.pop() ).isEqualTo( value );
	}

	@Test
	@DisplayName("Given a stack with elements in it when popping should return elements in reverse insertion order")
	void givenAStackWithElementsInIt_whenPopping_shouldReturnElementsInReverseInsertionOrder() {
		// Given
		int firstIn = 5;
		stack.add( firstIn );
		int secondIn = 6;
		stack.add( secondIn );

		// When
		Integer firstOut = stack.pop();
		Integer secondOut = stack.pop();

		// Then
		assertThat( firstOut ).isEqualTo( secondIn );
		assertThat( secondOut ).isEqualTo( firstIn );
	}


}