// CS 271           Lab 5
// Program Name:	lab5test.c
// Author:		    Bryant Hernandez
// Date:            10/3/2019
// Purpose:         Tester program for functions written in 
//                  lab5functions.c
#include <stdio.h>
#include <math.h>
#include "lab5functions.h"

// main function begins execution
int main( void ){
    
    // create array of size 10
    int s = 10;
    int num[ ] = {7, 4, 5, 9, 7, 12, 4, 8, 4, 5};
    
    // test duplicates
    printf("Testing the duplicates method...\n");
    printf("There are %d duplicates.\n", duplicates( num, s ));
    
    // create float array of size 10
    int f = 10;
    float fnum[ ] = {5.2, 6.3, 8.4, 9.1, 5.5, 4.1, 3.3, 7.4, 6.2, 10.0};
    
    // test highestTwo
    highestTwo( fnum, f );
    
    // create a two dimensional array
    int rows = 2;
    int columns = 5;
    double TwoDArray[2][5] = {5.2, 6.3, 8.4, 9.1, 5.5, 4.1, 3.3, 7.4, 6.2, 10.0};
    double sumA[columns];
    
    // test columnSums
    columnSums( rows, columns, TwoDArray, sumA );
    
} // end main
