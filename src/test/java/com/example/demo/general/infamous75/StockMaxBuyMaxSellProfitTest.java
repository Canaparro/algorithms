package com.example.demo.general.infamous75;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StockMaxBuyMaxSellProfitTest {

	private final Solution solution = new Solution();

	@Test
	@DisplayName("Some test")
	void someTest() {
		// Given
	    int[] prices = new int[] {7,1,5,3,6,4};

		// When
		int result = solution.maxProfit( prices );

		// Then
		assertThat(result).isEqualTo( 5 );
	}

	class Solution {
		public int maxProfit(int[] prices) {
			if(prices.length < 2) return 0;

			int profit = 0;

			int left = 0;
			int right = 1;

			while(right < prices.length) {
				int buyPrice = prices[left];
				int sellPrice = prices[right];

				if(buyPrice < sellPrice) {
					profit = Math.max( profit, sellPrice - buyPrice);
				} else {
					left = right;
				}
				right++;
			}

			return profit;
		}
	}
}
