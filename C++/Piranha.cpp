#include "oop.hpp"
#include "Coins.hpp"
#include "Piranha.hpp"
#include "Interface.hpp"

#include <cmath>
#include <ctime>
#include <cstdlib>
#include <iostream>

#define guppyPrice 100
#define rightDirection 0
#define leftDirection 1

using namespace std;

// 4 sekawan
Piranha::Piranha() : Fish(), timeC(50){
    setSpeed(2);
    destX = rand()%101;
    destY = rand()%101;
    time = 0;
    direction = RIGHT;
} //constructor

Piranha::Piranha(int x, int y) : Fish(x,y), timeC(50){
    setSpeed(2);
    destX = rand()%101;
    destY = rand()%101;
    time = 0;
    direction = RIGHT;
}

Piranha::~Piranha() {} // dipanggil saat dimakan piranha dan tidak makan setelah M waktu

Piranha& Piranha::operator=(const Piranha& P) {
    setX(P.getX());
    setY(P.getY());
    setSpeed(P.getSpeed());
    setDest(P.getDestX(), P.getDestY());
    setTime(P.getTime());
    setDirection(P.getDirection());
	return *this;
} // operator assignment

// setter
void Piranha::setDest(int x, int y){
    this->destX = x;
    this->destY = y;
}
void Piranha::setTime(int time) {
	this->time = time;
}
void Piranha::setDirection(int direction){
    this->direction = direction;
}

// getter

int Piranha::getDestX() const{
    return destX;
}
int Piranha::getDestY() const{
    return destY;
}
int Piranha:: getTime() const {
	return time;
}
int Piranha::getDirection() const{
    return direction;
}
int Piranha::getTimeC() const {
	return timeC;
}

void Piranha::moveRandom(){
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

double Piranha::distanceTo(Guppy G){
	return pow( (pow(G.getX() - this->getX(), 2) + (pow(G.getY() - this->getY(), 2))), 0.5);
}

void Piranha::moveToFood(Guppy G){
    double a = atan2(G.getY() - this->getY(), G.getX() - this->getX());
    if(round(getSpeed()*cos(a)) >= 0){
        direction = RIGHT;
    }else{
        direction = LEFT;
    }
    setX(getX() + round(getSpeed()*cos(a)));
    setY(getY() + round(getSpeed()*sin(a)));
}

void Piranha::makeCoin(LinkedList<Coins> *ListCoins, Guppy G) {
    Coins *C = new Coins(getX(), getY(), (G.getPhase()+1)*500);
    ListCoins->add(*C);
}

void Piranha::draw() {
	if (direction == 0) {
        if(!getIsFull()){
            draw_image("PiranhaSick-Right.png",getX()*SCREEN_WIDTH/100,getY()*SCREEN_HEIGHT/100);
        }else{
            draw_image("Piranha-Right.png",getX()*SCREEN_WIDTH/100,getY()*SCREEN_HEIGHT/100);
        }
	} else {
		if(!getIsFull()){
            draw_image("PiranhaSick-Left.png",getX()*SCREEN_WIDTH/100,getY()*SCREEN_HEIGHT/100);
        }else{
            draw_image("Piranha-Left.png",getX()*SCREEN_WIDTH/100,getY()*SCREEN_HEIGHT/100);
        }
	}
} //interface

void Piranha::lifeCycle(LinkedList<Guppy>* ListGuppy, LinkedList<Coins>* ListCoins, LinkedList<Piranha>* ListPiranha){
    int idx = 0;
	if(!ListGuppy->isEmpty() && !getIsFull()){
		Guppy GClose = ListGuppy->get(idx);
		idx++;
		while(idx < ListGuppy->getIdx()) {
			if(this->distanceTo(GClose) > this->distanceTo(ListGuppy->get(idx))){
				GClose = ListGuppy->get(idx);
			}
			idx++;
		}
		this->moveToFood(GClose);
		if(abs(this->getX()-GClose.getX()) < 4 && abs(this->getY()-GClose.getY()) < 4){
            setIsFull(true);
            setTime(0);
            makeCoin(ListCoins, GClose);
			ListGuppy->remove(GClose); 
		}
	}else{
        moveRandom();
    }
    if(time >= timeT ){
        setIsFull(false);
    }
    if(time >= timetoDeath){
        ListPiranha->remove(*this);
    }
    time++;
}