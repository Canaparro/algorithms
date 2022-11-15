package com.example.demo.general.book.array;

import java.util.LinkedList;
import java.util.List;

public class ZeroMatrix {

	public static void apply(int[][] matrix){
		List<Coordinates> zeroes = new LinkedList<>();

		for ( int i = 0; i < matrix.length; i++ ) {
			for ( int j = 0; j < matrix[i].length; j++ ) {
				if(matrix[i][j] == 0) {
					zeroes.add( new Coordinates( i, j ) );
				}
			}
		}

		if( !zeroes.isEmpty() ) {
			for ( final Coordinates zero : zeroes ) {
				crossWithZeroes(zero, matrix);
			}
		}
	}

	private static void crossWithZeroes( final Coordinates zero, final int[][] matrix ) {
		for ( int i = 0; i < matrix[zero.row].length; i++ ) {
			matrix[zero.row][i] = 0;
		}

		for ( int i = 0; i < matrix[zero.column].length; i++ ) {
			matrix[i][zero.column] = 0;
		}
	}

	private static class Coordinates {
		int row;
		int column;

		public Coordinates( final int row, final int column ) {
			this.row = row;
			this.column = column;
		}
	}
}
