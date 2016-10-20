package com.company;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

/**
 * Created by boyice on 8/16/2016.
 *
 */
class LinkList {

    @Nullable
    static Node createList(Integer[] nums){

        if( nums == null  || nums.length == 0 ) return null;
        int length = nums.length;
        Node head = new Node(nums[0]);
        Node cursor = head;
        for (int i = 1; i < length; i++ ) {
            cursor.addToEnd(nums[i]);
            cursor = cursor.next;
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

    static Node findNthFromLast(Node head, int pos){
        if(head == null) return null;
        Node runner = head;
        for(int i = 0; i < pos; i++){
            runner = runner.next;
            if (runner == null) return null;
        }
        while(runner.next != null){
            head = head.next;
            runner = runner.next;
        }
        return head;
    }

    static void removeDuplicates(Node head){
        ArrayList<Integer> nodeList = new ArrayList<>();
        nodeList.add(head.data);
        Node prev = new Node();
        while (head != null){
            if(!nodeList.contains(head.data)){
                nodeList.add(head.data);
                prev = head;
            }
            else{
                prev.next = head.next;
            }
            head = head.next;
        }
    }

    static void removeDuplicatesNoBuff(Node head){
        Node runner;
        Node cursor = head.next;
        Node prev = head;
        while (cursor != null){
            runner = head;
            while (runner != cursor){
                if(runner.data == cursor.data) break;
                runner = runner.next;
            }
            if(runner == cursor){
                prev = cursor;
            }
            else {
                prev.next = cursor.next;
            }
            cursor = cursor.next;
        }
    }

    static void removeThisNode(Node node){
        if(node == null) return;
        Node next = node.next;
        if(next == null) return;
        node.data = next.data;
        node.next = next.next;

    }

    static int listAddition(Node list1, Node list2){
        int list1_int = linkListToInt(list1, 1);
        int list2_int = linkListToInt(list2, 1);
        return list1_int + list2_int;
    }

    private static int linkListToInt(Node list, int factor){
        if(list == null) return 0;
        return factor*list.data + linkListToInt(list.next, factor*10);
    }

    static Node findBeginCycle(Node head){
        ArrayList<Integer> nodeList = new ArrayList<>();
        while (!nodeList.contains(head.data)){
            nodeList.add(head.data);
            head = head.next;
        }
        return head;

    }

    static Node findBeginCycleNoBuffer(Node head){
        Node slow = head;
        Node fast = head.next;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = slow.next;
        while (slow != head){
            slow = slow.next;
            if(slow == fast) head = head.next;
        }
        return head;
    }

    static Node reverseLinkedList(Node head){
        Node currNode = head;
        Node prev = null;
        Node next = null;
        while (currNode != null){
            next = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = next;
        }
        return prev;
    }
}
