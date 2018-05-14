#include "Aquarium.hpp"

Aquarium::Aquarium() {
    ;
} // pembentukan array, beberapa guppy, satu piranha, satu siput secara acak
Aquarium::~Aquarium() {
} // delete array
void Aquarium::draw() {
    draw_image("aquarium1.jpg", SCREEN_WIDTH/2, SCREEN_HEIGHT/2);
} //interface
