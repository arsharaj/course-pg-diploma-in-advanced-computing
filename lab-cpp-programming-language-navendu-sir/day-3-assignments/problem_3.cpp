#include <iostream>

using namespace std;

void findSum(int &a, int &b) {
  long int sum = 0;
  for (int i = a; i <= b; i++) {
    sum += i;
  }
  cout << "Sum of " << a << " and " << b << " : " << sum << endl;
}

int main() {
  int m, n;
  cout << "Enter a positive M : ";
  cin >> m;
  cout << "Enter a positive N : ";
  cin >> n;

  if (m < 0 || n < 0) {
    cout << "Enter a positive number." << endl;
    return 0;
  }

  if (m <= n) {
    findSum(m, n);
  } else {
    findSum(n, m);
  }

  return 0;
}
