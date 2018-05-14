#include <fstream>
#include <iostream>
#include <string>
#include "Guppy.hpp"
#include "Coins.hpp"
#include "Piranha.hpp"
#include "Food.hpp"
#include "Snail.hpp"
using namespace std;

class ReadWrite {
    public:
        
        // functions read
        void writeStateGuppy(LinkedList<Guppy> ListGuppy, string filename) {
            ofstream outfile;
            outfile.open(filename);
            
            int idx = 0;
            while(idx < ListGuppy.getIdx()) {
                outfile << ListGuppy.get(idx).getX() << endl;
                outfile << ListGuppy.get(idx).getY() << endl;
                outfile << ListGuppy.get(idx).getPhase() << endl;  
                outfile << ListGuppy.get(idx).getDestX() << endl;
                outfile << ListGuppy.get(idx).getDestY() << endl;
                outfile << ListGuppy.get(idx).getFoodCounter() << endl;
                outfile << ListGuppy.get(idx).getTime() << endl;
                outfile << ListGuppy.get(idx).getDirection() << endl;
                
                idx++;
            }
            outfile.close();
        }
        void writeStateCoins(LinkedList<Coins> ListCoins, string filename) {
            ofstream outfile;
            outfile.open(filename);
            
            int idx = 0;
            while(idx < ListCoins.getIdx()) {
                outfile << ListCoins.get(idx).getX() << endl;
                outfile << ListCoins.get(idx).getY() << endl;
                outfile << ListCoins.get(idx).getValue() << endl;
                
                idx++;
            }
            outfile.close();
        }
        void writeStateFood(LinkedList<Food> ListFood, string filename) {
            ofstream outfile;
            outfile.open(filename);
            
            int idx = 0;
            while(idx < ListFood.getIdx()) {
                outfile << ListFood.get(idx).getX() << endl;
                outfile << ListFood.get(idx).getY() << endl;

                idx++;
            }
            outfile.close();
        }
        void writeStatePiranha(LinkedList<Piranha> ListPiranha, string filename) {
            ofstream outfile;
            outfile.open(filename);
            
            int idx = 0;
            while(idx < ListPiranha.getIdx()) {
                outfile << ListPiranha.get(idx).getX() << endl;
                outfile << ListPiranha.get(idx).getY() << endl; 
                outfile << ListPiranha.get(idx).getDestX() << endl;
                outfile << ListPiranha.get(idx).getDestY() << endl;
                outfile << ListPiranha.get(idx).getSpeed() << endl;
                outfile << ListPiranha.get(idx).getTime() << endl;
                outfile << ListPiranha.get(idx).getDirection() << endl;
                
                idx++;
            }
            outfile.close();
        }
        void writeStateMoney(int value, string filename) {
            ofstream outfile;
            outfile.open(filename);
            
            outfile << value << endl;

            outfile.close();
        }
        void writeStateEgg(int value, string filename) {
            ofstream outfile;
            outfile.open(filename);
            
            outfile << value << endl;

            outfile.close();
        }
        void writeStateEggPrice(int value, string filename) {
            ofstream outfile;
            outfile.open(filename);
            
            outfile << value << endl;

            outfile.close();
        }
        void readStateGuppy(LinkedList<Guppy>* ListGuppy, string filename) {
            ifstream infile; 
            infile.open(filename); 
        
            char data[100];
            while(infile >> data) {
                int X = stoi(data);
                infile >> data;
                int Y = stoi(data);
                infile >> data;
                int phase = stoi(data);
                infile >> data;
                int DestX = stoi(data);
                infile >> data;
                int DestY = stoi(data);
                infile >> data;
                int foodCounter = stoi(data);
                infile >> data;
                int time = stoi(data);
                infile >> data;
                int direction = stoi(data); 
                
                Guppy *G = new Guppy(X, Y);
                G->setPhase(phase);
                G->setDest(DestX, DestY);
                G->setFoodCounter(foodCounter);
                G->setTime(time);
                G->setDirection(direction);
                ListGuppy->add(*G);
            }

        infile.close();
        }
        void readStateCoins(LinkedList<Coins>* ListCoins, string filename) {
            ifstream infile; 
            infile.open(filename); 
            
            char data[100];
            while(infile >> data) {
                int x = stoi(data);
                infile >> data;
                int y = stoi(data);
                infile >> data;
                int value = stoi(data);

                Coins *C = new Coins(x, y, value);
                ListCoins->add(*C);
            }

            infile.close();
        }
        void readStateFood(LinkedList<Food>* ListFood, string filename) {
            ifstream infile; 
            infile.open(filename); 
            
            char data[100];
            while(infile >> data) {
                int x = stoi(data);
                infile >> data;
                int y = stoi(data);

                Food *F = new Food(x, y);
                ListFood->add(*F);
            }

            infile.close();
        }
        void readStatePiranha(LinkedList<Piranha>* ListPiranha, string filename) {
            ifstream infile; 
            infile.open(filename); 
        
            char data[100];
            while(infile >> data) {
                int X = stoi(data);
                infile >> data;
                int Y = stoi(data);
                infile >> data;
                int DestX = stoi(data);
                infile >> data;
                int DestY = stoi(data);
                infile >> data;
                int speed = stoi(data);
                infile >> data;
                int time = stoi(data);
                infile >> data;
                int direction = stoi(data); 
                
                Piranha *P = new Piranha(X, Y);
                P->setDest(DestX, DestY);
                P->setSpeed(speed);
                P->setTime(time);
                P->setDirection(direction);
                ListPiranha->add(*P);
            }

        infile.close();
    }
    int readStateMoney(string filename) {
        ifstream infile; 
        int money;
        infile.open(filename);
        char data[100];

        infile >> data;
        money = stoi(data);
        infile.close();
        
        return money;
    }
    int readStateEgg(string filename) {
        ifstream infile; 
        int egg;
        infile.open(filename);
        char data[100];

        infile >> data;
        egg = stoi(data);
        infile.close();
        
        return egg;
    }
    int readStateEggPrice(string filename) {
        ifstream infile; 
        int eggPrice;
        infile.open(filename);
        char data[100];

        infile >> data;
        eggPrice = stoi(data);
        infile.close();
        
        return eggPrice;
    }
};
