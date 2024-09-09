#include <iostream>

using namespace std;

class Complex {
  int real, imaginary;
  
  public :
    Complex() {
      this->real = 0;
      this->imaginary = 0;
    }
    
    Complex(int real, int imaginary) {
      this->real = real;
      this->imaginary = imaginary;
    }
    
    int getReal() { return this->real; }
  
    int getImaginary() { return this->imaginary; }
    
    void setReal(int real) { this->real = real; }
    
    void setImaginary(int imaginary) { this->imaginary = imaginary; }
    
    void display() { cout << "Real : " << getReal() << " Imaginary : " << getImaginary() << endl; }
    
    Complex operator+ (Complex obj) { 
      return Complex(this->getReal() + obj.getReal(), this->getImaginary() + obj.getImaginary());
    }
    
    Complex operator- (Complex obj) { 
      return Complex(this->getReal() - obj.getReal(), this->getImaginary() - obj.getImaginary());
    }
    
    void operator-= (Complex obj) {
      this->setReal(this->getReal() - obj.getReal()); 
      this->setImaginary(this->getImaginary() - obj.getImaginary());
    }
    
    void operator= (Complex obj) {
      this->setReal(obj.getReal());
      this->setImaginary(obj.getImaginary());
    }
};

int main() {
  Complex c1(12, 14), c2(31, 35), c3(22, 25), c4(77, 23);
  cout << "Addition :- " << endl;
  c1.display();
  c2.display();
  c3.display();
  c3 = c1 + c2;
  c3.display();
  
  cout << "Subtraction :- " << endl;
  c1.display();
  c2.display();
  c3.display();
  c3 = c1 - c2;
  c3.display();
  
  cout << "Shortcut Subtraction :- " << endl;
  c1.display();
  c2.display();
  c2 -= c1;
  c2.display();
  
  return 0;
}
