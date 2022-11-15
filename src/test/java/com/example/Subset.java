package com.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Subset {

	private Solution solution = new Solution();

	@Test
	void test() {

		System.out.println( solution.subsets( new int[] { 1, 2, 3, 4 } ) );

	}

	class Solution {
		public List<List<Integer>> subsets( int[] nums ) {

			Arrays.sort( nums );

			//Initialize result with empty set
			List<List<Integer>> result = new LinkedList();
			result.add( List.of() );

			//edge case
			if ( nums.length == 1 ) {
				result.add( List.of( nums[0] ) );
				return result;
			}

			for ( int size = 1; size <= nums.length; size++ ) {

				List<List<Integer>> partialResult = combinationsForSize( size, nums );
				result.addAll( partialResult );

			}

			return result;
		}
		//[1,2,3,4]
		//[1,2][1,3],[1,4][2,3]

		private List<List<Integer>> combinationsForSize( int size, int[] array ) {
			List<Integer> partialResult = new LinkedList<>(  );

			for ( int i = 0; i < array.length; i++ ) {
				for ( int j = 0; j < array.length; j++ ) {
					if ( i == j ) continue;
					partialResult.add( j );
				}
			}

			return List.of();


		}

	}
}
