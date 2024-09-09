#include <iostream>

using namespace std;

struct Book {
  int bookId;
  string title;
  float price;
};

typedef struct Book BOOK;

void displayBook(BOOK book) {
  cout << "Book : " << book.bookId << " " << book.title << " " << book.price << endl;
}

void acceptInput(BOOK (*book_ptr)[]) {
  for(int i = 0; i < 5; i++) {
    cout << "Enter Book Id : ";
    cin >> (*book_ptr)[i].bookId;
    cout << "Enter Book Title : ";
    cin >> (*book_ptr)[i].title;
    cout << "Enter Book price : ";
    cin >> (*book_ptr)[i].price;
  }
}

int main() {
  BOOK book[5];
  BOOK (*book_ptr)[] = &book;
  acceptInput(book_ptr);
  displayBook(book[0]);
  displayBook(book[1]);
  displayBook(book[2]);
  displayBook(book[3]);
  displayBook(book[4]);
  return 0;
}
