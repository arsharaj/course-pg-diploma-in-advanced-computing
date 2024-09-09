#include <iostream>

using namespace std;

void Fibonacci(int num) {
  if(num <= 0) {
    cout << "Enter a positive number.";
    return;
  }

  if(num == 1) {
    cout << "0 ";
    return;
  }
  
  cout << "0 1 ";
  int first = 0, second = 1;
  for(int i = 3; i <= num; i++) {
    int next = first + second;
    cout << next << ' ';
    first = second;
    second = next;
  }
}

int main() {
  int num;
  cout << "Enter the number of terms : ";
  cin >> num;
  cout << "Fibonacci Series : ";
  Fibonacci(num);
  cout << endl;
  return 0;
}
