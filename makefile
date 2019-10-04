all: lab5test

lab5test: lab5functions.o lab5test.o
	gcc lab5functions.o lab5test.o -o lab5test -lm

lab5test.o: lab5test.c lab5functions.h
	gcc -c lab5test.c

lab5functions.o: lab5functions.c lab5functions.h
	gcc -c lab5functions.c
