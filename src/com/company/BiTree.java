package com.company;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by boyice on 8/16/2016.
 *
 */
class BiTree {

    static BiTreeNode createTree(String treeString){
        // split the string by spaces
        String[] treeParts = treeString.split(" ");
        // temp holder array for connecting nodes
        BiTreeNode[] nodeArray = new BiTreeNode[2];
        // hash of all the nodes in the tree
        HashMap<Integer, BiTreeNode> treeNodeHashMap = new HashMap<>();
        BiTreeNode root = null;
        BiTreeNode currentNode;
        for (String treePart : treeParts) {
            // try to convert tree string part into an int
            try {
                int num = Integer.valueOf(treePart);
                // add new node to tree hash if not already in it
                if (!treeNodeHashMap.containsKey(num)){
                    currentNode = new BiTreeNode(num);
                    treeNodeHashMap.put(num, currentNode);
                }
                // get reference the node from the tree if is already in it
                else{
                    currentNode = treeNodeHashMap.get(num);
                }
                // set the root
                if(root == null) root = currentNode;
                if(nodeArray[0] == null) nodeArray[0] = currentNode;
                else if (nodeArray[1] == null) nodeArray[1] = currentNode;
                else {
                    System.out.println("Something went wrong...");
                    break;
                }
                // catch errors when string can not be converted into an int
            } catch (NumberFormatException e) {
                // add left edge
                if (treePart.toUpperCase().equals("L")) {
                    nodeArray[0].left = nodeArray[1];
                  // add right edge
                } else if (treePart.toUpperCase().equals("R")) {
                    nodeArray[0].right = nodeArray[1];
                  // case for unknown character
                } else {
                    System.out.println("Got a weird character in the tree string: " + treePart);
                    break;
                }
                nodeArray[0] = null;
                nodeArray[1] = null;
            }
        }
        return root;
    }

    static void serializeTree(BiTreeNode root, Integer[] array){
        // create stack to hold tree nodes
        Stack<BiTreeNode> stack = new Stack<>();
        // add the root to the bottom of the stack
        stack.push(root);
        // create a cursor to do traversal
        BiTreeNode cursor = root.left;
        // depth first inorder traverse the tree
        while ( cursor != null ){
            if ( !stack.contains(cursor) ){
                stack.push(cursor);
            }
        }
    }
}
