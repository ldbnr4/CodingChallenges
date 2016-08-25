package com.company;

import java.util.HashMap;

/**
 * Created by boyice on 8/16/2016.
 *
 */
class BiTree {

    static BiTreeNode deserializeTree(String treeString){
        // split the string by spaces
        String[] treeParts = treeString.split(" ");
        // temp holder array for connecting nodes
        BiTreeNode[] nodeArray = new BiTreeNode[2];
        // hash of all the nodes in the tree
        HashMap<Integer, BiTreeNode> treeNodeHashMap = new HashMap<>();
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

        return getRootNode(treeNodeHashMap);
    }

    private static BiTreeNode getRootNode(HashMap<Integer, BiTreeNode> treeNodeHashMap) {
        final int[] max = {Integer.MIN_VALUE};
        final int[] maxKey = {0};
        treeNodeHashMap.forEach((k,v)->{
            int nodeHeight = BiTreeNode.getHeight(v);
            if(max[0] < nodeHeight){
                max[0] = nodeHeight;
                maxKey[0] = k;
            }
        });
        return treeNodeHashMap.get(maxKey[0]);
    }

    static String preorderTreeSerialization(BiTreeNode root){
        // create and return the String for the serialized tree
        return preorderTreeSerialization(root, "");
    }
    private static String preorderTreeSerialization(BiTreeNode root, String serialString) {
        // base criteria
        if(root != null) {
            // add the node's connections to it's children to the serialized string
            if(root.left != null){
                serialString += root.data + " " + root.left.data + " L ";
            }
            if(root.right != null){
                serialString += root.data + " " + root.right.data + " R ";
            }
            // recursive call to traverse left first
            serialString = preorderTreeSerialization(root.left, serialString);
            // recursive call to traverse right after going left first
            serialString = preorderTreeSerialization(root.right, serialString);
        }
        return serialString;
    }

    static String inorderTreeSerialization(BiTreeNode root) {
        // create and return the String for the serialized tree
        return inorderTreeSerialization(root, "");
    }

    private static String inorderTreeSerialization(BiTreeNode root, String serialString){
        // base criteria
        if (root != null){
            // recursive call to traverse left first
            serialString = inorderTreeSerialization(root.left, serialString);
            // add the node's connections to it's children to the serialized string
            if(root.left != null){
                serialString += root.data + " " + root.left.data + " L ";
            }
            if(root.right != null){
                serialString += root.data + " " + root.right.data + " R ";
            }
            // recursive call to traverse left after adding node to the array list
            serialString = inorderTreeSerialization(root.right, serialString);
        }
        return serialString;
    }

    static String postorderTreeSerialization(BiTreeNode root) {
        // create and return the String for the serialized tree
        return postorderTreeSerialization(root, "");

    }

    private static String postorderTreeSerialization(BiTreeNode root, String serialString){
        // base criteria
        if(root != null){
            // recursive call to traverse left first
            serialString = postorderTreeSerialization(root.left, serialString);
            // recursive call to traverse right after going left first
            serialString = postorderTreeSerialization(root.right, serialString);
            // add the node's connections to it's children to the serialized string
            if(root.left != null){
                serialString += root.data + " " + root.left.data + " L ";
            }
            if(root.right != null){
                serialString += root.data + " " + root.right.data + " R ";
            }
        }
        return serialString;
    }
}
