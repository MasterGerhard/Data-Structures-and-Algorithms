import java.security.InvalidKeyException;
import java.util.Scanner; 
/** 
 * @author Steven Gerhard
 * ID: 1849880
 * CSE 2100 Lab 6
 * December 2013
 * Maze Construct Creates a Maze from given inputs
 *
 */

public class MazeConstruct {
	private Cell start, finish;
	private int N; // Maze dimensions n*n
	
	public MazeConstruct() {
		start = null;
		finish = null;
	}
	
	/** Draws the given maze.*/
	public void drawMaze(EdgeListGraph G) {
		System.out.println();
		System.out.println("Edges:");
		for( int e = 0; e < G.edges().size(); e++ ) {
			G.edges().get(e).print();
		}
		
		int v = 0; 	// index for G.vertices()
		System.out.print(" _");
		for(int i = 1; i < N-1; i++ ){								//for top line of maze
			if( (start.getX() == 0 && start.getY() == i) || 
					(finish.getX() == 0 && finish.getY() == i) ) {	// if start/finish
				System.out.print("  ");								// do not print wall
			}
			else {
				System.out.print(" _");
			}
		}	
		System.out.print(" _");
		// Top line of maze is correctly printed, now iterator through (rows,columns)
		for( int i = 0; i < N; i++ ) {		// row iterator, row = i
			System.out.println();
			if( (start.getX() == i && start.getY() == 0) || 
					(finish.getX() == i && finish.getY() == 0) ) { 	// if start/finish at begin of row
				System.out.print(" ");								// do not print wall		
			}
			else {
				System.out.print("|");	
			}
			
			for( int j = 0; j < N; j++ ) {		// column iterator, column = j
				if (i < N-1)  { 	
					if( j < N-1) {	
						if(G.areAdjacent(G.vertices().get(v),G.vertices().get(v+N))) {
							System.out.print(" ");
						}
						else {
							System.out.print("_");
						}
						if( G.areAdjacent(G.vertices().get(v), G.vertices().get(v+1))) {
							System.out.print(" ");
						}
						else {
							System.out.print("|");
						}
						v++;
					}
					else {
						if(G.areAdjacent(G.vertices().get(v),G.vertices().get(v+N))) {
							System.out.print(" ");
						}
						else {
							System.out.print("_");
						}
						if ((start.getX() == i && start.getY() == N-1) ||			// if at end of row 
								(finish.getX() == i && finish.getY() == N-1)) {		// and start/finish
							System.out.print(" ");								// do not print wall
						}
						else {
							System.out.print("|");
						}
						v++;
					}
							
				}
				
				else {	// (i == N-1) last row is handled differently
					if( j == 0 || j == N-1) {	// if last row end columns, always print bottom wall
						System.out.print("_");	
					}
					else if ((start.getX() == i && start.getY() == j) || 		// else if in last row middle columns
								(finish.getX() == i && finish.getY() == j)) {	// and start/finish
						System.out.print(" ");									// do not print wall
					}
					else {
						System.out.print("_");
					}
					if (j < N-1) {
						if( G.areAdjacent(G.vertices().get(v), G.vertices().get(v+1))) {
							System.out.print(" ");
						}
						else {
							System.out.print("|");
						}
						v++;
					}
					else {	// j == N-1
						if ((start.getX() == i && start.getY() == N-1) ||			// if in last row end columns
								(finish.getX() == i && finish.getY() == N-1)) {		// and start/finish
							System.out.print(" ");								// do not print wall
						}
						else {
							System.out.print("|");
						}
						v++;
					}
				}
			}
		}
		System.out.println();
		
	}
		
	
	
	/** Sets the start of maze. */
	public void setStart(Cell Start) {
		start = Start;
	}
	
	/** Sets the end of maze. */
	public void setFinish(Cell Finish) {
		finish = Finish;
	}
	
	/** Sets maze dimensions. */
	public void setDimension(int n) { N = n; }
	
	/** Returns start Cell of maze. */
	public Cell start() { return start; }
	
	/** Returns finish Cell of maze. */ 
	public Cell finish() { return finish; }
	
	public static void main(String[] args) throws InvalidKeyException, 
			InvalidPositionException, BoundaryViolationException, 
			EmptyPriorityQueueException, EmptyTreeException, InvalidEntryException {
		Scanner input = new Scanner(System.in);
		MazeConstruct maze = new MazeConstruct();
		EdgeListGraph dual = new EdgeListGraph();
		System.out.println("Enter Maze Paramaters");	
		System.out.println("n  r_start  c_start  r_finish  c_finish");
		System.out.println("wall weight line 1...");
		int n = input.nextInt();
		maze.setDimension(n);
		int x = 0;	// index for vertices
		for (int i = 0; i < n; i++) {	// x coordinate
			for (int j = 0; j < n; j++) {	// y coordinate
				Vertex v = new Vertex(x, i, j);
				x++;
				dual.insertVertex(v);
			}
		}
		maze.setStart(new Cell(input.nextInt(),input.nextInt()));
		maze.setFinish(new Cell(input.nextInt(),input.nextInt()));
		int y = 0;	// index for edges
		// The loops below add all the edges based off input weights
		// The vertices have indices 0 to (n*n)-1
		for (int i = 0; i < n-1; i++) {
			for (int j = i*n; j < ((i+1)*n)-1; j++) {
				dual.insertEdge(new Edge(y,input.nextInt(),dual.vertices().get(j), dual.vertices().get(j+1)));
				y++;
			}
			for (int k = i*n; k < (i+1)*n; k++) {
				dual.insertEdge(new Edge(y,input.nextInt(),dual.vertices().get(k),dual.vertices().get(k+n)));
				y++;
			}
		}
		for (int i = ((n*(n-1))); i < (n*n)-1; i++ ) {
			dual.insertEdge(new Edge(y,input.nextInt(),dual.vertices().get(i), dual.vertices().get(i+1)));
			y++;
		}
		EdgeListGraph MST = new PrimJarnikMST().MST(dual);
		maze.drawMaze(MST);
		System.out.println("Number of vertices: " + MST.vertices().size());
		System.out.println("Number of edges: " + MST.edges().size());
		input.close();
	}
}
