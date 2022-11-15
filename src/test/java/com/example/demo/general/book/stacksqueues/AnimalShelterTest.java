package com.example.demo.general.book.stacksqueues;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnimalShelterTest {

	@Test
	@DisplayName("Given a filled anima shelter when getting cats should return the last cat")
	void givenAFilledAnimaShelter_whenGettingCats_shouldReturnTheLastCat() {
		// Given
	    AnimalShelter shelter = new AnimalShelter();
		AnimalShelter.Animal cat1 = new AnimalShelter.Animal( AnimalShelter.AnimalType.CAT );
		shelter.enqueue( cat1 );
		AnimalShelter.Animal dog1 = new AnimalShelter.Animal( AnimalShelter.AnimalType.DOG );
		shelter.enqueue( dog1 );
		AnimalShelter.Animal dog2 = new AnimalShelter.Animal( AnimalShelter.AnimalType.DOG );
		shelter.enqueue( dog2 );
		AnimalShelter.Animal cat2 = new AnimalShelter.Animal( AnimalShelter.AnimalType.CAT );
		shelter.enqueue( cat2 );
		AnimalShelter.Animal dog3 = new AnimalShelter.Animal( AnimalShelter.AnimalType.DOG );
		shelter.enqueue( dog3 );

		// When
		AnimalShelter.Animal first = shelter.dequeueDog();
		AnimalShelter.Animal second = shelter.dequeueAny();
		AnimalShelter.Animal third = shelter.dequeueCat();
		AnimalShelter.Animal forth = shelter.dequeueAny();
		AnimalShelter.Animal fifth = shelter.dequeueDog();
		AnimalShelter.Animal sixth = shelter.dequeueDog();

		// Then
		assertThat(first).isEqualTo( dog1 );
		assertThat(second).isEqualTo( cat1 );
		assertThat(third).isEqualTo( cat2 );
		assertThat(forth).isEqualTo( dog2 );
		assertThat(fifth).isEqualTo( dog3 );
		assertThat(sixth).isNull();
	}

}