package searching_sorting;

public interface SearchingAndSorting {

	static int linearSearch(int[] array, int element) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == element) {
				return i;
			}
		}
		return -1;
	}

	static int binarySearch(int[] array, int element) {
		int left = 0;
		int right = array.length;
		while (left < right) {
			int mid = (left + right) / 2;
			if (array[mid] > element) {
				right = mid + 1;
			} else if (array[mid] < element) {
				left = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	static void bubbleSort(int[] array) {
		int size = array.length;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	static void selectionSort(int[] array) {
		int size = array.length;
		for (int i = 0; i < (size - 1); i++) {
			for (int j = i + 1; j < size; j++) {
				if (array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}

	static void insertionSort(int[] array) {
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

	static void quickSort(int[] array) {
		quickSortHelper(array, 0, array.length - 1);
	}

	static void quickSortHelper(int[] array, int left, int right) {
		if (left > right) {
			return;
		}
		
		int pivot = partition(array, left, right);
		quickSortHelper(array, left, pivot - 1);
		quickSortHelper(array, pivot + 1, right);
	}

	static int partition(int[] array, int left, int right) {
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

	static void mergeSort(int[] array) {
		
	}
}
