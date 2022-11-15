package com.example.demo.general;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {

	public static List<List<Integer>> get( final int[] nums ) {
		List<List<Integer>> result = new LinkedList<>();
		result.add( new LinkedList<>() );

		for ( final int num : nums ) {
			List<List<Integer>> partial = new ArrayList<>();

			for ( final List<Integer> list : result ) {
				if(!list.contains( num )) {
					ArrayList<Integer> newList = new ArrayList<>( list );
					newList.add( num );
					partial.add( newList );
				}
			}
			result.addAll( partial );
		}
		return result;
	}

	public static List<List<Integer>> getRecursive( final int[] nums ) {
		List<List<Integer>> result = new LinkedList<>();
		result.add( new LinkedList<>() );

		return List.of();
	}
}
