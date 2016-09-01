package com.company;

/**
 * Created by boyice on 8/16/2016.
 *
 */
class BiTreeNode extends Node{
    BiTreeNode left = null, right = null;

    BiTreeNode(int data){
        super(data);
    }

    boolean isLeaf(){
        return left == null && right == null;
    }

    void setLeft(BiTreeNode left){
        this.left = left;
    }

    void setRight(BiTreeNode right){
        this.right = right;
    }

    static int getHeight(BiTreeNode root){
        if(root==null)return 0;
        return (1 + Math.max(getHeight(root.left), getHeight(root.right)));
    }

    static boolean compare(BiTreeNode tree_1, BiTreeNode tree_2){
        return BiTree.preorderTreeSerialization(tree_1).equals(BiTree.preorderTreeSerialization(tree_2));
    }
}
