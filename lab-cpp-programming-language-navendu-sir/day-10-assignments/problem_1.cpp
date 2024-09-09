#include <iostream>

using namespace std;

class BigInt {
  private:
    int num;
  public:
    BigInt() : num(0) {}
    BigInt(int newNum) : num(newNum) {}

    int getNum();
    void setNum(int num);

    BigInt operator+(BigInt num);
    BigInt operator-(BigInt num);
    BigInt operator*(BigInt num);
    BigInt operator/(BigInt num);
    BigInt operator+(int num);
    BigInt operator-(int num);
    BigInt operator*(int num);
    BigInt operator/(int num);
    BigInt operator++();
    BigInt operator++(int);
    BigInt operator--();
    BigInt operator--(int);
};

int BigInt::getNum() { return this -> num; }
void BigInt::setNum(int num) { this -> num = num; }

BigInt BigInt::operator+(BigInt num) { return BigInt(this -> getNum() + num.getNum()); }
BigInt BigInt::operator-(BigInt num) { return BigInt(this -> getNum() - num.getNum()); }
BigInt BigInt::operator*(BigInt num) { return BigInt(this -> getNum() * num.getNum()); }
BigInt BigInt::operator/(BigInt num) { return BigInt(this -> getNum() / num.getNum()); }
BigInt BigInt::operator+(int num) { return BigInt(this -> getNum() + num); }
BigInt BigInt::operator-(int num) { return BigInt(this -> getNum() - num); }
BigInt BigInt::operator*(int num) { return BigInt(this -> getNum() * num); }
BigInt BigInt::operator/(int num) { return BigInt(this -> getNum() / num); }
BigInt BigInt::operator++() {
  this -> setNum(this -> getNum() + 1);
  return BigInt(this -> getNum());
}
BigInt BigInt::operator++(int) {
  int temp = this -> getNum();
  this -> setNum(this -> getNum() + 1);
  return BigInt(temp);
}
BigInt BigInt::operator--() {
  this -> setNum(this -> getNum() - 1);
  return BigInt(this -> getNum());
}
BigInt BigInt::operator--(int) {
  int temp = this -> getNum();
  this -> setNum(this -> getNum() - 1);
  return BigInt(temp);
}

int main() {
  BigInt firstNum(12), secondNum(12);
  firstNum = firstNum + secondNum;
  cout << "Number FirstNum + SecondNum : " << firstNum.getNum() << endl;
  firstNum = firstNum - secondNum;
  cout << "Number FirstNum - SecondNum : " << firstNum.getNum() << endl;
  firstNum = firstNum * secondNum;
  cout << "Number FirstNum * SecondNum : " << firstNum.getNum() << endl;
  firstNum = firstNum / secondNum;
  cout << "Number FirstNum / SecondNum : " << firstNum.getNum() << endl;
  firstNum = firstNum + 3;
  cout << "Number FirstNum + 3 : " << firstNum.getNum() << endl;
  firstNum = firstNum - 3;
  cout << "Number FirstNum - 3 : " << firstNum.getNum() << endl;  
  firstNum = firstNum * 3;
  cout << "Number FirstNum * 3 : " << firstNum.getNum() << endl;
  firstNum = firstNum / 3;
  cout << "Number FirstNum / 3 : " << firstNum.getNum() << endl;
  firstNum++;
  cout << "Post Increment : " << firstNum.getNum() << endl;
  ++firstNum;
  cout << "Pre Increment : " << firstNum.getNum() << endl;
  firstNum--;
  cout << "Post Decrement : " << firstNum.getNum() << endl;
  --firstNum;
  cout << "Pre Decrement : " << firstNum.getNum() << endl;
  return 0;
}