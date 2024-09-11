#include <iostream>

using namespace std;

int fibonacci(int num);

int main() {
  int num;
  cout << "Enter n for nth term of fibonacci : ";
  cin >> num;
  cout << "Fibonacci Number : " << fibonacci(num) << endl;
  return 0;
}

int fibonacci(int num) {
  if (num == 0) return 0;
  else if (num == 1) return 1;
  else return fibonacci(num - 1) + fibonacci(num - 2);
}
