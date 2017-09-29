import java.util.Arrays;

public class HashTable {
	int[] hashArray;
	int arraySize;
	int itemCount;

	public HashTable(int size) {
		this.arraySize = size;
		this.hashArray = new int[size];
		Arrays.fill(this.hashArray, -1);
		this.itemCount = 0;
	}
}
