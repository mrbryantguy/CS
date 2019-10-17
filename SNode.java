// Bryant Hernandez
// CS 272 - Lab8
// 10/16/2019

public class SNode<E>{
	
	// instance variables
	private E data;
	private SNode<E> link;
	
	// no argument constructor 
	public SNode(){ data = null; link = null; }
	
	// constructor with parameters
	public SNode( E _data, SNode<E> _link ) {
		data = _data;
		link = _link;
	} // end constructor
	
	// getters and setters
		public E getData() {
			return data;
		} // end getData
		public SNode<E> getLink() {
			return link;
		} // end getLink
		public void setData( E num ) {
			data = num;
		} // end setData
		public void setLink( SNode<E> next ) {
			link = next;
		} // end setLink
		
	// method to add node
	public void addNodeAfterThis( E newdata ) {
		link = new SNode( newdata, null );
	} // end add node
	
} // end class