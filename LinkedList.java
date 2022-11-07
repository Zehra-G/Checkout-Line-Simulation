/**
 * Lab 5
 * File: LinkedList.java
 * Author: Zehra Gundogdu
 * Date: 3/18/2022
 */

import java.util.Iterator;    // defines the Iterator interface
import java.util.ArrayList;   
import java.util.Collections; // contains a shuffle function

public class LinkedList<T> implements Iterable<T>{

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

    

    private class LLIterator implements Iterator<T> {
        public Node node;

        public LLIterator(Node head) {
            node = head;
        }

        public boolean hasNext() {
            return node != null;
        }

        public T next() {
            Node tempNode = node;
            node = node.next;
            return tempNode.getVal();
        }

    }

    //constructor that initializes the fields so it is an empty list
    public LinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    //empties the list (resets the fields so it is an empty list)
    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }

    //returns the size of the list
    public int size(){
        return size;
    }

    //inserts the item at the beginning of the list.
    public void addFirst(T item){ 
        if (size == 0){
            Node newNext = new Node(item);
            head = newNext;
            tail = newNext;  
            size ++;  
        }else if (size == 1){
            Node newNext = new Node(item);
            newNext.setNext(head);
            tail = head;
            head = newNext;
            size++;
        }else {
            Node newNext = new Node(item);
            newNext.setNext(head);
            head = newNext;
            size++;
        }
    
    }

    // appends the item at the end of the list.
    public void addLast(T item) {
        if (size == 0) {
            addFirst(item);
        } else {
            Node last = new Node(item);
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = last;
        }
    }
    
    // inserts the item at the specified poistion in the list.
    public void add(int index, T item) { 
        Node newNode = new Node(item);
        if (head != null && tail != null) {
            Node temp = head;

            int counter = 0;

            while (counter < index - 1) {
                temp = temp.next;
                counter++;
            }

            newNode.setNext(temp.getNext());
            temp.setNext(newNode);

        }
        size += 1;
    }

    //removes the item at the specified position in the list.
    public T remove(int index) {
        if (size > 0) {
            Node current = head;
            Node prev = null;
            int counter = 0;

            while (counter < index) {
                prev = current;
                current = current.getNext();
                counter++;
            }

            if (current == head) {
                T result = current.getVal();
                head = head.getNext();
                size--;
                return result;

            } else if (current == tail) {
                T result = current.getVal();
                tail = prev;
                prev.setNext(null);
                size--;
                return result;

            } else {
                T result = current.getVal();
                prev.setNext(current.getNext());
                size--;
                return result;
            }
        }
        return null;
    }

    // Return a new LLIterator pointing to the head of the list
    public Iterator<T> iterator() {
        return new LLIterator(this.head);

    }

    // returns an ArrayList of the list contents in order.
    public ArrayList<T> toArrayList() {
        ArrayList<T> out = new ArrayList<T>();
        Iterator<T> ic = iterator();
        while (ic.hasNext()) {
            out.add(ic.next());
        }
        return out;
    }

    // returns an ArrayList of the list contents in shuffled order.
    public ArrayList<T> toShuffledList() {
        ArrayList<T> out = toArrayList();
        Collections.shuffle(out);
        return out;
    }
}