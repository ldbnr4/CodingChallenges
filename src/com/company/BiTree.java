package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                // fill our holder array with the two nodes
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

    static ArrayList<Integer> serializeTree(BiTreeNode root, ArrayList<Integer> array){
        // create stack to hold tree nodes
        Stack<BiTreeNode> stack = new Stack<>();
        // depth first, inorder traverse the tree
        inorder(root, stack, array);
        return array;
    }

    private static void inorder(BiTreeNode node, Stack<BiTreeNode> stack, ArrayList<Integer> arrayList){
        // base case
        if(node == null) {
            // if there is something on the stack we can add it to our array
            if(!stack.isEmpty()) {
                BiTreeNode topOfStack = stack.pop();
                arrayList.add(topOfStack.data);
            }
        }
        else{
            // traverse the left side
            inorder(node.left, stack, arrayList);
            // add the node to the stack after going all the way left
            stack.push(node);
            // traverse the right side
            inorder(node.right, stack, arrayList);
        }
    }
    static BiTreeNode deserializeTree(ArrayList<Integer> array){

        int min = Integer.MAX_VALUE;
        for(Integer val : array){
            if (val < min) min = val;
        }

        BiTreeNode root = new BiTreeNode(min);

        for(int i = 0; i < array.size(); i++){
            if(i < array.size()-2){
                int first = array.get(i);
                int second = array.get(i+1);
                BiTreeNode parent;
                BiTreeNode child;

                if( first > second){
                    // first is a child of second
                }
                else{
                    // first is the parent of second
                }
                //if(i != 0 && parent.left == null){
                    // assign child to left parent
                //}
                //else{
                    //
                //}

            }
            else{

            }
        }

        return null;
    }
}
