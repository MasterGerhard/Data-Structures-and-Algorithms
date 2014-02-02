/** Interface for the priority queue ADT */
import java.security.InvalidKeyException;

public interface PriorityQueue<K,V> {
	/** Returns the number of items in the priority queue. */
	public int size();
	/** Returns whether the priority queue is empty. */
	public boolean isEmpty();
	/** Returns but does not remove an entry with minimum key. */
	public Entry<K,V> min() 
			throws EmptyPriorityQueueException, EmptyTreeException;
	/** Inserts a key-value pair and return the entry created. */
	public Entry<K,V> insert(K key, V value) 
			throws InvalidKeyException, BoundaryViolationException, InvalidPositionException;
	/** Removes and returns an entry with minimum key. */
	public Entry<K,V> removeMin() 
			throws EmptyPriorityQueueException, EmptyTreeException, InvalidPositionException,
			BoundaryViolationException;
}
