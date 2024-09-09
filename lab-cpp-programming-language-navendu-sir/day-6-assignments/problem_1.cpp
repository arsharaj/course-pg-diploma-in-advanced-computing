#include <iostream>

using namespace std;

void swap(int numOne, int numTwo) {
  cout << "--- Before Swapping ---" << endl;
  cout << "First Number : " << numOne << endl;
  cout << "Second Number : " << numTwo << endl;
  int temp = numOne;
  numOne = numTwo;
  numTwo = temp;
  cout << "--- After Swapping ---" << endl;
  cout << "First Number : " << numOne << endl;
  cout << "Second Number : " << numTwo << endl;
}

void swap(char numOne, char numTwo) {
  cout << "--- Before Swapping ---" << endl;
  cout << "First Number : " << numOne << endl;
  cout << "Second Number : " << numTwo << endl;
  char temp = numOne;
  numOne = numTwo;
  numTwo = temp;
  cout << "--- After Swapping ---" << endl;
  cout << "First Number : " << numOne << endl;
  cout << "Second Number : " << numTwo << endl;
}

void swap(float numOne, float numTwo) {
  cout << "--- Before Swapping ---" << endl;
  cout << "First Number : " << numOne << endl;
  cout << "Second Number : " << numTwo << endl;
  float temp = numOne;
  numOne = numTwo;
  numTwo = temp;
  cout << "--- After Swapping ---" << endl;
  cout << "First Number : " << numOne << endl;
  cout << "Second Number : " << numTwo << endl;
}

void swap(double numOne, double numTwo) {
  cout << "--- Before Swapping ---" << endl;
  cout << "First Number : " << numOne << endl;
  cout << "Second Number : " << numTwo << endl;
  double temp = numOne;
  numOne = numTwo;
  numTwo = temp;
  cout << "--- After Swapping ---" << endl;
  cout << "First Number : " << numOne << endl;
  cout << "Second Number : " << numTwo << endl;
}

void swap(string numOne, string numTwo) {
  cout << "--- Before Swapping ---" << endl;
  cout << "First Number : " << numOne << endl;
  cout << "Second Number : " << numTwo << endl;
  string temp = numOne;
  numOne = numTwo;
  numTwo = temp;
  cout << "--- After Swapping ---" << endl;
  cout << "First Number : " << numOne << endl;
  cout << "Second Number : " << numTwo << endl;
}

int main() {
  swap(1, 2);
  swap(-1, 4);
  swap(-128,-132);
  swap(0, 12);
  swap('a', 'z');
  /* swap(65, 'a'); */
  swap(12.04, 13.96);
  swap(1213.0982f, 1232.34f);
  swap("World", "Hello");
  swap("I am learning OS.", "I am learning Cpp.");
  return 0;
}
