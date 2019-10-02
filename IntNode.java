// 10/1/2019
// CS272

/** Represents a linked list.
 * @author Bryant Hernandez
 * @version 2.0
 */
public class IntNode {

	// instance variables
	private int data;
	private IntNode link;
	
	// no-argument constructor
	public IntNode() {
		data = 0;
		link = null;
	} // end no-argument constructor
	
	/** Creates an IntNode linked list with given parameters
	 * 
	 * @param _data The nodes integer value
	 * @param _node The nodes link
	 */
	public IntNode( int _data, IntNode _node ) {
		data = _data;
		link = _node;
	} // end constructor
	
	// get and set methods: 
		/** Get the nodes value
		 * @return Integer value of the node
		 */
		public int getNode() {
			return data;
		}
		/** Set the nodes value
		 * @param _data Integer which will be set as the nodes data
		 */
		public void setNode(int _data ) {
			data = _data;
		}
	
		/** Get the nodes link
		 * @return Link of the current node
		 */
		public IntNode getLink() {
			return link;
		}
		/** Set the nodes link
		 * @param _node Link which will be set as the link of the current node
		 */
		public void setLink( IntNode _node ) {
			link = _node;
		}
	
	/** Creates string for the linked list starting from the node that activates
	 * 
	 * @return String representation of the linked list
	 */
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
	
	/** Method to add a node after the current node
	 * 
	 * @param newdata Integer which will be added to a new node on the linked list
	 */
	public void addNodeAfterThis( int newdata ) {
		link = new IntNode( newdata, link );
	} // end add node
	
	// Method to remove the node after the current node
	public void removeNodeAfterThis() {
		if ( link != null ) {
			link = link.link;
		} // end precondition
	} // end remove node
	
	/** Method to get the number of nodes in the list starting from a given node head
	 * 
	 * @param head Determines where method will begin counting
	 * @return Integer value representing the length of linked list
	 */
	public static int listLength( IntNode head ) {
		int answer = 0;
		for (IntNode cursor = head; cursor != null; cursor = cursor.link) {
			answer++;
		}
		return answer;
	} // end node length
	
	/** Method to search whether a linked list contains a given value data
	 * 
	 * @param head Determines where the method will begin searching
	 * @param data Integer value being searched for
	 * @return True if data does exist in list, false if otherwise
	 */
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
	
	// method to calculate the number of even elements in the linked list starting from the given head
	public static int listEvenNumber( IntNode head ) {
		if( head == null )
			return 0;
		
		int eCnt = 0;
		for( IntNode cursor = head; cursor != null; cursor = cursor.link ) {
			if( cursor.data % 2 == 0 )
				eCnt++;
		} // end for
		return eCnt;		
	} // end listEvenNumber
	
	// method to add the given newdata to the end of the linked list that starts from the current node
	public void addToEnd( int newdata ) {		
		if( link == null )
			link = new IntNode( newdata, null );
		else {
			IntNode current = link;
			while( current.link != null ) {
				current = current.link;
			} // end while
			IntNode newNode = new IntNode( newdata, null );
			current.link = newNode;
		} // end else
	} // end addToEnd
	
	// method to calculate the summation of elements in the last num nodes in a given linked list
	public static int sumLast( IntNode head, int num ) {
		
		int sum = 0;
		// when num is bigger than the number of nodes in the list, it should return the summation of elements in all the nodes
		IntNode cursor = head;
		if( num > listLength(head) )
			num = listLength(head);
		for( int i = 1; i <= num; i++ ) {
			if( cursor != null ) {
				sum = sum + cursor.data;
				cursor = cursor.link;
			} // end if
		} // end for
		return sum;
		
	} // end sumLast
	
	// copy part of a given linked list
	public static IntNode copyOdd( IntNode head ) {
		
		// if head is not null, method should copy all the odd elements in the linked list starting from
		// the given head, create a new linked list with all these odd numbers, and return the linked list with the new head
		if( head != null ) {
			IntNode odd = new IntNode();
			for( IntNode cursor = head; cursor != null; cursor = cursor.link ) {
				if( (cursor.data % 2) != 0 ) {
					if( odd.data == 0 )
						odd.setNode(cursor.data);
					else
						odd.addNodeAfterThis(cursor.data);
				} // end if
			} // end for
			return odd;
		} // end if
		return null;
	} // end copyOdd
	
