#include <iostream>

using namespace std;

int main() {
  char ch;
  cout << "Enter a character : ";
  cin >> ch;
  
  if(ch >= 'a' && ch <= 'z') {
    ch = ch - ('a' - 'A');
    cout << "Character : " << ch << endl;
  } else if(ch >= 'A' && ch <= 'Z') {
    ch = ch + ('a' - 'A');
    cout << "Character : " << ch << endl;
  } else {
    cout << "Enter a valid character !" << endl;
  }

  return 0;
}