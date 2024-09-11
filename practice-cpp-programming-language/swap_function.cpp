#include <iostream>

using namespace std;

void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

int main() {
    int a;
    int b;
    cout << "Enter a : " << endl;
    cin >> a;
    cout << "Enter b : " << endl;
    cin >> b;
    swap(&a,&b);
    cout << "a : " << a << endl;
    cout << "b : " << b <<  endl;
    return 0;
}
