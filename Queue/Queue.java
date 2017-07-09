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
		queueSize = size;
		queue = new int[size];
		Arrays.fill(queue, -1);
	}


	public void enqueue(int value) {
		if(storedItems+1 <= queueSize) {
			queue[rear++] = value;
			++storedItems;
		}
	}


	public void dequeue() {
		if (storedItems > 0) {
			queue[front++] = -1;
			--storedItems;
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
