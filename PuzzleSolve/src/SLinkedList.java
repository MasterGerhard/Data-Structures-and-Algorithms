/*
 * Singly linked list
 */

public class SLinkedList {
	protected Node head,tail;	// head node of list
	protected int size;	// number of nodes in list
	
	// Default constructor that creates an empty list		
	public SLinkedList(){
		head = tail = null;
		size = 0;
		
	}
	
	// add node to beginning of list
	public void addFirst(String s){
		Node link = new Node(s);
		if(size==0){
			tail = link;
		}
		
		link.setNext(head);
		head = link;
		size++;
	}
	
	// add node to end of list
	public void addLast(String s){
		Node link = new Node(s);
		if(size==0){
			addFirst(s);
		}
		else{
		link.setNext(null);
		tail.setNext(link);
		tail = link;
		size++;
		}
	}
	
	// remove the first node
	public void removeFirst(){
		if (head == null){
			System.out.println("List is Empty");
			return;
			}
		Node t = head;
		head = head.getNext();
		t.setNext(null);
		size--;
		}
	
	// removes tail node
	// can be inefficient but 
	// puzzle solve uses at most 10 nodes
	public void removeLast(){
		Node current = head;
		Node mem = null;
		do{
			mem = current;
			current = current.getNext();
		}
			while(current.getNext() != null);
		mem.setNext(null);
		tail = mem;
		size--;
	}
		
	// returns element of head node
	public String getHead(){
		return head.getElement();
	}
	
	// returns the tail element
	public String getTail(){
		return tail.getElement();
	}
	
	// returns the number of nodes
	public int getSize(){
		return size;
	}
	
	// returns true if the list is empty
	public boolean isEmpty(){
		return head==null;
	}
	
	// turns the entire list into a single string
	public String getList(){
		Node current = head;
		String result = "";
		while(current != null){
			result = result + String.valueOf(current.getElement());
			current = current.getNext();
		}
		return result;
	}
	
	// prints all elements of the list
	public void printList(){
		Node current = head;
		System.out.println("Elements of List:");
		while(current != null){
			current.printNode();
			current = current.getNext();
		}
	}
	public static void main(String[] args){
		SLinkedList test = new SLinkedList();
		test.addFirst("1");
		test.addFirst("2");
		test.addFirst("3");
		test.addFirst("4");
		test.addFirst("5");
		test.printList();
		test.removeFirst();
		test.printList();
		System.out.println(test.getHead());
		
	}
}


