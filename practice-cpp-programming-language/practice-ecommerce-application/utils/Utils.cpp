#include <iostream>
#include <vector>

#ifndef CORE_H
#define CORE_H
    #include "../core/Person.cpp"
    #include "../core/Product.cpp"
    #include "../core/Seller.cpp"
#endif

using namespace std;

class Utils {
public:
    static void addSeller(vector<Seller> &allSellers) {
        int id;
        string name;
        cout << "Enter seller details (id, name) : " << endl;
        cin >> id >> name;
        Seller *newSeller = new Seller(id, name);
        allSellers.push_back(*newSeller);
        cout << "Seller successfully added." << endl;
    }

    static void displaySellers(vector<Seller> &allSellers) {
        cout << "All the sellers :- " << endl;
        for (Seller seller : allSellers) {
            seller.toString();
        }
    }
};