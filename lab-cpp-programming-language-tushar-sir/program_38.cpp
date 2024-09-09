#include <iostream>

using namespace std;

double Multiply(double first = 1, double second = 1, double third = 1, double fourth = 1) {
  return first * second * third * fourth;
}

int main() {
  cout << Multiply(9) << endl;
  cout << Multiply(2, 9.3) << endl;
  cout << Multiply(2.3, 9.1, 4.2) << endl;
  cout << Multiply(1.54, 1.98, 4.36, 2) << endl;
  return 0;
}
