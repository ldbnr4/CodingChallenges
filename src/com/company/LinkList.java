package com.company;

import org.jetbrains.annotations.Nullable;

/**
 * Created by boyice on 8/16/2016.
 *
 */
class LinkList {
    @Nullable
    static Node createList(Integer[] nums){
        if( nums.length == 0 ) {
            System.out.println("Empty array!\n");
            return null;
        }
        int length = nums.length;
        Node head = null;
        Node prevNode = null;
        for (int i = 0; i < length; i++ ) {
            Node newNode = new Node(nums[i]);
            if( i == 0 ) head = newNode;
            if( i >= 1 && prevNode != null) prevNode.next = newNode;
            prevNode = newNode;
        }
        return head;
    }

    static void printList(Node head){
        if (head == null){
            System.out.println("Empty list!\n");
            return;
        }
        while(head != null){
            System.out.print( "[" + head.data + "]->");
            head = head.next;
        }
        System.out.println("/NULL");
    }

    static Node removeFromList(Node head, int nodePos){
        if(head == null){
            System.out.println("Empty list!\n");
        }
        else if (nodePos < 0){
            System.out.println("Illegal node index!\n");
        }
        else if(nodePos == 0){
            head = head.next;
        }
        else{
            Node cursor = head;
            Node prevNode = null;
            for(int i = 0; i < nodePos ;i++) {
                if (cursor == null) break;
                prevNode = cursor;
                cursor = cursor.next;
            }
            if( cursor  != null ) {
                assert prevNode != null;
                prevNode.next = cursor.next;
            }
        }
        return head;
    }


}
