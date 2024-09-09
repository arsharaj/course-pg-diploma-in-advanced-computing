#include <iostream>

using namespace std;

void findSum(int num) {
  long int sum = 0;
  while (num != 0) {
    sum += num % 10;
    num /= 10;
  }
  sum = (sum < 0) ? (sum * -1) : sum;
  cout << "Sum of digits : " << sum << endl;
}

int main() {
  int num;
  cout << "Enter a number : ";
  cin >> num;
  findSum(num);
  return 0;
}
