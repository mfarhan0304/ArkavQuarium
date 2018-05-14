#include "Snail.hpp"

Snail::Snail():Entity(){
	this->y = 100;
	this->x = 0;
	direction = RIGHT;
}

Snail::~Snail() {}

double Snail::distanceTo(Coins C){
	return pow( (pow(C.getX() - this->getX(), 2) + (pow(C.getY() - this->getY(), 2))), 0.5);
}

void Snail::moveToCoins(Coins C){
	if(x < C.getX()){
		direction = RIGHT;
		x = x + this->getSpeed();
	}else if(x > C.getX()){
		direction = LEFT;
		x = x - this->getSpeed();
	}
}

void Snail::takeCoins(Coins C) {
	// ~Coins();
} // mengambil coin yang berada di dekatnya

void Snail::draw() {
	if(direction == 0){
		draw_image("snail0.png",getX()*SCREEN_WIDTH/100,(getY()-6)*SCREEN_HEIGHT/100);
	}else{
		draw_image("snail1.png",getX()*SCREEN_WIDTH/100,(getY()-6)*SCREEN_HEIGHT/100);
	}
} //interface

void Snail::lifeCycle(LinkedList<Coins>* ListCoins){
	int idx = 0;
	if(!ListCoins->isEmpty()){
		Coins CClose = ListCoins->get(idx);
		idx++;
		while(idx < ListCoins->getIdx()) {
			if(this->distanceTo(CClose) > this->distanceTo(ListCoins->get(idx))){
				CClose = ListCoins->get(idx);
			}
			idx++;
		}
		this->moveToCoins(CClose);
		if(this->getX() == CClose.getX() && this->getY()-10 <= CClose.getY()){
			Coins::Money += CClose.getValue();
			ListCoins->remove(CClose); 
		}
	}
}