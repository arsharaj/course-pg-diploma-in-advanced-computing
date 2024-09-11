#include <iostream>

using namespace std;

int main() {
  int *ptr;
  {
    int var = 34;
    ptr = &var;
  }

  cout << *ptr << endl;
  return 0;
}
