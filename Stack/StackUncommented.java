import java.util.Arrays;

public class Stack {

	private int[] stack;
	private int stackSize;
	private int stackTop = -1;


	Stack(int size) {
		stack = new int[size];
		stackSize = size;
		Arrays.fill(stack, -1);
	}


	public boolean isEmpty() { return stackTop == -1; }


	public boolean isFull() { return stackTop+1 == stackSize; }


	public void push(int value) {
		if(stackTop+1 < stackSize)
			stack[++stackTop] = value;
	}


	public int pop() {
		if(stackTop > -1) {
			stack[stackTop] = -1;
			return stack[stackTop--];
		} else {
			return -1;
		}
	}


	public int peek() { return stack[stackTop]; }


	public int[] getStack() { return stack; }


	public static void main(String[] args) {}

}
