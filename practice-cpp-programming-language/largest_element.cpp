#include <iostream>

using namespace std;

int main() {
  int n, largest = 0, temp;
  cout << "Enter no of elements : ";
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> temp;
    if (temp > largest)
      largest = arr[i];
  }

  cout << "Largest Element = " << largest << "\n";
  return 0;
}
