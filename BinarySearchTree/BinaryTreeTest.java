public class BinaryTreeTest {

	// Keeps track of the number of tests and passed tests.
	private static int numTests = 0;
	private static int passedTests = 0;


	// Tests the insert method to see if adding a node
	//		works properly
	private static boolean testOneInsert() {
		++numTests;
		BinaryTree bt = new BinaryTree();
		bt.insert(5);

		return bt.getRoot() == 5;
	}


	// Tests getting the root works properly
	private static boolean testBadRoot() {
		++numTests;
		BinaryTree bt = new BinaryTree();

		return bt.getRoot() == -404;
	}


	// Tests the insert method to see if adding many nodes
	//		works properly
	private static boolean testManyInserts() {
		++numTests;
		BinaryTree bt = new BinaryTree();
		for (int i = 10; i > 0; --i)
			bt.insert(i);

		return bt.find(10);
	}


	// Tests the find method in the case of
	//		no values to find.
	private static boolean testNoValueFind() {
		++numTests;
		BinaryTree bt = new BinaryTree();

		return bt.find(100);
	}


	// Tests the find method in the case of
	//		finding an invalid value
	private static boolean testBadFind() {
		++numTests;
		BinaryTree bt = new BinaryTree();
		for (int i = 10; i > 0; --i)
			bt.insert(i);

		return bt.find(100);
	}


	// Tests the delete method to see if deleting one node
	//		works properly
	private static boolean testOneDelete() {
		++numTests;
		BinaryTree bt = new BinaryTree();
		bt.insert(5);
		bt.delete(5);

		return bt.getRoot() == -404;
	}


	// Tests the delete method to see if deleting many nodes
	//		works properly
	private static boolean testManyDeletes() {
		++numTests;
		BinaryTree bt = new BinaryTree();
		for (int i = 10; i > 0; --i)
			bt.insert(i);

		for(int i = 2; i < 5; ++i)
			bt.delete(i);

		return !bt.find(2);
	}


	// Main, runs all of the tests and prints out the results.
	public static void main(String[] args) {
		if (testOneInsert())
			++passedTests;
		else
			System.out.println("Test One Insert: Failed.");

		if (testBadRoot())
			++passedTests;
		else
			System.out.println("Test Bad Root: Failed.");

		if (testManyInserts())
			++passedTests;
		else
			System.out.println("Test Many Inserts: Failed.");

		if (testManyDeletes())
			++passedTests;
		else
			System.out.println("Test Many Deletes: Failed.");

		if (testOneDelete())
			++passedTests;
		else
			System.out.println("Test One Delete: Failed.");

		if (!testBadFind())
			++passedTests;
		else
			System.out.println("Test Bad Find: Failed.");

		if (!testNoValueFind())
			++passedTests;
		else
			System.out.println("Test No Value Find: Failed.");

		System.out.println("Tests Passed: " + passedTests + " / " + numTests);
	}

}
