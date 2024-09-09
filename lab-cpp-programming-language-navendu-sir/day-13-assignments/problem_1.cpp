#include <iostream>

using namespace std;

// Printer Class
class Printer {
  protected:
    long resolution;
    int speed;
    string colour;
    int cache;
    Printer();
    Printer(long resolution, int speed, string colour, int cache);
  public:
    void showDetails();
    void printFile();
    void printImage();
};

Printer::Printer() {
  this -> resolution = 0.0;
  this -> speed = 0;
  this -> colour = "No Color";
  this -> cache = 0;
}

Printer::Printer(long resolution, int speed, string colour, int cache) {
  this -> resolution = resolution;
  this -> speed = speed;
  this -> colour = colour;
  this -> cache = cache;
}

void Printer::showDetails() {
  cout << "Resolution : " << this -> resolution << " dots per inch." << endl;
  cout << "Speed : " << this -> speed << " sheets of paper printed per min." << endl;
  cout << "Colour : " << this -> colour << "." << endl;
  cout << "Cache : " << this -> cache << " MB." << endl;
}

void Printer::printFile() {
  cout << "Printing a file." << endl;
}

void Printer::printImage() {
  cout << "Printing an image." << endl;
}

// DotMatrix Class
class DotMatrix : public Printer {
  public:
    DotMatrix() : Printer(0.0, 40, "Black", 0) {}
    void showDetails();
};

void DotMatrix::showDetails() {
  cout << "Speed : " << this -> speed << " characters per min." << endl;
  cout << "Colour : " << this -> colour << "." << endl;
}

// Thermal Class
class Thermal : public Printer {
  public:
    Thermal() : Printer(203, 250, "Monochrome", 8) {}
    void showDetails();
};

void Thermal::showDetails() {
  cout << "Resolution : " << this -> resolution << " dots per inch." << endl;
  cout << "Speed : " << this -> speed << " mm/sec throughput monochrome." << endl;
  cout << "Colour : " << this -> colour << "." << endl;
  cout << "Cache : " << this -> cache << " MB." << endl;
}

// InkJet Class
class InkJet : public Printer {
  public:
    InkJet() : Printer(300, 8.5, "Black", 64) {}
};

// Laser Class
class Laser : public Printer {
  public:
    Laser() : Printer(600, 24, "Black", 64) {}
};

int main() {
  Laser laserPrinter;
  cout << "--- Laser Printer ---" << endl;
  laserPrinter.showDetails();
  laserPrinter.printFile();
  laserPrinter.printImage();

  InkJet inkjetPrinter;
  cout << "--- InkJet Printer ---" << endl;
  inkjetPrinter.showDetails();
  inkjetPrinter.printFile();
  inkjetPrinter.printImage();

  Thermal thermalPrinter;
  cout << "--- Thermal Printer ---" << endl;
  thermalPrinter.showDetails();
  thermalPrinter.printFile();
  thermalPrinter.printImage();

  DotMatrix dotmatrixPrinter;
  cout << "--- Dot Matrix Printer ---" << endl;
  dotmatrixPrinter.showDetails();
  dotmatrixPrinter.printFile();
  dotmatrixPrinter.printImage();

  return 0;
}