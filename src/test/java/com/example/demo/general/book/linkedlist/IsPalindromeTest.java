package com.example.demo.general.book.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.demo.datastructures.CustomLinkedList;

class IsPalindromeTest {

	@Test
	@DisplayName("Given a palindrome linked list when checking should return true")
	void givenAPalindromeLinkedList_whenChecking_shouldReturnTrue() {
		// Given
		CustomLinkedList<Character> list = new CustomLinkedList<>( 'a', 'b', 'c', 'b', 'a' );

		// When
		boolean isPalindrome = IsPalindrome.isPalindrome( list );

		// Then
		assertThat(isPalindrome).isTrue();
	}

	@Test
	@DisplayName("Given a non palindrome linked list when testing should return false")
	void givenANonPalindromeLinkedList_whenTesting_shouldReturnFalse() {
		// Given
		CustomLinkedList<Character> list = new CustomLinkedList<>( 'a', 'b', 'c', 'b', 'd' );

		// When
		boolean isPalindrome = IsPalindrome.isPalindrome( list );

		// Then
		assertThat(isPalindrome).isFalse();
	}
}