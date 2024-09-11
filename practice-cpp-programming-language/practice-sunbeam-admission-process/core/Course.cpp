#include <iostream>

using namespace std;

class Course
{
private:
  string courseName;
  double fees;

public:
  Course(string courseName, double fees)
  {
    this->courseName = courseName;
    this->fees = fees;
  }

  string getCourseName()
  {
    return this->courseName;
  }

  double getFees()
  {
    return this->fees;
  }

  void setCourseName(string courseName)
  {
    this->courseName = courseName;
  }

  void setFees(double fees)
  {
    this->fees = fees;
  }

  void toString() 
  {
    cout << "Course [" << this->getCourseName() << ", " << this->getFees() << "]" << endl;
  }
};