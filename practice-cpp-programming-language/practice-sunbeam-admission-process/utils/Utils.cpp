#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>

#ifndef CORE_H
#define CORE_H
#include "../core/Student.cpp"
#include "../core/Course.cpp"
#endif

using namespace std;

class Utils
{
public:
  static void registerStudent(vector<Student> *registeredStudents, unordered_map<int, vector<Course>> *studentCourseMap)
  {
    string name;
    int rollNo;
    long mobile;
    cout << "Enter student details : (name, rollNo, mobile)" << endl;
    cin >> name >> rollNo >> mobile;
    Student *newStudent = new Student(name, rollNo, mobile);
    vector<Course> courses;
    registeredStudents->push_back(*newStudent);
    (*studentCourseMap)[newStudent->getRollNo()] = courses;
    cout << "New student successfully registered." << endl;
  }

  static void takeCourse(vector<Student> *registeredStudents, unordered_map<int, vector<Course>> *studentCourseMap)
  {
    // TODO : Extract the student registration validation.
    bool found = false;
    int rollNo;
    cout << "Enter the student roll no : " << endl;
    cin >> rollNo;
    for (Student student : (*registeredStudents))
    {
      if (student.getRollNo() == rollNo)
      {
        found = true;
        break;
      }
    }
    if (found)
    {
      cout << "Enter the course details : (courseName, fees)" << endl;
      string courseName;
      double fees;
      cin >> courseName >> fees;
      Course *newCourse = new Course(courseName, fees);
      (*studentCourseMap).at(rollNo).push_back(*newCourse);
      cout << "Course successfully added." << endl;
    }
    else
    {
      cout << "Roll no not found. Please do register if not done so." << endl;
    }
  }

  static void displayCourseByRollNo(vector<Student> *registeredStudents, unordered_map<int, vector<Course>> *studentCourseMap)
  {
    // TODO : Extract the student registration validation if required.
    bool found = false;
    int rollNo;
    cout << "Enter the student roll no : " << endl;
    cin >> rollNo;
    for (Student student : (*registeredStudents))
    {
      if (student.getRollNo() == rollNo)
      {
        found = true;
        break;
      }
    }
    if (found)
    {
      cout << "The course taken by this student are : " << endl;
      for (Course course : (*studentCourseMap).at(rollNo))
      {
        course.toString();
      }
    }
    else
    {
      cout << "Roll no not found. Please do register if not done so." << endl;
    }
  }

  static void displayCourse(vector<Student> *registeredStudents, unordered_map<int, vector<Course>> *studentCourseMap)
  {
    for (Student student : (*registeredStudents))
    {
      cout << "Courses taken by student : ";
      student.toString();
      for (Course course : (*studentCourseMap).at(student.getRollNo()))
      {
        course.toString();
      }
      cout << endl;
    }
  }
};