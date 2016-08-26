package com.company;

public class Main {

    public static void main(String[] args) {
        // callStringReverseFunc();
        // callRotateFunc();
        // callLinkList();
        // callBiTree();
        // callSpiralMatrix();
        callBSTree();

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
}
