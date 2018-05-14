#include "oop.hpp"
#include "Aquarium.hpp"
#include "Entity.hpp"
#include "Fish.hpp"
#include "Guppy.hpp"
#include "Coins.hpp"
#include "Snail.hpp"
#include "LinkedList.hpp"
#include "Piranha.hpp"
#include "ReadWrite.hpp"
#include <iostream>
#include <math.h>
#include <sstream>
#include <ctime>
#include <string>

using namespace std;

//const double speed = 50; // pixels per second

int Coins::Money = 100;

int main( int argc, char* args[] )
{
    int egg = 0;
    int eggprice = 10000;
    LinkedList<Guppy> ListGuppy;
    LinkedList<Coins> ListCoins;
    LinkedList<Food> ListFood;
    LinkedList<Piranha> ListPiranha;
    Aquarium aquarium;
    Snail S;
    bool MoneyLess = false;
    int idx = 0;
    bool ClickCoins = false;
    bool mainMenu = true;
    bool firstLoop = true;
    bool win = false;
    bool lose = false;
    bool running = true;

    init();

    while (running) {

        handle_input();
        if (quit_pressed()) {
            running = false;
        }

        while(mainMenu){
            handle_input();
            clear_screen();
            draw_image("aquarium.jpg", SCREEN_WIDTH/2, SCREEN_HEIGHT/2);
            draw_image("MainMenu.png", SCREEN_WIDTH/2, SCREEN_HEIGHT/2);
            for (auto key : get_clicked_mouse()) {
                switch (key) {
                case 1:{
                    if(get_clicked_mouseX() >= 258 && get_clicked_mouseX() <= 480 && get_clicked_mouseY() <= 570 && get_clicked_mouseY() >= 440){
                        mainMenu = false;
                        Guppy *G = new Guppy(rand()%101, rand()%101);
                        ListGuppy.add(*G);
                    }
                    if(get_clicked_mouseX() >= 580 && get_clicked_mouseX() <= 820 && get_clicked_mouseY() <= 570 && get_clicked_mouseY() >= 440){
                        mainMenu = false;
                        ReadWrite RW;
                        string filenameGuppy = "Guppy.txt";
                        string filenameCoins = "Coins.txt";
                        string filenameFood = "Food.txt";
                        string filenamePiranha = "Piranha.txt";
                        string filenameMoney = "Money.txt";
                        string filenameEgg = "Egg.txt";
                        string filenameEggPrice = "EggPrice.txt";
                        RW.readStateGuppy(&ListGuppy, filenameGuppy);
                        RW.readStateCoins(&ListCoins, filenameCoins);
                        RW.readStateFood(&ListFood, filenameFood);
                        RW.readStatePiranha(&ListPiranha, filenamePiranha);
                        Coins::Money = RW.readStateMoney(filenameMoney);
                        egg = RW.readStateEgg(filenameEgg);
                        eggprice = RW.readStateEggPrice(filenameEggPrice);
                    }
                    if(get_clicked_mouseX() >= 920 && get_clicked_mouseX() <= 1150 && get_clicked_mouseY() <= 570 && get_clicked_mouseY() >= 440){
                        mainMenu = false;
                        running = false;
                        close();
                        return 0;
                    }
                }
                }
            }
            update_screen();
        }

        // Proses masukan yang bersifat "tombol"
        for (auto key : get_tapped_keys()) {
            switch (key) {
                // x untuk keluar
                case SDLK_x:{
                    running = false;     
                } break;
                // c muncul coin
                case SDLK_c:{
                    Coins *C = new Coins(rand()%101, 0, 100);
                    ListCoins.add(*C);
                } break;
                case SDLK_g:{
                    if(Coins::Money >= 100){
                        Coins::Money -= 100;
                        Guppy *G = new Guppy(rand()%101, rand()%101);
                        ListGuppy.add(*G);
                    }else{
                        MoneyLess = true;
                    }
                } break;
                case SDLK_p:{
                    if(Coins::Money >= 500){
                        Coins::Money -= 500;
                        Piranha *P = new Piranha();
                        ListPiranha.add(*P);
                    }else{
                        MoneyLess = true;
                    }
                } break;
                case SDLK_s:{
                    ReadWrite RW;
                    string filenameGuppy = "Guppy.txt";
                    string filenameCoins = "Coins.txt";
                    string filenameFood = "Food.txt";
                    string filenamePiranha = "Piranha.txt";
                    string filenameMoney = "Money.txt";
                    string filenameEgg = "Egg.txt";
                    string filenameEggPrice = "EggPrice.txt";
                    RW.writeStateGuppy(ListGuppy, filenameGuppy);
                    RW.writeStateCoins(ListCoins, filenameCoins);
                    RW.writeStateFood(ListFood, filenameFood);
                    RW.writeStatePiranha(ListPiranha, filenamePiranha);
                    RW.writeStateMoney(Coins::Money, filenameMoney);
                    RW.writeStateEgg(egg, filenameEgg);
                    RW.writeStateEggPrice(eggprice, filenameEggPrice);
                } break;
            }
        }
        if(!firstLoop){
            for (auto key : get_clicked_mouse()) {
                switch (key) {
                case 1:
                    cout << "X = " << get_clicked_mouseX() << "Y = " << get_clicked_mouseY() << endl;        
                    if ((get_clicked_mouseX() >= 1169 && get_clicked_mouseX() <= 1312) && (get_clicked_mouseY() >= 95 && get_clicked_mouseY() <= 164)){
                        if(Coins::Money >= eggprice){
                            Coins::Money -= eggprice;
                            egg++;
                            eggprice += 5000;
                            if(egg == 3){
                                win = true;
                            }
                        }else{
                            MoneyLess = true;
                        }
                    }else
                    if ((get_clicked_mouseX() >= 964 && get_clicked_mouseX() <= 1123) && (get_clicked_mouseY() >= 95 && get_clicked_mouseY() <= 164)) {
                        if(Coins::Money >= 5000){
                            Coins::Money -= 5000;
                            Piranha *P = new Piranha();
                            ListPiranha.add(*P);
                        }else{
                            MoneyLess = true;
                        }
                    } else 
                    if ((get_clicked_mouseX() >= 765 && get_clicked_mouseX() <= 922) && (get_clicked_mouseY() >= 95 && get_clicked_mouseY() <= 164)) {
                        if(Coins::Money >= 500){
                            Coins::Money -= 500;
                            Guppy *G = new Guppy(rand()%101, rand()%101);
                            ListGuppy.add(*G);
                        }else{
                            MoneyLess = true;
                        }
                    } else
                    {
                        idx = 0;
                        if(!ListCoins.isEmpty()){
                            while(idx < ListCoins.getIdx()) {
                                if(abs(get_clicked_mouseX()*100/1366 - ListCoins.get(idx).getX()) < 2 && abs(get_clicked_mouseY()*100/768 - ListCoins.get(idx).getY()) < 4){
                                    Coins::Money += ListCoins.get(idx).getValue();
                                    ListCoins.remove(ListCoins.get(idx));
                                    ClickCoins = true;
                                }
                                idx++;
                            }
                        }
                        if(!ClickCoins){
                            if(Coins::Money >= 20){
                                Coins::Money -= 20;
                                Food *F = new Food(get_clicked_mouseX()/13.66, get_clicked_mouseY()/7.66);
                                ListFood.add(*F);
                            }else{
                                MoneyLess = true;
                            }
                            ClickCoins = false;
                        }else{
                            ClickCoins = false;
                        }
                    }    
                    break;
                }
            }
        }else{
            firstLoop = false;
        }

        if(ListGuppy.isEmpty() && ListPiranha.isEmpty() && Coins::Money < 500){
            lose = true;
        }

        while(lose){
            handle_input();
            clear_screen();
            draw_image("aquarium.jpg", SCREEN_WIDTH/2, SCREEN_HEIGHT/2);
            draw_image("youlose.png", SCREEN_WIDTH/2, SCREEN_HEIGHT/2);
             for (auto key : get_clicked_mouse()) {
                switch (key) {
                case 1:{
                    if(get_clicked_mouseX() >= 986 && get_clicked_mouseX() <= 1185 && get_clicked_mouseY() <= 609 && get_clicked_mouseY() >= 512){
                        win = false;
                        running = false;
                        close();
                        return 0;
                    }
                    if(get_clicked_mouseX() >= 184 && get_clicked_mouseX() <= 560 && get_clicked_mouseY() <= 609 && get_clicked_mouseY() >= 512){
                        idx = 0;
                        while(!ListGuppy.isEmpty()){
                            ListGuppy.remove(ListGuppy.get(idx));
                        }
                        while(!ListCoins.isEmpty()){
                            ListCoins.remove(ListCoins.get(idx));
                        }
                        while(!ListFood.isEmpty()){
                            ListFood.remove(ListFood.get(idx));
                        }
                        while(!ListPiranha.isEmpty()){
                            ListPiranha.remove(ListPiranha.get(idx));
                        }
                        MoneyLess = false;
                        ClickCoins = false;
                        firstLoop = true;
                        win = false;
                        lose = false;
                        running = true;
                        Guppy *G = new Guppy(rand()%101, rand()%101);
                        ListGuppy.add(*G);
                        Coins::Money = 100;
                        egg = 0;
                    }
                }
                }
             }
            update_screen();
        }
        
        while(win){
            handle_input();
            clear_screen();
            draw_image("aquarium.jpg", SCREEN_WIDTH/2, SCREEN_HEIGHT/2);
            draw_image("YOUWIN.png", SCREEN_WIDTH/2, SCREEN_HEIGHT/2);
             for (auto key : get_clicked_mouse()) {
                switch (key) {
                case 1:{
                    if(get_clicked_mouseX() >= 986 && get_clicked_mouseX() <= 1185 && get_clicked_mouseY() <= 609 && get_clicked_mouseY() >= 512){
                        win = false;
                        running = false;
                        close();
                        return 0;
                    }else
                    if(get_clicked_mouseX() >= 184 && get_clicked_mouseX() <= 560 && get_clicked_mouseY() <= 609 && get_clicked_mouseY() >= 512){
                        cout << "gas terus"<< endl;
                        idx = 0;
                        while(!ListGuppy.isEmpty()){
                            ListGuppy.remove(ListGuppy.get(idx));
                        }
                        while(!ListCoins.isEmpty()){
                            ListCoins.remove(ListCoins.get(idx));
                        }
                        while(!ListFood.isEmpty()){
                            ListFood.remove(ListFood.get(idx));
                        }
                        while(!ListPiranha.isEmpty()){
                            ListPiranha.remove(ListPiranha.get(idx));
                        }
                        MoneyLess = false;
                        ClickCoins = false;
                        firstLoop = true;
                        win = false;
                        lose = false;
                        running = true;
                        Guppy *G = new Guppy(rand()%101, rand()%101);
                        ListGuppy.add(*G);
                        Coins::Money = 100;
                        eggprice += 3000;
                        egg = 0;
                    }
                }
                }
             }
            update_screen();
        }

        clear_screen();
        aquarium.draw();
        S.lifeCycle(&ListCoins);
        S.draw();
        
        idx = 0;
        while(idx < ListGuppy.getIdx()) {
            if(!ListGuppy.isEmpty()){
                ListGuppy.get(idx).lifeCycle(&ListFood, &ListCoins, &ListGuppy);
            }
            idx++;
        }

        idx = 0;
        while(idx < ListFood.getIdx()) {
            ListFood.get(idx).lifeCycle(&ListFood);
            idx++;
        }

        idx = 0;
        if(!ListPiranha.isEmpty()){
            while(idx < ListPiranha.getIdx()) {
                ListPiranha.get(idx).lifeCycle(&ListGuppy, &ListCoins, &ListPiranha);
                idx++;
            }
        }

        idx = 0;
        if(!ListPiranha.isEmpty()){
            while(idx < ListPiranha.getIdx()) {
                ListPiranha.get(idx).draw();
                idx++;
            }
        }

        idx = 0;
        if(!ListCoins.isEmpty()){
            while(idx < ListCoins.getIdx()) {
                ListCoins.get(idx).draw();
                ListCoins.get(idx).move();
                idx++;
            }
        }

        idx = 0;
        if(!ListFood.isEmpty()){
            while(idx < ListFood.getIdx()) {
                ListFood.get(idx).draw();
                idx++;
            }
        }

        idx = 0;
        if(!ListGuppy.isEmpty()){
            while(idx < ListGuppy.getIdx()) {
                ListGuppy.get(idx).draw();
                idx++;
            }
        }

        
        draw_image("papan.png", 1245, 80);
        draw_image("papan.png", 1045, 80);
        draw_image("papan.png", 845, 80);
        draw_image("scroll.png", 170, 80);

        switch(egg){
            case 0:{
                draw_image("eggos1.png", 1245, 125);
            }break;
            case 1:{
                draw_image("eggos2.png", 1245, 125);
            }break;
            case 2:{
                draw_image("eggos3.png", 1245, 125);
            }break;
        }
        draw_text(to_string(eggprice),14,1224,158,0,0,0);
        draw_image("gup.png", 847, 132);
        draw_text("500", 14, 836, 158, 0, 0, 0); //GUPPY
        draw_text("5000", 14, 1030, 158, 0, 0, 0); //PIRANHA
        draw_image("pir.png", 1041, 131);
        if(MoneyLess){
            draw_text("Money : ",32,80,35,239, 45, 23);
            draw_text(to_string(Coins::Money),32,80,75,239, 45, 23);
            MoneyLess = false;
        }else{
            draw_text("Money : ",32,80,35,0,0,0);
            draw_text(to_string(Coins::Money),32,80,75,0,0,0);
        }


        update_screen();
        SDL_Delay(100);
    }

    close();

    return 0;
}
