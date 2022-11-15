package com.example.demo;

class Solution {

	public static void main( String[] args ) {
		System.out.println( new Solution().surfaceArea(
				new int[][] { { 1, 2 }, { 3,4 } } ) );
	}

	public int surfaceArea( int[][] grid ) {
		int area = 0;

		for ( int i = 0; i < grid.length; i++ ) {

			for ( int j = 0; j < grid[i].length; j++ ) {
				area += calculateArea( grid, i, j );
			}

		}

		return area;
	}

	private int calculateArea( final int[][] grid, final int horizontalPosition,
			final int verticalPosition ) {
		int cubeHeight = grid[horizontalPosition][verticalPosition];

		int cubeArea = 0;

		if ( cubeHeight > 0 ) {
			//account for top and bottom
			cubeArea += 2;

			//account area left
			cubeArea += getCubeExposedWallArea( grid, horizontalPosition - 1, verticalPosition,
					cubeHeight );

			//account area right
			cubeArea += getCubeExposedWallArea( grid, horizontalPosition + 1, verticalPosition,
					cubeHeight );

			//account area up
			cubeArea += getCubeExposedWallArea( grid, horizontalPosition, verticalPosition + 1,
					cubeHeight );

			//account area down
			cubeArea += getCubeExposedWallArea( grid, horizontalPosition, verticalPosition - 1,
					cubeHeight );

		}
		return cubeArea;
	}

	private int getCubeExposedWallArea( final int[][] grid, final int horizontalPosition,
			final int verticalPosition, final int cubeHeight ) {

		int neighborCubeHeight = getCubeHeightIn( grid, horizontalPosition, verticalPosition );

		return Math.max( cubeHeight - neighborCubeHeight, 0 );
	}

	private int getCubeHeightIn( final int[][] grid, final int horizontalPosition,
			final int verticalPosition ) {
		int cubeHeight = 0;

		if ( horizontalPosition >= 0 && horizontalPosition < grid.length
				&& verticalPosition >= 0 && verticalPosition < grid[horizontalPosition].length ) {
			cubeHeight = grid[horizontalPosition][verticalPosition];
		}

		return cubeHeight;
	}
}