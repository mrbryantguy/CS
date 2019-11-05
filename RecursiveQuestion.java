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
	
	public static void main( String args[] ) {
		
		// test FibBinaryRecursive
		System.out.println("Printing the first 20 Fibonacci numbers.\n");
		
		for( int i = 0; i < 20; i++ ) {
			System.out.println(i + ": " + FibBinaryRecursive(i));
		} // end for
		
		//
		
	} // end main
	
} // end RecursiveQuestion