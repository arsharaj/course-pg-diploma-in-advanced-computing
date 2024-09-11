#include <iostream>

using namespace std;

class Seller {
private:
    int sid;
    string sname;

public:
    Seller(int sid, string sname) {
        this->sid = sid;
        this->sname = sname;
    }

    int getSid() {
        return this->sid;
    }

    string getSname() {
        return this->sname;
    }

    void setSid(int sid) {
        this->sid = sid;
    }

    void setSname(string sname) {
        this->sname = sname;
    }

    void toString(){
        cout << "Seller [" << sid << ", " << sname << "]" << endl;
    }
};