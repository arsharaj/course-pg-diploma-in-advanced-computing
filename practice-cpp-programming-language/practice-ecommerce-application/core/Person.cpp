#include <iostream>

using namespace std;

class Person {
private:
    string name;

public:
    Person(string name) {
        this->name = name;
    }

    string getName() {
        return this->name;
    }

    void setName(string name) {
        this->name = name;
    }

    void toString() {
        cout << "Person [" << this->name <<  "]" << endl;
    }
};