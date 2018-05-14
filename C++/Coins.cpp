#include "Coins.hpp"
#include <iostream>
using namespace std;
Coins::Coins():Entity(){
	this->value = 0;
}

Coins::Coins(int value) : Entity() {
	this->value = value;
} // memanggil ctor parent Entity

Coins::Coins(int x, int y, int v) : Entity(x,y){
	setValue(v);
}
Coins::~Coins() {} // dipanggil saat diambil siput

Coins& Coins::Coins::operator=(const Coins& C){
	this->x = C.getX();
	this->y = C.getY();
	setValue(C.getValue());
	return *this;
}
// setter
void Coins::setValue(int value) {
	this->value = value;
}
void Coins::move() {
	if(y != 94){		
		setY(getY()+1);
	}
} // koin bergerak dari atas ke bawah

// getter
int Coins::getValue() const{
	return value;
}

//function
void Coins::draw() {
    draw_image("coin.png",getX()*SCREEN_WIDTH/100,getY()*SCREEN_HEIGHT/100);
} //interface
