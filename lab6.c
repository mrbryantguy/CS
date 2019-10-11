// CS 271           Lab 6
// Program Name:	lab6.c
// Author:		    Bryant Hernandez
// Date:            10/10/2019
// Purpose:         Tester program for functions written in 
//                  strFunctions.c

#include <stdio.h>
#include "strFunctions.h"

// main function begins execution
int main( void ){
    
    // create char arrays to test functions
    char upperCase[25]; char lowerCase[25];
    char sentence1[] = "The symbol for Intel is INTC.";
    char sentence2[] = "The symb234ol for In@@36tel is I#7NTC.";
    char sentence3[] = "abck123@XY";
    
    printf("\nTesting the splitAlpha function...");
    splitAlpha(sentence1, lowerCase, upperCase);
    splitAlpha(sentence2, lowerCase, upperCase);
    
    printf("\nTesting the printSequences function...");
    printSequences( sentence2 );
    
} // end main
