import java.util.Arrays;

public class CircularQueueTest {

	// Keeps track of the number of tests and passed tests.
	private static int numTests = 0;
	private static int passedTests = 0;


	// Tests the init method with 4 items.
	private static boolean testInit() {
		int[] expectedCircularQueue = new int[]{-1, -1, -1, -1};
		++numTests;

		CircularQueue q = new CircularQueue(4);

		return Arrays.equals(q.getCircularQueue(), expectedCircularQueue) && q.isEmpty();
	}


	// Tests the enqueue method with 5 items.
	private static boolean testEnqueueFull() {
		++numTests;

		CircularQueue q = new CircularQueue(5);

		for (int i = 1; i < 7; ++i)
			q.enqueue(i);

		return q.isFull();
	}

	// Tests the circular queue by doing a series
	//		of enqueues and dequeues to make sure
	//		both enqueue and dequeue are working
	//		as well as our queue being circular.
	private static boolean testCircularEnqueue() {
		++numTests;

		CircularQueue q = new CircularQueue(3);

		for (int i = 1; i < 4; ++i)
			q.enqueue(i);

		for (int i = 1; i < 3; ++ i)
			q.dequeue();

		for (int i = 6; i < 8; ++ i)
			q.enqueue(i);

		for (int i = 1; i < 3; ++ i)
			q.dequeue();

		return q.peek() == 7;
	}


	// Main, runs all of the tests and prints out the results.
	public static void main(String[] args) {
		if(testInit())
			++passedTests;
		else
			System.out.println("Test Init: Failed.");

		if(testEnqueueFull())
			++passedTests;
		else
			System.out.println("Test Enqueue Full: Failed.");

		if(testCircularEnqueue())
			++passedTests;
		else
			System.out.println("Test Circular Enqueue: Failed.");

		System.out.println("Tests Passed: " + passedTests + " / " + numTests);
	}
}
