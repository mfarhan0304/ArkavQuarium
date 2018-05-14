#ifndef FOOD_HPP
#define FOOD_HPP
#include "Entity.hpp"
#include "Interface.hpp"
#include "LinkedList.hpp"
#include "oop.hpp"

class Food : public Entity, public Interface {
public:
	Food();
	Food(int,int);
	~Food();
	void draw(); // interface
	void move(); // makanan bergerak dari atas ke bawah
	void lifeCycle(LinkedList<Food>*);
};

#endif