#include <iostream>

using namespace std;

class Base {
	private:
		int varOne;
	protected:
		int varTwo;
	public:
		void funcOne() {
			varOne = 10;
			varTwo = 20;
			cout << this << endl;
		}
};

class Derived : public Base {
	private:
		int varThree;
	protected:
		int varFour;
	public:
		void funcTwo() {
			// varOne += 10;
			varTwo += 10;
			varThree = 100;
			varFour = 200;
			funcOne();
			cout << this << endl;
		}
};

class Subderived : protected Derived {
	public:
		void funcThree() {
		  varTwo = 0;
			varFour = 0;
		}
};

int main() {
	Base base;
	// base.varOne = 30;
	// base.varTwo = 40;
	base.funcOne();

	Derived derived;
	// derived.varOne = 100;
	// derived.varTwo = 200;
	// derived.varThree = 300;
	// derived.varFour = 400;
	derived.funcOne();
	derived.funcTwo();

	cout << "Size of Base class : " << sizeof(Base) << endl;
	cout << "Size of Derived class : " << sizeof(Derived) << endl;

	Subderived subderived;
	subderived.funcThree();

  return 0;
}
