#include "core.h"

string Servicing::getCustomerName()
{
    return this->customerName;
}

int Servicing::getVehicleNo()
{
    return this->vehicleNo;
}

long Servicing::getMobileNo()
{
    return this->mobileNo;
}

double Servicing::getTotalBill()
{
    return this->totalBill;
}

void Servicing::setCustomerName(string customerName)
{
    this->customerName = customerName;
}

void Servicing::setVehicleNo(int vehicleNo)
{
    this->vehicleNo = vehicleNo;
}

void Servicing::setMobileNo(long mobileNo)
{
    this->mobileNo = mobileNo;
}

void Servicing::setTotalBill(double totalBill)
{
    this->totalBill = totalBill;
}

void Servicing::toString()
{
    cout << "Servicing [" << this->getCustomerName() << ", " << this->getVehicleNo() << ", " << this->getMobileNo() << ", " << this->getTotalBill() << "]" << endl;
}