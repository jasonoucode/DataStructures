import java.util.Arrays;
import java.util.ArrayList;

public class HashTableFunctions {

	public static boolean isPrime(int num) {
		if (num == 2 || num == 3) return true;

		if (num % 2 == 0) return false;

		for (int i = 3; i*i <= num; i+= 2) {
			if (num % i == 0) return false;
		}

		return true;
	}


	public static int nextPrime(int num) {
		++num;

		while(!isPrime(num))
			++num;

		return num;
	}


	public static HashTable moveArray(HashTable ht, int size) {
		int[] cleanHt = cleanArray(ht);

		ht = new HashTable(size);

		for (int i : cleanHt)
			put(i, ht);

		return ht;
	}


	public static HashTable resizeArray(HashTable ht) {
		int newSize = nextPrime(ht.arraySize);

		return moveArray(ht, newSize);
	}


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


	public static void print(HashTable ht) {
		System.out.println();

		for (int i = 0; i < ht.arraySize; ++i)
			System.out.println(i + " : " + ht.hashArray[i]);

		System.out.println();
	}


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


	public static void main(String args[]) {}

}
