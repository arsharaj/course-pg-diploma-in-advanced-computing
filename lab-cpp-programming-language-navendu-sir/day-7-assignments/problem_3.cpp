#include <iostream>

using namespace std;

int findSecondLargest(int arr[], int size) {
  int largest = (arr[0] > arr[1]) ? arr[0] : arr[1];
  int secondLargest = (arr[0] > arr[1]) ? arr[1] : arr[0];

  for (int i = 3; i < size; i++) {
    if (arr[i] > largest) {
      secondLargest = largest;
      largest = arr[i];
      continue;
    }
    if (arr[i] > secondLargest) {
      secondLargest = arr[i];
    }
  }

  return secondLargest;
}

int main() {
  int size;
  cout << "Enter the number of elements (minimum 2) : ";
  cin >> size;
  if (size < 2) {
    cout << "Enter a valid size." << endl;
  } else {
    int arr[size];
    for (int i = 0; i < size; i++) {
      cout << "Enter number " << (i + 1) << " element : ";
      cin >> arr[i];
    }
    int secondLargest = findSecondLargest(arr, size);
    cout << "Second largest element : " << secondLargest << endl;
  }
  return 0;
}
