#include <iostream>

using namespace std;

struct Book {
  int bookId;
  string title;
  float price;
};

typedef struct Book BOOK;

int main() {
  BOOK book_1 = {1, "C++", 300.0};
  BOOK book_2 = {2, "SQL", 400.0};
  cout << "Book 1 : " << book_1.bookId << " " << book_1.title << " " << book_1.price << endl;
  cout << "Book 2 : " << book_2.bookId << " " << book_2.title << " " << book_2.price << endl;
  return 0;
}
