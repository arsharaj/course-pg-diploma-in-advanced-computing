package tester;

import java.util.Scanner;

import searching_sorting.SearchingAndSorting;

public class TestSearchingAndSorting {
	private static int[] array;
	
	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			int choice = 0;
			do {
				try {
					System.out.println("--- Test Searching and Sorting ---");
					System.out.println("1. Initialize an array with a capacity");
					System.out.println("2. Linear Search");
					System.out.println("3. Binary Search (Condition :  array should be sorted)");
					System.out.println("4. Display the array content.");
					System.out.println("5. Selection Sort");
					System.out.println("6. Bubble Sort");
					System.out.println("7. Insertion Sort");
					System.out.println("8. Quick Sort");
					System.out.println("9. Merge Sort");
					System.out.println("0. Exit");
					System.out.print("Enter your choice : ");
					choice = scan.nextInt();
					switch (choice) {
					case 1:
						initializeArray(scan);
						displayArray();
						break;
					case 2:
						linearSearchHelper(scan);
						break;
					case 3:
						binarySearchHelper(scan);
						break;
					case 4:
						displayArray();
						break;
					case 5:
						SearchingAndSorting.selectionSort(array);
						displayArray();
						break;
					case 6:
						SearchingAndSorting.bubbleSort(array);
						displayArray();
						break;
					case 7:
						SearchingAndSorting.insertionSort(array);
						displayArray();
						break;
					case 8:
						SearchingAndSorting.quickSort(array);
						displayArray();
						break;
					case 9:
						SearchingAndSorting.mergeSort(array);
						displayArray();
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

	private static void linearSearchHelper(Scanner scan) {
		System.out.println("Enter the element to be searched : ");
		int element = scan.nextInt();
		if (array != null) {
			int index = SearchingAndSorting.linearSearch(array, element);
			if (index == -1) {
				System.out.println("Element not present in the array.");
			} else {
				System.out.println("Element present at " + (index + 1) + " position.");
			}
		} else {
			System.out.println("Initialize the array first.");
		}
	}

	private static void binarySearchHelper(Scanner scan) {
		System.out.println("Enter the element to be searched : ");
		int element = scan.nextInt();
		if (array != null) {
			int index = SearchingAndSorting.binarySearch(array, element);
			if (index == -1) {
				System.out.println("Element not present in the array.");
			} else {
				System.out.println("Element present at " + (index + 1) + " position.");
			}
		} else {
			System.out.println("Initialize the array first.");
		}
	}
	
	private static void displayArray() {
		System.out.println("Array : ");
		if (array != null) {
			for (int i = 0; i < array.length; i++) {
				System.out.println(array[i] + " ");
			}
		}
		System.out.println();
	}

	private static void initializeArray(Scanner scan) {
		System.out.println("Enter the size of the array : ");
		int size = scan.nextInt();
		array = new int[size];
		System.out.println("Enter the elements in the array :- ");
		for (int i = 0; i < size; i++) {
			System.out.println("Enter element at " + (i + 1) + " position : ");
			array[i] = scan.nextInt();
		}
		System.out.println("Array initialized.");
	}

}
