package com.company;

/**
 * Created by boyice on 8/16/2016.
 *
 */
class Node {
    Node next;
    int data;

    Node() {}

    Node(int d) {
        data = d;
        next = null;
    }

    void addToEnd(int data){
        this.next = new Node(data);
    }

}
