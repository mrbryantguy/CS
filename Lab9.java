package Lab9;

import java.util.*;
import java.io.*;

public class Lab9 {
	
	 private void permute(String str, int l, int r) {
	 	if (l == r) 
	         System.out.println(str); 
	     else
	     { 
	         for (int i = l; i <= r; i++) 
	         { 
	             str = swap(str,l,i); 
	             permute(str, l+1, r); 
	             str = swap(str,l,i); 
	         } 
	     } 
	 } // end permute
	 
	public static int factorial(int n) {
		int fact = 1;
		for(int i = 1; i <= n; i++) {
			fact = fact * i;
		} // end for
		return fact;
	} // end factorial
	 
	public String swap(String a, int i, int j) { 
		char temp; 
	    char[] charArray = a.toCharArray(); 
	    temp = charArray[i] ; 
	    charArray[i] = charArray[j]; 
	    charArray[j] = temp; 
	    return String.valueOf(charArray); 
	} // end swap 
	
	public static void main (String args[]) throws IOException{
		String input;
		int cnt = 0;
		Scanner fileScan = new Scanner(new File("scrabble3.txt"));
		
		// open the 3-letter word file and input the strings into an array
		String words3[] = new String[1065];
		while(fileScan.hasNext()) {
			
			input = fileScan.nextLine();
			// insert line into array
			words3[cnt] = input;
			// increment count
			cnt++;			
		} // end while
		
		Scanner fileScan2 = new Scanner(new File("scrabble4.txt"));
		cnt = 0;
		// open the 4-letter word file and input the strings into an array
		String words4[] = new String[3996];
		while(fileScan2.hasNext()) {
			
			input = fileScan2.nextLine();
			// insert line into array
			words4[cnt] = input;
			// increment count
			cnt++;			
		} // end while
		
		// input 3 letters from the user
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter 3 letters with no spaces in between: ");
		String user = scan.nextLine();
		
		// calculate the number of permutations possible with 3 letters, print this number
		int factorial = factorial(user.length());
		System.out.printf("There are %d 3-letter permutations. They are:\n", factorial);
		// construct all 3-letter permutations that can be made with the users letters, it is recommended that oyu store these strings in an array
		// print the permutations
		
	} // end main	
} // end class