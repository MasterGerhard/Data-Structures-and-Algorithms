/**
 * Creates a complete Binary Tree
 * stored as an ArrayIndexList
 *
 * from Data Structures and Algorithms page 355
 */

public class ArrayListCompleteBinaryTree<E>  {
	protected ArrayIndexList<BTPos<E>> T;	// indexed list of tree positions
	
	/** Nested class for an index list-based complete binary tree node. */
	protected static class BTPos<E> implements Position<E> {
		E element;	// element stored at this position
		int index;		// index of this position in the array
		public BTPos(E elt, int i) {
			element = elt;
			index = i;
		}
		public E element() { return element; }
		public int index() { return index; }
		public E setElement(E elt) {
			E temp = element;
			element = elt;
			return temp;
		}
	}
	
	/** default constructor */
	public ArrayListCompleteBinaryTree() {
		T = new ArrayIndexList<BTPos<E>>();
		T.add(0,null); // the location at rank 0 is deliberately empty
	}
	
	/** Returns the number of (internal and external) nodes. */
	public int size() { return T.size() -1; }
	
	/** Returns whether the tree is empty. */
	public boolean isEmpty() { return (size() == 0); }
	
	/** Returns whether v is an internal node. */
	public boolean isInternal(Position<E> v) throws InvalidPositionException {
		return hasLeft(v);	// if v has a right child it will have a left child
	}
	
	/** Returns whether v is an external node. */
	public boolean isExternal(Position<E> v) throws InvalidPositionException {
		return !isInternal(v);
	}
	
	/** Returns whether v is the root node. */
	public boolean isRoot(Position<E> v) throws InvalidPositionException {
		BTPos<E> vv = checkPosition(v);
		return vv.index() == 1;
	}
	
	/** Returns whether v has a left child. */
	public boolean hasLeft(Position<E> v) throws InvalidPositionException {
		BTPos<E> vv = checkPosition(v);
		return 2*vv.index() <= size();
	}
	
	/** Returns whether v has a right child. */
	public boolean hasRight(Position<E> v) throws InvalidPositionException {
		BTPos<E> vv = checkPosition(v);
		return 2*vv.index() + 1 <= size();
	}
	
	/** Returns the root of the tree. */
	public Position<E> root() throws EmptyTreeException {
		if (isEmpty()) throw new EmptyTreeException("Tree is empty");
		return T.get(1);
	}
	
	/** Returns the left child of v. */
	public Position<E> left(Position<E> v)
			throws InvalidPositionException, BoundaryViolationException {
		if(!hasLeft(v)) throw new BoundaryViolationException("No left child");
		BTPos<E> vv = checkPosition(v);
		return T.get(2*vv.index());
	}
	
	/** Returns the right child of v. */
	public Position<E> right(Position<E> v)
			throws InvalidPositionException, BoundaryViolationException {
		if(!hasRight(v)) throw new BoundaryViolationException("No right child");
		BTPos<E> vv = checkPosition(v);
		return T.get(2*vv.index() + 1);
	}
	
	/** Returns the parent of v. */
	public Position<E> parent(Position<E> v)
			throws InvalidPositionException, BoundaryViolationException {
		if (isRoot(v)) throw new BoundaryViolationException("No parent");
		BTPos<E> vv = checkPosition(v);
		return T.get(vv.index()/2);
	}
	
	/** Replaces the element at v. */
	public E replace(Position<E> v, E o) throws InvalidPositionException {
		BTPos<E> vv = checkPosition(v);
		return vv.setElement(o);
	}
	
	/** Adds an element just after the last node (in a level numbering). */
	public Position<E> add(E e) {
		int i = size() + 1;
		BTPos<E> p = new BTPos<E>(e,i);
		T.add(i,p);
		return p;
	}
	
	/** Removes and returns the element at the last node. */
	public E remove() throws EmptyTreeException {
		if(isEmpty()) throw new EmptyTreeException("Tree is empty");
		return T.remove(size()).element();
	}
	
	/** Determines whether the given position is a valid node. */
	protected BTPos<E> checkPosition(Position<E> v)
			throws InvalidPositionException {
		if ( v == null || !( v instanceof BTPos))
			throw new InvalidPositionException("Position is invalid");
		return (BTPos<E>) v;
	}
}
