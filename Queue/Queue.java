import java.util.Arrays;

// Queue class and implementation
public class Queue {

	// Used to keep track of the queue array,
	//		size of the queue,
	//		front and rear index of the queue,
	//		and number of stored items.
	// Variables kept private for this file's use only.
	private static int[] queue;
	private static int queueSize,
					   front,
					   rear,
					   storedItems;


	// Used to initialize the stack
	Queue(int size) {
		queue = new int[size];
		queueSize = size;
		front = rear = -1;
		Arrays.fill(queue, -1);
	}


	// isEmpty()
	public boolean isEmpty() { return front == -1 && rear == -1; }


	// isFull()
	public boolean isFull() { return storedItems == queueSize; }


	// getSize()
	public int getSize() { return storedItems; }


	// Insert
	public void enqueue(int value) {
		if (isFull()) {
			return;
		} else if (isEmpty()) {
			front = rear = 0;
		} else {
			++rear;
		}
		queue[rear] = value;
		++storedItems;
	}


	// Delete
	public void dequeue() {
		if (isEmpty()) {
			return;
		} else if (front == rear) {
			front = rear = -1;
		} else {
			++front;
		}
	}


	// Peek method to look at the top of the queue.
	// The value -1 means null or nothing in the stack.
	public int peek() { return queue[front]; }


	// Used to get the entire queue.
	public int[] getQueue() { return queue; }


	// Main
	public static void main(String[] args) {}

}
