// Hash Table Functions package imports
import java.util.Arrays;
import java.util.ArrayList;

// Hash Table Functions class and implementation
public class HashTableFunctions {

	/**
	 * @desc checks if the number inputted is a prime number
	 *
	 * @param int num - the number we want to check if prime
	 *
	 * @return boolean - true means it's prime, false means it's
	 *				not prime.
	 */
	public static boolean isPrime(int num) {
		// 2 and 3 are prime
		if (num == 2 || num == 3) return true;

		// Even numbers that is not 2 are not prime
		if (num % 2 == 0) return false;

		// odd numbers that are divisible are not prime.
		//		int i = 3, starting at 3 since we already
		//					checked even numbers.
		//		i*i <= num, check less values and avoids
		//					 checking the odd val itself
		//		i+=2      , next odd value to check
		for (int i = 3; i*i <= num; i+= 2) {
			// if able to mod with an odd val, it is not prime
			if (num % i == 0) return false;
		}

		// if odd and not divisible, it is prime
		return true;
	}


	/**
	 * @desc checks for the next number that is prime
	 *			relative to the number inputted
	 *
	 * @param int num - the number we want to check
	 *
	 * @return int - the next prime number relative to the
	 *				number inputted is returned
	 */
	public static int nextPrime(int num) {
		// starting at the next val, we check
		//		if the num is prime.
		++num;

		// keeps incrementing until the next prime
		//		value is found.
		while(!isPrime(num))
			++num;

		// once found, return the prime val
		return num;
	}


	/**
	 * @desc moves the current hastable into a new hashtable of
	 *       size inputted
	 *
	 * @param HashTable ht - the hashtable that needs to be expanded
	 * @param int size - the size of the new hashtable
	 *
	 * @return HashTable - returns the new, bigger hashtable with the
	 *                     old HashTable stored in it
	 */
	public static HashTable moveArray(HashTable ht, int size) {
		// removes all empty entries in the current array
		int[] cleanHt = cleanArray(ht);

		// creates a new hashtable to store the old array
		ht = new HashTable(size);

		// moves the old array items to the new array
		for (int i : cleanHt)
			put(i, ht);

		// return the new hash table
		return ht;
	}


	/**
	 * @desc resizes the current hashtable to make it bigger by
	 *       finding the next prime value that is larger than the
	 *       current size and moves the current hashtable into the
	 *       new, bigger hash table.
	 *
	 * @param HashTable ht - the hashtable that needs to be expanded
	 *
	 * @return HashTable - returns the new, bigger hashtable with the
	 *                     old HashTable stored in it
	 */
	public static HashTable resizeArray(HashTable ht) {
		// set the new size as the next prime number.
		// apparently prime numbers have less collisions
		int newSize = nextPrime(ht.arraySize);

		// return a new hashtable with the size of the increased size
		return moveArray(ht, newSize);
	}


	/**
	 * @desc removes all empty entries in the array
	 *
	 * @param HashTable ht - hashtable that we want to clean
	 *
	 * @return int[] - the array without empty entries
	 */
	public static int[] cleanArray(HashTable ht) {
		// Create a new arraylist to store our hashtable values
		ArrayList<Integer> intList = new ArrayList<Integer>();

		// goes through the hashtable and put non empty entries into the arraylist
		for (int i : ht.hashArray)
			// if not empty add value to arraylist
			if (i != -1)
				intList.add(i);

		// now we need to transfer the arraylist to an array to return back
		int[] intArray = new int[intList.size()];

		// transfer the arraylist to an array to return back
		for (int j = 0; j < intArray.length; ++j)
			intArray[j] = intList.get(j);

		// return the array list
		return intArray;
	}


	/**
	 * @desc puts a value into the hashtable
	 *
	 * @param int key - the key we want to add to the hashtable
	 * @param HashTable ht - the hashtable we want to add a value to
	 *
	 * @return HashTable - returns the hashtable with the value added
	 */
	public static HashTable put(int key, HashTable ht) {
		if (ht.arraySize == ht.itemCount)
			ht = resizeArray(ht);

		int index = key % ht.arraySize;

		while (ht.hashArray[index] != -1) {
			++index;
			index %= ht.arraySize;
		}

		ht.hashArray[index] = key;
		++ht.itemCount;

		return ht;
	}


	/**
	 * @desc prints out the entire hashtable
	 *
	 * @param Hashtable ht - the hashtable we want to print out
	 *
	 * @return null
	 */
	public static void print(HashTable ht) {
		// new line for formatting
		System.out.println();

		// goes through the array and prints out the key and value at each index
		for (int i = 0; i < ht.arraySize; ++i)
			System.out.println(i + " : " + ht.hashArray[i]);

		// new line for formatting
		System.out.println();
	}


	/**
	 * @desc finds the value we want in the hashtable
	 *
	 * @param int key - the key we are looking for
	 * @param HashTable ht - the hashtable we are searching through
	 *
	 * @return int - returns -1 if not found and returns positive index if found
	 */
	public static int find(int key, HashTable ht) {
		// calculate the index by doing key % arraySize since this was
		// 		how insert index was calculated
		int index = key % ht.arraySize;
		// to make sure we do not try searching more times than there are items in the array
		int itemCounter = ht.itemCount;

		// as long as the current index is not -1 and we have not searched the entire table
		//		we can keep searching
		while(ht.hashArray[index] != -1 && itemCounter-- != 0) {
			// check if key at index is equal to the key we are looking for
			if (ht.hashArray[index] == key)
				// if equal we return the index at which we found it
				return index;

			// else we go to the next index
			++index;
			// recalculate the index
			index %= ht.arraySize;
		}

		// if not found return -1
		return -1;
	}


	/**
	 * @desc main function
	 */
	public static void main(String args[]) {}

}
