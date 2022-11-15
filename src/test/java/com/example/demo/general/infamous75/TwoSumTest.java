package com.example.demo.general.infamous75;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TwoSumTest {

	private final Solution solution = new Solution();

	@Test
	@DisplayName("some test")
	void someTest() {
		// Given
		int[] nums = new int[]{2,7,11,15};
		int target = 18;

		// When
		int[] result = solution.twoSum( nums, target );

		// Then
		assertThat(result).containsExactly( 1, 2 );
	}
	class Solution {

		public int[] twoSum( int[] nums, int target ) {
			int[] result = new int[2];

			for ( int i = 0; i < nums.length; i++ ) {
				int currentValue = nums[i];
				if(currentValue >= target){
					break;
				}

				int currentValuePair = target - currentValue;

				for ( int j = i; j <nums.length; j++ ) {
					if(currentValuePair == nums[j]) {
						result[0] = i;
						result[1] = j;
					}
				}
			}

			return result;
		}
	}

}
