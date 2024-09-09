#include <iostream>

using namespace std;

void strCpy(char source[], char destination[]) {
  int counter = 0;
  do {
    destination[counter] = source[counter];
    counter++;
  } while (source[counter] != '\0' && counter < 26);
  destination[counter] = '\0';
}

int main() {
  char source[25], destination[25];
  cout << "Enter a string : ";
  cin >> source;
  strCpy(source, destination);
  cout << "Source String : " << source << endl;
  cout << "Destination String : " << destination << endl;
  return 0;
}
