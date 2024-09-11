#include <iostream>

using namespace std;

void passByValue(int var);
void passByReference(int &var);
void passByReferencePointer(int *var);

int main() {
  int var;
  int &reference = var;
  int *pointer = &var;
  cout << "Enter a variable : ";
  cin >> var;

  cout << "Main Function : " << &var << endl;

  passByValue(var);
  passByReference(reference);
  passByReferencePointer(pointer);

  cout << "Variable : " << &var << endl;
  cout << "Reference : " << &reference << endl;
  cout << "Size of Reference : " << sizeof(&reference) << endl;
  cout << "Size of Reference Pointer : " << sizeof(pointer) << endl;
  cout << "Reference Pointer : " << &pointer << endl;

  return 0;
}


void passByValue(int var) {
  cout << "Pass By Value : " << var << endl;
}

void passByReference(int &var) {
  cout << "Pass By Reference : " << var << endl;
}

void passByReferencePointer(int *var) {
  cout << "Pass By Reference Pointer : " << var << endl;
}
