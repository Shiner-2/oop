// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
		int maxx = 0, maxy = 0;
		int minx = Integer.MAX_VALUE, miny = Integer.MAX_VALUE;

		for(int i = 0 ; i < grid.length; i++){
			for(int j = 0 ; j < grid[i].length; j++){
				if(grid[i][j]==ch){
					maxy = Math.max(maxy,i);
					miny = Math.min(miny,i);
					maxx = Math.max(maxx,j);
					minx = Math.min(minx,j);
				}
			}
		}
		return (maxx-minx+1)*(maxy-miny+1); // YOUR CODE HERE
	}
	
	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus() {
		int ans = 0;
		for(int i = 1 ; i < grid.length-1; i++){
			for(int j = 1 ; j < grid[i].length-1; j++){
				if(grid[i][j]!=' '){
					char c = grid[i][j];
					int len = 0, xuong = 0, trai = 0, phai = 0;
					for(int up = i-1; up >= 0 ; up--){
						if(grid[up][j]==c){
							len++;
						}else{
							break;
						}
					}
					for(int down = i+1; down < grid.length ; down++){
						if(grid[down][j]==c){
							xuong++;
						}else{
							break;
						}
					}
					for(int left = j-1; left >= 0 ; left--){
						if(grid[i][left]==c){
							trai++;
						}else{
							break;
						}
					}
					for(int right = j+1; right < grid[i].length ; right++){
						if(grid[i][right]==c){
							phai++;
						}else{
							break;
						}
					}
					if(trai==phai && trai == len && trai == xuong){
						ans++;
					}
				}
			}
		}
		return ans; // YOUR CODE HERE
	}
	
}
