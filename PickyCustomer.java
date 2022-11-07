/**
 * Project 6
 * File: PickyCustomer.java
 * Author: Zehra Gundogdu
 * Date: 4/4/2022
 */

import java.util.ArrayList;

public class PickyCustomer extends Customer{

    //constructor
    public PickyCustomer( int num_items, int num_lines ){
        super(num_items, num_lines);
    }

    //returns the index of the CheckoutAgent with the shortest line.
    public int chooseLine(ArrayList<CheckoutAgent> checkouts){
        CheckoutAgent shortest = checkouts.get(0);
        for (CheckoutAgent a : checkouts){
            if (a.getNumInQueue() < shortest.getNumInQueue()){
                shortest = a;
            }
        }
        return checkouts.indexOf(shortest);
    }

}
