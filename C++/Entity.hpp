#ifndef ENTITY_HPP
#define ENTITY_HPP


class Entity {
public:
	Entity();
	Entity(int, int); // inisiasi letak awal entitys
	virtual ~Entity();
	Entity& operator=(const Entity&);
	bool operator== (const Entity&);

	// setter
	void setX(int);
	void setY(int);
	void setSpeed(int);

	// getter
	int getX() const;
	int getY() const;
	float getSpeed() const;

	//function
	virtual void draw(); //interface

protected:
	int x, y; // menandakan posisi
	int speed; // kecepatan bergerak
};

#endif
