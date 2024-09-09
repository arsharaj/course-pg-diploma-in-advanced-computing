#include <iostream>

using namespace std;

int* findMax(int *a, int *b) {
  if((*a) > (*b)) {
    return a;
  } else {
    return b;
  }
}

int main() {
  int num_1, num_2;
  cout << "Enter number 1 : ";
  cin >> num_1;
  cout << "Enter number 2 : ";
  cin >> num_2;
  int *result = findMax(&num_1, &num_2);
  cout << "Maximum : " << (*result) << endl;
  return 0;
}
