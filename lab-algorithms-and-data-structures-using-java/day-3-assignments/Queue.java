import java.util.NoSuchElementException;

public class Queue {
	private int[] queue;
	private int front;
	private int rear;

	public Queue(int capacity) {
		this.queue = new int[capacity];
		this.front = this.rear = -1;
	}

	public int size() {
		return rear - front + 1;
	}

	public boolean isEmpty() {
		return (this.front == -1) && (this.rear == -1);
	}

	public boolean isFull() {
		return this.rear == queue.length - 1;
	}

	public void add(int element) {
		if (isEmpty()) {
			this.front++;
			this.rear++;
			queue[this.front] = element;
		} else if (isFull()) {
			System.out.println("Queue is full.");
		} else {
			this.rear++;
			queue[this.rear] = element;
		}
	}

	public int remove() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue is empty.");
		} else {
			int element = queue[this.front++];
			if (this.rear < this.front) {
				this.front = this.rear = -1;
			}
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
			System.out.println("Queue is empty.");
		} else {
			System.out.print("Queue content : ");
			for (int i = front; i <= rear; i++) {
				System.out.print(queue[i] + " ");
			}
			System.out.println();
		}
	}
}
