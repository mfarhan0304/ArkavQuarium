#include "Guppy.hpp"
#include <iostream>
#include <cstdlib>

using namespace std;
// 4 sekawan
Guppy::Guppy() : Fish(), maxPhase(3), timeC(50){
    setSpeed(2);
	phase = 1;
    destX = rand()%101;
    destY = rand()%101;
    foodCounter = 0;
    time = 0;
    direction = RIGHT;
} //constructor

Guppy::Guppy(int x, int y) : Fish(x,y), maxPhase(3), timeC(50){
    setSpeed(2);
	phase = 1;
    destX = rand()%101;
    destY = rand()%101;
    foodCounter = 0;
    time = 0;
    direction = RIGHT;
}

Guppy::~Guppy() {} // dipanggil saat dimakan piranha dan tidak makan setelah M waktu

Guppy& Guppy::operator=(const Guppy& G) {
    setX(G.getX());
    setY(G.getY());
    setSpeed(G.getSpeed());
    setPhase(G.getPhase());
    setDest(G.getDestX(), G.getDestY());
    setFoodCounter(G.getFoodCounter());
    setTime(G.getTime());
    setDirection(G.getDirection());
	return *this;
} // operator assignment

// setter
void Guppy::setPhase(int phase) {
	this->phase = phase;
}
void Guppy::setDest(int x, int y){
    this->destX = x;
    this->destY = y;
}
void Guppy::setFoodCounter(int foodCounter) {
	this->foodCounter = foodCounter;
}
void Guppy::setTime(int time) {
	this->time = time;
}
void Guppy::setDirection(int direction){
    this->direction = direction;
}

// getter

int Guppy::getPhase() const{
	return phase;
}
int Guppy::getDestX() const{
    return destX;
}
int Guppy::getDestY() const{
    return destY;
}
int Guppy::getFoodCounter() const {
	return foodCounter;
}
int Guppy:: getTime() const {
	return time;
}
int Guppy::getDirection() const{
    return direction;
}
int Guppy::getMaxPhase() const {
	return maxPhase;
}
int Guppy::getTimeC() const {
	return timeC;
}

void Guppy::moveRandom(){
    if(abs(getX()-getDestX()) < 4 && abs(getY()-getDestY()) < 4){
        setDest(rand()%101, rand()%101);
    }
    double a = atan2(getDestY() - this->getY(), getDestX() - this->getX());
    if(round(getSpeed()*cos(a)) >= 0){
        direction = RIGHT;
    }else{
        direction = LEFT;
    }
    setX(getX() + round(getSpeed()*cos(a)));
    setY(getY() + round(getSpeed()*sin(a)));
}

double Guppy::distanceTo(Food F){
	return pow( (pow(F.getX() - this->getX(), 2) + (pow(F.getY() - this->getY(), 2))), 0.5);
}

void Guppy::grow() {
    setPhase(getPhase() + 1);
}

void Guppy::moveToFood(Food F){
    double a = atan2(F.getY() - this->getY(), F.getX() - this->getX());
    if(round(getSpeed()*cos(a)) >= 0){
        direction = RIGHT;
    }else{
        direction = LEFT;
    }
    setX(getX() + round(getSpeed()*cos(a)));
    setY(getY() + round(getSpeed()*sin(a)));
}

void Guppy::makeCoin(LinkedList<Coins> *ListCoins) {
    Coins *C = new Coins(getX(), getY(), getPhase()*100);
    ListCoins->add(*C);
}

void Guppy::draw() {
	if (direction == 0) {
        if(!getIsFull()){
            if (getPhase() == 1){
                draw_image("ikanlaper2flip.png",getX()*SCREEN_WIDTH/100,getY()*SCREEN_HEIGHT/100);
            } else 
            if (getPhase() == 2) {
                draw_image("ikanlaper1flip.png",getX()*SCREEN_WIDTH/100,getY()*SCREEN_HEIGHT/100);                
            } else 
            if (getPhase() == 3) {
                draw_image("ikanlaperflip.png",getX()*SCREEN_WIDTH/100,getY()*SCREEN_HEIGHT/100);
            }
        }else{
            if (getPhase() == 1) {
                draw_image("ikanb2flip.png",getX()*SCREEN_WIDTH/100,getY()*SCREEN_HEIGHT/100);
            } else
            if (getPhase() == 2) {
                draw_image("ikanb1flip.png",getX()*SCREEN_WIDTH/100,getY()*SCREEN_HEIGHT/100);                
            } else
            if (getPhase() == 3) {
                draw_image("ikanbflip.png",getX()*SCREEN_WIDTH/100,getY()*SCREEN_HEIGHT/100);                
            }
        }
	} else {
		if(!getIsFull()){
            if (getPhase() == 1){
                draw_image("ikanlaper2.png",getX()*SCREEN_WIDTH/100,getY()*SCREEN_HEIGHT/100);
            } else 
            if (getPhase() == 2) {
                draw_image("ikanlaper1.png",getX()*SCREEN_WIDTH/100,getY()*SCREEN_HEIGHT/100);                
            } else 
            if (getPhase() == 3) {
                draw_image("ikanlaper.png",getX()*SCREEN_WIDTH/100,getY()*SCREEN_HEIGHT/100);
            }
        }else{
            if (getPhase() == 1) {
                draw_image("ikanb2.png",getX()*SCREEN_WIDTH/100,getY()*SCREEN_HEIGHT/100);
            } else
            if (getPhase() == 2) {
                draw_image("ikanb1.png",getX()*SCREEN_WIDTH/100,getY()*SCREEN_HEIGHT/100);                
            } else
            if (getPhase() == 3) {
                draw_image("ikanb.png",getX()*SCREEN_WIDTH/100,getY()*SCREEN_HEIGHT/100);                
            }
        }
	}
	// draw_image("ikan.png",getX()*SCREEN_WIDTH/100,getY()*SCREEN_HEIGHT/100);
} //interface

void Guppy::lifeCycle(LinkedList<Food>* ListFood, LinkedList<Coins>* ListCoins, LinkedList<Guppy>* ListGuppy){
    int idx = 0;
	if(!ListFood->isEmpty() && !getIsFull()){
		Food FClose = ListFood->get(idx);
		idx++;
		while(idx < ListFood->getIdx()) {
			if(this->distanceTo(FClose) > this->distanceTo(ListFood->get(idx))){
				FClose = ListFood->get(idx);
			}
			idx++;
		}
		this->moveToFood(FClose);
		if(abs(this->getX()-FClose.getX()) < 4 && abs(this->getY()-FClose.getY()) < 4){
            setIsFull(true);
            setTime(0);
            foodCounter++;
			ListFood->remove(FClose); 
		}
	}else{
        moveRandom();
    }
    if(time >= timeT ){
        setIsFull(false);
    }
    if(time >= timetoDeath){
        ListGuppy->remove(*this);
    }
    time++;
    if (time % timeC == 0 && isFull) {
        makeCoin(ListCoins);
    }
    if (foodCounter > 3 && getPhase() == 1){
            grow();
    }
    if (foodCounter > 6 && getPhase() == 2){
            grow();
    }
}
