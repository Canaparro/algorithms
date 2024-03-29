package com.example.demo.datastructures;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomQueueTest {

	private CustomQueue<Integer> queue;

	@BeforeEach
	void setUp() {
		queue = new CustomQueue<>();
	}

	@Test
	@DisplayName(
			"Given a queue with three elements when popping should return in exact insertion order")
	void givenAQueueWithThreeElements_whenPopping_shouldReturnInExactInsertionOrder() {
		// Given
		int firstIn = 5;
		int secondIn = 6;
		int thirdIn = 6;
		queue.add( firstIn );
		queue.add( secondIn );
		queue.add( thirdIn );

		// When
		Integer firstOut = queue.remove();
		Integer secondOut = queue.remove();
		Integer thirdOut = queue.remove();

		// Then
		assertThat( firstOut ).isEqualTo( firstIn );
		assertThat( secondOut ).isEqualTo( secondIn );
		assertThat( thirdOut ).isEqualTo( thirdIn );
	}

	@Test
	@DisplayName("Given a queue with one element when popping twice should return the element then null")
	void givenAQueueWithOneElement_whenPoppingTwice_shouldReturnTheElementThenNull() {
		// Given
		int value = 5;
		queue.add( value );

		// When
		Integer firstPop = queue.remove();
		Integer secondPop = queue.remove();
		// Then
		assertThat( firstPop ).isEqualTo( value );
		assertThat( secondPop ).isNull();
	}
}