#ifndef FISH_HPP
#define FISH_HPP
#include <ctime>
#include <iostream>
#include "Entity.hpp"
#include "Interface.hpp"
#include "LinkedList.hpp"
#include "Food.hpp"
#define RIGHT 0;
#define LEFT 1;
using namespace std;

class Fish : public Entity {
public:
	Fish(); // memanggil ctor parents Entity
	Fish(int,int);
	virtual ~Fish(); // dipanggil saat Gruppy / Piranha mati
	virtual void draw() = 0;
	virtual void makeCoins(); // pure virtual fungsi makeCoins

	//setter
	void setIsFull(bool);
	//getter
	bool getIsFull() const;
	int getTimeToDeath() const;
	int getRadius() const;
	int getTimeM() const;
	int getTimeT() const;

protected:
	bool isFull; // setelah beberapa waktu akan jadi false
	const int timetoDeath; // waktu menuju kematian
	const int radius; // radius mengambil makanan
	const int timeM; // waktu untuk mencari makanan saat kelaparan
	const int timeT; // waktu bergerak bebas saat kenyang

};

#endif