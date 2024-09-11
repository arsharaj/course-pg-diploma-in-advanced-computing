#include <iostream>

using namespace std;

class Student
{
private:
  string name;
  int rollNo;
  long mobile;

public:
  Student(string name, int rollNo, long mobile)
  {
    this->name = name;
    this->rollNo = rollNo;
    this->mobile = mobile;
  }

  string getName()
  {
    return this->name;
  }

  int getRollNo()
  {
    return this->rollNo;
  }

  long getMobile()
  {
    return this->mobile;
  }

  void setName(string name)
  {
    this->name = name;
  }

  void setRollNo(int rollNo)
  {
    this->rollNo = rollNo;
  }

  void setMobile(long mobile)
  {
    this->mobile = mobile;
  }

  void toString()
  {
    cout << "Student [" << this->getName() << ", " << this->getRollNo() << ", " << this->getMobile() << "]" << endl;
  }
};