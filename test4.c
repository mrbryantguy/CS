// CS 271           Lab 4
// Program Name:	test4.c
// Author:		    Bryant Hernandez
// Date:            09/26/2019
// Purpose:         Tester program for functions written in lab4.c
#include <stdio.h>
#include <time.h>

// main function begins execution
int main( void ){
    
    // Declare an array of 100 integers
    int numbers [100];
    
    // Seed the random number generator with the time function
    srand(time(NULL));
    
    // Fill the array with random integers between 1 and 1000
    int i;
    for( i = 0; i < 100; i++ ){
        numbers[i] = rand() % 1000 + 1;
    } // end for
    
    // Print the array using the printIntArray function
    printIntArray( numbers, 100 );
    
    // Using linearSearch to search for 30, 86, and 87
    int index = linearSearch( numbers, 100, 30 );
    
        if( index == -1 )
            printf( "30 was not found in the array.\n" );
        else
            printf( "30 was found in the array at index " + index + "." );
    
    int index = linearSearch( numbers, 100, 86 );
    
        if( index == -1 )
            printf( "86 was not found in the array.\n" );
        else
            printf( "86 was found in the array at index " + index + "." );
    
    int index = linearSearch( numbers, 100, 87 );
    
        if( index == -1 )
            printf( "87 was not found in the array.\n" );
        else
            printf( "87 was found in the array at index " + index + "." );
    
    // Use bubble sort to sort the array
    bubbleSort( numbers, 100 );
    
    // Print the array using the printIntArray function
    printIntArray( numbers, 100 );
    
    // Use binarySearch to search for 11, 28, 74, and 99
    int index = binarySearch( numbers, 100, 11 );
    
        if( index == -1 )
            printf( "11 was not found in the array.\n" );
        else
            printf( "11 was found in the array at index " + index + "." );
    
    int index = binarySearch( numbers, 100, 28 );
    
        if( index == -1 )
            printf( "28 was not found in the array.\n" );
        else
            printf( "28 was found in the array at index " + index + "." );
        
    int index = binarySearch( numbers, 100, 74 );
    
        if( index == -1 )
            printf( "74 was not found in the array.\n" );
        else
            printf( "74 was found in the array at index " + index + "." );
        
    int index = binarySearch( numbers, 100, 99 );
    
        if( index == -1 )
            printf( "99 was not found in the array.\n" );
        else
            printf( "99 was found in the array at index " + index + "." );
    
} // end main
