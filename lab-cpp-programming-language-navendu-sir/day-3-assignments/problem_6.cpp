#include <iostream>

using namespace std;

void findSum(int num) {
  long int sum = 0;
  while (num > 0) {
    sum += num % 10;
    num /= 10;
  }
  cout << "Sum of digits : " << sum << endl;
}

int main() {
  int num;
  cout << "Enter a positive number : ";
  cin >> num;
  if (num < 0) {
    cout << "Enter a positive number." << endl;
  } else {
    findSum(num);
  }
  return 0;
}
