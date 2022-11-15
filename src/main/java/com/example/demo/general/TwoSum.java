package com.example.demo.general;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

	/**
	 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
	 *
	 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
	 *
	 * You can return the answer in any order.
	 */

	public static void main( String[] args ) {
		TwoSum twoSum = new TwoSum();
		int[] re = twoSum.twoSum( new int[]{3,2,4}, 6 );
		System.out.println( Arrays.toString( re ) );
	}

	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> complementMap = new HashMap<>();
		for ( int i = 0; i < nums.length; i++ ) {
			complementMap.put( nums[i], i);
		}
		for ( int i = 0; i < nums.length; i++ ) {
			if(complementMap.containsKey( target - nums[i] ) && i != complementMap.get( target - nums[i] )) {
				return new int[]{i, complementMap.get( target - nums[i] )};
			}
		}
		return new int[]{};
	}
}
