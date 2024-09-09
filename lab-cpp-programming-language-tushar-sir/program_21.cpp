#include <iostream>
#define PI 3.14

using namespace std;

void areaCircum(double *radius, double *area, double *circum) {
  (*area) = PI * (*radius) * (*radius);
  (*circum) = 2 * PI * (*radius);
}

void areaPeri(double *length, double *breadth, double *area, double *perimeter) {
  (*area) = (*length) * (*breadth);
  (*perimeter) = 2 * ((*length) + (*breadth));
}

int main() {
  int choice;
  cout << "1. Rectangle" << endl << "2. Circle" << endl;
  cout << "Enter your choice : ";
  cin >> choice;
  switch(choice) {
    case 1:
    {
      double length, breadth, area = 0.0, perimeter = 0.0;
      cout << "Enter length : ";
      cin >> length;
      cout << "Enter breadth : ";
      cin >> breadth;
      areaPeri(&length, &breadth, &area, &perimeter);
      cout << "Area of rectangle : " << area << endl;
      cout << "Perimeter of rectangle : " << perimeter << endl;
      break;
    }
    case 2:
    {
      double radius, area = 0.0, circum = 0.0;
      cout << "Enter radius : ";
      cin >> radius;
      areaCircum(&radius, &area, &circum);
      cout << "Area of circle : " << area << endl;
      cout << "Circumference of circle : " << circum << endl;
      break;
    }
    default: 
    {
      cout << "Enter a valid choice." << endl;
    }
  }
  return 0;
}
