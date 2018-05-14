#ifndef SNAIL_HPP
#define SNAIL_HPP
#include "Entity.hpp"
#include "Interface.hpp"
#include "Entity.hpp"
#include "Interface.hpp"
#include "Coins.hpp"
#include "oop.hpp"
#include "LinkedList.hpp"
#include <cmath>
#include <iostream>
#define RIGHT 0;
#define LEFT 1;

class Snail : public Entity  {
	public:
		Snail();
		~Snail();
		double distanceTo(Coins C);
		void moveToCoins(Coins C);
		void takeCoins(Coins C); // mengambil coin yang berada di dekatnya
		void draw(); //interface
		void lifeCycle(LinkedList<Coins>*);
	private:
		int direction;
};

#endif