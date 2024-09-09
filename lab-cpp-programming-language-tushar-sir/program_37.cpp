#include <iostream>

using namespace std;

int add(int a, int b) {
  return a + b;
}

float add(float a, float b) {
  return a + b;
}

double add(double a, double b) {
  return a + b;
}

int main() {
  int a, b;
  float c, d;
  double e, f;
  cout << "Enter integer a : ";
  cin >> a;
  cout << "Enter integer b : ";
  cin >> b;
  cout << "Enter float c : ";
  cin >> c;
  cout << "Enter float d : ";
  cin >> d;
  cout << "Enter double e : ";
  cin >> e;
  cout << "Enter double f : ";
  cin >> f;
  cout << "a + b = " << add(a, b) << endl;
  cout << "c + d = " << add(c, d) << endl;
  cout << "e + f = " << add(e, f) << endl;
  return 0;
}
