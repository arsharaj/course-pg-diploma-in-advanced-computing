#include <iostream>

using namespace std;

void findFirstDigit(int num) {
  int first = num;
  while (num > 0) {
    first = num % 10;
    num /= 10;
  }
  cout << "First Digit of " << num << " : " << first << endl;
}

int main() {
  int num;
  cout << "Enter a positive number : ";
  cin >> num;

  if (num < 0) {
    cout << "Enter a positive number." << endl;
  } else {
    findFirstDigit(num);
  }

  return 0;
}
