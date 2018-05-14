#ifndef AQUARIUM_HPP
#define AQUARIUM_HPP
#include "Interface.hpp"
#include "oop.hpp"
#include "Entity.hpp"

class Aquarium: public Interface {
public:
	Aquarium(); // pembentukan array, beberapa guppy, satu piranha, satu siput secara acak
	~Aquarium(); // delete array
	void draw(); //interface
};

#endif
