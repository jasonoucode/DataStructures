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
default: LinkedList.class LinkedListTest.class Node.class

# this target entry builds the Node, LinkedList, and LinkedListTest Classes
#
LinkedList.class: LinkedList.java
	$(JCC) $(JFLAGS) LinkedList.java

LinkedListTest.class: LinkedListTest.java
	$(JCC) $(JFLAGS) LinkedListTest.java

Node.class: Node.java
	$(JCC) $(JFLAGS) Node.java

# Running tests to make sure our code is working.
# 'make test' to run tests.
test: LinkedListTest.class
	java LinkedListTest

# To start over from scratch, type 'make clean'.
# Removes all .class files, so that the next make rebuilds them
#
clean:
	$(RM) *.class