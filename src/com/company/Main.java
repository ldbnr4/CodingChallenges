package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // callStringReverseFunc();
        // callRotateFunc();
        // callLinkList();
        // callBiTree();
        // callSpiralMatrix();
        // callBSTree();
        /* System.out.println(findLIS(new Vector<Integer>(
                Arrays.asList(2, 5, 3, 7, 11, 8, 10, 13, 6)
        )));
        System.out.println(findLISN2(new Vector<Integer>(
                Arrays.asList(2, 5, 3, 7, 11, 8, 10, 13, 6)
        )));
        */
        callBiTree2();
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

        BiTreeNode tree = BiTree.deserializeTree("10 40 L 10 60 R 20 10 L 20 30 R");
        BSTree.biTreeToBSTree(tree);
        System.out.println(tree);

    }

    private static List<Integer> findLIS(List<Integer> sequence){ //N^2
        final int size = sequence.size();
        // Add boundary case, when array n is zero
        // Depend on smart pointers
        Vector<Integer> tailIndicies   = new Vector<Integer>(){{
            for (int x = 0; x < size; x++){
                add(0);
            }
        }};
        Vector<Integer> prevIndicies = new Vector<Integer>(){{
            for (int x = 0; x < size; x++){
                add(-1);
            }
        }};
        int len = 1; // always points empty slot
        for (int i = 1; i < size; i++)
        {
            if (sequence.get(i) < sequence.get(tailIndicies.get(0)))
                // new smallest value
                tailIndicies.set(0, i);

            else if (sequence.get(i) > sequence.get(tailIndicies.get(len-1))) {
                // A[i] wants to extend largest subsequence
                prevIndicies.set(i, tailIndicies.get(len-1));
                tailIndicies.set(len++, i);
            }
            else
            {
                // arr[i] wants to be a potential condidate of
                // future subsequence
                // It will replace ceil value in tailIndices
                int pos = CeilIndex(sequence, tailIndicies, -1, len - 1, sequence.get(i));
                prevIndicies.set(i, tailIndicies.get(pos-1));
                tailIndicies.set(pos, i);
            }
        }
        Vector<Integer> res = new Vector<Integer>();
        for(int y = tailIndicies.get(len-1); y >= 0; y = prevIndicies.get(y)){
            res.add(0, sequence.get(y));
        }
        return res;
    }

    // Binary search (note boundaries in the caller)
    // sequence[] is ceilIndex in the caller
    private static int CeilIndex(List<Integer> sequence, List<Integer> tailIndicies, int l, int r, int key)
    {
        while (r - l > 1)
        {
            int m = l + (r - l)/2;
            if (sequence.get(tailIndicies.get(m)) >= key)
                r = m;
            else
                l = m;
        }

        return r;
    }

    private static List<Integer> findLISN2(List<Integer> sequence){
        final int size = sequence.size();
        int maxIndex = 0, maxSize = 0;
        Vector<Vector<Integer>> L = new Vector<Vector<Integer>>(){{
            for(int x = 0; x < size; x++){
                add(new Vector<Integer>());
            }
        }};
        L.get(0).add(sequence.get(0));
        for(int i = 1; i < size; i++){
            for(int j = 0; j < i; j++){
                if((sequence.get(j) < sequence.get(i)) && (L.get(i).size() < L.get(j).size()+1)){
                    L.set(i, (Vector<Integer>) L.get(j).clone());
                }
            }
            L.get(i).add(sequence.get(i));
        }
        for (int y = 0; y < size; y++){
            if (L.get(y).size() > maxSize){
                maxIndex = y;
                maxSize = L.get(y).size();
            }
        }
        return L.get(maxIndex);
    }

    private static void callBiTree2(){
        BiTree.levelDiff(BiTree.deserializeTree("10 20 L 10 30 R 20 40 L 20 60 R"));
    }
}
