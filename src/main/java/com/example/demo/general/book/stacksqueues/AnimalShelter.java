package com.example.demo.general.book.stacksqueues;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class AnimalShelter {
	LinkedList<Animal> cats = new LinkedList<>();
	LinkedList<Animal> dogs = new LinkedList<>();

	public void enqueue( Animal animal ) {
		animal.arrivalDate = LocalDateTime.now();
		if ( animal.type == AnimalType.CAT ) {
			cats.addLast( animal );
		}
		if ( animal.type == AnimalType.DOG ) {
			dogs.addLast( animal );
		}
	}

	public Animal dequeueAny() {
		if ( cats.isEmpty() ) {
			return dequeueDog();
		} else if ( dogs.isEmpty() ) {
			return dequeueCat();
		} else if ( cats.peek().arrivalDate.isBefore( dogs.peek().arrivalDate ) ) {
			return dequeueCat();
		} else {
			return dequeueDog();
		}
	}

	public Animal dequeueCat() {
		return cats.poll();
	}

	public Animal dequeueDog() {
		return dogs.poll();
	}

	static class Animal {
		AnimalType type;
		LocalDateTime arrivalDate;

		public Animal( final AnimalType type ) {
			this.type = type;
		}
	}

	enum AnimalType {
		CAT,
		DOG
	}
}
