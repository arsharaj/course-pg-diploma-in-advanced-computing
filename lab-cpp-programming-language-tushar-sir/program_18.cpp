#include <iostream>

using namespace std;

void charLine(char ch, int num);

int main() {
  charLine('-', 30);
  cout << "Data Type \t Size in Bytes \n";
  charLine('-', 30);
  cout << "Integer \t\t" << sizeof(int) << endl;
  charLine('-', 30);
  cout << "Character \t\t" << sizeof(char) << endl;
  charLine('-', 30);
  cout << "Float \t\t\t" << sizeof(float) << endl;
  charLine('-', 30);
  return 0;
}

void charLine(char ch, int num) {
  while(num > 0) {
    cout << ch;
    num--;
  }
  cout << endl;
}
