/**
 * Project 6
 * File: Landscape.java
 * Author: Zehra Gundogdu
 * Date: 4/4/2022
 */

import java.util.ArrayList;
import java.awt.Graphics;

public class Landscape {
    protected int width;
    protected int height;
    protected ArrayList<CheckoutAgent> checkouts;
    protected LinkedList<Customer> outCustomers;

    //constructor
    public Landscape (int w, int h, ArrayList<CheckoutAgent> checkouts){
        LinkedList<Customer> newlist = new LinkedList<Customer>();
        outCustomers = newlist;
        width = w;
        height = h;
        this.checkouts = checkouts;
    }

    public Landscape (int w, int h, ArrayList<CheckoutAgent> checkouts,LinkedList<Customer> outCustomers ){
        this.outCustomers = outCustomers;
        width = w;
        height = h;
        this.checkouts = checkouts;
    }

    //returns the height of the landscape
    public int getHeight(){
        return height;
    }

    //returns the width of the landscape
    public int getWidth(){
        return width;
    }

    //returns a string indicating how many checkouts and finished customers are in the landscape
    public String toString(){
        return "Number of checkouts = " + checkouts.size() + ", Finished customers = " + outCustomers.size();
    }

    //adds the Customer to the list of finished customers
    public void addFinishedCustomer(Customer c ){
        outCustomers.addFirst(c);
    }

    //loops through the CheckoutAgents, calling the draw method on each.
    public void draw( Graphics g ){
        for (CheckoutAgent a : checkouts){
            a.draw(g);
        }
    }

    public void updateCheckouts(){
        for (CheckoutAgent c : checkouts){
            c.updateState(this);
        }
    }

    public void printFinishedCustomerStatistics(){
        int totTime = 0;
        for (Customer c : outCustomers) {
            totTime += c.getTime();
        }
        double avgTime = (double) totTime / outCustomers.size();
        double stdDev = 0;
        
        for (Customer c : outCustomers) {
            stdDev += Math.pow(c.getTime() - avgTime, 2);
        }
        stdDev = Math.sqrt(stdDev / outCustomers.size());

        System.out.println("Average time = " + avgTime);
        System.out.println("Standard deviation = " + stdDev);
    }
}
