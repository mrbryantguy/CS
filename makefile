all: Lab10

Lab10: Term.o Lab10.o
	g++ Term.o Lab10.o -o Lab10

Term.o: Term.cpp Term.h
	g++ -c Term.cpp

Lab10.o: Lab10.cpp Term.h
	g++ -c Lab10.cpp
