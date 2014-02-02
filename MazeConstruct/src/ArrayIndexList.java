/** Realization of an indexed list by means of an array, which is doubled
 *  when the size of the indexed list exceeds the capacity of the array.
 *  Data Structures and Algorithms page 244
 */

public class ArrayIndexList<E> {
	private E[] A;				// array storing the elements of the indexed list
	private int capacity = 10;	// initial length of array A
	private int size = 0;		// number of elements stored in the indexed list
	/** Creates the indexed list with initial capacity 10. */
	public ArrayIndexList() {
		A = (E[]) new Object[capacity];
	}
	/** Inserts an element at the given index. */
	public void add(int r, E e)
		throws IndexOutOfBoundsException {
		checkIndex(r,size() + 1);
		if(size == capacity) {	// an overflow
			capacity *= 2;
			E[] B = (E[]) new Object[capacity];
			for (int i = 0; i < size; i++)
				B[i] = A[i];
			A = B;
		}
		for (int i = size -1; i >= r; i--)	// shift elements up
			A[i+1] = A[i];
		A[r] = e;
		size++;
	}
	/** Removes and returns the element stored at the given index. 
	 * 	Shifts all elements down in list	*/
	public E remove(int r)
		throws IndexOutOfBoundsException{
		checkIndex(r,size());
		E temp = A[r];
		for (int i=r; i<size-1; i++)	// shift elements down
			A[i] = A[i+1];
		size--;
		return temp;
	}
	/** checks whether an index r is in the range [0,n-1]. */
	public void checkIndex(int r, int size) 
		throws IndexOutOfBoundsException{
		if (r >= size)
			throw new IndexOutOfBoundsException();
	}
	/** returns the number of elements stored */
	public int size() { return size; }
	/** returns the element stored at index r */
	
	public E get(int r){
		return A[r];
	}
}
