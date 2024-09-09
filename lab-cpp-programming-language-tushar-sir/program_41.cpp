#include <iostream>

using namespace std;

class Array {
public:
  int size;
  int *arr;

  Array() {
    this->size = 5;
    this->arr = new int[size];
    for (int i = 0; i < size; i++) {
      arr[i] = 0;
    }
  }
  
  Array(int size) {
    this->size = size;
    this->arr = new int[size];
    for (int i = 0; i < size; i++) {
      arr[i] = 0;
    }
  }
  
  Array(Array &arrObj) {
    this->size = arrObj.size;
    this->arr = new int[arrObj.size];
    for (int i = 0; i < arrObj.size; i++) {
      arr[i] = 0;
    }
  }
  
  void display() {
    cout << "Size : " << this->size << endl;
    cout << "Array : ";
    for (int i = 0; i < size; i++) {
      cout << this->arr[i] << " ";
    }
    cout << endl;
  }
   
  ~Array() { 
    delete[] arr;
  }
};
  
  
int main()
{
  Array obj_1;
  obj_1.display();
  Array obj_2(4);
  obj_2.display();
  Array obj_3(obj_2);
  obj_3.display();  
  return 0;
}
