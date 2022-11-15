package com.example.demo.general.book.stacksqueues;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ThreeStacksOneArrayTest {

	@Test
	@DisplayName("Given an stack when pushing over the capacity should throw")
	void givenAnStack_whenPushingOverTheCapacity_shouldThrow() {
		// Given
		ThreeStacksOneArray stacks = new ThreeStacksOneArray( 1 );
		stacks.push( 2, 1 );
		// When
		ThrowableAssert.ThrowingCallable callable = () -> stacks.push( 2, 2 );
		// Then
		assertThatThrownBy(callable).hasMessage( "stack 2 is full" );
	}

}