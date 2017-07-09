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
default: Queue.class QueueTest.class

# this target entry builds the Queue and QueueTest Classes
#
Queue.class: Queue.java
	$(JCC) $(JFLAGS) Queue.java

QueueTest.class: QueueTest.java
	$(JCC) $(JFLAGS) QueueTest.java

# Running tests to make sure our code is working.
# 'make test' to run tests.
test: QueueTest.class
	java QueueTest

# To start over from scratch, type 'make clean'.
# Removes all .class files, so that the next make rebuilds them
#
clean:
	$(RM) *.class
