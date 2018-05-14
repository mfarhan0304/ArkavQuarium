#ifndef LINKEDLIST_HPP
#define LINKEDLIST_HPP
#include "Entity.hpp"
#include <iostream>

using namespace std;

template <class T>
struct node{
    T data;
    node *next;
};

template <class T>
class LinkedList{
    private:
        node<T> *head, *tail;

    public:
        LinkedList() {
            head = NULL;
            tail = NULL;
        }
        int find(T element) {
            node<T>* p = head; //first is the first element of the list
            int idx = 0;
            do {
                //x is in the list
                if(p->data == element) {
                    return idx;
                }
                p = p->next;
                idx++;
            } while(head->next != NULL);//go to the next element
            //we've reached the end of the list, so x isn't in it
            return -1;
        }
        bool isEmpty() {
            return head == NULL;
        }
        void add(T element) {
            node<T>* tmp = new node<T>;
            tmp->data = element;
            tmp->next = NULL;
            if (head == NULL) {
                head = tmp;
                tail = head;  
            } else {
                tail->next = tmp;
                tail = tail->next;  
            }
        }

        void remove(T element) {
            int idx = find(element);
            node<T>* p = head;
            if (element == head->data) {
                head = p->next;
                delete p;
            } else if (element == tail->data) {
                for (int i = 0; i < idx - 1; ++i) {
                    p = p->next;
                }
                p->next = NULL;
                tail = p;
            } else if (head == tail){
                delete p;
                head = NULL;
                tail = NULL;
            }
            else {
                for (int i = 0; i < idx - 1; ++i) {
                    p = p->next;
                }
                delete (p->next);
                p->next = (p->next)->next;
            }
        }

        T& get(int index) {
            node<T>* p = head;
            for (int i = 0; i < index; ++i) {
                p = p->next;
            }
            return p->data;
        }

        void print() {
            node<T>* p = head;
            while (p != NULL) {
                cout << p->data << " ";
                p = p->next;
            }
            cout << endl;
        }

        int getIdx(){
            node<T>* p = head;
            int idx = 0;
            while(p != NULL){
                idx++;
                p = p->next;
            }
            return idx;
        }
};

#endif