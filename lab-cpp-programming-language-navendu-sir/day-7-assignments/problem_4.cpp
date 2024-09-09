#include <iostream>

using namespace std;

int findSecondSmallest(int arr[], int size) {
  int smallest = (arr[0] < arr[1]) ? arr[0] : arr[1];
  int secondSmallest = (arr[0] < arr[1]) ? arr[1] : arr[0];

  for (int i = 3; i < size; i++) {
    if (arr[i] < smallest) {
      secondSmallest = smallest;
      smallest = arr[i];
      continue;
    }
    if (arr[i] < secondSmallest) {
      secondSmallest = arr[i];
    }
  }

  return secondSmallest;
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
    int secondSmallest = findSecondSmallest(arr, size);
    cout << "Second smallest element : " << secondSmallest << endl;
  }
  return 0;
}
