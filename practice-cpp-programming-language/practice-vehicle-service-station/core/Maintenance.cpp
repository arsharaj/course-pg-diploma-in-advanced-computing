#include "core.h"

string Maintenance::getPartName()
{
    return this->partName;
}

double Maintenance::getPartPrice()
{
    return this->partPrice;
}

double Maintenance::getLabourCharge()
{
    return this->labourCharge;
}

void Maintenance::setPartName(string partName)
{
    this->partName = partName;
}

void Maintenance::setPartPrice(double partPrice)
{
    this->partPrice = partPrice;
}

void Maintenance::setLabourCharge(double labourCharge)
{
    this->labourCharge = labourCharge;
}

void Maintenance::toString()
{
    cout << "Maintenance [" << this->getCustomerName() << ", " << this->getVehicleNo() << ", " << this->getMobileNo() << ", " << this->getTotalBill() << ", " << this->getPartName() << ", " << this->getPartPrice() << ", " << this->getLabourCharge() << "]" << endl;
}