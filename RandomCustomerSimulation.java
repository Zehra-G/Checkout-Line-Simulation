/**
 * Project 6
 * File: RandomCustomerSimulation.java
 * Author: Zehra Gundogdu
 * Date: 4/4/2022
 */

import java.util.Random;
import java.util.ArrayList;

public class RandomCustomerSimulation {
    public static void main(String[] args) throws InterruptedException {
        Random gen = new Random();
        ArrayList<CheckoutAgent> checkouts = new ArrayList<CheckoutAgent>(5);

        for(int i=0;i<5;i++) {
            CheckoutAgent checkout = new CheckoutAgent( i*100+50, 480 );
            checkouts.add( checkout );
        }
        Landscape scape = new Landscape(500,500, checkouts);
        LandscapeDisplay display = new LandscapeDisplay(scape);
        
        for (int j = 0; j < 1000; j++) {
            Customer cust = new RandomCustomer(1+gen.nextInt(5));
            int choice = cust.chooseLine( checkouts );
            checkouts.get(choice).addCustomerToQueue( cust );
            scape.updateCheckouts();
            display.repaint();
            Thread.sleep( 2 );
            if ((j + 1) % 100 == 0) {
                scape.printFinishedCustomerStatistics();
            }
        }
        
        

    }
}
