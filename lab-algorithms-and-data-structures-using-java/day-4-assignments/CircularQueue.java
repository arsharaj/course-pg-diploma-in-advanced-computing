import java.util.NoSuchElementException;

public class CircularQueue {
	private int[] queue;
	private int front;
	private int rear;
	private int size;
	private int capacity;

	public CircularQueue(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.queue = new int[capacity];
		this.front = this.rear = 0;
	}
	
	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public boolean isFull() {
		return this.size == capacity;
	}

	public void add(int element) {
		if (isFull()) {
			System.out.println("Circular queue is full.");
		} else {
			this.size++;
			queue[this.rear] = element;
			this.rear = (this.rear + 1) % capacity;
		}
	}

	public int remove() {
		if (isEmpty()) {
			throw new NoSuchElementException("Circular queue is empty.");
		} else {
			this.size--;
			int element = queue[this.front % capacity];
			this.front = (this.front + 1) % capacity;
			return element;
		}

	}

	public int peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue is empty.");
		} else {
			return queue[this.front];
		}
	}

	public void display() {
		if (isEmpty()) {
			System.out.println("Circular queue is empty.");
		} else {
			System.out.print("Circular queue content : ");
			for (int i = 0; i < size ; i++) {
				System.out.print(queue[(front + i) % capacity] + " ");
			}
			System.out.println();
		}
	}

}
