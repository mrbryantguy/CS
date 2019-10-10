package Lab7;

public class DoublyLinkedListDummy {

	// instance variables
	// head & tail should be a dummy node instead of a null reference
	private DIntNode head = new DIntNode();
	private DIntNode tail = new DIntNode();
	// do not add any new instance variables
	
	// getter and setter methods for head and tail of DoublyLinkedList
	public DIntNode getHead() {
		return head;
	}
	public DIntNode getTail() {
		return tail;
	}
	public void setHead( DIntNode node ) {
		head = node;
	}
	public void setTail( DIntNode node ) {
		tail = node;
	}
	
	// no argument constructor which creates the dummy head and tail and link them together
	public DoublyLinkedListDummy() {
		head.setNext(tail);
		tail.setPrev(head);
	} // end constructor
	
	// method to add an element from the end of the list
	public void addEnd( int element ) {
		if( head == null )
			head = new DIntNode( element );
		else {
			DIntNode cursor = head;
			while( cursor.getNext() != null ) {
				cursor = cursor.getNext();
			}
			tail = new DIntNode( element, cursor, null );
			cursor.setNext(tail);
		} // end else
		
	 	// please denote( not analyze in detail ) the time complexity of your method in Big-O and put the complexity in the method comment
	} // end addEnd
	
	// method to remove the first actual node( i.e. the node that the dummy head points to )
	public void removeFromHead() {
		// please denote( not analyze in detail ) the time complexity of your method in Big-O and put the complexity in the method comment
	} // end removeFromHead
	
	/** public String toString() {
		String s = "";
		
		for ( IntNode i = this; i!= null; i = i.link )  {
			if (i.link == null)
				s = s + i.data;
			else
				s = s + i.data + "->";
		} // end for
		
		return s;
	} // end toString
	*/
	
	// method to convert the list to a string
	public String toString() {
		// should return a String with two lines where the first line lists all the nodes starting from the first node, and the second line
		// lists all the nodes starting from the last node
		String s = "(Forward) ";
		for( DIntNode cursor = head; cursor != null; cursor = cursor.getNext() ) {
			if( cursor.getNext() == null )
				s = s + cursor.getData();
			else
				s = s + cursor.getData() + "<->";
		} // end forwards for
		
		s = s + "\n(Backward) ";
		for( DIntNode cursor = tail; cursor != null; cursor = cursor.getPrev() ) {
			if( cursor.getPrev() == null)
				s = s + cursor.getData();
			else
				s = s + cursor.getData() + "<->";
		} // end backwards for
		
		return s;
	} // end toString
	
	// method to compute the number of times that the given value e occurs in nodes in this linked list
	public int countOccurrence( int e ) {
		// method will count the times that e occurs in this DoublyLinkedList
		// if no node in this list contains data e, return 0
		// please denote( not analyze in detail ) the time complexity of your method in Big-O and put the complexity in the method comment
	} // end countOccurrence
	
	// method to remove all the nodes that contain element e from the list
	public boolean removeAll( int e ) {
		// please denote( not analyze in detail ) the time complexity of your method in Big-O and put the complexity in the method comment
		
	} // end removeAll
	
	// method to extract a sublist of this list
	public DoublyLinkedListDummy subList( int beginIdx, int endIdx ) {
		
		// precondition
		//beginIdx is no less than 0
		//beginIdx is no greater than the size of this list
		//beginIdx is no greater than endIdx
		// returns a new doublylinkedlist which copies the portion of this list between the specified beginIdx, inclusive, and endIdx exclusive
		// please denote( not analyze in detail ) the time complexity of your method in Big-O and put the complexity in the method comment
		
	} // end subList
	
	//
	public void printStatistics() {
		
	} // end printStatistics
	
	// test cases to thoroughly test your code
	public static void main( String args[] ) {
		
		// test no argument
		DoublyLinkedListDummy list1 = new DoublyLinkedListDummy();
		
		// test addEnd
		list1.addEnd(74);
		list1.addEnd(85);
		
		// test toString
		System.out.println(list1.toString());
		
		// test getters and setters
		
	} // end main
	
} // end class