#include <iostream>

using namespace std;

int main() {
  int marks[5], sum = 0;
  cout << "Enter marks of 5 subjects (0 - 100): ";
  for (int i = 0; i < 5; i++) {
    cin >> marks[i];
    if (marks[i] < 0 || marks[i] > 100) {
      cout << "Invalid Input !" << endl;
      i = i - 1;
      continue;
    }
    sum += marks[i];
  }
  cout << "Average = " << (sum / 5) << endl;
  return 0;
}

