#include <iostream>
#include <string>
#include <exception>

using namespace std;

class ServicingException : public exception
{
private:
    string message;

public:
    ServicingException(string message) : message(message) {}

    string what()
    {
        return message;
    }
};