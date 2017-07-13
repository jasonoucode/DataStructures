public class LinkedListTest {

	// Keeps track of the number of tests and passed tests.
	private static int numTests = 0;
	private static int passedTests = 0;


	// Tests the append method to see if adding a link
	//		works properly
	private static boolean testOneLinkAppend() {
		++numTests;
		LinkedList ll = new LinkedList();
		ll.append(5);

		return ll.getHeadData() == 5;
	}


	// Tests the prepend method by using two links
	//		to make sure prepend works properly
	private static boolean testTwoLinksPrepend() {
		++numTests;
		LinkedList ll = new LinkedList();
		ll.append(5);
		ll.prepend(6);

		return ll.getHeadData() == 6;
	}


	// Tests if we are able to find existing values
	// 		given the value we want to find
	//		in the linked list
	private static boolean testFindByData() {
		++numTests;
		LinkedList ll = new LinkedList();
		for (int i = 0; i < 10; ++i)
			ll.append(i);

		return ll.findByData(5);
	}


	// Tests delete by deleting the head value
	//		and checking if the next value
	//		then becomes the head.
	private static boolean testDelete() {
		++numTests;
		LinkedList ll = new LinkedList();
		ll.append(5);
		ll.append(6);
		ll.deleteWithData(5);

		return ll.getHeadData() == 6;
	}


	// Main, runs all of the tests and prints out the results.
	public static void main(String[] args) {
		if (testOneLinkAppend())
			++passedTests;
		else
			System.out.println("Test One Link Append: Failed.");

		if (testTwoLinksPrepend())
			++passedTests;
		else
			System.out.println("Test Two Links Prepend: Failed.");

		if (testDelete())
			++passedTests;
		else
			System.out.println("Test Delete: Failed.");

		if (testFindByData())
			++passedTests;
		else
			System.out.println("Test Find By Data: Failed.");

		System.out.println("Tests Passed: " + passedTests + " / " + numTests);
	}

}
