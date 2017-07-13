public class LinkedListTest {

	// Keeps track of the number of tests and passed tests.
	private static int numTests = 0;
	private static int passedTests = 0;

	private static boolean testOneLink() {
		++numTests;
		LinkedList ll = new LinkedList();
		ll.append(5);
		ll.prepend(6);

		return ll.getHeadData() == 6;
	}

	// Main, runs all of the tests and prints out the results.
	public static void main(String[] args) {
		if(testOneLink())
			++passedTests;
		else
			System.out.println("Test One Link: Failed.");

		System.out.println("Tests Passed: " + passedTests + " / " + numTests);
	}

}
