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
		
		
		
	} // end showCallLevel
	
	// binary print function
	// prints value of n as a binary number
	public static int BinaryPrint( int n ) {
		
		// n is non-negative
		if( n >= 0 ) {
			// if n is zero, zero is printed
			if( n == 0 )
				return 0;
			// otherwise, no leading zeros are printed in the output
			else
				return(n % 2 + 10 * (BinaryPrint( n / 2 )));
		} // end if
		else return -1;
	} // end BinaryPrint
	
	public static void main( String args[] ) {
		
		// test FibBinaryRecursive
		System.out.println("Printing the first 20 Fibonacci numbers.\n");
		
		for( int i = 0; i < 20; i++ ) {
			System.out.println( i + ": " + FibBinaryRecursive(i) );
		} // end for
		
		// test BinaryPrint
		System.out.println("\nTesting BinaryPrint...");
		BinaryPrint(0);
		BinaryPrint(4);
		BinaryPrint(27);
		
	} // end main
	
} // end RecursiveQuestion