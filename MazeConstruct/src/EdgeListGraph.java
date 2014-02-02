/**
 * This creates a graph implemented using edge list structure.
 * All vertices stored in an ArrayIndex
 * All edges stored in an ArrayIndex
 * @author Steven Gerhard
 *
 */

public class EdgeListGraph {
	
	private ArrayIndexList<Edge> edges;
	private ArrayIndexList<Vertex> vertices;
	 
	/** Creates a new EdgeListGraph. */
	public EdgeListGraph() {
		edges = new ArrayIndexList<Edge>();
		vertices = new ArrayIndexList<Vertex>();
	}
	
	/** Returns the vertices a given edge connects. */
	public ArrayIndexList<Vertex> endVertices(Edge e) {
		return e.vertices();
	}
	
	/** Returns the opposite vertex given an edge and 1 vertex. */
	public Vertex opposite(Vertex ver, Edge ed) {
		ArrayIndexList<Vertex> test = ed.vertices();
		if (test.get(0).equals(ver)) 
			return test.get(1);
		else
			return test.get(0);
	}
	
	/** Returns true iff an edge connects the two vertices. */
	public boolean areAdjacent(Vertex v1, Vertex v2) {
		boolean ans = false;
		for(int i = 0; i<edges.size(); i++) {
			if (edges.get(i).vertex1().equals(v1) && edges.get(i).vertex2().equals(v2)) {
				ans = true;
			}
			if (edges.get(i).vertex1().equals(v2) && edges.get(i).vertex2().equals(v1)) {
				ans = true;
			}
			if (ans == true) {break;}
		}
		return ans;
	}
	
	/** replaces vertex at given index with new vertex */
	public void replace(int r, Vertex V) {
		for(int i = 0; i < vertices.size(); i++) {
			if( vertices.get(i).index() == r) {
				vertices.remove(i);
				vertices.add(i, V);
				break;
			}
		}
	}
	
	/** replaces edge at given index with new edge */
	public void replace(int r, Edge E) {
		for(int i = 0; i < edges.size(); i++) {
			if( edges.get(i).index() == r) {
				edges.remove(i);
				edges.add(i, E);
				break;
			}
		}
	}
	
	/** Adds vertex object to graph */
	public void insertVertex(Vertex ver) {	

		vertices.add(ver.index(), ver);
		
	}
	
	/** Adds edge object to graph */
	public void insertEdge(Edge ed) {	
		
		edges.add(ed.index(), ed);
	}
	
	/** Removes and returns vertex at given index.
	 *  Also removes incident edges */
	public Vertex removeVertex(int r) throws IndexOutOfBoundsException {	
		Vertex ans = null;
		for(int i = 0; i < vertices.size(); i++) {
			if( vertices.get(i).index() == r) {
				ans = vertices.remove(i);
				break;
			}
		}
		if(ans.equals(null))
			throw new IndexOutOfBoundsException("No vertex at index");
		ArrayIndexList<Edge> temp = incidentEdges(ans);
		while (temp.size() != 0) {
			this.removeEdge(temp.get(0).index());
			temp.remove(0);
		}
		return ans;
	}
	
	/** Remove and returns edge at given index. */
	public Edge removeEdge(int r) {
		Edge ans = null;
		for(int i = 0; i < edges.size(); i++) {
			if( edges.get(i).index() == r) {
				ans = edges.remove(i);
				break;
			}
		}
		return ans;
	}
	
	/** Returns an array of incidentEdges to a given vertex. */
	public ArrayIndexList<Edge> incidentEdges(Vertex ver) {
		ArrayIndexList<Edge> ans = new ArrayIndexList<Edge>();
		int x = 0;
		for( int i = 0; i < edges.size(); i++) {
			if(edges.get(i).vertex1().equals(ver) || edges.get(i).vertex2().equals(ver)) {
				ans.add(x, edges().get(i));
				x++;
			}
		}
		return ans;
	}
	/** Returns an array of all vertexes 
	 *  the first vertex has index 0 */
	public ArrayIndexList<Vertex> vertices() {
		return vertices;
	}
	/** Returns an array of all edges. 
	 *  the first edge has index 0 */
	public ArrayIndexList<Edge> edges() {
		return edges;
	}
}
