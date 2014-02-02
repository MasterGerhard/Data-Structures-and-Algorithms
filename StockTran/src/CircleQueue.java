/*
 * Steven Gerhard
 * Creates a circle queue
 * for use with StockTran.java
 */

import java.math.BigDecimal;
public class CircleQueue {
	static final int MAX_SIZE = 32;
	protected Node head,tail;	// head points to first filled node
								// tail points to last filled node
	
	
	// Creates a list of 32 nodes
	// each with index day = [1,32]
	// (the index isn't actually used)
	// and connects them circularly
	
	public CircleQueue(){
		Node current = new Node();
		head = tail = current;
		current.setDay(1);
		for(int i = 2; i <= MAX_SIZE; i++ ){
			Node next = new Node();
			next.setDay(i);
			current.setNext(next);
			current = next;
			}
		current.setNext(head);
	}
	
	// returns the number of filled nodes
	public int size(){
		return(tail.getDay() - head.getDay());
	}
	
	// returns true if empty
	public boolean isEmpty(){
		return(tail.getDay() == head.getDay());
	}
	
	// returns head node
	public Node front(){
		if(isEmpty()){
			throw new EmptyQueueException("Queue is empty");
		}
		Node temp = head;
		return temp;
	}
	
	// adds elements to end of queue
	public void enqueue(BigDecimal A, BigDecimal P){
		if(size() == 31){
			throw new FullQueueException("Queue is Full");
		}
		BigDecimal amt = A;
		BigDecimal price = P;
		tail.setAmt(amt);
		tail.setPrice(price);
		tail = tail.next();
	}
	
	// removes front of queue
	public Node dequeue(){
		if(isEmpty()){
			throw new EmptyQueueException("Queue is empty");
		}
		Node temp = head;
		head.clearNode();
		head = head.next();
		return temp;
	}
	
	// this allows a specific amt subtracted
	// from head node without dequeuing
	public void sellShares(BigDecimal amt){
		head.setAmt(head.getAmt().subtract(amt));
	}
	
	// Prints all the nodes of the queue
	public void printList(){
		Node current = head;
		System.out.println("Elements of List:");
		for( int i = 0; i < size(); i++) {
			current.printNode();
			current = current.next();
		}
	}

}
