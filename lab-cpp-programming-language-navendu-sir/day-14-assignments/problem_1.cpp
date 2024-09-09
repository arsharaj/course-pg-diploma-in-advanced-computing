#include <iostream>

using namespace std;

template <typename T>
void swapNums(T &numOne, T &numTwo) {
  cout << "--- Before Swapping ---" << endl;
  cout << "First Number : " << numOne << endl;
  cout << "Second Number : " << numTwo << endl;
  T temp = numOne;
  numOne = numTwo;
  numTwo = temp;
  cout << "--- After Swapping ---" << endl;
  cout << "First Number : " << numOne << endl;
  cout << "Second Number : " << numTwo << endl;
}

int main() {
  int p = 1, q = 2;
  swapNums <int> (p, q);
  p = -12, q = 12;
  swapNums <int> (p, q);
  char x = 'a', y = 'z';
  swapNums <char> (x, y);
  float a = 1213.0982f, b = 1232.34f;
  swapNums <float> (a, b);
  double c = 12.04, d = 13.96;
  swapNums <double> (c, d);
  return 0;
}
