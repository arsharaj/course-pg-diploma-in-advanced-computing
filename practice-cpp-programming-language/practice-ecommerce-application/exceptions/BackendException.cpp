#include <iostream>
#include <exception>
#include <string>

using namespace std;

class BackendException : public exception
{
private:
  string message;

public:
  BackendException(string message) : message(message) {}

  string what() {
    return this->message;
  }
};