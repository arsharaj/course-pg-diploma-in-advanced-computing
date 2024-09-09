#include <iostream>

using namespace std;

void swap(int &numOne, int &numTwo) {
  cout << "--- Before Swapping ---" << endl;
  cout << "First Number : " << numOne << endl;
  cout << "Second Number : " << numTwo << endl;
  int temp = numOne;
  numOne = numTwo;
  numTwo = temp;
  cout << "--- After Swapping ---" << endl;
  cout << "First Number : " << numOne << endl;
  cout << "Second Number : " << numTwo << endl;
}

void swap(char &numOne, char &numTwo) {
  cout << "--- Before Swapping ---" << endl;
  cout << "First Number : " << numOne << endl;
  cout << "Second Number : " << numTwo << endl;
  char temp = numOne;
  numOne = numTwo;
  numTwo = temp;
  cout << "--- After Swapping ---" << endl;
  cout << "First Number : " << numOne << endl;
  cout << "Second Number : " << numTwo << endl;
}

void swap(float &numOne, float &numTwo) {
  cout << "--- Before Swapping ---" << endl;
  cout << "First Number : " << numOne << endl;
  cout << "Second Number : " << numTwo << endl;
  float temp = numOne;
  numOne = numTwo;
  numTwo = temp;
  cout << "--- After Swapping ---" << endl;
  cout << "First Number : " << numOne << endl;
  cout << "Second Number : " << numTwo << endl;
}

void swap(double &numOne, double &numTwo) {
  cout << "--- Before Swapping ---" << endl;
  cout << "First Number : " << numOne << endl;
  cout << "Second Number : " << numTwo << endl;
  double temp = numOne;
  numOne = numTwo;
  numTwo = temp;
  cout << "--- After Swapping ---" << endl;
  cout << "First Number : " << numOne << endl;
  cout << "Second Number : " << numTwo << endl;
}

int main() {
  int p = 1, q = 2;
  swap(p, q);
  p = -12, q = 12;
  swap(p, q);
  char x = 'a', y = 'z';
  swap(x, y);
  float a = 1213.0982f, b = 1232.34f;
  swap(a, b);
  double c = 12.04, d = 13.96;
  swap(c, d);
  return 0;
}
