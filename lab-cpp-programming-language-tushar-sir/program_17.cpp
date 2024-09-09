#include <iostream>

using namespace std;

int main() {
  int num;
  cout << "Enter a number : ";
  cin >> num;
  int space = 0;
  for (int i = num; i >= 1; i--) {
    for (int j = 1; j <= i; j++) {
      cout << j << " ";
    }
    for (int j = 0; j < space; j++) {
      cout << "    ";
    }
    space += 1;
    for (int j = i; j >= 1; j--) {
      cout << j << " ";
    }
    cout << endl;
  }
  return 0;
}