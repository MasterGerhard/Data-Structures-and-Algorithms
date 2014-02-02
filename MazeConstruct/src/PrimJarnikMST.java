import java.security.InvalidKeyException;
/**
 * Prim's Algorithm
 * Creates MST of a given Graph
 * @author SteveG
 *
 */

public class PrimJarnikMST {
	
	private Vertex[] vertices;
	private int[] distance;
	private Edge[] parent;
	private MyEntry<Integer,Vertex>[] entry;

	/**
	 * @throws BoundaryViolationException 
	 * @throws InvalidPositionException 
	 * @throws InvalidKeyException 
	 * @throws EmptyTreeException 
	 * @throws EmptyPriorityQueueException */
	
	
	public PrimJarnikMST() {}
	
	public EdgeListGraph MST(EdgeListGraph G) throws InvalidKeyException, 
							InvalidPositionException, BoundaryViolationException, 
									EmptyPriorityQueueException, EmptyTreeException, InvalidEntryException {
		
		HeapAdaptablePriorityQueue<Integer,Vertex> Q = 
							new HeapAdaptablePriorityQueue<Integer, Vertex>();
		int n = G.vertices().size();
		vertices = new Vertex[n];
		distance = new int[n];
		parent = new Edge[n];
		entry = new MyEntry[n];

		for (int i = 0; i < G.vertices().size(); i++ ) {
			
			if( i == 0) {
				distance[i] = 0;	// Root of cloud
			}
			else {
				distance[i] = Integer.MAX_VALUE;
			}
			parent[i] = null;
			vertices[i] = G.vertices().get(i);
			entry[i] = (MyEntry<Integer, Vertex>) Q.insert(distance[i], vertices[i]);
		}

		
		while(!Q.isEmpty()) {
			Vertex u = Q.removeMin().getValue();
			
			for( int i = 0; i < G.incidentEdges(u).size(); i++ ) {
				Edge e = G.incidentEdges(u).get(i);
				Vertex z = G.opposite(u,e);
				int r = e.weight();
				if ( r < distance[z.index()]) {
					distance[z.index()] = r;
					parent[z.index()] = e;
					Q.replaceKey(entry[z.index()], r);
				}
				
				
			}
		}
		
		
		EdgeListGraph ans = new EdgeListGraph();
		for( int i = 0; i < vertices.length; i++ ) {
			ans.insertVertex(vertices[i]);
		}
		int x = 0;
		for( int j = 0; j < parent.length; j++ ) {
			if(parent[j] != (null))	{
				parent[j].setIndex(x);
				ans.insertEdge(parent[j]);	
				x = x+1;
			}
		}
		return ans;
	
	}
	
	public Edge[] edges() { return parent; } 
	public Vertex[] vertices() { return vertices; }
		
	
}
