#include <iostream>

using namespace std;

string numToWord(int num) {
  switch(num) {
    case 0: return "Zero ";
    case 1: return "One ";
    case 2: return "Two ";
    case 3: return "Three ";
    case 4: return "Four ";
    case 5: return "Five ";
    case 6: return "Six ";
    case 7: return "Seven ";
    case 8: return "Eight ";
    case 9: return "Nine ";
    default: return "";
  }
}

void printAsWords(int num) {
  if (num == 0) {
    cout << "In Words : Zero " << endl;
    return; 
  }

  string words = "";
  while (num > 0) {
    words = numToWord(num % 10) + words;
    num /= 10;
  }
  cout << "In Words : " << words << endl;
}

int main() {
  int num;
  cout << "Enter a positive number : ";
  cin >> num;
  if (num < 0) {
    cout << "Enter a positive number." << endl;
  } else {
    printAsWords(num);
  }
  return 0;
}
