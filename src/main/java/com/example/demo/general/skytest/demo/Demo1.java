package com.example.demo.general.skytest.demo;

import java.util.Arrays;

public class Demo1 {
	public static void main( String[] args ) {
		System.out.println(solution( new int[]{1, 3, 6, 4, 1, 2} ));
		System.out.println(solution( new int[]{-1,-3} ));
	}

	public static int solution(int[] A) {
		// write your code in Java SE 8

		Arrays.sort(A);

		int result = 1;

		for ( final int element : A ) {
			if(element < 1) {
				continue;
			}
			if(element > result) {
				break;
			}
			if(element == result) {
				result++;
			}
		}

		return result;
	}
}
