#include <iostream>

using namespace std;

class Complex {
  int real, imaginary;
  
  public:
    static int objects_count;
    
    static int getObjectsCount() { return objects_count; }
    
    Complex() {
      this -> objects_count += 1;
      this -> real = this -> imaginary = 0;
    }
    
    Complex(int real, int imaginary) {
      this -> objects_count += 1;
      this -> real = real;
      this -> imaginary = imaginary;
    }
    
    int getReal() { return this -> real; }

    int getImaginary() { return this -> imaginary; }
    
    void setReal(int real) { this -> real = real; }
    
    void setImaginary(int imaginary) { this -> imaginary = imaginary; }
    
    void display() { cout << "Real : " << this -> real << " Imaginary : " << this -> imaginary << endl; }
};

int Complex :: objects_count = 0;

int main() {
  Complex num_1;  // Using default constructor
  num_1.display();
  Complex num_2(34, 43);  // Using parameterized constructor
  num_2.display();
  num_2.setReal(25);
  num_2.setImaginary(50);
  cout << "Updated Real : " << num_2.getReal() << endl;
  cout << "Updated Imaginary : " << num_2.getImaginary() << endl;
  num_2.display();
  cout << "No. of objects : " << num_2.getObjectsCount() << endl;
  return 0;
}

