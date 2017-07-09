import java.util.Arrays;

public class StackTest {

	// Keeps track of the number of tests and passed tests.
	private static int numTests = 0;
	private static int passedTests = 0;


	// Tests the init method with 4 items.
	private static boolean testInit() {
		int[] expectedStack = new int[]{-1, -1, -1, -1};
		++numTests;

		Stack s = new Stack(4);

		return Arrays.equals(s.getStack(), expectedStack);
	}


	// Tests the push method with 5 items.
	private static boolean testPush() {
		int[] expectedStack = new int[]{1, 2, 3, 4, 5};
		++numTests;

		Stack s = new Stack(5);

		for (int i = 1; i < 6; ++i)
			s.push(i);

		return Arrays.equals(s.getStack(), expectedStack);
	}


	// Tests the pop method with 5 items.
	private static boolean testPop() {
		int[] expectedStack = new int[]{-1, -1, -1, -1, -1};
		++numTests;

		Stack s = new Stack(5);

		for (int i = 1; i < 6; ++i)
			s.push(i);

		for (int i = 1; i < 6; ++i) {
			s.pop();
		}

		return Arrays.equals(s.getStack(), expectedStack);
	}


	// Tests the push full method with 3 items with one extra for when it's full.
	private static boolean testPushFull() {
		int[] expectedStack = new int[]{1, 2, 3};
		++numTests;

		Stack s = new Stack(3);

		for (int i = 1; i < 4; ++i)
			s.push(i);

		return s.isFull();
	}


	// Tests the pop empty method with 5 items and one extra pop.
	private static boolean testPopEmpty() {
		++numTests;

		Stack s = new Stack(5);

		for (int i = 1; i < 6; ++i)
			s.push(i);

		for (int i = 1; i < 6; ++i) {
			s.pop();
		}

		return s.isEmpty();
	}


	// Tests the peek after 5 push and 2 pops
	private static boolean testPeek() {
		++numTests;

		Stack s = new Stack(5);

		for (int i = 1; i < 6; ++i)
			s.push(i);

		for (int i = 1; i < 3; ++i) {
			s.pop();
		}

		return s.peek() == 3;
	}


	// Main, runs all of the tests and prints out the results.
	public static void main(String[] args) {
		if(testInit())
			++passedTests;
		else
			System.out.println("Test Init: Failed.");

		if(testPush())
			++passedTests;
		else
			System.out.println("Test Push: Failed.");

		if(testPop())
			++passedTests;
		else
			System.out.println("Test Pop: Failed.");

		if(testPushFull())
			++passedTests;
		else
			System.out.println("Test Push Full: Failed.");

		if(testPopEmpty())
			++passedTests;
		else
			System.out.println("Test Pop Empty: Failed.");

		if(testPeek())
			++passedTests;
		else
			System.out.println("Test Peek: Failed.");

		System.out.println("Tests Passed: " + passedTests + " / " + numTests);
	}
}
