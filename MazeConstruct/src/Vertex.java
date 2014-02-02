/**
 * Vertex object
 * stores an element (cell object for maze)
 * and index for edge list structure graph
 * @author Steven Gerhard
 */

public class Vertex {

	private Cell element;
	private int index;

	
	public Vertex(int in, int X, int Y) {
		element = new Cell(X,Y);
		index = in;
	}
	
	public Cell element() { return element; }
	public int index() { return index; }
	public void setIndex(int i) { index = i; }
	public Cell setCell(int X, int Y) {
		Cell temp = element;
		element = new Cell(X,Y);
		return temp;
	}

	
	/** For testing purposes. */
	public void print() {	
		element.print();
	}
	
}