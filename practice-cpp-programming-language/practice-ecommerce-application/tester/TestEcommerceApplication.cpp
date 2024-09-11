#include <iostream>
#include <vector>

#ifndef CORE_H
#define CORE_H
    #include "../core/Person.cpp"
    #include "../core/Product.cpp"
    #include "../core/Seller.cpp"
#endif

#include "../utils/Utils.cpp"

using namespace std;

vector<Seller> allSellers;

int main() {
    int choice;
    do {
        try {
            cout << "--- E-commerce Application ---" << endl;
            cout << "1. Add seller" << endl;
            cout << "2. Add product" << endl;
            cout << "3. Display products sold by specific seller" << endl;
            cout << "4. Display all sellers" << endl;
            cout << "5. Display all products" << endl;
            cout << "0. Exit the application" << endl;
            cout << "Enter your choice : ";
            cin >> choice;
            switch (choice) {
                case 1: {
                    Utils::addSeller(allSellers);
                    break;
                }
                case 4: {
                    Utils::displaySellers(allSellers);
                    break;
                }
                case 0: {
                    cout << "Thank you for using our application." << endl;
                    break;
                }
                default: {
                    cout << "Enter a valid choice !" << endl;
                }
            }
        } catch (exception e) {
            cout << e.what() << endl;
        }
    } while (choice != 0);
    return 0;
}