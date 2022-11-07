/**
 * Project 6
 * File: Customer.java
 * Author: Zehra Gundogdu
 * Date: 4/4/2022
 */

import java.util.ArrayList;

abstract class Customer{
    private int num_items;
    private int time_steps;

    //default constructor method
    public Customer(int num_items){
        this.num_items = num_items;
        time_steps = 0;
    }

    //constructor method
    public Customer(int num_items, int time_steps){
        this.num_items =num_items;
        this.time_steps = time_steps;
    }

    //increments time steps
    public void incrementTime(){
        time_steps++;
    }

    //returns the number of time steps
    public int getTime(){
        return time_steps;
    }

    //decrements the number of items (indicating another item has been paid for)
    public void giveUpTime(){
        num_items--;
    }

    //returns the number of items
    public int getNumItems(){
        return num_items;
    }

    public abstract int chooseLine(ArrayList<CheckoutAgent> checkouts);
}
