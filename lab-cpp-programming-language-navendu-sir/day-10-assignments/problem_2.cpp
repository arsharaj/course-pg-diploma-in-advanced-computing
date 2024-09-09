#include <iostream>

using namespace std;

class Date {
  private:
    int date, month, year;
  public:
    Date() : date(0), month(0), year(0) {}
    Date(int dd, int mm, int yyyy) : date(dd), month(mm), year(yyyy) {}

    int getDate();
    int getMonth();
    int getYear();
    void read();
    void write();
    bool isLeapYear();    
    bool operator==(Date secondDate);
};

int Date::getDate() { return this -> date; }
int Date::getMonth() { return this -> month; }
int Date::getYear() { return this -> year; }

void Date::read() {
  cout << "Date : " << this -> date << "/" << this -> month << "/" << this -> year << endl;
}

void Date::write() {
  cout << "Enter date in dd format : ";
  cin >> this -> date;
  cout << "Enter month in mm format : ";
  cin >> this -> month;
  cout << "Enter year in yyyy format : ";
  cin >> this -> year;
}

bool Date::operator==(Date secondDate) {
  if (this -> date == secondDate.getDate() &&
      this -> month == secondDate.getMonth() &&
      this -> year == secondDate.getYear()) {
    return true;
  } else {
    return false;
  }
}

bool Date::isLeapYear() {
  if (this -> year % 400 == 0) return true;
  if (this -> year % 100 == 0) return false;
  if (this -> year % 4 == 0) return true;
  return false;
}

int main() {
  Date firstDate;
  cout << "First ";
  firstDate.read();
  firstDate.write();
  cout << "First ";
  firstDate.read();
  Date secondDate(12, 12, 2023);
  cout << "Second ";
  secondDate.read();
  if (firstDate == secondDate) {
    cout << "Both the dates are equal." << endl;
  } else {
    cout << "Both the dates are not equal." << endl;
  }
  if (firstDate.isLeapYear()) {
    cout << "First Year : " << firstDate.getYear() << endl;
    cout << "First Date is a leap year." << endl;
  } else {
    cout << "First Date is not a leap year." << endl;
  }
  return 0;
}
