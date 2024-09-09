#include <iostream>

using namespace std;

int main() {
  int length, breadth;
  cout << "Enter length : ";
  cin >> length;
  cout << "Enter breadth : ";
  cin >> breadth;
  
  for(int i = 1; i <= length; i++) {
    for(int j = 1; j <= breadth; j++) {
      if (i == 1 || i == length || j == 1 || j == breadth) {
        cout << "* ";
      } else {
        cout << "  ";
      }
    }
    cout << endl;
  }

  return 0;
}