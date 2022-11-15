package com.example.demo.memoization;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BestSum {

	// m is targetSum
	// n is numbers.lenght
	// without memoization
	// time complexity is O(n^m)
	// space complexity is O(m * m)

	// with memoization
	// time complexity is O(m * n * m) last m is from the array copy
	// space complexity is O(m * m) from memo object m keys with length m

	public static void main( String[] args ) {

		System.out.println( bestSum( 7, List.of( 2, 3, 4, 5, 7 ) ) );
		System.out.println( bestSum( 8, List.of( 2, 3, 5 ) ) );
		System.out.println( bestSum( 8, List.of( 1, 4, 5 ) ) );
		System.out.println( bestSum( 100, List.of( 1, 2, 5, 25 ) ) );

	}

	private static List<Integer> bestSum( int targetSum, List<Integer> numbers ) {
		return bestSum( targetSum, numbers, new HashMap<>() );
	}

	private static List<Integer> bestSum( int targetSum, List<Integer> numbers,
			Map<Integer, List<Integer>> memo ) {
		if ( memo.containsKey( targetSum ) ) {
			return memo.get( targetSum );
		}
		if ( targetSum == 0 ) {
			return new LinkedList<>();
		}
		if ( targetSum < 0 ) {
			return null;
		}

		List<Integer> result = null;

		for ( final int number : numbers ) {
			List<Integer> combination = bestSum( targetSum - number, numbers, memo );
			if ( combination != null ) {
				List<Integer> copyOfCombination = new LinkedList<>(combination);
				copyOfCombination.add( number );
				if ( result == null || copyOfCombination.size() < result.size() ) {
					result = copyOfCombination;
				}
			}
		}
		memo.put( targetSum, result );
		return result;
	}

}
