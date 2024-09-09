#include <iostream>

using namespace std;

void findProduct(int num) {
  if (num == 0) {
    cout << "Product of Digits : 0 " << endl;
    return;
  }

  long int product = 1;
  while (num > 0) {
    product *= num % 10;
    num /= 10;
  }
  cout << "Product of Digits : " << product << endl;
}

int main() {
  int num;
  cout << "Enter a positive number : ";
  cin >> num;
  if (num < 0) {
    cout << "Enter a positive number." << endl;
  } else {
    findProduct(num);
  }
  return 0;
}
