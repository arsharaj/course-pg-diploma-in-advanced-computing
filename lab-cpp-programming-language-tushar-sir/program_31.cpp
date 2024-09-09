#include <iostream>
#include <cstdlib>
#include <cstring>

using namespace std;

int main() {
  int n;
  cout << "Enter number of strings : ";
  cin >> n;
  char *str_ptr[n];
  for(int i = 0; i < n; i++) {
		string temp;
		cout << "Enter a string : ";
		cin >> temp;
		str_ptr[i] = &temp;
  }
	for(int i = 0; i < n - 1; i++) {
	  for(int j = i + 1; j < n; j++) {
		  if(strcmp(str_ptr[i], str_ptr[j]) > 0) {
			  string temp = *str_ptr[i];
				*str_ptr[i] = *str_ptr[j];
				*str_ptr[j] = temp;
			}
		}
	}
	cout << "Sorted Strings : ";
	for(int i = 0; i < n; i++) {
	  cout << *str_ptr[i] << endl;
	}
  return 0;
}
