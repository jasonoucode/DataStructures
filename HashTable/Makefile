
#
# A simple makefile for compiling three java classes
#

# define a makefile variable for the java compiler
#
JCC = javac

# define a makefile variable for compilation flags
# the -g flag compiles with debugging information
#
JFLAGS = -g

# typing 'make' will invoke the first target entry in the makefile
# (the default one in this case)
#
default: HashTableFunctions.class HashTableFunctionsTest.class HashTable.class

# this target entry builds the HashTable, HashTableFunctions, and HashTableFunctionsTest Classes
#
HashTableFunctions.class: HashTableFunctions.java
	$(JCC) $(JFLAGS) HashTableFunctions.java

HashTableFunctionsTest.class: HashTableFunctionsTest.java
	$(JCC) $(JFLAGS) HashTableFunctionsTest.java

HashTable.class: HashTable.java
	$(JCC) $(JFLAGS) HashTable.java

# Running tests to make sure our code is working.
# 'make test' to run tests.
test: HashTableFunctionsTest.class
	java HashTableFunctionsTest

# To start over from scratch, type 'make clean'.
# Removes all .class files, so that the next make rebuilds them
#
clean:
	$(RM) *.class