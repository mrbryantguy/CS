// Bryant Hernandez
// CS 272 - Lab8
// 10/16/2019

public interface StackInterface<E> {

	/*	Get the reference to the top element and remove it from the stack
	 *	Report error if the stack is empty
	 *	@return top element */
	public E pop();
	
	/* Insert an object to the stack */
	public void push(E e);
	
	/*	Return a reference to the top element without removing it
	 *	Report error if the stack is empty
	 *	@return top element */
	 public E top();
	 
	 /*	@return the number of elements in the stack */
	 public int size();
	 
	 /*	@return true if the stack is empty and false otherwise */
	 public boolean isEmpty();
	
}// end interface