package data_structure;

public interface MySinglyLinkedList {
	void add(int elem);
	void addAll(MySinglyLinkedList otherList);
	int remove(int elem, int index);
}
