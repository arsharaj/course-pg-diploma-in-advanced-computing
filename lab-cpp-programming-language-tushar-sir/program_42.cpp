#include <iostream>

using namespace std;

class Employee {
  int emp_id;
  string emp_name;
  double salary;
  
  public:
    Employee() {
      this->emp_id = 0;
      this->emp_name = "";
      this->salary = 0.0;
    }
    
    Employee(int emp_id, string emp_name, double salary) {
      this->emp_id = emp_id;
      this->emp_name = emp_name;
      this->salary = salary;
    }
    
    void Accept() {
      cout << "Enter employee id : ";
      cin >> this->emp_id;
      cout << "Enter employee name : ";
      cin >> this->emp_name;
      cout << "Enter employee salary : ";
      cin >> this->salary;
    }
    
    void Display() {
      cout << "Employee id : " << this->emp_id << endl;
      cout << "Employee name : " << this->emp_name << endl;
      cout << "Employee salary : " << this->salary << endl;
    }
    
    int getEmpId() {
      return this->emp_id;
    }
};

int main() {
  int no, choice;
  cout << "Enter the number of employees : ";
  cin >> no;
  Employee employees[no];
  
  do {
    cout << "1. Insert records into array." << endl;
    cout << "2. Update information of specific employee." << endl;
    cout << "3. Display all records." << endl;
    cout << "4. Exit the menu." << endl;
    cout << "Enter your choice : ";
    cin >> choice;
    cout << endl;
    if (choice == 1) {
      for (int i = 0; i < no; i++)
        employees[i].Accept();
    } else if (choice == 2) {
      int temp_id;
      cout << "Enter Employee id : ";
      cin >> temp_id;
      for (int i = 0; i < no; i++) {
        if (employees[i].getEmpId() == temp_id) {
          employees[i].Accept();
          break;
        }
      }
      cout << "Information Updated!" << endl;
    } else if (choice == 3) {
      for (int i = 0; i < no; i++) {
        cout << "Employee " << i + 1 << " details :- " << endl;
        employees[i].Display();
      }
    } else if (choice == 4) {
      break;
    } else {
      cout << "Enter a valid choice." << endl;
    }
    cout << endl;
  } while(choice != 4);
  
  return 0;
}