	// method to remove ALL the nodes that have the data value e from the linked list starting from the given head
	// method should return the linked list with the new head
	public static IntNode removeAll( IntNode head, int e ) {
		
		if( head != null ) {
			IntNode newInNo = new IntNode();
			for( IntNode cursor = head; cursor != null; cursor = cursor.link ) {
				if( cursor.data != e ) {
					if( newInNo.data == 0 )
						newInNo.setNode( cursor.data );
				    else
				    	newInNo.addNodeAfterThis( cursor.data );
				} // end if
			} // end for
			return newInNo;
		} // end if
		
		return null;		
	} // end removeAll
	
	// method to reverse a linked list
	public static IntNode reverse( IntNode head ) {
		
		// method should return the linked list with the new head
		if( head != null ) {
			IntNode prev = null;
			IntNode cursor = head;
			IntNode link = null;
			while( cursor != null ) {
				link = cursor.link;
				cursor.link = prev;
				prev = cursor;
				cursor = link;
			}
			head = prev;
			return head;
		} // end if
		
		return null;	
		
	} // end reverse
	
	// method to test whether a linked list starting from the given head is cyclic or acyclic
	public static boolean hasCycle( IntNode head ) {
	
		for( IntNode cursor = head; cursor != null; cursor = cursor.link ) {
			// otherwise should return false if the list is acyclic
			if( cursor.link == null )
				return false;
		}
		// should return true if it is cyclic
		return true;
		
	} // end hadCycle
	
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
		
		// test listEvenNumber method
		System.out.println("\nTesting listEvenNumber method...");
		System.out.println(list1.toString());
		if( listEvenNumber(list1) < 2 )
			System.out.println("There is " + listEvenNumber(list1) + " even number in list1.");
		else
			System.out.println("There are " + listEvenNumber(list1) + " even numbers in list1.");

		System.out.println(list2.toString());
		if( listEvenNumber(list2) < 2 )
			System.out.println("There is " + listEvenNumber(list2) + " even number in list2.");
		else
			System.out.println("There are " + listEvenNumber(list2) + " even numbers in list2.");
		
		// test addToEnd
		System.out.println("\nTesting addToEnd on both list1 and list2...");
		list1.addToEnd( 88 );
		list2.addToEnd( 88 );
		System.out.println(list1.toString());
		System.out.println(list2.toString());
		
		// test sumLast
		System.out.println("\nTesting sumLast on both list1 and list2...");
		System.out.println(list1.toString());
		System.out.println("The sum of list1 is " + sumLast(list1, 7) + ".");
		System.out.println(list2.toString());
		System.out.println("The sum of list2 is " + sumLast(list2, 7) + ".");
		
		System.out.println("\nTesting sumLast with parameter of 2(only the first 2)...");
		System.out.println(list1.toString());
		System.out.println("The sum of list1 is " + sumLast(list1, 2) + ".");
		System.out.println(list2.toString());
		System.out.println("The sum of list2 is " + sumLast(list2, 2) + ".");
		
		// test copyOdd
		System.out.println("\nTesting copyOdd method...");
		System.out.println(list1.toString());
		System.out.println("The odd elements in list1 are " + copyOdd(list1).toString());
		System.out.println(list2.toString());
		System.out.println("The odd elements in list2 are " + copyOdd(list2).toString());
		
		// create new IntNode list
		IntNode list3 = new IntNode( 50, null );
		list3.addNodeAfterThis(14);
		list3.addNodeAfterThis(50);
		list3.addNodeAfterThis(35);
		list3.addNodeAfterThis(50);
		list3.addNodeAfterThis(76);
		
		// test removeAll
		System.out.println("\nlist3...");
		System.out.println(list3.toString());
		System.out.println("\nTesting removeAll on list3 with 50 as the int parameter...");
		System.out.println(removeAll(list3, 50).toString());
		
		// test reverse
		System.out.println("\nlist2...");
		System.out.println(list2.toString());
		System.out.println("\nTesting reverse on list2...");
		System.out.println(reverse(list2).toString());
		
		// test hasCycle
		System.out.println("\nTesting hasCycle on list1 and list3...");
		System.out.println(list1.toString());
		if( hasCycle(list1) )
			System.out.println("list1 is cyclic.");
		else
			System.out.println("list1 is acyclic.");
		
		System.out.println(list3.toString());
		if( hasCycle(list3) )
			System.out.println("list3 is cyclic.");
		else
			System.out.println("list3 is acyclic.");
		
	} // end main
	
} // end class