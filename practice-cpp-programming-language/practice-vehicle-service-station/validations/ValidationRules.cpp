#include <iostream>

#include "../exceptions/ServicingException.cpp"

using namespace std;

class ValidationRules
{
public:
    static void validatePrice(double price)
    {
        if (price < 0)
        {
            throw ServicingException("Price could not be negative.");
        }
    }
};
