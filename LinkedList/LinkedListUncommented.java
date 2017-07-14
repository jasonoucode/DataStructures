public class LinkedList {

	Node head;


	public void append(int data) {
		if (head == null) {
			head = new Node(data);
			return;
		}

		Node current = head;
		while (current.next != null)
			current = current.next;

		current.next = new Node(data);
	}


	public void prepend(int data) {
		Node newHead = new Node(data);
		newHead.next = head;
		head = newHead;
	}


	public void deleteWithData(int data) {
		if (head == null) return;
		if (head.data == data) {
			head = head.next;
			return;
		}

		Node current = head;
		while (current.next != null) {
			if (current.next.data == data) {
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}
	}


	public boolean findByData(int data) {
		if (head == null) return false;
		if (head.data == data)
			return true;

		Node current = head;
		while (current.next != null) {
			if (current.next.data == data)
				return true;
			current = current.next;
		}
		return false;
	}


	public int getHeadData() {
		if (head == null) return -1;
		return head.data;
	}


	public static void main(String[] args) {}

}
