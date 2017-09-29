// Hash Table package imports
import java.util.Arrays;

// Hash Table class and implementation
public class HashTable {

	// the main array used for storage and manipulation.
	//		this is our hashtable.
	int[] hashArray;

	// keeps track of the size of the hash table
	int arraySize;

	// keeps track of the number of values in the hashtable
	int itemCount;


	/**
	 * @desc constructor for the hash table where the size is taken in
	 *			to initiate the hash table with all -1s and initiate all
	 *			variables with information about the hash table.
	 *
	 * @param int size - the size of our hash table
	 *
	 * @return void - nothing to return
	 */
	public HashTable(int size) {
		this.arraySize = size;
		this.hashArray = new int[size];
		Arrays.fill(this.hashArray, -1);
		itemCount = 0;
	}

}
