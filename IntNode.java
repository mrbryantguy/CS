// Bryant Hernandez
// 09/18/2019
// CS272

public class IntNode {

	// instance variables
	private int data;
	private IntNode link;
	
	// no-argument constructor
	public IntNode() {
		data = 0;
		link = null;
	} // end no-argument constructor
	
	// constructor w/ given
	public IntNode( int _data, IntNode _node ) {
		data = _data;
		link = _node;
	} // end constructor
	
	// get and set methods for: 
		// node value 
		public int getNode() {
			return data;
		}
		public void setNode(int _data ) {
			data = _data;
		}
	
		// node link
		public IntNode getLink() {
			return link;
		}
		public void setLink( IntNode _node ) {
			link = _node;
		}
	
	// toString method which returns a String for the linked list 
	// starting from the node that activates this method
	public String toString() {
		String s = "";
		
		for ( IntNode i = this; i!= null; i = i.link )  {
			if (i.link == null)
				s = s + i.data;
			else
				s = s + i.data + "->";
		} // end for
		
		return s;
	} // end toString
	
	// method to add a node after the current node
	public void addNodeAfterThis( int newdata ) {
		link = new IntNode( newdata, link );
	} // end add node
	
	// a method to remove the node after the current node
	public void removeNodeAfterThis() {
		if ( link != null ) {
			link = link.link;
		} // end precondition
	} // end remove node
	
	// method to get the number of nodes in the list starting from
	// a given node head
	public static int listLength( IntNode head ) {
		int answer = 0;
		for (IntNode cursor = head; cursor != null; cursor = cursor.link) {
			answer++;
		}
		return answer;
	} // end node length
	
	// method to search whether a linked list contains a given value data
	// returns true if data exists in the linked list starting w/ head
	// returns false otherwise
	public static boolean search( IntNode head, int data ) {
		boolean answer = false;
		if ( head != null ) {
			
			for(IntNode cursor = head; cursor != null; cursor = cursor.link) {
				if(cursor.data == data ) {
					answer = true;
					break;
				}
			} // end for
			
		} // end precondition
		return answer;
	} // end search
	
	// main method to test all methods
	public static void main ( String args[] ) {
		
		// test no-argument
		System.out.println("Testing no-argument constructor...");
		IntNode list1 = new IntNode(); 
		System.out.println(list1.toString());
		
		// test add
		System.out.println("Test add method on list1...");
		list1.addNodeAfterThis(51);
		list1.addNodeAfterThis(47);
		list1.addNodeAfterThis(68);
		System.out.println(list1.toString());
		
		// test toString on third node
		System.out.println("Testing toString on third node...");
		System.out.println(list1.link.link.toString());
		
		// test remove
		System.out.println("Testing remove on node after 47...");
		// move to 47
		list1.link.link.removeNodeAfterThis();
		System.out.println( list1.toString());
		
		// testing constructor
		System.out.println("\nTesting regular constructor and setting head node to 43...");
		IntNode list2 = new IntNode(43, null);
		System.out.println(list2.toString());
		
		// add nodes
		System.out.println("Adding nodes to list2...");
		list2.addNodeAfterThis(87);
		list2.addNodeAfterThis(18);
		list2.addNodeAfterThis(73);
		System.out.println(list2.toString());
		
		// test listLength
		System.out.println("There are " + listLength(list2) + " nodes in list2.\n");
		
		// test set and get for link
		System.out.println("Removing node after 73 using set method...");
			// removes node after 73 by GETting the link of the node after it and 
			// SETting it to be the current link
			list2.link.setLink(list2.link.link.getLink());
		System.out.println(list2.toString());
		
		// test listLength again
			System.out.println("There are " + listLength(list2) + " nodes in list2.\n");
		
		// testing set for node
		System.out.println("Changing third node to 86 using set method...");
			list2.link.link.setNode(86);
		System.out.println(list2.toString());
		
		
		// test search method
		System.out.println("\nSearching for 86 in list2 using search method...");
		if (search(list2, 86))
			System.out.println("86 was found in list2");
		else
			System.out.println("86 was NOT found in list2");
		
		// test search method
		System.out.println("\nSearching for 87 in list2 using search method...");
		if (search(list2, 87))
			System.out.println("87 was found in list2");
		else
			System.out.println("87 was NOT found in list2");
		
	} // end main
	
} // end class