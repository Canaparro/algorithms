package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Exercises {

	@Test
	void differenceSumOfSquaresTest() {
		assertEquals( 25164150, differenceSumOfSquares( 100 ) );
	}

	public int differenceSumOfSquares( int numberOfItemsToSum ) {

		int sumOfSquares = 0;
		int regularSum = 0;

		for ( int i = 1; i < numberOfItemsToSum + 1; i++ ) {
			sumOfSquares += i * i;
			regularSum += i;
		}

		return(regularSum * regularSum ) - sumOfSquares;
	}

	@Test
	void nthPrimeTest() {
		assertEquals( 104743, nthPrime( 10001 ) );
	}

	public int nthPrime( int n ) {
		int primesFound = 0;
		int currentNumber = 1;

		while ( primesFound < n ) {
			currentNumber++;
			if ( isPrime2( currentNumber ) ) {
				primesFound++;
			}
		}
		return currentNumber;

	}

	private boolean isPrime2( final int n ) {
		boolean isPrime = true;
		for ( int i = 2; i < n; i++ ) {
			if ( n % i == 0 ) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}

	private boolean isPrime( final int n ) {
		boolean isPrime = true;
		for ( int i = 2; i < n; i++ ) {
			if ( n % i == 0 ) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}
}
