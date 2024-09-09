#include <iostream>

using namespace std;

int main() {
  double basic, sales, net_salary;
  cout << "Enter basic salary : ";
  cin >> basic;
  cout << "Enter sales amount : ";
  cin >> sales;

  if (sales < 5000) {
    net_salary = basic;
  } else if (sales >= 5000 && sales <= 7500) {
    net_salary = basic + (3 * basic) / 100;
  } else if (sales >= 7501 && sales <= 10500) {
    net_salary = basic + (8 * basic) / 100;
  } else if (sales >= 10501 && sales <= 15000) {
    net_salary = basic + (11 * basic) / 100;
  } else if (sales >= 15001) {
    net_salary = basic + (15 * basic) / 100;
  }

  cout << "Net Salary : " << net_salary << endl;

  return 0;
}

