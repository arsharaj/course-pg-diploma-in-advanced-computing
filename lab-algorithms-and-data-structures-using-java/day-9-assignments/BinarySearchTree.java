public class BinarySearchTree {
	private class Node {
		private int data;
		private Node left;
		private Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	private Node root;

	public BinarySearchTree() {
		this.root = null;
	}

	public void insert(int data) {
		Node newNode = new Node(data);

		if (root == null) {
			root = newNode;
		} else {
			insertInTree(root, newNode);
		}
	}

	private void insertInTree(Node root, Node newNode) {
		if (newNode.data < root.data) {
			if (root.left == null) {
				root.left = newNode;
			} else {
				insertInTree(root.left, newNode);
			}
		} else {
			if (root.right == null) {
				root.right = newNode;
			} else {
				insertInTree(root.right, newNode);
			}
		}
	}

	public void displayInOrder() {
		System.out.print("Tree : ");
		displayInOrderHelper(this.root);
		System.out.println();
	}

	private void displayInOrderHelper(Node root) {
		if (root == null) {
			return;
		}

		displayInOrderHelper(root.left);
		System.out.print(root.data + " ");
		displayInOrderHelper(root.right);
	}

	public void displayPreOrder() {
		System.out.print("Tree : ");
		displayPreOrderHelper(this.root);
		System.out.println();
	}

	private void displayPreOrderHelper(Node root) {
		if (root == null) {
			return;
		}

		System.out.print(root.data + " ");
		displayPreOrderHelper(root.left);
		displayPreOrderHelper(root.right);
	}

	public void displayPostOrder() {
		System.out.print("Tree : ");
		displayPostOrderHelper(this.root);
		System.out.println();
	}

	private void displayPostOrderHelper(Node root) {
		if (root == null) {
			return;
		}

		displayPostOrderHelper(root.left);
		displayPostOrderHelper(root.right);
		System.out.print(root.data + " ");
	}
}
