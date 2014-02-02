/**
 * Edge Object
 * stores an element (wall weight)
 * and 2 vertices
 * also stores index for edge list graph structure
 * @author Steven Gerhard
 */

public class Edge {

	private int weight;
	private int index;
	private Vertex v1,v2;
	
	public Edge(int in, int wei, Vertex V1, Vertex V2) {
		weight = wei;
		index = in;
		v1 = V1;
		v2 = V2;
	}
	public Vertex vertex1() { return v1; }
	public Vertex vertex2() { return v2; }
	public ArrayIndexList<Vertex> vertices() {
		ArrayIndexList<Vertex> ans = new ArrayIndexList<Vertex>();
		ans.add(0,v1);
		ans.add(1,v2);
		return ans;
	}
	public int weight() { return weight; }
	public int index() { return index; }
	public void setIndex(int i) { index = i; }
	public int setWeight(int wei) {
		int temp = weight;
		weight = wei;
		return temp;
	}
	
	public void print() {
		v1.print();
		v2.print();
		System.out.println();
	}
}
