package com.example.demo.general;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnagramTest {

	@Test
	void howManyToRemoveForAnagram() {

		int i = Anagram.howManyToRemoveForAnagram( "balloon", "cartoon" );

		assertThat(i).isEqualTo( 6 );
	}
}