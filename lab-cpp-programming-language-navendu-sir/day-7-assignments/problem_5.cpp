#include <iostream>

using namespace std;

bool findKey(int arr[], int size, int key) {
  for (int i = 0; i < size; i++) {
    if (arr[i] == key) {
      return true;
    }
  }
  return false;
}

int main() {
  int size;
  cout << "Enter the number of elements : ";
  cin >> size;
  if (size < 1) {
    cout << "Enter a valid size." << endl;
  } else {
    int arr[size];
    for (int i = 0; i < size; i++) {
      cout << "Enter number " << (i + 1) << " element : ";
      cin >> arr[i];
    }

    int key;
    cout << "Enter the element to search : ";
    cin >> key;

    if (findKey(arr, size, key)) {
      cout << "Element present in the array." << endl;
    } else {
      cout << "Element not present in the array." << endl;
    }
  }
  return 0;
}
