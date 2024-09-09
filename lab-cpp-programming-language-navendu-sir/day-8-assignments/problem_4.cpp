#include <iostream>

using namespace std;

void toUpper(char str[]) {
  int counter = 0;
  do {
    if (str[counter] >= 'a' && str[counter] <= 'z') {
      str[counter] -= ('a' - 'A');
    }
    counter++;
  } while (str[counter] != '\0' && counter < 26);
}

int main() {
  char str[26];
  cout << "Enter a string (maximum 25 characters) : ";
  cin >> str;
  toUpper(str);
  cout << "Upper Case : " << str << endl;
  return 0;
}
