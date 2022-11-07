/**
 * Project 6
 * File: CheckoutAgent.java
 * Author: Zehra Gundogdu
 * Date: 4/4/2022
 */

import java.awt.Graphics;

public class CheckoutAgent {
    protected int posX;
    protected int posY;
    protected MyQueue<Customer> customers;

    //constructor
    public CheckoutAgent(int x, int y){
        posX = x;
        posY = y;
        MyQueue<Customer> queue = new MyQueue<Customer>();
        customers = queue;
    }

    //add a Customer to its queue.
    public void addCustomerToQueue(Customer c){
        customers.offer(c);
    }

    //returns the number of Customers in its queue.
    public int getNumInQueue(){
        return customers.size();
    }

    //draws the CheckoutAgent as a rectangle near the bottom of the window with a height proportional to the number of Customers in the queue
    public void draw(Graphics g){
        int N  = getNumInQueue();
        g.drawRect(posX, posY - 10*N, 10, 10*N);
    }

    public void updateState(Landscape scape) {
        for (Customer customer : customers) {
            customer.incrementTime();
        }
        if (customers.size() > 0) {
            Customer c = customers.peek();
            c.giveUpTime();
            if (c.getNumItems() == 0) {
                scape.addFinishedCustomer(customers.poll());
            }
        }
    }
    public static void main(String[] args){

    }
}
