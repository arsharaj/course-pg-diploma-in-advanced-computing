#include <iostream>

using namespace std;

int main() {
  int num_1, num_2;
  cout << "Enter number 1 : ";
  cin >> num_1;
  cout << "Enter number 2 : ";
  cin >> num_2;

  int choice;
  cout << "1. Addition \n";
  cout << "2. Subtraction \n";
  cout << "3. Multiplication \n";
  cout << "4. Division \n";
  cout << "5. Remainder \n";
  cout << "Enter your choice : ";
  cin >> choice;

  switch (choice) {
    case 1: cout << num_1 + num_2 << endl; break;
    case 2: cout << num_1 - num_2 << endl; break;
    case 3: cout << num_1 * num_2 << endl; break;
    case 4: cout << num_1 / num_2 << endl; break;
    case 5: cout << num_1 % num_2 << endl; break;
    default: cout << "Invalid Input." << endl;
  }

  return 0;
}

