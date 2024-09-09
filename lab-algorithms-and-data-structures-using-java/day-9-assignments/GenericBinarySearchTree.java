class Node<T extends Comparable<T>> {
	private T data;
	private Node<T> left;
	private Node<T> right;

	public Node(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public Node<T> getLeft() {
		return left;
	}

	public Node<T> getRight() {
		return right;
	}

}

public class GenericBinarySearchTree<T extends Comparable<T>> {

	private Node<T> root;

	public GenericBinarySearchTree() {
		this.root = null;
	}

	public void insert(T data) {
		Node newNode = new Node(data);

		if (root == null) {
			root = newNode;
		} else {
			insertInTree(root, newNode);
		}
	}

	private void insertInTree(Node<T> root, Node<T> newNode) {
		if (newNode.getData().compareTo(root.getData()) == -1) {
			if (root.getLeft() == null) {
				root.setLeft(newNode);
			} else {
				insertInTree(root.getLeft(), newNode);
			}
		} else {
			if (root.getRight() == null) {
				root.setRight(newNode); 
			} else {
				insertInTree(root.getRight(), newNode);
			}
		}
	}

	public void displayInOrder() {
		System.out.print("Tree : ");
		displayInOrderHelper(this.root);
		System.out.println();
	}

	private void displayInOrderHelper(Node<T> root) {
		if (root == null) {
			return;
		}

		displayInOrderHelper(root.getLeft());
		System.out.print(root.getData() + " ");
		displayInOrderHelper(root.getRight());
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

		System.out.print(root.getData() + " ");
		displayPreOrderHelper(root.getLeft());
		displayPreOrderHelper(root.getRight());
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

		displayPostOrderHelper(root.getLeft());
		displayPostOrderHelper(root.getRight());
		System.out.print(root.getData() + " ");
	}
}
