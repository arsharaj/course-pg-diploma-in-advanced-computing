#include <iostream>

using namespace std;

int strlen(char str[]) {
  int counter = 0;
  while (str[counter] != '\0' && counter < 26) {
    counter++;
  }
  return (counter == 26) ? -1 : counter;
}

int main() {
  char str[26];
  cout << "Enter a string (maximum 25 characters) : ";
  cin >> str;
  cout << "Number of characters : " << strlen(str) << endl;
  return 0;
}
