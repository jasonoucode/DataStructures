// Binary Tree class and implementation
public class BinaryTree {
	// head node is used to keep track of the front
	//		of the binary tree
	Node root;


	// Traverses the tree in post order.
	//		left, right, root.
	//		This is the recursive function.
	public void postOrderTraverseRec(Node curr) {
		if (curr != null) {
			// left
			postOrderTraverseRec(curr.left);
			// right
			postOrderTraverseRec(curr.right);
			// root
			System.out.println(curr.data);
		}
	}


	// Calls on the recursive post order function
	//		as long as root is not null
	public void postOrderTraverse() {
		if (root != null) postOrderTraverseRec(root);
	}


	// Traverses the tree in pre order.
	//		root, left, right.
	//		This is the recursive function.
	public void preOrderTraverseRec(Node curr) {
		if (curr != null) {
			// root
			System.out.println(curr.data);
			// left
			preOrderTraverseRec(curr.left);
			// right
			preOrderTraverseRec(curr.right);
		}
	}


	// Calls on the recursive pre order function
	//		as long as root is not null
	public void preOrderTraverse() {
		if (root != null) preOrderTraverseRec(root);
	}


	// Traverses the tree in in order.
	//		left, root, right.
	//		This is the recursive function.
	public void inOrderTraverseRec(Node curr) {
		if (curr != null) {
			// left
			inOrderTraverseRec(curr.left);
			// root
			System.out.println(curr.data);
			// right
			inOrderTraverseRec(curr.right);
		}
	}


	// Calls on the recursive in order function
	//		as long as root is not null
	public void inOrderTraverse() {
		if (root != null) inOrderTraverseRec(root);
	}


	// Find method starts from root and
	//		goes through the tree until
	//		the value we want to find is
	//		found then return true,
	//		else return false.
	public boolean find(int data) {
		// Starting from the root
		Node current = root;

		// As long as the current node is not null
		//		that means we can keep looking
		//		for the data we want.
		while(current != null) {
			// If the data is found in the current
			//		node, we return true.
			if (data == current.data) return true;

			// If the data is smaller, we traverse left
			if (data <= current.data) {
				current = current.left;
			} else {
				// If the data is greater, we traverse right
				current = current.right;
			}
		}
		// If we go through the whole tree and the data
		//		isnt found, then we return false.
		return false;
	}


	// Insert method inserts a node either in the left
	//		or right side depending on how this value
	//		compares to the root.
	public void insert(int data) {
		// If there does not exist a root,
		//		then we set the data as root.
		if (root == null) {
			root = new Node(data);
			return;
		}

		// Starting from the root
		Node current = root;

		// We keep checking the left or right node
		//		until we add the data into the place
		//		it belongs in the tree
		//		then we stop looping.
		while(true) {
			// If the data we want to insert is less than or
			//		equal to the parent node, it belongs on
			//		the left side.
			if (data <= current.data) {
				// If the left side of the parent is null, that means
				//		we insert the new data into the left of the parent
				//		by creating a new node for the parent
				if (current.left == null) {
					current.left = new Node(data);
					return;
				}
				// Else if there already exists a left to the parent,
				//		we go to the left child and set that as parent
				current = current.left;
			} else {
				// If the data we want to insert is greater than
				//		the parent node, it belongs on the right side.
				// If the right side of the parent is null, that means
				//		we insert the new data into the right of the parent
				//		by creating a new node for the parent
				if (current.right == null) {
					current.right = new Node(data);
					return;
				}
				// Else if there already exists a right to the parent,
				//		we go to the right child and set that as parent
				current = current.right;
			}
		}
	}


