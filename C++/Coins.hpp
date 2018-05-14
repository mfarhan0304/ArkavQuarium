#ifndef COINS_HPP
#define COINS_HPP
#include "Entity.hpp"
#include "Interface.hpp"
#include "oop.hpp"

class Coins : public Entity  {
	public:
		static int Money;
		Coins();
		Coins(int); // memanggil ctor parent Entity
		Coins(int,int,int);
		~Coins(); // dipanggil saat diambil siput

		Coins& operator=(const Coins&);
		// setter
		void setValue(int);
		void move(); // koin bergerak dari atas ke bawah

		// getter
		int getValue() const;
		
		//function
		void draw(); //interface
	private:
		int value; // nilai setiap koin
};

#endif