#include <iostream>
#include <cmath>

using namespace std;

int main() {
  int num;
  cout << "Enter a number : ";
  cin >> num;

  if(num == 1) {
    cout << "1 is not prime." << endl;
    return 0;
  }

  int root = sqrt(num);
  for(int i = 2; i < root; i++) {
    if (num % i == 0) {
      cout << num << " is not prime." << endl;
      return 0;
    }
  }

  cout << num << " is prime." << endl;

  return 0;
}
