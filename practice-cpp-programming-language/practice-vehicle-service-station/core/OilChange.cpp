#include "core.h"

string OilChange::getOilName()
{
    return this->oilName;
}

double OilChange::getOilPrice()
{
    return this->oilPrice;
}

void OilChange::setOilName(string oilName)
{
    this->oilName = oilName;
}

void OilChange::setOilPrice(double oilPrice)
{
    this->oilPrice = oilPrice;
}

void OilChange::toString()
{
    cout << "Oil Change [" << this->getCustomerName() << ", " << this->getVehicleNo() << ", " << this->getMobileNo() << ", " << this->getTotalBill() << ", " << this->getOilName() << ", " << this->getOilPrice() << "]" << endl;
}