	// Replace the node we want to delete with either the
	//		left or right child.
	public Node replaceNode(Node replace) {
		// keeps track of the parent of the replacement.
		Node replaceParent = replace;
		// keep track of what we are replacing.
		Node replacement = replace;

		// we start with the right node since the larger side
		//		should replace the node we are deleting.
		Node current = replace.right;

		// We then traverse the left most node of the right side to get the smallest
		//		node on the right side to replace the current node we want deleted.
		while(current != null) {
			// This keeps track of the parent of the replacement.
			replaceParent = replacement;
			// This is going to be the node we want to replace the current node with.
			//		One current reaches null, we know thats when we got to the
			//		left most node so we store the last current which wasnt null.
			replacement = current;
			// This helps to make sure that the left most node that we want to replace is set to null.
			current = current.left;
		}

		// We dont want to go through extra steps if the replacement node is the right node of
		//		the node we want replaced. If replacement == replace.right then all we have to
		//		do is just return the replacement or current.right node.
		if (replacement != replace.right) {
			// If there's anything that exists to the right of the replacement,
			//		we set give that to the parent instead to get rid of replacement's
			//		position, that way data will not be lost.
			replaceParent.left = replacement.right;
			//	We then set the right children of replacement as the right side of what we want to replace
			//		that way we can get rid and truly delete the node we want replaced.
			replacement.right = replace.right;
		}

		// Once that is done, we return the replacement node and its children.
		return replacement;
	}


	// Delete method
	// Delete has 4 cases.
	// Case 1: Element does not exist.
	// Case 2: Element is found and has no children.
	// Case 3: Element is found and only has 1 child on the left.
	// Case 4: Element is found and only has 1 child on the right.
	// Case 5: Element is found and has 2 children on left and right.
	public boolean delete(int data) {
		// If root is empty, return false
		if (root == null) return false;

		// Used for keeping track of current
		//		and parent nodes
		Node current = root;
		Node parent = root;

		// Used to track whether our current
		//		node is a left child or not.
		boolean leftChild = true;

		// Loop through until we find the node
		//		we want to remove
		while (current.data != data) {
			// If there not found, return false
			if (current == null) return false;

			// We keep track of the parent of the
			//		current node
			parent = current;

			// If data is less than,
			//		it is on left side
			if (data < current.data) {
				leftChild = true;
				current = current.left;
			} else {
				// If data is greater than,
				//		it is on right side.
				leftChild = false;
				current = current.right;
			}
		}

		// Once we found the node we want to delete
		//		we first check if there is a right
		//		or left child associated with the node
		//		we want to delete.
		// In this case, if there is no left or right children
		//		for the node we want to delete:
		if (current.left == null && current.right == null) {
			// If the current node is the root node,
			//		we set root to null.
			if (current == root) {
				root = null;
			} else if (leftChild) {
				// If it is a left child with no children
				//		of its own, we set the its parent's
				//		left child to null.
				parent.left = null;
			} else {
				// If it is a right child with no children
				//		of its own, we set the its parent's
				//		right child to null.
				parent.right = null;
			}
		// In this case, if there is a left child, but no right child
		//		for the node we want to delete:
		} else if (current.right == null) {
			// if current node is the root node,
			//		we set the root as the left node
			//		since there doesnt exist a right node.
			if (current == root) {
				root = current.left;
			} else if (leftChild) {
				// if our current node isnt root and it is a left child node,
				//		we set the parent's left node to the current node's
				//		left node
				parent.left = current.left;
			} else {
				// if our current node isnt root and it is a right child node,
				//		we set the parent's right node to the current node's
				//		left node.
				parent.right = current.left;
			}
		// In this case, if there is a right child, but no left child
		//		for the node we want to delete:
		} else if (current.left == null) {
			// If current is the root and left is null,
			//		the root becomes the right child.
			if (current == root) {
				root = current.right;
			} else if (leftChild) {
				// if our current node isnt root and it is a left child node,
				//		we set the parent's left node to the current node's
				//		right node
				parent.left = current.right;
			} else {
				// if our current node isnt root and it is a right child node,
				//		we set the parent's right node to the current node's
				//		right node
				parent.right = current.right;
			}
		// In this case, if there is a both a left and right child,
		//		for the node we want to delete:
		} else {
			// We want to find the node that we want to replace the
			//		existing node with.
			Node replacement = replaceNode(current);

			// If the current node is root, we set the replacement node as
			//		the root.
			if (current == root) {
				root = replacement;
			} else if (leftChild) {
				parent.left = replacement;
			} else {
				parent.right = replacement;
			}

			replacement.left = current.left;
		}

		// Reaching this point means we deleted the node successfully.
		return true;
	}


	// Returns the data in the root node
	//		if there exists a root,
	//		else it returns -404.
	public int getRoot() {
		if (root != null) return root.data;
		else return -404;
	}


	// Main
	public static void main(String[] args) {}

}
