#include <iostream>

using namespace std;

int factorial(int num);
double power(int x, int y);

int main() {
  int x;
  cout << "Enter x value : ";
  cin >> x;
  double result = x - (power(x, 3) / factorial(3)) + (power(x, 5) / factorial(5)) - (power(x, 7) / factorial(7)) + (power(x, 9) / factorial(9));
  cout << "Value of sine series upto 5 terms : " << result << endl;
  return 0;
}

int factorial(int num) {
  long int fact = 1;
  for(int i = 1; i <= num; i++) {
    fact *= i;
  }
  return fact;
}

double power(int x, int y) {
  double result = 1;
  while(y > 0) {
    result *= x;
    y--;
  }
  return result;
}
