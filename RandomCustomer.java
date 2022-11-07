/**
 * Project 6
 * File: RandomCustomer.java
 * Author: Zehra Gundogdu
 * Date: 4/4/2022
 */

import java.util.ArrayList;
import java.util.Random;

public class RandomCustomer extends Customer {

    //constructor
    public RandomCustomer( int num_items ){
        super(num_items, 1);
    }

    //implementation of the abstract method in abstract class Customer
    //returns an integer randomly chosen from the range 0 (inclusive) to the lenght of the list (exclusive).
    public int chooseLine(ArrayList<CheckoutAgent> checkouts){
        Random rand = new Random();
        return rand.nextInt(checkouts.size());
    }
}
