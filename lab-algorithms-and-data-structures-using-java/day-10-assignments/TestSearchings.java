package assignment_10;

import java.util.Scanner;
import static assignment_10.Searchings.linearSearch;
import static assignment_10.Searchings.binarySearch;
import static assignment_10.Sortings.selectionSort;
import static assignment_10.Sortings.bubbleSort;
import static assignment_10.Sortings.insertionSort;

public class TestSearchings {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			int[] array = null;
			int choice = 0;
			do {
				try {
					System.out.println("--- Searching bases operations ---");
					System.out.println("1. Initialize an array with a capacity.");
					System.out.println("2. Linear Search.");
					System.out.println("3. Binary Search. (Condition : array should be sorted)");
					System.out.println("4. Display the array content.");
					System.out.println("5. Selection Sort.");
					System.out.println("6. Bubble Sort.");
					System.out.println("7. Insertion Sort.");
					System.out.println("0. Exit.");
					System.out.print("Enter a choice : ");
					choice = scan.nextInt();

					switch (choice) {
					case 1:
						initializeArray(scan, array);
						displayArray(array);
						break;
					case 2:
						linearSearchHelper(scan, array);
						break;
					case 3:
						binarySearchHelper(scan, array);
						break;
					case 4:
						displayArray(array);
						break;
					case 5:
						selectionSort(array);
						displayArray(array);
						break;
					case 6:
						bubbleSort(array);
						displayArray(array);
						break;
					case 7:
						insertionSort(array);
						displayArray(array);
						break;
					case 0:
						System.out.println("Thank you for using our services.");
						break;
					default:
						System.out.println("Enter a valid choice.");
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} while (choice != 0);
		}
	}

	private static void initializeArray(Scanner scan, int[] array) {
		System.out.print("Enter the size of the array : ");
		int size = scan.nextInt();
		array = new int[size];
		System.out.println("Enter the elements in the array :- ");
		for (int i = 0; i < size; i++) {
			System.out.print("Enter element at " + (i + 1) + " position : ");
			array[i] = scan.nextInt();
		}
		System.out.println("Array initialized.");
	}

	private static void linearSearchHelper(Scanner scan, int[] array) {
		System.out.println("Enter the element to be searched : ");
		int element = scan.nextInt();
		if (array != null) {
			int index = linearSearch(array, element);
			if (index == -1) {
				System.out.println("Element not present in the array.");
			} else {
				System.out.println("Element present at " + (index + 1) + " position.");
			}
		} else {
			System.out.println("Initialize the array first.");
		}
	}

	private static void binarySearchHelper(Scanner scan, int[] array) {
		System.out.println("Enter the element to be searched : ");
		int element = scan.nextInt();
		if (array != null) {
			int index = binarySearch(array, element);
			if (index == -1) {
				System.out.println("Element not present in the array.");
			} else {
				System.out.println("Element present at " + (index + 1) + " position.");
			}
		} else {
			System.out.println("Initialize the array first.");
		}
	}

	private static void displayArray(int[] array) {
		System.out.print("Array : ");
		if (array != null) {
			for (int i = 0; i < array.length; i++) {
				System.out.print(array[i] + " ");
			}
		}
		System.out.println();
	}
}
