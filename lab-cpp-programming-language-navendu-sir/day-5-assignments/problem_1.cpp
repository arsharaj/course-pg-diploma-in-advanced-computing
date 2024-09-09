#include <iostream>

using namespace std;

void findReverse(int n) {
  int reverse = 0;
  while (n > 0) {
    reverse = (reverse * 10) + (n % 10);
    n /= 10;
  }
  cout << "Reverse of " << n << " : " << reverse << endl;
}

int main() {
  int n;
  cout << "Enter a positive integer n : ";
  cin >> n;
  if (n >= 0) {
    findReverse(n);
  } else {
    cout << "Enter a positive integer." << endl;
  }
  return 0;
}
