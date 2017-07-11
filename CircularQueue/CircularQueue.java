import java.util.Arrays;

// CircularQueue class and implementation
public class CircularQueue {

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
	CircularQueue(int size) {
		queue = new int[size];
		queueSize = size;
		front = rear = -1;
		Arrays.fill(queue, -1);
	}


	// If the front and rear are -1, then that means the queue is empty
	public boolean isEmpty() { return front == -1 && rear == -1; }


	// If the number of stored items and the size of the queue is the same,
	//		then the queue is full.
	public boolean isFull() { return storedItems == queueSize; }


	// Returns the number of stored items in the queue
	public int getSize() { return storedItems; }


	// Enqueue, insert function for queues
	public void enqueue(int value) {
		// If queue is full, we exit.
		if (isFull()) {
			return;
		} else if (isEmpty()) {
			// If the queue is empty, we initialize
			//		front and rear to start at 0.
			front = rear = 0;
		} else {
			// If the queue is not empty,
			//		we set the rear to the next
			//		index in the circular queue.
			rear = (rear+1) % queueSize;
		}
		// After setting the index, we put the value we want
		//		in the queue rear
		queue[rear] = value;
		// Keeps track of the number of items stored
		++storedItems;
	}


	// Dequeue, delete function for queues
	public void dequeue() {
		// If it's empty, theres nothing to delete
		//		so we exit.
		if (isEmpty()) {
			return;
		} else if (front == rear) {
			// If we delete the last item,
			//		in the case the front and
			//		rear are at the same index,
			//		then we set front and rear to
			//		-1 to indicate, empty.
			front = rear = -1;
		} else {
			// If the queue is not empty,
			//		we set the front to the next
			//		index in the circular queue.
			front = (front+1) % queueSize;
		}
		--storedItems;
	}


	// Peek method to look at the top of the queue.
	// The value -1 means null or nothing in the queue.
	public int peek() {
		if (!isEmpty())
			return queue[front];
		else
			return -1;
	}


	// Used to get the entire queue.
	public int[] getCircularQueue() { return queue; }


	// Main
	public static void main(String[] args) {}

}
