public class BinaryTree {
	Node root;


	public void postOrderTraverseRec(Node curr) {
		if (curr != null) {
			postOrderTraverseRec(curr.left);
			postOrderTraverseRec(curr.right);
			System.out.println(curr.data);
		}
	}


	public void postOrderTraverse() {
		if (root != null) postOrderTraverseRec(root);
	}


	public void preOrderTraverseRec(Node curr) {
		if (curr != null) {
			System.out.println(curr.data);
			preOrderTraverseRec(curr.left);
			preOrderTraverseRec(curr.right);
		}
	}


	public void preOrderTraverse() {
		if (root != null) preOrderTraverseRec(root);
	}


	public void inOrderTraverseRec(Node curr) {
		if (curr != null) {
			inOrderTraverseRec(curr.left);
			System.out.println(curr.data);
			inOrderTraverseRec(curr.right);
		}
	}


	public void inOrderTraverse() {
		if (root != null) inOrderTraverseRec(root);
	}


	public boolean find(int data) {
		Node current = root;

		while(current != null) {
			if (data == current.data) return true;

			if (data <= current.data) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return false;
	}


	public void insert(int data) {
		if (root == null) {
			root = new Node(data);
			return;
		}

		Node current = root;

		while(true) {
			if (data <= current.data) {
				if (current.left == null) {
					current.left = new Node(data);
					return;
				}
				current = current.left;
			} else {
				if (current.right == null) {
					current.right = new Node(data);
					return;
				}
				current = current.right;
			}
		}
	}


	public Node replaceNode(Node replace) {
		Node replaceParent = replace;
		Node replacement = replace;

		Node current = replace.right;

		while(current != null) {
			replaceParent = replacement;
			replacement = current;
			current = current.left;
		}

		if (replacement != replace.right) {
			replaceParent.left = replacement.right;
			replacement.right = replace.right;
		}

		return replacement;
	}


	public boolean delete(int data) {
		if (root == null) return false;

		Node current = root;
		Node parent = root;

		boolean leftChild = true;

		while (current.data != data) {
			if (current == null) return false;

			parent = current;

			if (data < current.data) {
				leftChild = true;
				current = current.left;
			} else {
				leftChild = false;
				current = current.right;
			}
		}

		if (current.left == null && current.right == null) {
			if (current == root) {
				root = null;
			} else if (leftChild) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		} else if (current.right == null) {
			if (current == root) {
				root = current.left;
			} else if (leftChild) {
				parent.left = current.left;
			} else {
				parent.right = current.left;
			}
		} else if (current.left == null) {
			if (current == root) {
				root = current.right;
			} else if (leftChild) {
				parent.left = current.right;
			} else {
				parent.right = current.right;
			}
		} else {
			Node replacement = replaceNode(current);

			if (current == root) {
				root = replacement;
			} else if (leftChild) {
				parent.left = replacement;
			} else {
				parent.right = replacement;
			}

			replacement.left = current.left;
		}

		return true;
	}


	public int getRoot() {
		if (root != null) return root.data;
		else return -404;
	}


	public static void main(String[] args) {}

}
