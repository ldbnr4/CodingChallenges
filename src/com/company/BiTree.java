package com.company;

import java.util.*;

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
        int max = Integer.MIN_VALUE;
        int maxKey = 0, maxHeight, key;
        for (Map.Entry<Integer, BiTreeNode> integerBiTreeNodeEntry : treeNodeHashMap.entrySet()) {
            Map.Entry pair = (Map.Entry) integerBiTreeNodeEntry;
            key = (int) pair.getKey();
            maxHeight = BiTreeNode.getHeight(treeNodeHashMap.get(key));
            if (maxHeight > max) {
                maxKey = key;
                max = maxHeight;
            }
        }
        return treeNodeHashMap.get(maxKey);
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

    static int levelDiff(BiTreeNode root){
        int sums[] = new int[2];
        levelDiff(root, sums, false);
        return sums[0] - sums[1];
    }

    private static void levelDiff(BiTreeNode root, int sums[], boolean even){
        if(root == null) return;
        if(even) sums[1] += root.data;
        else sums[0] += root.data;
        even = !even;
        levelDiff(root.left, sums, even);
        levelDiff(root.right, sums, even);
    }

    static String verticalPrint(BiTreeNode root){
        HashMap<Integer, ArrayList<Integer>> levelMap = new HashMap<>();
        verticalPrint(root, 0, levelMap);
        final int[] lowestKey = {Integer.MAX_VALUE};
        final int[] highestKey = {Integer.MIN_VALUE};
        levelMap.keySet().forEach(key ->{
            if(key < lowestKey[0]) lowestKey[0] = key;
            if(key > highestKey[0]) highestKey[0] = key;
        });
        for (int i = lowestKey[0]; i <= highestKey[0]; i++){
            levelMap.get(i).forEach(key -> System.out.print(key + " "));
            System.out.print("$ ");
        }

        return "";
    }

    private static void verticalPrint(BiTreeNode root, int level, HashMap<Integer, ArrayList<Integer>> levelMap){
        if(root != null){
            ArrayList<Integer> levelList = levelMap.get(level);
            if(levelList == null){
                levelList = new ArrayList<>();
                levelList.add(root.data);
                levelMap.put(level, levelList);
            }
            else{
                levelList.add(root.data);
            }
            verticalPrint(root.left, level-1, levelMap);
            verticalPrint(root.right, level+1, levelMap);
        }
    }

    static void firstCommonAncestor(BiTreeNode root, BiTreeNode node1, BiTreeNode node2){
        if(root != null) {
            if(covers(root.left, node1) && covers(root.left, node2)) firstCommonAncestor(root.left, node1, node2);
            else if(covers(root.right, node1) && covers(root.right, node2)) firstCommonAncestor(root.right, node1, node2);
            System.out.println(root.data);
        }
    }

    static private boolean covers(BiTreeNode parent, BiTreeNode child) {
        return parent != null && (
                child == null || parent.data == child.data ||
                covers(parent.left, child) || covers(parent.right, child)
        );
    }

}
