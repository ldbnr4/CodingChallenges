package com.company;

import jdk.internal.util.xml.impl.Pair;

import java.util.*;

public class Main {
    private static String string = "hello";
    private static String string2 = "elloh";
    private static char[] str = string.toCharArray();
    private static char[] str2 = string2.toCharArray();
    private static Integer[] nums = null;
    private static Integer[] nums2 = {4, 4, 3, 7, 1, 19, 39, 5};
    private static String userStrings = "u1,u3,u4,u6,u2,u1,u3,u4,u1";
    private static Node head = LinkList.createList(nums);
    private static Node head2 = LinkList.createList(nums2);

    public static void main(String[] args) {
        StringArray.findTopUsers(userStrings, 2);
    }

    private static void rotateFunc(){
        StringArray.rotateArray(new Integer[]{1,2}, 6);
        StringArray.rotateArray(new Integer[]{1,2}, -5);
        StringArray.rotateArray(new Integer[]{}, 6);
        StringArray.rotateArray(new Integer[]{1,2,3,4,5,6,7,8}, 0);
        StringArray.rotateArray(new Integer[]{1,2,3,4,5,6,7,8}, -3);
        StringArray.rotateArray(new Integer[]{1,2,3,4,5,6,7,8}, 3);
    }

    private static void stringReverseFunc(){
        StringArray.stringReversal("This is a sentence.");
        StringArray.stringReversal("");
        StringArray.stringReversal("Two! Words!?");
        StringArray.stringReversal("Run forrest Run");
    }

    private static void linkList(){
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

    private static void biTree(){
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

    private static void spiralMatrix(){
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

    private static void bSTree(){

        BiTreeNode tree = BiTree.deserializeTree("10 40 L 10 60 R 20 10 L 20 30 R");
        BSTree.biTreeToBSTree(tree);
        System.out.println(tree);

    }

    private static List<Integer> findLIS(List<Integer> sequence){ //N^2
        final int size = sequence.size();
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
            Integer key = sequence.get(i);
            if (key < sequence.get(tailIndicies.get(0)))
                // new smallest value
                tailIndicies.set(0, i);

            else if (key > sequence.get(tailIndicies.get(len-1))) {
                // A[i] wants to extend largest subsequence
                prevIndicies.set(i, tailIndicies.get(len-1));
                tailIndicies.set(len++, i);
            }
            else
            {
                // arr[i] wants to be a potential condidate of
                // future subsequence
                // It will replace ceil value in tailIndices
                int pos = CeilIndex(sequence, tailIndicies, -1, len - 1, key);
                prevIndicies.set(i, tailIndicies.get(pos-1));
                tailIndicies.set(pos, i);
            }
        }
        Vector<Integer> res = new Vector<>();
        for(int y = tailIndicies.get(len-1); y >= 0; y = prevIndicies.get(y)){
            res.add(0, sequence.get(y));
        }
        return res;
    }

    // Binary search (note boundaries in the caller)
    // sequence[] is ceilIndex in the caller
    private static int CeilIndex(List<Integer> sequence, List<Integer> tailIndicies, int l, int r, int key) {
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
        int maxIndex = Integer.MIN_VALUE, maxSize = Integer.MIN_VALUE;
        Vector<Vector<Integer>> L = new Vector<Vector<Integer>>(){{
            for(int x = 0; x < size; x++){
                add(new Vector<>());
            }
        }};
        L.get(0).add(sequence.get(0));
        for(int nextListIdx = 1; nextListIdx < size; nextListIdx++){
            for(int prevListIdx = 0; prevListIdx < nextListIdx; prevListIdx++){
                if( (sequence.get(nextListIdx) > sequence.get(prevListIdx)) && (L.get(nextListIdx).size() < L.get(prevListIdx).size() + 1) ){
                    L.set(nextListIdx, new Vector<>(L.get(prevListIdx)));
                }
            }
            L.get(nextListIdx).add(sequence.get(nextListIdx));
            if(L.get(nextListIdx).size() > maxSize){
                maxSize = L.get(nextListIdx).size();
                maxIndex = nextListIdx;
            }
        }
        return L.get(maxIndex);
    }

    private static void levelSum(){
        System.out.println(
                BiTree.levelDiff(
                    BiTree.deserializeTree("10 20 L 10 30 R 20 40 L 20 60 R")
                )
        );
    }

    private static void verticalPrint(){
        System.out.println(
                BiTree.verticalPrint(
                        BiTree.deserializeTree("10 20 L 10 30 R 20 40 L 20 60 R")
                )
        );
    }

    private static int celebProb(){
        int N = 4;
        int MATRIX[][] = {
            {0, 0, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 0},
            {0, 0, 1, 0}
        };

        int p1 = 0, p2 = N-1;
        while (p1 < p2){
            if(MATRIX[p1][p2] == 1) p1++;
            else p2--;
        }

        for (int i = 0; i < N; i++)
        {
            if (i != p2 && (MATRIX[p1][i] == 1 || MATRIX[i][p1] == 0))
                return -1;
        }
        return p1;
    }

    private static void topoSort(){
        DirectedGraphNode graph = new DirectedGraphNode("5 0 5 2 2 3 4 0 4 1 1 3");
    }

}
