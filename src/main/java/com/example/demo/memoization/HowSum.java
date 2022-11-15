package com.example.demo.memoization;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HowSum {
	public static void main( String[] args ) {
		System.out.println( Arrays.toString( howSum( 7, new int[] { 5, 3, 4, 7 } ) ) );
		System.out.println( Arrays.toString( howSum( 8, new int[] { 2, 3, 5 } ) ) );
		System.out.println( Arrays.toString( howSum( 7, new int[] { 2, 4 } ) ) );
		System.out.println( Arrays.toString( howSum( 0, new int[] { 1, 2, 3 } ) ) );
		System.out.println( Arrays.toString( howSum( 300, new int[] { 7, 14 } ) ) );
	}

	private static int[] howSum( final int targetSum, final int[] numbers ) {
		return howSum( targetSum, numbers, new HashMap<>() );
	}

	private static int[] howSum( final int targetSum, final int[] numbers, Map<Integer, int[]> memo ) {
		if(memo.containsKey( targetSum )) return memo.get( targetSum );
		if(targetSum == 0) return new int[0];
		if(targetSum < 0) return null;

		for ( int num : numbers ) {
			int remainder = targetSum - num;
			int[] remainderResult = howSum( remainder, numbers, memo );
			if(remainderResult != null) {
				int[] newArray = Arrays.copyOf( remainderResult, remainderResult.length + 1);
				newArray[newArray.length - 1] = num;
				memo.putIfAbsent( targetSum, newArray );
				return memo.get( targetSum );
			}
		}
		memo.putIfAbsent( targetSum, null );
		return memo.get( targetSum );
	}

//	private static List<Integer> howSum( final int targetSum, final int[] array ) {
//		List<Integer> result = new LinkedList<>();
//
//		if(canSum( targetSum, array, result )) {
//			return result;
//		} else {
//			return null;
//		}
//	}
//
//	private static boolean canSum( int targetSum, int[] array, final List<Integer> result ) {
//		if ( targetSum == 0 ) {
//			return true;
//		}
//		if ( targetSum < 0 ) {
//			return false;
//		}
//
//		for ( int num : array ) {
//			if ( canSum( targetSum - num, array, result ) ) {
//				result.add( num );
//				return true;
//			}
//		}
//
//		return false;
//	}
}
