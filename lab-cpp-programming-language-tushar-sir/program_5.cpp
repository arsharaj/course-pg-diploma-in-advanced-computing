#include <iostream>

using namespace std;

int main() {
  double basic;
  cout << "Enter basic salary : ";
  cin >> basic;
  double hra = (15 * basic) / 100;
  double da = (30 * basic) / 100;
  double gross = basic + hra + da;
  double pf = (12.5 * gross) / 100;
  double net_salary = gross - pf;
  cout << "Net Salary : " << net_salary << endl;
  return 0;
}

