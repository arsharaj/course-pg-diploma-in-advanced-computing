#include <iostream>

using namespace std;

int main() {
  int n;
  cin >> n;
  void *ptr = malloc(n * sizeof(int));
  cout << "Dereferencing Void Pointer : " << *ptr << endl;
  free(ptr);
  return 0;
}
