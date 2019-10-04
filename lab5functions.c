// CS 271           	Lab 5
// Program Name:        lab5functions.c
// Author:		        Bryant Hernandez
// Date:            	10/3/2019
// Purpose:         	Create three functions to test an int array, a
//                      float array, and a two-dimensional array

#include <stdio.h>
#include <math.h>
#include "lab5functions.h"

    // duplicates method
    int duplicates( int nums[ ], int size ){
        int duplicates = 0;
        
        for( int i = 0; i < size; i++){
            
            for( int j = i + 1; j < size; j++ ){
                if( nums[i] == nums[j] ){
                    duplicates++;
                    break;
                } // end if
            } // end for
            
        } // end for
        return duplicates;
    } // end duplicates

    // highestTwo method
    void highestTwo( float fnums[ ], int fsize ){
        
        // instance variables
        float highest1 = 0;
        float highest2 = 0;
        float temp = 0;
        
        for( int i = 0; i < fsize; i++ ){
            
            // determine the two highest numbers in the array
            if( fnums[i] >= highest2 ){
                highest2 = fnums[i];
                
                // if second highest is larger than highest, swap elements
                if( highest2 >= highest1 ){
                    temp = highest1;
                    highest1 = highest2;
                    highest2 = temp;
                } // end if
            } // end if
        } // end for
        
        // print the highest two
        printf("\nThe highest number in the array is %14.2f", highest1);
        printf("\nThe SECOND highest number in the array is %7.2f\n", highest2);
        
    } // end highestTwo

    // columnSums method
    void columnSums( int rows, int columns, 
                     double array1[rows][columns], double array2[columns] ){
    // DO NOT CHANGE THE TWO-DIMENSINAL ARRAY
        
        // calculate the sum of the elements in each column of the two-dimensional array and store the sum in the corresponding element of the one-dimensional array
        for( int i = 0; i < rows; i++ ){
            array2[i] = 0.0;
            for( int j = 0; j < columns; j++ ){
                array2[i] = array2[i] + array1[i][j];
            } // end for
        } // end for
        
        // print out all arrays
        
        printf("\nArray1, Row 1: ");
        for( int i = 0; i < columns; i++ ){
            printf("%5.2lf", array1[0][i]);
        } // end for
        
        printf("\nArray1, Row 2: ");
        for( int i = 0; i < columns; i++ ){
            printf("%5.2lf", array1[1][i]);
        } // end for
        
        printf("\nSums:           ");
        for( int i = 0; i < columns; i++ ){
            printf("%5.2lf", array2[i]);
        } // end for
        
    } // end columnSums
