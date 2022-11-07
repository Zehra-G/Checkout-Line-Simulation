/**
 * Lab 6
 * File: MyQueue.java
 * Author: Zehra Gundogdu
 * Date: 3/29/2022
 */

import java.util.Iterator;    // defines the Iterator interface
import java.util.ArrayList; 

public class MyQueue<T> implements Iterable<T>{
    private Node head;
    private Node tail;
    private int size;

    private class Node{

        private Node next;
        private Node prev;
        private T item;

        // a constructor that initializes next to null and the container field to item
        public Node (T item){
            this.next = null;
            this.prev = null;
            this.item = item;
        }

        //returns the value of the container field.
        public T getVal(){
            return this.item;
        }

        //sets next to the given node.
        public void setNext(Node n){
            this.next = n;
        }

        //returns the next field.
        public Node getNext(){
            return this.next;
        }

        //sets next to the given node.
        public void setPrev(Node n){
            this.prev = n;
        }

        //returns the next field.
        public Node getPrev(){
            return this.prev;
        }
    }

    private class QueueIterator implements Iterator<T> {
        public Node node;

        public QueueIterator(Node head) {
            node = head;
        }

        //check whether the queue has next or not
        public boolean hasNext() {
            if (node != null){
                return true;
            } else {
                return false;
            }
        }

        //returns the value of the next item in the list
        public T next() {
            if (this.hasNext() == true){
                T val = node.getVal();
                node = node.getNext();
                return val;
            }
            return null;
        }

    }

    //Return a new QueueIterator pointing to the head of the list
    public Iterator<T> iterator() {
        return new QueueIterator(this.head);

    }

    //constructor that initializes the fields so it is an empty queue
    public MyQueue(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    //empties the list (resets the fields so it is an empty queue)
    public void clear(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    //returns the size of the queue
    public int size(){
        return this.size;
    }

    public boolean offer(T item) {
        // Inserts item into this queue if possible. Returns true if successful.
        Node newNode = new Node(item);
        if (head == null){
            head = newNode;
            tail = newNode;
            size++;
            return true;
        } else if (size == 1){
            head.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
            size++;
            return true;
        }else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
            size++;
            return true;
        }
    }
    
    public T peek() {
        // Returns, but does not remove, the head of this queue, or returns null if this queue is empty.
        if (head == null){
            return null;
        } else {
            return head.getVal();
        }
    }
    
    public T poll() {
        // Returns and removes the head of this queue, or returns null if this queue is empty.
        if (head == null){
            return null;
        } else if (size == 1) {
            Node removedHead = head;
            head = null;
            tail = null;
            size--;
            return removedHead.getVal();

        } else {
            Node removedHead = head;
            Node newHead = head.getNext();
            newHead.setPrev(null);
            head = newHead;
            size--;
            return removedHead.getVal();
        }
    }

    public ArrayList<T> toArrayList(){
        ArrayList<T> result = new ArrayList<T>();
        Iterator<T> iter = this.iterator();

        while (iter.hasNext()){
            result.add(iter.next());
        }
        return result;
    }

    public String toString() {
        String str = "";
        Node obj = head;
        while (obj.getNext() != null){
            str += String.valueOf(obj.getVal()) + ", ";
            obj = obj.getNext();
        }
        str += String.valueOf(tail.getVal());
        return str;
    }

    public static void main(String[] args){
        MyQueue queue = new MyQueue();
        System.out.println("Offering 1, 2, 3 to the queue:");
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        Iterator iter = queue.iterator();
        System.out.println(queue);

        System.out.println("Iterating over the queue");
        System.out.println(iter.next());
        System.out.println(iter.next());
        System.out.println("Has next: " + iter.hasNext());
        System.out.println(iter.next());
        System.out.println("Has next: " + iter.hasNext());


        System.out.println("returning and removing the head of the queue");
        System.out.println(queue.poll());
        System.out.println("new queue: " + queue);
        System.out.println("returning and removing the head of the queue");
        System.out.println(queue.poll());
        System.out.println("new queue: " + queue);

        System.out.println("Offering 4, 5, 6 to the queue:");
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        System.out.println(queue);
        System.out.println("peeking at the head of the queue");
        System.out.println("head = " + queue.peek());
        System.out.println("peeked queue: " + queue);

        //ADD TEST CODE FOR THE ITERATOR

    }
}