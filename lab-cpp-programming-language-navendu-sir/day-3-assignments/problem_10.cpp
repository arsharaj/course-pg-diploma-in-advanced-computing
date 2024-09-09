#include <iostream>

using namespace std;

void checkPerfect(int num) {
  if (num == 0) {
    cout << num << " is not a perfect number." << endl;
    return;
  }

  int factorsSum = 0;
  for (int i = 1; i <= num / 2; i++) {
    if (num % i == 0) {
      factorsSum += i;
    }
  }
  if (num == factorsSum) {
    cout << num << " is a perfect number." << endl;
  } else {
    cout << num << " is not a perfect number." << endl;
  }
}

int main() {
  int num;
  cout << "Enter a positive number : ";
  cin >> num;
  if (num < 0) {
    cout << "Enter a positive number." << endl;
  } else {
    checkPerfect(num);
  }
  return 0;
}
