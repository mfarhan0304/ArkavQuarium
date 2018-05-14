#include "Fish.hpp"

Fish::Fish() : Entity(), timetoDeath(100), radius(4), timeM(75), timeT(50) {
	isFull = true;
} // memanggil ctor parents Entity

Fish::Fish(int x, int y) : Entity(x,y), timetoDeath(100), radius(4), timeM(75), timeT(50) {
	isFull = true;
}

Fish::~Fish() {} // dipanggil saat Gruppy / Piranha mati

void Fish::makeCoins(){}
//setter
void Fish::setIsFull(bool full) {
	isFull = full;
}

//getter
bool Fish::getIsFull() const {
	return isFull;
}
int Fish::getTimeToDeath() const{
	return timetoDeath;
}
int Fish::getRadius() const{
	return radius;
}
int Fish::getTimeM() const {
	return timeM;
}
int Fish::getTimeT() const {
	return timeT;
}