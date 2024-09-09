#include <iostream>

using namespace std;

void findFactors(int &n) {
  cout << "Factors of " << n << " : ";
  for (int i = 1; i <= n; i++) {
    if (n % i == 0) {
      cout << i << " ";
    }
  }
  cout << endl;
}

int main() {
  int n;
  cout << "Enter a positive integer n : ";
  cin >> n;
  if (n > 0) {
    findFactors(n);
  } else if (n < 0) {
    cout << "Enter a positive number." << endl;
  } else {
    cout << "Factors of 0 : 0 1 " << endl;
  }
  return 0;
}
