public class CircularLinkedList {
	private static class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node head;
	private Node tail;

	public CircularLinkedList() {
		this.head = null;
		this.tail = null;
	}

	public void display() {
		System.out.println("Circular linked list : ");
		Node temp = head;
		while (temp != tail) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		if (tail != null) {
			System.out.println(temp.data + " ");
		}
		System.out.println();
	}

	public void insertAtBegin(int data) {
		Node newNode = new Node(data);

		if (head == null) {
			newNode.next = newNode;
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			newNode.next = head;
			head = newNode;
		}
	}

	public int size() {
		int size = 0;
		Node temp = head;
		while (temp != tail) {
			size++;
			temp = temp.next;
		}
		if (tail != null) {
			size++;
		}
		return size;
	}

	public boolean isEmpty() {
		return head == null;
	}

}
