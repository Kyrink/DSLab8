/**
 * AVLTree.java - simulates an AVL tree class
 * 
 * @author abbasjabor sethtedder kyrinkalonji
 * @version 29 March 2023
 *
 */
public class AVLTree {
	/**
	 * Nested class used for AVL tree
	 */
	private class Node {
		int value, height;
		Node left, right;

		/**
		 * Creates nodes necessary for an AVL tree
		 * 
		 * @param value the key value of the node
		 */
		public Node(int value) {
			this.value = value;
			height = 1;
		}
	}

	private Node root;

	/**
	 * creates an empty AVL tree
	 */
	public AVLTree() {
		root = null;
	}

	// Helper methods for balancing the tree
	private int getHeight(Node node) {
		if (node == null) {
			return 0;
		}
		return node.height;
	}

	private int getBalance(Node node) {
		if (node == null) {
			return 0;
		}
		return getHeight(node.left) - getHeight(node.right);
	}

	private Node leftRotate(Node x) {
		Node y = x.right;
		Node T2 = y.left;
		y.left = x;
		x.right = T2;
		x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
		y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
		return y;
	}

	private Node rightRotate(Node y) {
		Node x = y.right;
		Node T2 = x.left;
		x.left = y;
		y.right = T2;
		y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
		x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
		return y;
	}

	/**
	 * Abbas - adds a value to an AVL tree by calling on the private add method
	 * 
	 * @param value the value you want added
	 */
	public void add(int value) {
		add(root, value);
	}

	/**
	 * Abbas - add a node to the AVL Tree by recursively calling on this method 
	 * and then balance the tree once the nodes been added
	 * 
	 * @param node  the node you're currently on
	 * @param value the value you want to add
	 * @return the node added or the node already in the AVL tree
	 */
	private Node add(Node node, int value) {
		if (node == null) {
			return new Node(value);
		}
		// Recursively calls on itself until the value reaches it's correct position for
		// it to be added
		if (value < node.value) {
			node.left = add(node.left, value);
		} else if (value > node.value) {
			node.right = add(node.right, value);
		} else {
			return node;
		}
		// set the height of the node
		node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

		// obtain the height difference between the nodes children
		int balance = getBalance(node);

		// Rotate the tree if necessary
		if (balance > 1 && value < node.left.value) {
			return rightRotate(node);

		}
		if (balance < -1 && value > node.right.value) {
			return leftRotate(node);
		}
		if (balance > 1 && value > node.left.value) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}
		if (balance < -1 && value < node.right.value) {
			node.right = rightRotate(node.right);
			return leftRotate(node);

		}
		return node;

	}
	//Seth: print()
	//Baseline code sourced from Abbas bfs() method.
	/**
	 * Returns a string containing all information in tree.
	 * @return
	 */
	public String print() {
		String result = new String();
		if (root == null) {
			return "Empty!";
		}
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			result += node.value + " ";
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
		return result;
	}

}
