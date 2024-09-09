#include <iostream>

using namespace std;

int main() {
  int num_1, num_2;
  cout << "Enter Num 1 : ";
  cin >> num_1;
  cout << "Enter Num 2 : ";
  cin >> num_2;

  // Using third variable
  int temp = num_1;
  num_1 = num_2;
  num_2 = temp;
  cout << "Number 1 is " << num_1 << endl << "Number 2 is " << num_2 << endl;

  // Without using third variable
  num_1 = num_1 + num_2;
  num_2 = num_1 - num_2;
  num_1 = num_1 - num_2;
  cout << "Number 1 is " << num_1 << endl << "Number 2 is " << num_2 << endl;

  return 0;
}

