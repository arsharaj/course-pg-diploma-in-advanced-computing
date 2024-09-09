#include <iostream>

using namespace std;

struct Book {
  int id;
  string name;
  float price;
};

typedef struct Book BOOK;

int main() {
  BOOK book = {1, "SQL", 300.0}, bookCopy;
  bookCopy.id = book.id;
  bookCopy.name = book.name;
  bookCopy.price = book.price;
  cout << "Book : " << bookCopy.id << " " << bookCopy.name << " " << bookCopy.price << endl;
  book = {2, "DBMS", 400.23};
  bookCopy = book;
  cout << "Book : " << bookCopy.id << " " << bookCopy.name << " " << bookCopy.price << endl;
  return 0;
}
