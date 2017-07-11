import java.util.Arrays;

public class CircularQueue {

	private static int[] queue;
	private static int queueSize,
					   front,
					   rear,
					   storedItems;


	CircularQueue(int size) {
		queue = new int[size];
		queueSize = size;
		front = rear = -1;
		Arrays.fill(queue, -1);
	}


	public boolean isEmpty() { return front == -1 && rear == -1; }


	public boolean isFull() { return storedItems == queueSize; }


	public int getSize() { return storedItems; }


	public void enqueue(int value) {
		if (isFull()) {
			return;
		} else if (isEmpty()) {
			front = rear = 0;
		} else {
			rear = (rear+1) % queueSize;
		}
		queue[rear] = value;
		++storedItems;
	}


	public void dequeue() {
		if (isEmpty()) {
			return;
		} else if (front == rear) {
			front = rear = -1;
		} else {
			front = (front+1) % queueSize;
		}
		--storedItems;
	}


	public int peek() {
		if (!isEmpty())
			return queue[front];
		else
			return -1;
	}


	public int[] getCircularQueue() { return queue; }


	public static void main(String[] args) {}

}
