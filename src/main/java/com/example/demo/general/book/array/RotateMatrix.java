package com.example.demo.general.book.array;

public class RotateMatrix {

	public static void rotatePixel( int[][] matrix ) {
		int n = matrix.length;
		for ( int layer = 0; layer < n / 2; layer++ ) {

			int first = layer;
			int last = n - 1 - layer;

			for ( int i = first; i < last; i++ ) {
				int offSet = i - first;

				// save top
				int temp = matrix[first][ i ];

				// left to top
				matrix[first][ i ] = matrix[last - offSet][first];

				// bottom to left
				matrix[last - offSet][first] = matrix[last][last - offSet];

				// right to bottom
				matrix[last][last - offSet] = matrix[i][last];

				// top to right
				matrix[i][last] = temp;
			}
		}

	}

	public static void print(int[][] matrix) {

		for ( int i = 0; i < matrix.length; i++ ) {
			for ( int j = 0; j < matrix.length; j++ ) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
