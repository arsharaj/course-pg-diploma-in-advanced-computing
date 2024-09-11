#include <iostream>
#include <exception>
#include <string>

using namespace std;

class AdmissionException : public exception
{
private:
  string message;

public:
  AdmissionException(string message) : message(message) {}

  string what()
  {
    return this->message;
  }
};