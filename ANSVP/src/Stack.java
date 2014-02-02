/**
 * Interface for a stack: a collection of objects that
 * are inserted and removed according to the last-in
 * first- out principle. This interface includes
 * the main methods of java.utill.Stack.
 * 
 * @author Roberto Tamassia
 * @author Michael Goodrich
 * @see EmpthStackException
 */
public interface Stack<E> {
	/**	 
 	* @return the number of elements in the stack.
 	*/
public int size();
	/**
	 * @return true if the stack is empty, false otherwise.
	 */
public boolean isEmpty();
	/**
	 * Inspect element at top.
	 * @return top element in stack.
	 * @exception EmptyStackException if the stack is empty.
	 */
public E top()
	throws EmptyStackException;
	/**
	 * Insert an element at top of stack.
	 * @param element to be inserted
	 */
public void push (E element);
	/**
	 * Remove the top element of the stack
	 * @return element removed.
	 * @exception EmptyStackException
	 */
public E pop()
	throws EmptyStackException;
}
