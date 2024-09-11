#include <iostream>
#include <string>

#include "../core/core.h"
#include "../validations/ValidationRules.cpp"

using namespace std;

int main()
{
    int choice;
    string customerName;
    long mobileNo;
    int vehicleNo;
    string partName;
    double partPrice;
    double labourCharges;
    string oilName;
    double oilPrice;
    Servicing *servicing;
    do
    {
        try
        {
            cout << "--- Vehicle Service Station Bill Generation Menu --- " << endl;
            cout << "1. Maintenance or Repairing" << endl;
            cout << "2. Engine or Gear Oil Change" << endl;
            cout << "0. Exit" << endl;
            cout << "Enter your choice : ";
            cin >> choice;
            switch (choice)
            {
            case 1:
                // customerName, vehicleNo, mobileNo, partName, partPrice, labourCharge
                cout << "Enter customer name : ";
                cin >> customerName;
                cout << "Enter mobile number : ";
                cin >> mobileNo;
                cout << "Enter vehicle number : ";
                cin >> vehicleNo;
                cout << "Enter vehicle part to be replaced : ";
                cin >> partName;
                cout << "Enter the price of the part to be replaced : ";
                cin >> partPrice;
                ValidationRules::validatePrice(partPrice);
                cout << "Enter labour charges : ";
                cin >> labourCharges;
                ValidationRules::validatePrice(labourCharges);
                servicing = new Maintenance(customerName, vehicleNo, mobileNo, partName, partPrice, labourCharges);
                servicing->toString();
                break;
            case 2:
                // customerName, vehicleNo, mobileNo, oilName, price
                cout << "Enter customer name : ";
                cin >> customerName;
                cout << "Enter mobile number : ";
                cin >> mobileNo;
                cout << "Enter vehicle number : ";
                cin >> vehicleNo;
                cout << "Enter oil brand name : ";
                cin >> oilName;
                cout << "Enter oil price : ";
                cin >> oilPrice;
                ValidationRules::validatePrice(oilPrice);
                servicing = new OilChange(customerName, vehicleNo, mobileNo, oilName, oilPrice);
                servicing->toString();
                break;
            case 0:
                cout << "Thank you for using our services." << endl;
                break;
            default:
                cout << "Enter a valid choice !" << endl;
                break;
            }
        }
        catch (exception e)
        {
            cout << e.what() << endl;
        }
    } while (choice != 0);
    return 0;
}