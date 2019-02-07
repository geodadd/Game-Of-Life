import java.util.Scanner;

public class GameOfLife {

	public static void main(String[] args) {
	 	Grid grid = new Grid();
	 	Scanner scanner = new Scanner(System.in);
	 	
	 	
	 	grid.setCell(true, 5, 5);
	 	grid.setCell(true, 5, 6);
	 	grid.setCell(true, 5, 7);
	 	
	 	grid.printGrid();
	 	while(true){
	 		if (!scanner.nextLine().equalsIgnoreCase("Q")) {
	 			grid.iteration();
				grid.printGrid();;
				continue;
	 		}
	 		scanner.close();
			break;
	 	}
	}

}
