#include <iostream>

using namespace std;

int findMin(int arr[], int &size) {
  int smallest = arr[0];
  for (int i = 0; i < size; i++) {
    smallest = (arr[i] < smallest) ? arr[i] : smallest;
  }
  return smallest;
}

int main() {
  int size;
  cout << "Enter the size of the array : ";
  cin >> size;

  if (size <= 0) {
    cout << "Enter a valid size." << endl;
  } else {
    int arr[size];
    for (int i = 0; i < size; i++) {
      cout << "Enter element number " << (i + 1) << " : ";
      cin >> arr[i];
      if (arr[i] < 0) {
        cout << "Enter a positive number." << endl;
	i--;
      }
    }
    int smallest = findMin(arr, size);
    cout << "Minimum Element is : " << smallest << endl;
  }

  return 0;
}
