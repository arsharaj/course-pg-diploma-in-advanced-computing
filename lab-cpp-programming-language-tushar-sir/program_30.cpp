#include <iostream>

using namespace std;

int main() {
  int n, sum = 0;
  cout << "Enter n : ";
  cin >> n;
  int *arr = (int *) malloc(n * sizeof(int));
  for(int i = 0; i < n; i++) {
    cout << "Enter subject " << i + 1 << " marks : "; 
    cin >> arr[i];
    sum += arr[i];
  }
  cout << "Average = " << ((float) sum / n) << endl;
  free(arr);
  return 0;
}
