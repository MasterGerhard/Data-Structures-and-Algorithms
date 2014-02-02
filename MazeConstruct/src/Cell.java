/**
 * Cell Object
 * stores x,y coordinates for maze
 * @author SteveG
 */

public class Cell {
	int x,y;
	
	public Cell(int X, int Y) {
		x = X;
		y = Y;
	}
	
	public int getX() { return x; }
	public int getY() { return y; }
	public void print() {
		System.out.print("(" + x + "," + y + ") ");
	}
}
