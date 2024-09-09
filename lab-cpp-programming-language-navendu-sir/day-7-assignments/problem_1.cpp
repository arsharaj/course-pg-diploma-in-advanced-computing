#include <iostream>

using namespace std;

int findMax(int arr[], int &size) {
  int largest = arr[0];
  for (int i = 0; i < size; i++) {
    largest = (arr[i] > largest) ? arr[i] : largest;
  }
  return largest;
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
    int largest = findMax(arr, size);
    cout << "Maximum Element is : " << largest << endl;
  }

  return 0;
}
