//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {
	private boolean[][] grid = new boolean[100][100];
	private int sizex = 100;
	private int sizey = 100;
	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
		this.sizex = grid[0].length;
		this.sizey = grid.length;

		for (int i = 0; i < sizey; i++){
			for (int j = 0 ; j < sizex; j++){
				this.grid[i][j] = grid[i][j];
			}
		}
	}
	
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		for(int i = sizey-1; i >= 0 ; i--){
			int cnt = 0;
			for(int j = 0 ; j < sizex; j++){
				if(grid[i][j]==true) cnt++;
			}
			if(cnt==sizex){
				for(int ii = i; ii > 0 ; ii--){
					for(int jj = 0 ; jj < sizex; jj++){
						grid[ii][jj] = grid[ii-1][jj];
					}
				}
				for(int jj = 0; jj < sizex; jj++){
					grid[0][jj] = false;
				}
				i = i + 1;
			}
		}
	}
	
	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {

		return this.grid; // YOUR CODE HERE
	}

}
