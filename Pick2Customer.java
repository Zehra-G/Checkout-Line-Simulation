/**
 * Project 6
 * File: Pick2Customer.java
 * Author: Zehra Gundogdu
 * Date: 4/4/2022
 */

import java.util.ArrayList;
import java.util.Random;

class Pick2Customer extends Customer{

    //constructor
    public Pick2Customer( int num_items ){
        super(num_items, 2);
    }

    // returns the index of the shorter of two randomly chosen queues.
    public int chooseLine(ArrayList<CheckoutAgent> checkouts){
        Random rand = new Random();
        int idxline1 = rand.nextInt(checkouts.size());
        int idxline2 = rand.nextInt(checkouts.size());

        while (idxline2 == idxline1){
            idxline2 = rand.nextInt(checkouts.size());
        }

        if (checkouts.get(idxline1).getNumInQueue() < checkouts.get(idxline2).getNumInQueue()){
            return idxline1;
        } else {
            return idxline2;
        }
    }
  
}
