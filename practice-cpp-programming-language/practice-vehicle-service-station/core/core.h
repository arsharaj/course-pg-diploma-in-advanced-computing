#ifndef CORE_SERVICES_H
#define CORE_SERVICES_H

#include <iostream>
#include <string>

using namespace std;

class Servicing
{
private:
    string customerName;
    int vehicleNo;
    long mobileNo;
    double totalBill;

public:
    Servicing(string customerName, int vehicleNo, long mobileNo)
    {
        this->customerName = customerName;
        this->vehicleNo = vehicleNo;
        this->mobileNo = mobileNo;
        this->totalBill = 0.0;
    }
    string getCustomerName();
    int getVehicleNo();
    long getMobileNo();
    double getTotalBill();
    void setCustomerName(string customerName);
    void setVehicleNo(int vehicleNo);
    void setMobileNo(long mobileNo);
    void setTotalBill(double totalBill);
    void toString();
};

class Maintenance : public Servicing
{
private:
    string partName;
    double partPrice;
    double labourCharge;

public:
    Maintenance(string customerName, int vehicleNo, long mobileNo, string partName, double partPrice, double labourCharge)
        : Servicing(customerName, vehicleNo, mobileNo)
    {
        this->partName = partName;
        this->partPrice = partPrice;
        this->labourCharge = labourCharge;
    }
    string getPartName();
    double getPartPrice();
    double getLabourCharge();
    void setPartName(string partName);
    void setPartPrice(double partPrice);
    void setLabourCharge(double labourCharge);
    void toString();
};

class OilChange : public Servicing
{
private:
    string oilName;
    double oilPrice;

public:
    OilChange(string customerName, int vehicleNo, long mobileNo, string oilName, double price)
        : Servicing(customerName, vehicleNo, mobileNo)
    {
        this->oilName = oilName;
        this->oilPrice = oilPrice;
    }
    string getOilName();
    double getOilPrice();
    void setOilName(string oilName);
    void setOilPrice(double oilPrice);
    void toString();
};

#endif