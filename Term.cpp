#include<stdexcept>
#include "Term.h"
using namespace std;

Term::Term ( int coef, int exp ){
    setCoefficient(coef);
    setExponent(exp);
} // end constructor

Term& Term::setCoefficient ( int coef ){
    coefficient = coef;
} // end setCoefficient

Term& Term::setExponent ( int exp ){
    exponent = exp;
} // end setExponent

int Term::getCoefficient ( ) const{
    return coefficient;
} // end getCoefficient

int Term::getExponent( ) const{
    return exponent;
} // end getExponent

Term Term::operator+ (const Term& t) const {
    Term answer;
    if(exponent == t.exponent){
        answer.setCoefficient(coefficient + t.coefficient);
        answer.setExponent(exponent);
    }else
        throw invalid_argument("Exponents are not equal.");
    
    return answer;
} // end + overload

Term Term::operator- (const Term& t) const {
    Term answer;
    if(exponent == t.exponent){
        answer.setCoefficient(coefficient - t.coefficient);
        answer.setExponent(exponent);
    }else
        throw invalid_argument("Exponents are not equal.");
    
    return answer;
} // end + overload
    
Term Term::operator* (const Term& t) const{
    Term answer;
    answer.setCoefficient(coefficient * t.coefficient);
    answer.setExponent(exponent + t.exponent);
    return answer;
} // end * overload

Term Term::operator/ (const Term& t) const{
    Term answer;
    answer.setCoefficient(coefficient / t.coefficient);
    answer.setExponent(exponent - t.exponent);
    return answer;
} // end / overload

ostream& operator<<( ostream& out, const Term& t ){
    out << t.getCoefficient() << "x^" << t.getExponent();
    return out;
} // end stream insertion overload

istream& operator>>( istream& in, Term& t ){
    in >> t.coefficient;
    in.ignore(2);
    in >> t.exponent;
    
    return in;
} // end stream extraction overload
