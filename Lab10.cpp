#include "Term.h"
using namespace std;

int main() {

    Term r;
    cout << "Input a polynomial in the form of 2x^2:";
    cin >> r;
    Term r2;
    cout << "Input another polynomial:";
    cin >> r2;
    
    cout << endl << "Adding both polynomials..." << endl
         << r << " + " << r2 << " = " << r + r2 << endl;
         
    cout << endl << "Subtracting both polynomials..." << endl
         << r << " - " << r2 << " = " << r - r2 << endl;
         
    cout << endl << "Multiplying both polynomials..." << endl
         << r << " * " << r2 << " = " << r * r2 << endl;
         
    cout << endl << "Dividing both polynomials..." << endl
         << r << " / " << r2 << " = " << r / r2 << endl;
    
} // end main
