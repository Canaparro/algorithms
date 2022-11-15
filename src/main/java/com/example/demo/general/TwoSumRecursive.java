package com.example.demo.general;

import java.util.Arrays;
import java.util.HashSet;

public class TwoSumRecursive {

	private static int[] result = new int[0];

	/**
	 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
	 *
	 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
	 *
	 * You can return the answer in any order.
	 */

	public static void main( String[] args ) {
		TwoSumRecursive twoSum = new TwoSumRecursive();
		twoSum.twoSum( new int[] { 2, 7, 11, 15 }, 9 );
		System.out.println( Arrays.toString( result ) );
	}

	public boolean twoSum( int[] nums, int targetSum ) {
		return twoSum( nums, targetSum, new HashSet<>() );
	}

	private boolean twoSum( int[] nums, int targetSum, HashSet<Integer> usedIndexes ) {
		if ( usedIndexes.size() > 2 ) {
			return false;
		}
		if ( targetSum == 0 && usedIndexes.size() == 2 ) {
			return true;
		}

		for ( int i = 0; i < nums.length; i++ ) {
			if ( usedIndexes.contains( i ) ) {
				continue;
			}
			usedIndexes.add( i );
			boolean returnedArray = twoSum( nums, targetSum - nums[i], usedIndexes );
			if ( returnedArray ) {
				result = Arrays.copyOf( result, result.length + 1 );
				result[result.length - 1] = i;
			}
		}
		return false;
	}
}
