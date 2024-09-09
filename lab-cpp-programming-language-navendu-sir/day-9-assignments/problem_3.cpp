#include <iostream>

using namespace std;

class String {
  private:
    string str;
  public:
    String() : str("") {}
    String(string newStr) : str(newStr) {}

    string getStr() const;
    void setStr(string newStr);

    bool operator<(const String &secondStr) const;
    bool operator<=(const String &secondStr) const;
    bool operator>(const String &secondStr) const;
    bool operator>=(const String &secondStr) const;
    bool operator==(const String &secondStr) const;
    bool operator!=(const String &secondStr) const;
};

string String::getStr() const { return str; }
void String::setStr(string newStr) { str = newStr; }

bool String::operator<(const String &secondStr) const { return str < secondStr.getStr(); }
bool String::operator<=(const String &secondStr) const { return str <= secondStr.getStr(); }
bool String::operator>(const String &secondStr) const { return str > secondStr.getStr(); }
bool String::operator>=(const String &secondStr) const { return str >= secondStr.getStr(); }
bool String::operator==(const String &secondStr) const { return str == secondStr.getStr(); }
bool String::operator!=(const String &secondStr) const { return str != secondStr.getStr(); }


int main() {
  String firstStr ("String");
  String secondStr("String");
  cout << "First String : " << firstStr.getStr() << endl;
  cout << "String String : " << secondStr.getStr() << endl;
  cout << "First String < Second String : " << (firstStr < secondStr) << endl;
  cout << "First String <= Second String : " << (firstStr <= secondStr) << endl;
  cout << "First String > Second String : " << (firstStr > secondStr) << endl;
  cout << "First String >= Second String : " << (firstStr >= secondStr) << endl;
  cout << "First String == Second String : " << (firstStr == secondStr) << endl;
  cout << "First String != Second String : " << (firstStr != secondStr) << endl;
  return 0;
}