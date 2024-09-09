#include <iostream>

using namespace std;

void checkPalindrome(int num) {
  int temp = num, reverse = 0;
  while (temp > 0) {
    reverse = (reverse * 10) + (temp % 10);
    temp /= 10;
  }
  if (num == reverse) {
    cout << num << " is a palindrome." << endl;
  } else {
    cout << num << " is not a palindrome." << endl;
  }
}

int main() {
  int num;
  cout << "Enter a positive number : ";
  cin >> num;
  if (num < 0) {
    cout << "Enter a positive number." << endl;
  } else {
    checkPalindrome(num);
  }
  return 0;
}
