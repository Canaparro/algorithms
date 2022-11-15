package com.example.demo.general;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClosestPointToOrigin {
	public static void main( String[] args ) {
		List<Tuple> tuples = List.of( new Tuple( -2, 4 ), new Tuple( 0, -2 ), new Tuple( -1, 0 ),
				new Tuple( 3, 5 ), new Tuple( -2, -3 ), new Tuple( 3, 2 ) );

		List<Tuple> closest = getKClosestToOrigin( 2, tuples );
		System.out.println( closest );
	}

	private static List<Tuple> getKClosestToOrigin( final int k, final List<Tuple> tuples ) {

		List<MesuredTuple> measurements = new ArrayList<>();

		for ( final Tuple tuple : tuples ) {
			measurements.add( new MesuredTuple( getDistanceToOrigin( tuple ), tuple ) );
		}

		return measurements.stream()
				.sorted( Comparator.comparing( MesuredTuple::distance ) )
				.map( MesuredTuple::tuple )
				.limit( k )
				.toList();
	}

	private static double getDistanceToOrigin( Tuple tuple ) {
		double quadraticSum = Math.pow( tuple.x(), 2 ) + Math.pow( tuple.y(), 2 );
		return Math.sqrt( quadraticSum );
	}

	record Tuple(int x, int y) {}

	record MesuredTuple(double distance, Tuple tuple) {}
}
