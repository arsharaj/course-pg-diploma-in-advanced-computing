#include <iostream>

using namespace std;

void getDate(int *date, int *month, int *year) {
  cout << "Enter a valid date : ";
  cin >> *date;
  cout << "Enter a valid month : ";
  cin >> *month;
  cout << "Enter a valid year : ";
  cin >> *year;
}

void printDate(int *date, int *month, int *year) {
  cout << "Date : ";
  if((*date) < 10) {
    cout << "0" << (*date);
  } else {
    cout << (*date);
  }
  cout << "/";
  if((*month) < 10) {
    cout << "0" << (*month);
  } else {
    cout << (*month);
  }
  cout << "/";
  if((*year) / 100 != 0) {
    cout << ((*year) % 100 ) << endl;
  } else {
    cout << (*year) << endl;
  }
}

int main() {
  int date, month, year;
  getDate(&date, &month, &year);
  printDate(&date, &month, &year);
  return 0;
}
