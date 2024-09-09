#include <iostream>

using namespace std;

class BigInt {
  private:
    int num;
  public:
    BigInt(int num) : num(num) {}

    int getNum() const;
    void display() const;

    BigInt operator+(const BigInt &num) const;
    BigInt operator-(const BigInt &num) const;
    BigInt operator*(const BigInt &num) const;
    BigInt operator==(const BigInt &num) const;
    BigInt operator>(const BigInt &num) const;
    BigInt operator>=(const BigInt &num) const;
    BigInt operator<(const BigInt &num) const;
    BigInt operator<=(const BigInt &num) const;
    BigInt operator!=(const BigInt &num) const;
    BigInt operator&&(const BigInt &num) const;
    BigInt operator||(const BigInt &num) const;
    BigInt operator!() const;
    BigInt operator/(const BigInt &num) const;
    BigInt operator%(const BigInt &num) const;
};

BigInt BigInt::operator+(const BigInt &num) const { return BigInt(this -> num + num.getNum()); }
BigInt BigInt::operator-(const BigInt &num) const { return BigInt(this -> num - num.getNum()); }
BigInt BigInt::operator*(const BigInt &num) const { return BigInt(this -> num * num.getNum()); }
BigInt BigInt::operator==(const BigInt &num) const { return BigInt(this -> num == num.getNum()); }
BigInt BigInt::operator>(const BigInt &num) const { return BigInt(this -> num > num.getNum()); }
BigInt BigInt::operator>=(const BigInt &num) const { return BigInt(this -> num >= num.getNum()); }
BigInt BigInt::operator<(const BigInt &num) const { return BigInt(this -> num < num.getNum()); }
BigInt BigInt::operator<=(const BigInt &num) const { return BigInt(this -> num <= num.getNum()); }
BigInt BigInt::operator!=(const BigInt &num) const { return BigInt(this -> num != num.getNum()); }
BigInt BigInt::operator&&(const BigInt &num) const { return BigInt(this -> num && num.getNum()); }
BigInt BigInt::operator||(const BigInt &num) const { return BigInt(this -> num || num.getNum()); }
BigInt BigInt::operator!() const { return BigInt(!this -> num); }
BigInt BigInt::operator/(const BigInt &num) const {
  if (num.getNum() == 0) {
    cout << "Zero Division Error." << endl;
    return BigInt(0);
  }
  return BigInt(this -> num / num.getNum());
}
BigInt BigInt::operator%(const BigInt &num) const {
  if (num.getNum() == 0) {
    cout << "Zero Modulus Error." << endl;
    return BigInt(0);
  }
  return BigInt(this -> num % num.getNum()); 
}

int BigInt::getNum() const {
  return this -> num;
}

void BigInt::display() const {
  cout << "Number : " << this -> num << endl;
}

int main() {
  BigInt firstNum(40), secondNum(0);
  cout << "--- Addition ---" << endl;
  BigInt additionResult = firstNum + secondNum;
  additionResult.display();
  cout << "--- Subtraction ---" << endl;
  BigInt subtractionResult = firstNum - secondNum;
  subtractionResult.display();
  cout << "--- Multiplication ---" << endl;
  BigInt multiplicationResult = firstNum * secondNum;
  multiplicationResult.display();
  cout << "--- Division ---" << endl;
  BigInt divisionResult = firstNum / secondNum;
  divisionResult.display();
  cout << "--- Modulus ---" << endl;
  BigInt modulusResult = firstNum % secondNum;
  modulusResult.display();
  cout << "--- Equality ---" << endl;
  BigInt equalityResult = firstNum == secondNum;
  equalityResult.display();
  cout << "--- Greater Than ---" << endl;
  BigInt greaterResult = firstNum > secondNum;
  greaterResult.display();
  cout << "--- Greater Than Equal ---" << endl;
  BigInt greaterEqualResult = firstNum >= secondNum;
  greaterEqualResult.display();
  cout << "--- Less Than ---" << endl;
  BigInt lessResult = firstNum < secondNum;
  lessResult.display();
  cout << "--- Less Than Equal ---" << endl;
  BigInt lessEqualResult = firstNum <= secondNum;
  lessEqualResult.display();
  cout << "--- Not Equal ---" << endl;
  BigInt notEqualResult = firstNum != secondNum;
  notEqualResult.display();
  cout << "--- And Operator ---" << endl;
  BigInt andResult = firstNum && secondNum;
  andResult.display();
  cout << "--- Or Operator ---" << endl;
  BigInt orResult = firstNum || secondNum;
  orResult.display();
  cout << "--- Not Operator ---" << endl;
  BigInt notResult = !firstNum;
  notResult.display();
  return 0;
}
