#include <iostream>
#include <vector>
#include <unordered_map>

#ifndef CORE_H
#define CORE_H
  #include "../core/Student.cpp"
  #include "../core/Course.cpp"
#endif

#include "../utils/Utils.cpp"

using namespace std;

vector<Student> registeredStudents;
unordered_map<int, vector<Course>> studentCourseMap;

int main()
{
  int choice;
  do
  {
    try
    {
      cout << "--- Sunbeam Admission Process ---" << endl;
      cout << "1. Register Student" << endl;
      cout << "2. Take Course" << endl;
      cout << "3. Display specific student's taken courses" << endl;
      cout << "4. Display all students and their courses registered" << endl;
      cout << "0. Exit" << endl;
      cout << "Enter your choice : ";
      cin >> choice;
      switch (choice)
      {
      case 1:
        Utils::registerStudent(&registeredStudents, &studentCourseMap);
        break;
      case 2:
        Utils::takeCourse(&registeredStudents, &studentCourseMap);
        break;
      case 3:
        Utils::displayCourseByRollNo(&registeredStudents, &studentCourseMap);
        break;
      case 4:
        Utils::displayCourse(&registeredStudents, &studentCourseMap);
        break;
      case 0:
        cout << "Thank you for using our services." << endl;
        break;
      default:
        cout << "Enter a valid choice !" << endl;
        break;
      }
    }
    catch (exception e)
    {
      cout << e.what() << endl;
    }
  } while (choice != 0);

  return 0;
}