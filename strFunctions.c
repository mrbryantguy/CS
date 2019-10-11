// CS 271           	Lab 6
// Program Name:        strFunctions.c
// Author:		        Bryant Hernandez
// Date:            	10/10/2019
// Purpose:         	n

#include <stdio.h>
#include "strFunctions.h"

    void splitAlpha( const char * original, char * lower, char * upper ){
        
        // instance variables for lower and upper
        int cntLower = 0;
        int cntUpper = 0;
        
        // loop that checks every char until it reaches a null character
        for( int i = 0; original[i] != '\0'; i++ ){
            
            // check if character is a letter
            if( isalpha(original[i]) ){
                // check if char is a lowercase letter
                if( islower(original[i]) ){
                    lower[cntLower] = original[i];
                    cntLower++;
                } // end if
                
                // check if char is uppercase letter
                if( isupper(original[i]) ){
                    upper[cntUpper] = original[i];
                    cntUpper++;
                } // end if
            } // end if
            
        } // end for
        
        // print lowercase string
        printf("\nLowercase characters found in the string: ");
        for( int i = 0; i < cntLower; i++ ){
            prinf("%c", lower[i]);
        } // end for
        
        // print uppercase string
        printf("\nUppercase characters found in the string: ");
        for( int i = 0; i < cntUpper; i++ ){
            prinf("%c", upper[i]);
        } // end for
        
        // print original string
        printf("\nOriginal string: ");
        for( int i = 0; original[i] != '\0'; i++ ){
            printf("%c", original[i]);
        } // end for
        
    } // end splitAlpha
    
    void printSequences( const char * text ){
        
        int reset = 1;
        for(int i = 0; text[i] != '\0' ; i++){
            if(text[i]+1 == text[i+1] || text[i]-1 == text[i-1]){
                printf("%c", text[i] );
                reset++;
            }
            if( ( text[i]+1 != text[i+1] && text[i]-1 != text[i-1] ) && ( reset % 2 == 0 )){
                printf("\n");
                reset = 1;
            } // end if
        } // end for
        
    } // end printSequences
