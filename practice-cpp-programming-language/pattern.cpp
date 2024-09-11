#include <iostream>

using namespace std;

int main() {
  int num;
  cout << "Enter a number : ";
  cin >> num;

  for(int i = num, space = 0; i >= 1; i--, space += 4) {
    int j = 1;
    while (j <= i) {
      cout << j << " ";
      j++;
    }
    j--;
    int temp = space;
    while(temp > 0) {
      cout << " ";
      temp--;
    }
    while(j >= 1) {
      cout << j << " ";
      j--;
    }
    cout << "\n";
  }

  return 0;
}
