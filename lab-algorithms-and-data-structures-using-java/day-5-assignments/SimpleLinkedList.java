import java.util.NoSuchElementException;

public class SimpleLinkedList {
	private static class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node head;

	public SimpleLinkedList() {
		this.head = null;
	}

	public void addAtBegin(int element) {
		Node newNode = new Node(element);

		if (head == null) {
			head = newNode;
		} else {
			Node temp = head;
			head = newNode;
			newNode.next = temp;
		}
	}

	public void addAtEnd(int element) {
		Node newNode = new Node(element);
		if (head == null) {
			head = newNode;
		} else {
			Node temp;
			for (temp = head; temp.next != null; temp = temp.next)
				;
			temp.next = newNode;
		}
	}

	public void addAtSpecificPosition(int element, int position) {
		Node newNode = new Node(element);
		if (head == null) {
			head = newNode;
		} else {                                 
			Node temp;

			int counter;
			for (temp = head, counter = 0; counter == position - 1; temp = temp.next, counter++)
				;
			newNode.next = temp.next;
			temp.next = newNode;
		}
	}

	public int deleteAtBegin() {
		if (head == null) {
			throw new NoSuchElementException("List is empty.");
		} else {
			int data = head.data;
			head = head.next;
			return data;
		}
	}

	public int deleteAtEnd() {
		if (head == null) {
			throw new NoSuchElementException("List is empty.");
		} else if (head.next == null) {
			int data = head.data;
			head = null;
			return data;
		} else {
			Node temp;
			for (temp = head; temp.next.next != null; temp = temp.next)
				;
			int data = temp.next.data;
			temp.next = null;
			return data;
		}
	}

	public int deleteAtSpecificPosition(int position) {
		if (head == null) {
			throw new NoSuchElementException("List is empty.");
		} else if(head.next == null) {
			return this.deleteAtEnd();
		}else {
			Node temp;
			int counter;
			for (temp = head, counter = 1; counter < position - 1; temp = temp.next, counter++) {

			}
			int data = temp.next.data;
			System.out.println("Data" + data);
			if (temp == head) {
				head = head.next;
			} else if (temp.next.next == null) {
				temp.next = null;
			} else {
				temp.next = temp.next.next;
			}
			return data;
		}
	}

	public void display() {
		Node temp;
		System.out.print("Linked List : ");
		for (temp = head; temp != null; temp = temp.next) {
			System.out.print(temp.data + " ");
		}
		System.out.println();
	}

	public int size() {
		Node temp;
		int size = 0;
		for (temp = head; temp != null; temp = temp.next) {
			size++;
		}
		return size;
	}

	public boolean isEmpty() {
		return this.head == null;
	}

}
