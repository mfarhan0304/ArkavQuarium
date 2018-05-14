#include "Entity.hpp"
#include "iostream"
using namespace std;

Entity::Entity(){
    this->x = 0;
    this->y = 0;
    this->speed = 1;
}
Entity::Entity(int x, int y){
    this->x = x;
    this->y = y;
    this->speed = 1;
} // inisiasi letak awal entitys

Entity::~Entity(){}

Entity& Entity::operator=(const Entity& other) {
    this->x = other.getX();
    this->y = other.getY();

    return *this;
}

bool Entity::operator== (const Entity& other) {
    return (this->x == other.getX() && this->y == other.getY());
}
// setter
void Entity::setX(int x) {
    this->x = x;
}
void Entity::setY(int y) {
    this->y = y;
}
void Entity::setSpeed(int speed){
    this->speed = speed;
}

// getter
int Entity::getX() const {
    return x;
}
int Entity::getY() const {
    return y;
}
float Entity::getSpeed() const {
    return speed;
}

void Entity::draw() {}
