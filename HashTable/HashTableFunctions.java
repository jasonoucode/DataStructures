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
	 * @desc
	 *
	 * @param
	 *
	 * @return
	 */
	public static HashTable moveArray(HashTable ht, int size) {
		int[] cleanHt = cleanArray(ht);

		ht = new HashTable(size);

		for (int i : cleanHt)
			put(i, ht);

		return ht;
	}


	/**
	 * @desc
	 *
	 * @param
	 *
	 * @return
	 */
	public static HashTable resizeArray(HashTable ht) {
		int newSize = nextPrime(ht.arraySize);

		return moveArray(ht, newSize);
	}


	/**
	 * @desc
	 *
	 * @param
	 *
	 * @return
	 */
	public static int[] cleanArray(HashTable ht) {
		ArrayList<Integer> intList = new ArrayList<Integer>();

		for (int i : ht.hashArray)
			if (i != -1)
				intList.add(i);

		int[] intArray = new int[intList.size()];

		for (int j = 0; j < intArray.length; ++j)
			intArray[j] = intList.get(j);

		return intArray;
	}


	/**
	 * @desc
	 *
	 * @param
	 *
	 * @return
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
	 * @desc
	 *
	 * @param
	 *
	 * @return
	 */
	public static void print(HashTable ht) {
		System.out.println();
		for (int i = 0; i < ht.arraySize; ++i)
			System.out.println(i + " : " + ht.hashArray[i]);
		System.out.println();
	}


	/**
	 * @desc
	 *
	 * @param
	 *
	 * @return
	 */
	public static int find(int key, HashTable ht) {
		int index = key % ht.arraySize;
		int itemCounter = ht.itemCount;

		while(ht.hashArray[index] != -1 && itemCounter-- != 0) {
			if (ht.hashArray[index] == key)
				return index;

			++index;
			index %= ht.arraySize;
		}

		return -1;
	}


	/**
	 * @desc main function
	 */
	public static void main(String args[]) {}

}
