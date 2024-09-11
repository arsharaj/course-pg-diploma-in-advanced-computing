package data_structure;

public class MySinglyLinkedListImpl implements MySinglyLinkedList {
	public static class Node {
		private int data;
		private Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	private Node head;
	
	@Override
	public void add(int elem) {
		Node newNode = new Node(elem);
		
		if (head == null) {
			head = newNode;
		} else {
			Node temp = head;
			while (temp.next != null && temp.next.data < elem) {
				temp = temp.next;
			}
			newNode.next = temp.next;
			temp.next = newNode;
		}
	}

	@Override
	public void addAll(MySinglyLinkedList otherList) {
		
	}

	@Override
	public int remove(int elem, int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		String result = "Element : ";
		Node temp = head;
		while (temp != null) {
			result = result + temp.data + ", ";
			temp = temp.next;
		}
		return result;
	}
	
}
