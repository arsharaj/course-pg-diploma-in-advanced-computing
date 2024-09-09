#include <iostream>

using namespace std;

bool compareStr(char firstStr[], char secondStr[]) {
  int counter = 0;
  do {
    if (firstStr[counter] != secondStr[counter]) {
      return false;
    }
    counter++;
  } while (firstStr[counter] != '\0' && counter < 26);
  return true;
}

int main() {
  char firstStr[25], secondStr[25];
  cout << "Enter your first string (maximum 25 characters) : ";
  cin >> firstStr;
  cout << "Enter your second string (maximum 25 characters) : ";
  cin >> secondStr;
  if (compareStr(firstStr, secondStr)) {
    cout << "Strings are equal." << endl;
  } else {
    cout << "Strings are not equal." << endl;
  }
  return 0;
}
