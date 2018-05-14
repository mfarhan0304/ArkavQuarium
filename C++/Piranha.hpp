#ifndef PIRANHA_HPP
#define PIRANHA_HPP
#include "Fish.hpp"
#include "Guppy.hpp"
#include "Interface.hpp"

const double pi = 3.1415926535897;

class Piranha : public Fish, public Interface  {
	public:
        // 4 sekawan
        Piranha(); //constructor
        Piranha(int x, int y);

        ~Piranha(); // dipanggil saat dimakan piranha dan tidak makan setelah M waktu
        Piranha& operator=(const Piranha&);

        // setter
        void setPhase(int);
        void setDest(int,int);
        void setTime(int);
        void setDirection(int);

        // getter

        int getDestX() const;
        int getDestY() const;
        int getTime() const;
        int getDirection() const;
        int getTimeC() const;

        // function
        void moveRandom();
        double distanceTo(Guppy G);
        void moveToFood(Guppy G);
        void draw(); //interface
        void makeCoin(LinkedList<Coins>*, Guppy G);
        
        // LIFE CYCLE
        void lifeCycle(LinkedList<Guppy>*, LinkedList<Coins>*, LinkedList<Piranha>*);

    private:
        int destX;
        int destY;
        int time;
        int direction;
        const int timeC; // waktu untuk menghasilkan coin
};

#endif
