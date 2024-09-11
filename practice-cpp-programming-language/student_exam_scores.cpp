// Program to manage and analyze student exam scores.

#include <iostream>

using namespace std;

void calculateSubjectData(int student_marks[][5], int no_of_students);

int main() {
  int no_of_students;
  cout << "Enter the number of students : ";
  cin >> no_of_students;

  int student_marks[no_of_students][5];
  for (int i = 0; i < no_of_students; i++) {
    cout << "Enter Student " << i + 1 << " marks for 5 subjects : ";
    for (int j = 0; j < 5; j++) {
      cin >> student_marks[i][j];

      if (student_marks[i][j] < 0 || student_marks[i][j] > 100) {
        cout << "Invalid Input Range. Try Again !" << endl;
        j--;
        continue;
      }
    }
  }

  calculateSubjectData(student_marks, no_of_students);

  return 0;
}


void calculateSubjectData(int student_marks[][5], int no_of_students) {
  for (int i = 0; i < 5; i++) {
    int sum_of_marks = 0, highest = student_marks[0][i], lowest = student_marks[0][i];
    for (int j = 0; j < no_of_students; j++) {
      sum_of_marks += student_marks[j][i];
      
      if (highest < student_marks[j][i]) {
        highest = student_marks[j][i];
      }
      
      if (lowest > student_marks[j][i]) {
        lowest = student_marks[j][i];
      }
    }
    cout << "Average of Subject " << i + 1 << " marks : " << (sum_of_marks / no_of_students) << endl;
    cout << "Highest of Subject " << i + 1 << " marks : " << highest << endl;
    cout << "Lowest of Subject " << i + 1 << " marks : " << lowest << endl;
  }
}