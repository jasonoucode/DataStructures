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

		return Arrays.equals(q.getCircularQueue(), expectedCircularQueue);
	}


	// Tests the enqueue method with 5 items.
	private static boolean testEnqueueFull() {
		int[] expectedCircularQueue = new int[]{1, 2, 3, 4, 5};
		++numTests;

		CircularQueue q = new CircularQueue(5);

		for (int i = 1; i < 7; ++i)
			q.enqueue(i);

		return q.isFull();
	}


	// Tests the dequeue method with 5 items.
	private static boolean testDequeueFull() {
		++numTests;

		CircularQueue q = new CircularQueue(5);

		for (int i = 1; i < 6; ++i)
			q.enqueue(i);

		for (int i = 1; i < 7; ++i)
			q.dequeue();

		return q.peek() == -1;
	}

	// Tests the dequeue method with 5 items.
	private static boolean testDequeue() {
		++numTests;

		CircularQueue q = new CircularQueue(5);

		for (int i = 1; i < 6; ++i)
			q.enqueue(i);

		for (int i = 1; i < 7; ++i)
			q.dequeue();

		return q.peek() == -1;
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
			System.out.println("Test Enqueue: Full Failed.");

		if(testDequeueFull())
			++passedTests;
		else
			System.out.println("Test Dequeue Full: Failed.");

		if(testDequeue())
			++passedTests;
		else
			System.out.println("Test Dequeue: Failed.");

		System.out.println("Tests Passed: " + passedTests + " / " + numTests);
	}
}
