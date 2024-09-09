#include <iostream>

using namespace std;

int main() {
  int sticks = 21, user;
  do {
    cout << "Enter your pick : ";
    cin >> user;
    if(user < 1 || user > 4) {      
       cout << "Enter between 1 and 4!" << endl;
       continue;
    }
    cout << "Computer pick : " << (5 - user) << endl;
    sticks -= 5;
  } while(sticks > 0);

  cout << "Computer Wins !" << endl;

  return 0;
}