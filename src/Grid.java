import java.util.HashMap;
import java.util.Map;

/**
 * Representation of two-dimensional board for the Game of Life
 * @author GeorgeDadeboe
 *
 */
public class Grid {
	private Cell[][] contents;
	private int width;
	private int height;
	private Map<Integer, Cell[][]> iterations;

	/**
	 * Creates a grid with default width and height of 10
	 */
	public Grid() {
		this.width = 10;
		this.height = 10;
		initialise();
	}

	/**
	 * Creates a grid given the dimensions of the grid
	 * @param width width of the grid
	 * @param height height of the grid
	 */
	public Grid(int width, int height){
		this.width = width;
		this.height = height;
		initialise();
	}

	/**
	 * Initialise all properties of the grid
	 */
	private void initialise(){
		this.contents = new Cell[this.width][this.height];
		iterations = new HashMap<>();
		
		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++)
				contents[i][j] = new Cell();
		
		iterations.put(iterations.size(),contents);
	}

	/**	
	 * Set the the state of a cell in the grid given its state and position in the grid
	 * @param state the state of the cell
	 * @param x the row position of the cell
	 * @param y the column position if the cell
	 * @return the cell that was set in the grid
	 */
	public Cell setCell(boolean state, int x, int y){
		Cell cell = new Cell();
		
		try {
			cell = contents[x][y];
		} catch (IndexOutOfBoundsException e) {
			return  cell;
		}

			cell.setState(state);
			updateNeighbours();

			contents[x][y] = cell;
			return cell;
	}

	/**
	 * Returns the number of neighbours of a cell in the grid given its location in the grid
	 * @param x the row position of cell in the grid
	 * @param y the column position of cell in the grid
	 * @return the number of neighbours for the specified cell
	 */
	public int getNumOfNeighbours(int x, int y){
		if (x < width && y < height) {
			int numNeighbors = 0;

			try {
				if (contents[x - 1][y - 1].isLive())	numNeighbors++;
				if (contents[x - 1][y].isLive()) 		numNeighbors++;
				if (contents[x - 1][y + 1].isLive())	numNeighbors++;
				if (contents[x][y - 1].isLive())		numNeighbors++;
				if (contents[x][y + 1].isLive())		numNeighbors++;
				if (contents[x + 1][y - 1].isLive())	numNeighbors++;
				if (contents[x + 1][y].isLive())		numNeighbors++;
				if (contents[x + 1][y + 1].isLive())	numNeighbors++;
			} 
			catch (IndexOutOfBoundsException e) {}

			return numNeighbors;
		}
		return -1;
	}

	/**
	 * Prints a representation of the grid to the console
	 */
	public void printGrid(){
		for (int i = 0; i < width*1.5; i++) System.out.print("-");
		System.out.println("\nGrid STARTS here\n");

		for (int i = 0; i < width; i++){ 
			for (int j = 0; j < height; j++) {
				Cell cell = this.contents[i][j];				
				if(cell.isLive()){
					System.out.print("X");
				}
				else{
					System.out.print("-");
				}
			}
			System.out.println();
		}


		System.out.println("\nGrid ENDS Here");
		System.out.println("Iterations.: " + (iterations.size()-1));
		for (int i = 0; i < width*1.5; i++) System.out.print("-");
	}

	/**
	 * Simulate a single evolution of the game of life 
	 */
	public void iteration(){
		Grid temp = new Grid(width, height);

		for(int x = 0; x < width; x++){
			for (int y = 0; y < height; y++){
				Cell cell = this.contents[x][y];
				int num = cell.getNumOfNeighbours();

				if(cell.isLive() && num < 2){

					temp.setCell(false, x, y);
				}
				else if(cell.isLive() && num > 3){
					temp.setCell(false, x, y);
				}
				else if (cell.isLive() && (num ==2 || num == 3)){
					temp.setCell(true, x, y);
				}
				else if (!cell.isLive() && num == 3){
					temp.setCell(true, x, y);
				}
				else {
					temp.setCell(false, x, y);
				}
			}
		}
		iterations.put(iterations.size(),temp.contents);
		this.contents = temp.contents;
	}

	/**
	 * Update all cells in the grid to ensure the have the correct number of neighbours
	 */
	private void updateNeighbours(){
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Cell cell = this.contents[i][j];
				cell.setNumOfNeighbours(getNumOfNeighbours(i, j));
			}
		}
	}



	/**
	 * Returns a pair of all iterations mapped to its corresponding grid layout
	 * @return Map of iteration number to the state of the grid for that iteration
	 */
	public Map<Integer,Cell[][]> getIterations() {
		return iterations;
	}
}
