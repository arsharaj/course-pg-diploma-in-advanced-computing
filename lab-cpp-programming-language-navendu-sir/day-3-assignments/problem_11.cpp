#include <iostream>

using namespace std;

int power(int num, int x) {
  int result = 1;
  while (x) {
    result *= num;
    x--;
  }
  return result;
}

int findDigits(int num) {
  int digits = 0;
  while (num > 0) {
    digits += 1;
    num /= 10;
  }
  return digits;
}

void checkArmstrong(int num) {
  int digits = findDigits(num), sum = 0, temp = num;
  while (temp > 0) {
    sum += power((temp % 10), digits);
    temp /= 10;
  }
  if (sum == num) {
    cout << num << " is an armstrong number." << endl;
  } else {
    cout << num << " is not an armstrong number." << endl;
  }
}

int main() {
  int num;
  cout << "Enter a positive number : ";
  cin >> num;
  if (num < 0) {
    cout << "Enter a positive number." << endl;
  } else {
    checkArmstrong(num);
  }
  return 0;
}
