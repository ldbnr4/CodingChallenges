package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //callStringReverseFunc();
        //callRotateFunc();
        //callLinkList();
        callBiTree();
    }

    private static void callRotateFunc(){
        StringArray.rotateArray(new Integer[]{1,2}, 6);
        StringArray.rotateArray(new Integer[]{1,2}, -5);
        StringArray.rotateArray(new Integer[]{}, 6);
        StringArray.rotateArray(new Integer[]{1,2,3,4,5,6,7,8}, 0);
        StringArray.rotateArray(new Integer[]{1,2,3,4,5,6,7,8}, -3);
        StringArray.rotateArray(new Integer[]{1,2,3,4,5,6,7,8}, 3);
    }

    private static void callStringReverseFunc(){
        StringArray.stringReversal("This is a sentence.");
        StringArray.stringReversal("");
        StringArray.stringReversal("Two! Words!?");
        StringArray.stringReversal("Run forrest Run");
    }

    private static void callLinkList(){
        Node node = LinkList.createList(new Integer[]{5,35,8,1,78,6,4});
        LinkList.printList(node);
        node = LinkList.removeFromList(node, 4);
        LinkList.printList(node);
        node = LinkList.removeFromList(node, -1);
        LinkList.printList(node);
        node = LinkList.removeFromList(node, 0);
        LinkList.printList(node);
        node = LinkList.removeFromList(node, 17);
        LinkList.printList(node);
    }

    private static void callBiTree(){
        BiTreeNode tree = BiTree.createTree("10 20 L 10 30 R 20 40 L 20 60 R");
        System.out.println(tree);
    }
}
