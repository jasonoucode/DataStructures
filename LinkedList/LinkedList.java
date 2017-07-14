// Linked List class and implementation
public class LinkedList {
	// head node is used to keep track of the front
	//		of the linked list
	Node head;


	// Append method puts a new link at the end of
	//		the linked list
	public void append(int data) {
		// If there exists no head,
		//		the new node being made
		//		will become the head
		if (head == null) {
			head = new Node(data);
			return;
		}

		// Else if there already exists a head
		//		node, then we append the new node
		//		at the end of the linked list.
		Node current = head;
		// Starting at the head, we iterate through
		//		until we get to the end of the linked
		//		list to input the new node
		while (current.next != null)
			current = current.next;

		// Once we reach the end of the linked list
		//		we append the new node
		current.next = new Node(data);
	}


	// Prepend method adds the new node to the front
	//		of the linked list
	public void prepend(int data) {
		// If there does not exist a link already,
		//		we set the new node as head
		if (head == null) {
			head = new Node(data);
			return;
		}

		// Else if there is a link existing,
		//		we set the new node as head
		//		and the next node of the
		//		new link as the rest of the existing
		//		linked list.
		Node newHead = new Node(data);
		newHead.next = head;
		head = newHead;
	}


	// deleteWithData method deletes a link given
	//		the data the user wants to delete
	public void deleteWithData(int data) {
		// If head is null, there is no data to delete
		if (head == null) return;
		// If the head is the data we want to delete,
		//		we set the next node as the head.
		if (head.data == data) {
			head = head.next;
			return;
		}

		// Iterate through the linked list until we find the data
		//		that we want to delete.
		Node current = head;
		while (current.next != null) {
			// When found, we set delete the link by
			//		setting the current next node as
			//		the next next node, skipping the next
			//		node.
			if (current.next.data == data) {
				current.next = current.next.next;
				return;
			}
			// Else we check the next node
			current = current.next;
		}
	}


	// findByData method determines if a link in the linked
	//		list exists or not based off of what the user wants
	//		to find
	public boolean findByData(int data) {
		// If no head exists, that means there's no links
		//		in the link list so we return false
		if (head == null) return false;
		// If the head is the data we want, we return
		//		true
		if (head.data == data)
			return true;

		// Iterate through the linked list until we find the data
		//		that we want to find.
		Node current = head;
		while (current.next != null) {
			// If we find it, then we return true to indicate
			//		found.
			if (current.next.data == data)
				return true;
			// Else we check the next node.
			current = current.next;
		}
		// If we cant find it in the rest of the linked list,
		//		we return false to indicate not found.
		return false;
	}


	// If there exists a head,
	//		we return the data stored
	//		in the head
	public int getHeadData() {
		// -1 means not found
		if (head == null) return -1;
		return head.data;
	}


	// Main
	public static void main(String[] args) {}

}
