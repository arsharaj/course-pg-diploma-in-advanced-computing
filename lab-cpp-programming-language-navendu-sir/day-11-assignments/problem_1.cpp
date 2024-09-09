#include <iostream>

using namespace std;

class String {
  private:
    string *str;
  public:
    String();
    String(string str);
    String(const String &str);
    ~String();

    string getStr() const;
    void setStr(string str);
    void operator=(String newStr);
};

String::String() { str = nullptr; }
String::String(string newStr) { str = new string(newStr); }
String::String(const String &newStr) { str = new string(newStr.getStr()); }
String::~String() { delete str; }

string String::getStr() const { return (str == nullptr) ? "" : *str; }
void String::setStr(string newStr) { *str = newStr; }
void String::operator=(String newStr) { this -> setStr(newStr.getStr()); }

int main() {
  String emptyStr;
  String firstStr("Hello World");
  String secondStr = firstStr;
  cout << "Empty String : " << emptyStr.getStr() << endl;
  cout << "First String : " << firstStr.getStr() << endl;
  cout << "Second String : " << secondStr.getStr() << endl;
  secondStr.setStr("New World");
  cout << "Second String : " << secondStr.getStr() << endl;
  cout << "First String : " << firstStr.getStr() << endl;
  secondStr = firstStr;
  firstStr.setStr("Old String");
  cout << "First String : " << firstStr.getStr() << endl;
  cout << "Second String : " << secondStr.getStr() << endl;
  secondStr = firstStr;
  cout << "First String : " << firstStr.getStr() << endl;
  cout << "Second String : " << secondStr.getStr() << endl;
  return 0;
}