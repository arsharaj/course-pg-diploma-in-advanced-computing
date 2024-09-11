/* 1. Pass values by reference to avoid making copies.
 * 2. If you do not intent to update the reference location then make it constant.
 * 3. Since this is a pointer to the current object that's why we cannot access the values using dot operator.
 * */

#include <iostream>

using namespace std;

class Student {
  int roll;
  string name, course;

  public:
    Student(int roll, string name, string course) {
      this -> roll = roll;
      this -> name = name;
      this -> course = course;
    }

    Student(const Student &obj) {
      this -> roll = obj.getRoll();
      this -> name = obj.getName();
      this -> course = obj.getCourse();
    }

    void incrementRoll() {
      ++roll;
    }

    void setRoll(const int &roll) {
      this -> roll = roll;
    }

    int getRoll() const {
      Student student(2, "Tushar", "DBDA");
      student.setRoll(100);
      return this -> roll;
    }

    string getName() const {
      return this -> name;
    }

    string getCourse() const {
      return this -> course;
    }

    void displayStudent() const {
      cout << "Roll No : " << roll << " Name : " << name << " Course : " << course << endl;
    }
};

int main() {
  Student student_1 = Student(1, "Arsh", "DAC");
  student_1.displayStudent();
  Student student_2 = Student(student_1);
  student_2.displayStudent();
  student_2.incrementRoll();
  student_2.displayStudent();
  cout << "Roll No = " << student_2.getRoll() << endl;
  return 0;
}
