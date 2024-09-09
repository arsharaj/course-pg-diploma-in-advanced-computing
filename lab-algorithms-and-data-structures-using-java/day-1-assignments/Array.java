import java.util.Scanner;

public class Array {
	private int size;
	private int[] array;

	public Array(int size) {
		this.size = size;
		this.array = new int[this.size];
	}

	public void displayOdd() {
		System.out.print("Odd Array : ");
		for (int element : array) {
			if ((element & 1) == 1)
				System.out.print(element + " ");
		}
		System.out.println();
	}

	public void displayEven() {
		System.out.print("Even Array : ");
		for (int element : array) {
			if ((element & 1) == 0)
				System.out.print(element + " ");
		}
		System.out.println();
	}

	public double findAverage() {
		return (double) this.findSum() / this.size;
	}

	public int findMax() {
		int max = this.array[0];
		for (int element : this.array) {
			max = (element > max) ? element : max;
		}
		return max;
	}

	public int findSum() {
		int sum = 0;
		for (int element : this.array) {
			sum += element;
		}
		return sum;
	}

	public void replaceNth(Scanner scan) {
		System.out.print("Enter the position of the element to be replaced : ");
		int position = scan.nextInt() - 1;
		System.out.print("Enter the new element : ");
		this.array[position] = scan.nextInt();
		System.out.println("Array after changing the element.");
		this.display();
	}

	public void reverse() {
		for (int i = 0; i < (this.size) / 2; i++) {
			int temp = this.array[i];
			this.array[i] = this.array[size - i - 1];
			this.array[size - i - 1] = temp;
		}
		System.out.print("Reversed ");
		this.display();
	}

	public void display() {
		System.out.print("Array : ");
		for (int element : array) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
}
