import java.util.Arrays;

// Stack class and implementation
public class Stack {

	// Used to keep track of the stack array,
	//		size of the stack,
	//		and the top index of the stack.
	// Variables kept private for this file's use only.
	private int[] stack;
	private int stackSize;
	private int stackTop = -1;


	// Used to initialize the stack
	Stack(int size) {
		stack = new int[size];
		stackSize = size;
		Arrays.fill(stack, -1);
	}


	// Checks if stack is empty
	public boolean isEmpty() { return stackTop == -1; }


	// Checks if stack is full
	public boolean isFull() { return stackTop+1 == stackSize; }


	// Checks for how many items in the stack
	public int getSize() { return stackSize; }


	// Push method to input a new value into the stack
	//		as long as the stack isn't full.
	public void push(int value) {
		// As long as stack has space,
		//		push a new item onto top of stack.
		if(!isFull())
			stack[++stackTop] = value;
	}


	// Pop method to remove the top value of the stack
	//		as long as the stack isn't empty.
	public int pop() {
		// As long as the stack isn't empty,
		//		pop the top of the stack.
		if(!isEmpty()) {
			stack[stackTop] = -1;
			return stack[stackTop--];
		} else {
			return -1;
		}
	}


	// Peek method to look at the top of the stack.
	// The value -1 means null or nothing in the stack.
	public int peek() { return stack[stackTop]; }


	// Used to get the entire stack.
	public int[] getStack() { return stack; }


	// Main
	public static void main(String[] args) {}

}
