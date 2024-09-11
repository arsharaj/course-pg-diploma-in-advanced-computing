#include <iostream>

using namespace std;

class Product {
private:
    int pid;
    string pname;
    float price;

public:
    Product(int pid, string pname, float price) {
        this->pid = pid;
        this->pname = pname;
        this->price = price;
    }

    int getPid() {
        return this->pid;
    }

    string getPname() {
        return this->pname;
    }

    float getPrice() {
        return this->price;
    }

    void setPid(int pid) {
        this->pid = pid;
    }

    void setPname(string pname) {
        this->pname = pname;
    }

    void setPrice(float price) {
        this->price = price;
    }

    void toString() {
        cout << "Product [" << pid << ", " << pname << ", " << price << "]" << endl;
    }
};