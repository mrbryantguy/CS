// CS 271           Lab 4
// Program Name:	lab4.c
// Author:		    Bryant Hernandez
// Date:            09/26/2019
// Purpose:         Create different functions for searching, sorting, and printing arrays

#include <stdio.h>
#include <math.h>
#include "lab4.h"

    // linear search
    int linearSearch( int array[ ], int arraySize, int key ){
        int index;
        
        for( index = 0; index < arraySize; index++ ){
            // if key is found in the array, return the index
            if( key == array[index] )
                return index;
        } // end for
        
        // if not found, return -1
        return -1;
    } // end linear search
    
    // binary search
    int binarySearch( int array[ ], int arraySize, int key ){
        int start = 0;
        int end = arraySize;
        int middle;
        
        while( start <= end ){
            // set middle
            middle = ( start + end ) / 2;
            
            // if key found in array, return index
            if( array[middle] == key )
                return middle;
            
            // if key is smaller than middle, set end to middle - 1
            if ( key < array[middle] )
                end = middle - 1;
            // if not set start to middle = 1
            else
                start = middle + 1;
        } // end while
        
    } // end binarySearch
    
    void printIntArray ( int array[ ], int arraySize ){
        // print the elements of the array, right-justified using a field width of 5
        for( index = 0; index < arraySize; i++ )
            printf("%5d", array[index] );
        
        // print 10 elements per line (last may not have 10)
        if( (index % 10) == 0 )
            printf("\n");
    } // end printIntArray
    
    void bubbleSort( int array[ ], int arraySize ){
        
        for( index = 1; index <= n-1; n++ ){
            boolean sorted = true;
            int j;
            
            for( j = 0; j <= n-1-index; j++ ){
                int temp;
                
                if( array[j] > array[j+1] ){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    sorted = false;
                } // end if
                
            } // end for
            
            // terminate the i loop if sorted is still true
            if( sorted )
                break;
        } // end for
        
    } // end bubbleSort
