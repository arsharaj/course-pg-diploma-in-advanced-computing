package assignment_11;

public class Sortings {

	public static void selectionSort(int[] array) {
		for (int i = 0; i < (array.length - 1); i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}

	public static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	public static void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int key = array[i];
			int j = i - 1;
			while (j > 0 && array[j] > key) {
				array[j + 1] = array[j];
				j--;
			}
			array[j] = key;
		}
	}

	public static void quickSort(int[] array) {
		quickSortHelper(array, 0, array.length - 1);
	}

	private static void quickSortHelper(int[] array, int left, int right) {
		if (left > right) {
			return;
		}

		int pivot = partition(array, left, right);
		quickSortHelper(array, left, pivot - 1);
		quickSortHelper(array, pivot + 1, right);
	}

	private static int partition(int[] array, int left, int right) {
		int pivotElement = array[right];
		int pivotIndex = left - 1;
		for (int i = left; i < right; i++) {
			if (array[i] < pivotElement) {
				pivotIndex++;
				int temp = array[pivotIndex];
				array[pivotIndex] = array[i];
				array[i] = temp;
			}
		}

		pivotIndex++;
		int temp = array[pivotIndex];
		array[pivotIndex] = array[right];
		array[right] = temp;

		return pivotIndex;
	}

	public static void mergeSort(int[] array) {
		if (array.length <= 1) {
			return;
		}

		int mid = array.length / 2;
		int[] firstArray = new int[mid];
		int[] secondArray = new int[array.length - mid];
		System.arraycopy(array, 0, firstArray, 0, mid);
		System.arraycopy(array, mid, secondArray, 0, array.length - mid);
		
		mergeSort(firstArray);
		mergeSort(secondArray);
		merge(array, firstArray, secondArray);
	}

	private static void merge(int[] array, int[] firstArray, int[] secondArray) {
		int arrayIndex = 0;
		int firstIndex = 0;
		int secondIndex = 0;
		while (firstIndex < firstArray.length && secondIndex < secondArray.length) {
			if (firstArray[firstIndex] < secondArray[secondIndex]) {
				array[arrayIndex] = firstArray[firstIndex];
				firstIndex++;
				arrayIndex++;
			} else {
				array[arrayIndex] = secondArray[secondIndex];
				secondIndex++;
				arrayIndex++;
			}
		}
		while (firstIndex < firstArray.length) {
			array[arrayIndex] = firstArray[firstIndex];
			arrayIndex++;
			firstIndex++;
		}
		while (secondIndex < secondArray.length) {
			array[arrayIndex] = secondArray[secondIndex];
			arrayIndex++;
			secondIndex++;
		}
	}

}
