#include <iostream>

using namespace std;

class Date {
  private:
    int date, month, year;
  public:
    Date() : date(0), month(0), year(0) {}
    Date(int dd, int mm, int yyyy) : date(dd), month(mm), year(yyyy) {}

    int getDate() const;
    int getMonth() const;
    int getYear() const;
    void read() const;
    void write();

    bool operator==(const Date secondDate) const;
};

int Date::getDate() const { return this -> date; }
int Date::getMonth() const { return this -> month; }
int Date::getYear() const { return this -> year; }

void Date::read() const {
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

bool Date::operator==(const Date secondDate) const {
  if (this -> date == secondDate.getDate() &&
      this -> month == secondDate.getMonth() &&
      this -> year == secondDate.getYear()) {
    return true;
  } else {
    return false;
  }
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
  return 0;
}
