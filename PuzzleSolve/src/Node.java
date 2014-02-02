// Creates a node class for
// a singly linked list

public class Node {
	private String element;		// object this node stores
	private Node next;		// next node in list
	
	// Creates a node with null references to its element and next node.
	public Node() {
		this(null);
	}
	
	// Creates a node with the given element and next node.
	public Node(String e) {
		element = e;
		//next = null;
	}
	
	// returns the object this node stores
	public String getElement() {
		return element;
	}
	
	// returns the next node in list
	public Node getNext() {
		return next;	
	}
	
	// sets the object being stored
	public void setElement(String newElem) {
		element = newElem;
	}
	
	// sets the next node
	public void setNext(Node newNext) {
		next = newNext;
	}
	
	// prints this node
	public void printNode(){
		System.out.println(element.toString());
		
	}
}