#include <iostream>

using namespace std;

// Person Class
class Person {
  protected:
    string name;
    string address;
    long mobile;
    Person();
    Person(string name, string address, long mobile);
};

Person::Person() {
  this -> name = "";
  this -> address = "";
  this -> mobile = 0;
}

Person::Person(string name, string address, long mobile) {
  this -> name = name;
  this -> address = address;
  this -> mobile = mobile;
}

// Student Class
class Student : Person {
  private:
    int roll;
    int standard;
    float marks;
  public:
    Student(string name, string address, long mobile, int roll, int standard, float marks) : Person(name, address, mobile) {
      this -> roll = roll;
      this -> standard = standard;
      this -> marks = marks;
    }
    void display();
};

void Student::display() {
  cout << "--- Student's Information ---" << endl;
  cout << "Name : " << this -> name << endl;
  cout << "Address : " << this -> address << endl;
  cout << "Mobile : " << this -> mobile << endl;
  cout << "Roll No : " << this -> roll << endl;
  cout << "Class : " << this -> standard << endl;
  cout << "Marks : " << this -> marks << endl;
}

// Employee Class
class Employee : Person {
  private:
    int id;
    string department;
    double salary;
  public:
    Employee(string name, string address, long mobile, int id, string department, double salary) : Person(name, address, mobile) {
      this -> id = id;
      this -> department = department;
      this -> salary = salary;
    }
    void display();
};

void Employee::display() {
  cout << "--- Employee's Information ---" << endl;
  cout << "Name : " << this -> name << endl;
  cout << "Address : " << this -> address << endl;
  cout << "Mobile : " << this -> mobile << endl;
  cout << "Emp Id : " << this -> id << endl;
  cout << "Department : " << this -> department << endl;
  cout << "Salary : " << this -> salary << endl;
}

// Artist Class
class Artist : Person {
  private:
    string signature;
    int works;
  public:
  Artist(string name, string address, long mobile, string signature, int works) : Person(name, address, mobile) {
    this -> signature = signature;
    this -> works = works;  
  }
  void display();
};

void Artist::display() {
  cout << "--- Artist's Information ---" << endl;
  cout << "Name : " << this -> name << endl;
  cout << "Address : " << this -> address << endl;
  cout << "Mobile : " << this -> mobile << endl;
  cout << "Signature : " << this -> signature << endl;
  cout << "No. of Works : " << this -> works << endl;
}

int main() {
  Student firstStudent = Student("Arsh", "Dholpur", 1234567890, 7, 12, 96.53);
  firstStudent.display();
  Employee firstEmployee = Employee("John", "Australia", 3214567890, 23, "Computer Science", 1000000);
  firstEmployee.display();
  Artist firstArtist = Artist("Sam", "Argentina", 4325678910, "Tree", 3);
  firstArtist.display();
  return 0;
}