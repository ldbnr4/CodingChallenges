package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        // callStringReverseFunc();
        // callRotateFunc();
        // callLinkList();
        // callBiTree();
        // callSpiralMatrix();
        // callBSTree();
        System.out.println(findLIS(new Vector<Integer>(Arrays.asList(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15))));
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
        String serialString;
        BiTreeNode tree, tree2;

        /*
         * First Tree
         */
        tree = BiTree.deserializeTree("20 40 L 20 60 R 10 20 L 10 30 R");

        serialString = BiTree.preorderTreeSerialization(tree);
        System.out.println("Preorder serialization: " + serialString);
        tree2 = BiTree.deserializeTree(serialString);
        if (!BiTreeNode.compare(tree, tree2)) throw new AssertionError();

        serialString = BiTree.inorderTreeSerialization(tree);
        System.out.println("Inorder serialization: " + serialString);
        tree2 = BiTree.deserializeTree(serialString);
        if (!BiTreeNode.compare(tree, tree2)) throw new AssertionError();

        serialString = BiTree.postorderTreeSerialization(tree);
        System.out.println("Postorder serialization: " + serialString);
        tree2 = BiTree.deserializeTree(serialString);
        if (!BiTreeNode.compare(tree, tree2)) throw new AssertionError();

        System.out.println();

        /*
         * Second Tree
         */
        tree = BiTree.deserializeTree("1 2 L 2 4 R 1 3 R 3 5 L 5 7 L 3 6 R 6 8 L 6 9 R");

        serialString = BiTree.preorderTreeSerialization(tree);
        System.out.println("Preorder serialization: " + serialString);
        tree2 = BiTree.deserializeTree(serialString);
        if (!BiTreeNode.compare(tree, tree2)) throw new AssertionError();


        serialString = BiTree.inorderTreeSerialization(tree);
        System.out.println("Inorder serialization: " + serialString);
        tree2 = BiTree.deserializeTree(serialString);
        if (!BiTreeNode.compare(tree, tree2)) throw new AssertionError();

        serialString = BiTree.postorderTreeSerialization(tree);
        System.out.println("Postorder serialization: " + serialString);
        tree2 = BiTree.deserializeTree(serialString);
        if (!BiTreeNode.compare(tree, tree2)) throw new AssertionError();

        System.out.println();

    }

    private static void callSpiralMatrix(){
        int index = 0;
        try {
            index = SpiralMatrix.getFromSpiralMatrix(new int[][]{
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,0,1,2},
                    {3,4,5,6}
            }, 4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(index);
    }

    private static void callBSTree(){

        BiTreeNode tree = BiTree.deserializeTree("20 40 L 20 60 R 10 20 L 10 30 R");
        BSTree.biTreeToBSTree(tree);

    }

    private static List<Integer> findLIS(List<Integer> sequence){ //N^2
        int size = sequence.size();
        // Add boundary case, when array size is one
        Vector<Integer> tailTable   = new Vector<Integer>();
        int len; // always points empty slot

        tailTable.add(sequence.get(0));
        len = 1;
        for (int i = 1; i < size; i++)
        {
            if (sequence.get(i) < tailTable.get(0))
                // new smallest value
                tailTable.set(0, sequence.get(i));

            else if (sequence.get(i) > tailTable.get(len-1)) {
                // A[i] wants to extend largest subsequence
                tailTable.add(sequence.get(i));
                len++;
            }
            else
                // A[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable
                tailTable.set(CeilIndex(tailTable, -1, len-1, sequence.get(i)), sequence.get(i));
        }
        return tailTable;
    }

    // Binary search (note boundaries in the caller)
    // A[] is ceilIndex in the caller
    private static int CeilIndex(Vector<Integer> A, int l, int r, int key)
    {
        while (r - l > 1)
        {
            int m = l + (r - l)/2;
            if (A.get(m)>=key)
                r = m;
            else
                l = m;
        }

        return r;
    }
}
