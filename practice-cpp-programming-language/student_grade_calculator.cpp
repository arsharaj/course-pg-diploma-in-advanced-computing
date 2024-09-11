// Cpp program to calculate and display the final grades of a class of student.

#include <iostream>

using namespace std;

int main() {
  int no_of_students;
  cout << "Enter the number of students in your class : ";
  cin >> no_of_students;

  while (no_of_students > 0) {
    string name = "";
    int assignment_one, assignment_two, assignment_three;
    cout << "Enter student's name : ";
    cin >> name;
    cout << "Enter assignment one marks : ";
    cin >> assignment_one;
    cout << "Enter assignment two marks : ";
    cin >> assignment_two;
    cout << "Enter assignment three marks:";
    cin >> assignment_three;

    if (assignment_one < 0 || assignment_one > 100 || assignment_two < 0 || assignment_two > 100 || assignment_three < 0 || assignment_three > 100) {
      cout << "Warning : Invalid Inputs !" << endl;
      continue;
    }

    cout << "Name : " << name << " Assignment Scores : " << assignment_one << " " << assignment_two << " " << assignment_three << endl;

    float average = (assignment_one + assignment_two + assignment_three) / 3;

    cout << "Average : " << average << " Grade : ";

    if (average <= 100 && average >= 90) {
      cout << "A";
    } else if (average < 90 && average >= 80) {
      cout << "B";
    } else if (average < 80 && average >= 70) {
      cout << "C";
    } else if (average < 70 && average >= 60) {
      cout << "D";
    } else {
      cout << "F";
    }

    cout << endl;

    no_of_students--;
  }
  
  return 0;
}
