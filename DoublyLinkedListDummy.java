// Bryant Hernandez
// 10/09/2019

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
		DIntNode cursor = head;
			while( cursor.getNext().getNext() != null ) {
				cursor = cursor.getNext();
			}
		DIntNode newNode = new DIntNode( element, cursor, tail );
		cursor.setNext(newNode);
		tail.setPrev( newNode );
		
	 	// please denote( not analyze in detail ) the time complexity of your method in Big-O and put the complexity in the method comment
	} // end addEnd
	
	// method to remove the first actual node( i.e. the node that the dummy head points to )
	public void removeFromHead() {
		head.setNext(head.getNext().getNext());
		head.getNext().setPrev(head);
		// please denote( not analyze in detail ) the time complexity of your method in Big-O and put the complexity in the method comment
	} // end removeFromHead
	
	// method to convert the list to a string
	public String toString() {
		// should return a String with two lines where the first line lists all the nodes starting from the first node, and the second line
		// lists all the nodes starting from the last node
		String s = "(Forward)  ";
		for( DIntNode cursor = head.getNext(); cursor.getNext() != null; cursor = cursor.getNext() ) {
			if( cursor.getNext().getNext() == null )
				s = s + cursor.getData();
			else
				s = s + cursor.getData() + "<->";
		} // end forwards for
		
		s = s + "\n(Backward) ";
		for( DIntNode cursor = tail.getPrev(); cursor.getPrev() != null; cursor = cursor.getPrev()) {
			if( cursor.getPrev().getPrev() == null )
				s = s + cursor.getData();
			else
				s = s + cursor.getData() + "<->";
		} // end backwards for
		
		return s;
	} // end toString
	
	// method to compute the number of times that the given value e occurs in nodes in this linked list
	public int countOccurrence( int e ) {
		// create counter variable
		int cnt = 0;
		for( DIntNode cursor = head.getNext(); cursor.getNext() != null; cursor = cursor.getNext()) {
			if( cursor.getData() == e )
				cnt++;
		} // end for
		// if no node in this list contains data e, return 0
		return cnt;
		// please denote( not analyze in detail ) the time complexity of your method in Big-O and put the complexity in the method comment
	} // end countOccurrence
	
	// method to remove all the nodes that contain element e from the list
	public boolean removeAll( int e ) {
		boolean ra = false;
		for( DIntNode cursor = head.getNext(); cursor.getNext() != null; cursor = cursor.getNext()) {
			if( cursor.getData() == e ) {
				cursor.getNext().setPrev(cursor.getPrev());
				cursor.getPrev().setNext(cursor.getNext());
				ra = true;
			} // end if
		} // end for
		return ra;
		// please denote( not analyze in detail ) the time complexity of your method in Big-O and put the complexity in the method comment
	} // end removeAll
	
	// method to extract a sublist of this list
	public DoublyLinkedListDummy subList( int beginIdx, int endIdx ) {
		DoublyLinkedListDummy newlist = new DoublyLinkedListDummy();
		
		// count the number of elements in the list
		int length = 0;
		for( DIntNode cursor = head.getNext(); cursor.getNext() != null; cursor = cursor.getNext()) {
			length++;
		} // end for
		
		// preconditions
		if( (beginIdx < 0) || (beginIdx > length) || (beginIdx > endIdx) )
			return null;
		else {
			// returns a new doublylinkedlist which copies the portion of this list between the specified beginIdx, inclusive, and endIdx exclusive
			int index = 0;
			for( DIntNode cursor = head.getNext(); cursor.getNext() != null; cursor = cursor.getNext()) {
				if( (index >= beginIdx) && (index < endIdx) ) {
					newlist.addEnd(cursor.getData());
				} // end if
				index++;
			} // end for
		} // end else
		return newlist;
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
		System.out.println("Creating a new doubly linked list and adding two nodes, 74 and 85...");
		list1.addEnd(74);
		list1.addEnd(85);
		
		// test toString
		System.out.println(list1.toString());
		
		// test getters and setters
		System.out.println("\nTesting getters and setters..." + 
							"\nSetting 1st node (node dummy head points to) to 23 and last node (node that points to dummy tail) to 78");
			list1.getHead().getNext().setData(23);
			list1.getTail().getPrev().setData(78);
			
				
		// print list1
		System.out.println(list1.toString());
		
		// add more nodes to the list
		list1.addEnd(98);
		list1.addEnd(44);
		list1.addEnd(98);
		System.out.println("\nAdding 98 and 44 to the list...\n" + list1.toString());
		
		// test removeFromHead
		list1.removeFromHead();
		System.out.println("\nTesting removeFromHead, should remove 23 from the list...\n" + list1.toString());
		
		// test countOccurrence on 98
		System.out.println("\nTesting countOccurrence, searching for 98...\n" + 
							"98 was found " + list1.countOccurrence(98) + " times in the list.");
		
		// testing removeAll on 98
		System.out.println("\nTesting removeAll, removing all 98's...");
		list1.removeAll(98);
		System.out.println(list1.toString());
		
		// create new list with 7 elements
		System.out.println("\nCreating a new doubly linked list and adding 7 elements...");
		DoublyLinkedListDummy list2 = new DoublyLinkedListDummy();
		list2.addEnd(77);
		list2.addEnd(84);
		list2.addEnd(11);
		list2.addEnd(26);
		list2.addEnd(86);
		list2.addEnd(94);
		list2.addEnd(36);
		System.out.println(list2.toString());
		
		// testing subList
		System.out.println("\nTesting subList and printing a sublist starting at index 0 to index 4...");
		System.out.println(list2.subList(0, 4).toString());
		
	} // end main
	
} // end class