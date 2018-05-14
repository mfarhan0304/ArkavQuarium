#ifndef GUPPY_HPP
#define GUPPY_HPP
#include "Fish.hpp"
#include "Interface.hpp"
#include "oop.hpp"
#include "Coins.hpp"
#include "LinkedList.hpp"
#include "Food.hpp"
#include <cmath>


class Guppy : public Fish{
public:
	// 4 sekawan
	Guppy(); //constructor
	Guppy(int x, int y);

	~Guppy(); // dipanggil saat dimakan piranha dan tidak makan setelah M waktu
	Guppy& operator=(const Guppy&);

	// setter
	void setPhase(int);
	void setDest(int,int);
	void setFoodCounter(int);
	void setTime(int);
	void setDirection(int);

	// getter

	int getPhase() const;
	int getDestX() const;
	int getDestY() const;
	int getFoodCounter() const;
	int getTime() const;
	int getDirection() const;
	int getMaxPhase() const;
	int getTimeC() const;

	// function
    void moveRandom();
	double distanceTo(Food F);
	void moveToFood(Food F);
	void draw(); //interface
	void makeCoin(LinkedList<Coins>*);
	void grow();
	
	// LIFE CYCLE
	void lifeCycle(LinkedList<Food>*, LinkedList<Coins>*, LinkedList<Guppy>*);

private:
	int phase; // dimulai dari phase 1 hingga phase 3
    int destX;
    int destY;
	int foodCounter;
	int time;
    int direction;
	const int maxPhase; // phase 3
	const int timeC; // waktu untuk menghasilkan coin
};

#endif