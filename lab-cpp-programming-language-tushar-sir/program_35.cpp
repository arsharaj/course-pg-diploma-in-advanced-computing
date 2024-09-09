#include <iostream>

using namespace std;

int main() {
  int n;
  cout << "Enter n : ";
  cin >> n;
  int *arr = new int[n];
  for(int i = 0; i < n; i++) {
    cin >> arr[i];
  }
  cout << "Marks of a student in n subjects : ";
  for(int i = 0; i < n; i++) {
    cout << arr[i] << endl;
  }
  cout << endl;
  free(arr);
  return 0;
}
