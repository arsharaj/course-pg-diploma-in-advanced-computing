#include <iostream>

using namespace std;

int* findSum(int num1, int num2);

int main() {
  int num1, num2;
  cout << "Enter number 1 : ";
  cin >> num1;
  cout << "Enter number 2 : ";
  cin >> num2;

  int *dangle = findSum(num1, num2);

  cout << "Sum = " << *dangle << endl;

  int *ptr;

  {
    int var = 12;
    ptr = &var;
  }

  cout << "Variable through Pointer : " << *ptr << endl;
  cout << "Variable : " << var << endl;

  *ptr = 14;

  cout << "Variable through Pointer : " << *ptr << endl;
  cout << "Variable through Pointer : " << *ptr << endl;
  cout << "Variable through Pointer : " << *ptr << endl;
  cout << "Variable through Pointer : " << *ptr << endl;

  return 0;
}

int* findSum(int num1, int num2) {
  int sum = num1 + num2;
  return &sum;
}
