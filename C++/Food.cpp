#include "Food.hpp"
#include <iostream>
#include <cstdlib>

Food::Food() {
	y = 0;
	x = 0; 
}
Food::Food(int x, int y){
	this->x = x;
	this->y = y;
}

Food::~Food() {}

void Food::draw(){
	draw_image("foodie.png", getX()*SCREEN_WIDTH/100, getY()*SCREEN_HEIGHT/100);
} // interface
void Food::move() {
	if(y != 94){		
		setY(getY()+1);
	}
} // makanan bergerak dari atas ke bawah

void Food::lifeCycle(LinkedList<Food> *ListFood) {
	move();
	if (y == 94) {
		ListFood->remove(*this);
	}
}