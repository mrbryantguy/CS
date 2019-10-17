// Bryant Hernandez
// CS 272 - Lab8
// 10/16/2019

import java.util.EmptyStackException;
public class LinkStack<E> implements StackInterface<E>{

	// instance variables
	private SNode<E> node;
	
	public E pop() {
		// report error if stack is empty
		if( node == null )
			throw new EmptyStackException();
		// get reference to top element and remove it from the stack
		node = node.getLink();
		return node.getData();
	} // end pop
	
	public void push(E e) {
		
	} // end push
	
	public E top() {
		
	} // end top
	
	public int size() {
		
	} // end size
	
	public boolean isEmpty() {
		
	} // end isEmpty
	
} // end LinkStack