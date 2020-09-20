package com.graph;

import java.util.Iterator;
import java.util.ListIterator;

public class Bag<Item> implements Iterable<Item> {

    private Node first;//链表的首节点

    private class Node{
        Item item;
        Node next;
    }

    public void add(Item item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public Iterator<Item> iterator(){
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        public void remove(){}

        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
