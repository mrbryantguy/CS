// Bryant Hernandez
// CS272 - Lab10
// 11/5/2019

public class RecursiveQuestion {

	// Fibonacci numbers
	public static int FibBinaryRecursive( int k ) {
		if( k == 0 )
			return 0;
		else if( k == 1 )
			return 1;
		else
			return FibBinaryRecursive( k-1 ) + FibBinaryRecursive( k-2 );
	} // end FibBinaryRecursive
	
	// HanoiTower
		/* This project uses the Towers class from
		 * Chapter 3’s Programming Project 12 on
		 * page 171. For the project, write a recursive 
		 * method that computes and prints a solution to the xxx
		 * Towers of Hanoi game. The method should meet this specification:
				
				public static void Hanoi(
				Towers t,
				int n,
				int start,
				int target,
				int spare
				);
				
		Precondition: start, target, and spare are three different peg numbers of the game, and n is non-negative. 
		Also, the n smallest rings currently are on	the top of the start peg. 
		Postcondition: The method has activated a sequence of moves for the tower t, so	that the total effect of these moves is to
		shift the top n rings from the start peg to	the target peg, using spare as the extra peg. 
		None of the other rings has been disturbed. 
		Each time a move is made, a message describing the move is printed.	
		Your solution should have a simple stopping case:
		When n is zero, there is no work to do. 
		When n is more than zero, use a recursive call to move n–1 rings from the start peg to the spare peg. 
		Then call the move method to move one ring from the start peg to the target peg. 
		Finally, make another recursive	call to move n–1 rings from the spare peg to the target peg. */
	
	// showCallLevel method
	public static String showCallLevel( int L, int curl ) {
		String ans = "";
		if( L == 0 || curl == 0 )
			return "";
		// indentation
		for( int i = 0; i < curl; i++ )
			ans = ans + "  ";
		// x calls
		if( curl <= L )
			return "\n" + ans + "  This was written by call number " + curl + "x." + showCallLevel( L, curl + 1 );
		// y calls
		if( L <= curl )
			return "\n" + ans + "This was written by call number " + L + "y." + showCallLevel( L-1, curl - 1 );
		return ans;
	} // end showCallLevel
	
	// prints value of n as a binary number
	public static void BinaryPrint( int n ) {
		// n is non-negative (precondition)
		if( n >= 0 ) {
			// if n is zero, zero is printed
			if( n == 0 )
				System.out.print(0);
			// otherwise, no leading zeros are printed in the output
			else {
				if( n > 1 )
					BinaryPrint( n / 2 );
				System.out.print( n % 2 );
			} // end else
		} // end precondition
	} // end BinaryPrint
	
	// pattern function (two recursive calls)
	// one parameter indicates the indentation of leftmost line in the pattern
	// another parameter indicates number of stars in the longest line
	public static void pattern( int indent, int numStars ){
		if ( numStars == 0 ) 
			return;
		// first half
		pattern( indent, numStars / 2 );
		for( int i = 0; i < indent; i++ ) 
			System.out.print("  ");
		for( int i = 0; i < numStars; i++ ) 
			System.out.print("* ");
		// newline
		System.out.println();
		// second half
		pattern( indent + numStars / 2, numStars / 2 );
	} // end pattern
	
	// main method
	public static void main( String args[] ) {
		
		// test FibBinaryRecursive
		System.out.println("Printing Fibonacci numbers 0 - 19...");
		
		for( int i = 0; i < 20; i++ ) {
			System.out.println( "F_" + i + "= " + FibBinaryRecursive(i) );
		} // end for
		
		// test showCallLevel
		System.out.println("\nTesting showCallLevel...");
		System.out.println(showCallLevel( 4, 1 ));
		
		// test BinaryPrint
		System.out.println("\nTesting BinaryPrint...");
		System.out.print("n=0 Output: "); BinaryPrint(0);
		System.out.print("\nn=4 Output: "); BinaryPrint(4);
		System.out.print("\nn=27 Output: "); BinaryPrint(27);
		
		// test pattern
		System.out.println("\n\nTesting pattern method...");
		pattern(0, 8);
		
	} // end main
	
} // end RecursiveQuestion