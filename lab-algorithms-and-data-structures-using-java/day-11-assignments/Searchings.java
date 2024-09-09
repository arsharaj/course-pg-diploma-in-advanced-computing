package assignment_11;

public class Searchings {

	public static int linearSearch(int[] array, int element) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == element) {
				return i;
			}
		}
		return -1;
	}

	public static int binarySearch(int[] array, int element) {
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

}
