#include <iostream>

using namespace std;

void countDigits(int num, int digit) {
  if (num == 0 && digit == 0) {
    cout << "Number of digits : 1 " << endl;
    return;
  }

  int count = 0;
  while (num > 0) {
    if (digit == (num % 10)) {
      count++;
    }
    num /= 10;
  }
  cout << "Number of digits : " << count << endl;
}

int main() {
  int num;
  cout << "Enter a positive number : ";
  cin >> num;
  if (num < 0) {
    cout << "Enter a positive number." << endl;
  } else {
    int digit;
    cout << "Enter a valid digit : ";
    cin >> digit;
    if (digit < 0) {
      cout << "Enter a valid digit." << endl;
    } else {
      countDigits(num, digit);
    }
  }
  return 0;
}
