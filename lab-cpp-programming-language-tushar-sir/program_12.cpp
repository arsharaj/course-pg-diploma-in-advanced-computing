#include <iostream>
#include <cmath>

using namespace std;

int main() {
  int num, temp;
  cout << "Enter a number : ";
  cin >> num;

  int digits = 0;
  temp = num;
  while(temp > 0) {
    digits += 1;
    temp /= 10;
  }

  int sum = 0;
  temp = num;
  while(temp > 0) {
    int last_digit = temp % 10;
    sum += pow(last_digit, digits);
    temp /= 10;
  }

  if(num == sum) {
    cout << num << " is Armstrong number." << endl;
  } else {
    cout << num << " is not Armstrong number." <<  endl;
  }

  return 0;
}
