/**
 * Representation of a cell in a grid 
 * @author GeorgeDadeboe
 *
 */
public class Cell {
	/**
	 * The state of the cell
	 * True for a cell that is alive
	 * False for a cell that is dead
	 */
	private boolean state;
	
	/**
	 * The number of neighbours the cell has
	 * Each cell can have at most 8 neighbours
	 */
	private int neighbours;
	
	/**
	 * Initialising a cell
	 * Default state is false
	 * Default number of neighbours is 0
	 */
	public Cell() {
		this.state = false;
		this.neighbours = 0;
	}
	
	/**
	 * Initialising a cell given its state
	 * @param state, the state of the cell
	 * Default number of neighbours is 0
	 */
	public Cell(boolean state){
		this.state = state;
		this.neighbours = 0;
	}
	
	/**
	 * Returns the state of cell
	 * @return state, state of the cell which is either true(alive) or false(dead)
	 */
	public boolean isLive() {
		return state;
	}

	/**
	 * Set the state of the cell
	 * @param state, state of the cell which is either true(alive) or false(dead)
	 */
	public void setState(boolean state) {
		this.state = state;
	}
	
	/**
	 * Returns the number of neighbours the cell has
	 * @return the number of neighbours the cell has
	 */
	public int getNumOfNeighbours(){
		return neighbours;
	}
	
	/**
	 * Set the number of neighbours the cell has
	 * @param int representing the number of neighbours
	 */
	public void setNumOfNeighbours(int neighbours) {
		this.neighbours = neighbours;
	}
	
	/**
	 * Returns a string representation of the cell
	 * @return the current cell in string
	 */
	@Override
	public String toString() {
		return "State: " + state + ", Neighbours: " + neighbours;
	}
}
