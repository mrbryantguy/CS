// CS271 - Lab 8
// Program Name:    wordFun.cpp
// Author:          Bryant Hernandez
// Date:            10/30/2019
// Purpose:         f

#include <string>
#include <iostream>
#include <iomanip>

using namespace std;

int main( ){

    // instance variables
    int cnt = 0;
    char letter;
    
    // create an array of 25 strings
    string words [25];
    
    // input the first word
    cout << "Enter a word: (press Ctrl-D to quit)";
    cin >> words[cnt];
    cnt++;
    
    // use a sentinel loop that reads from cin until the array is full or the end of input is reached( user presses Ctrl-D )
    while( !cin.eof() && cnt < 25 ){
        cout << "Enter a word: (press Ctrl-D to quit)";
        cin >> words[cnt];
        cnt++;
    } // end while
    
    // print newline
    cout << endl << endl;
    
    // use a for loop to move through the array( don't travel farther than the last array element that was input
    for( int i = 0; i < cnt; i++ ){
        
        // print one array element followed by a newline
        cout << words[i] << endl;
        
        // use a for loop to move through the characters of the string you just printed followed by a newline
        for( int j = 0; j < words[i].length(); j++ ){
            letter = words[i][j];
            cout << letter << endl;
        } // end nested for
        
        // print newline
        cout << endl;
        
    } // end for
    
} // end main
