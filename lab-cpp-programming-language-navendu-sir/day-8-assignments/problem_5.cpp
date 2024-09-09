#include <iostream>

using namespace std;

void toLower(char str[]) {
  int counter = 0;
  do {
    if (str[counter] >= 'A' && str[counter] <= 'Z') {
      str[counter] += ('a' - 'A');
    }
    counter++;
  } while (str[counter] != '\0' && counter < 26);
}

int main() {
  char str[26];
  cout << "Enter a string (maximum 25 characters) : ";
  cin >> str;
  toLower(str);
  cout << "Lower Case : " << str << endl;
  return 0;
}
