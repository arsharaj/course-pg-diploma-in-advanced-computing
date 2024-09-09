#include <iostream>

using namespace std;

bool isPrime(int &num) {
  bool prime = true;
  
  if (num == 0 || num == 1) {
    prime = false;
  }

  for (int i = 2; i < num; i++) {
    if (num % i == 0) {
      prime = false;
      break;
    }
  }

  return prime;
}

void findPrimes(int &a, int &b) {
  cout << "Prime Numbers between " << a << " and " << b << " : ";
  for (int i = a; i <= b; i++) {
    if (isPrime(i)) {
      cout << i << " ";
    }
  }
  cout << endl;
}

int main() {
  int m, n;
  cout << "Enter a positive number M : ";
  cin >> m;
  cout << "Enter a positive number N : ";
  cin >> n;
  
  if (m < 0 || n < 0) {
    cout << "Enter a positive number." << endl;
    return 0;
  }

  if (m <= n) {
    findPrimes(m, n);
  } else {
    findPrimes(n, m);
  }

  return 0;
}
