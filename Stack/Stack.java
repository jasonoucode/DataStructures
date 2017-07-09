import java.util.Arrays;

public class Stack {

	private int[] stack;
	private int stackSize;
	private int stackTop = -1;


	Stack(int size) {
		stackSize = size;
		stack = new int[size];
		Arrays.fill(stack, -1);
	}


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


	public int peek() {
		return stack[stackTop];
	}


	public void printStack() {
		System.out.println(Arrays.toString(stack));
	}


	public static void main(String[] args) {}

}