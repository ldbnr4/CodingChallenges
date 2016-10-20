package com.company;

import java.util.ArrayList;

/**
 * Created by boyice on 8/26/2016.
 *
 */
class BSTree {

    static BiTreeNode biTreeToBSTree(BiTreeNode biTree){
        if(biTree == null) return null;
        ArrayList<Integer> sortedInorderTree = getInorder(biTree);
        shellSort(sortedInorderTree);
        arrayListToBST(sortedInorderTree, biTree);
        return biTree;
    }

    private static void shellSort(ArrayList<Integer> arr) {
        int n = arr.size();
        // Start with a big gap, then reduce the gap
        for (int gap = n/2; gap > 0; gap /= 2)
        {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already in gapped order
            // keep adding one more element until the entire array is
            // gap sorted
            for (int i = gap; i < n; i += 1)
            {
                // add a[i] to the elements that have been gap sorted
                // save a[i] in temp and make a hole at position i
                int temp = arr.get(i);

                // shift earlier gap-sorted elements up until the correct
                // location for a[i] is found
                int j;
                for (j = i; j >= gap && arr.get(j - gap) > temp; j -= gap)
                    arr.set(j, arr.get(j - gap));

                //  put temp (the original a[i]) in its correct location
                arr.set(j, temp);
            }
        }
    }

    private static ArrayList<Integer> getInorder(BiTreeNode tree){
        ArrayList<Integer> sortedList = new ArrayList<>();
        getInorder(tree, sortedList);
        return sortedList;
    }

    private static void getInorder(BiTreeNode tree, ArrayList<Integer> array){
        if (tree != null){
            getInorder(tree.left, array);
            array.add(tree.data);
            getInorder(tree.right, array);
        }
    }

    private static void arrayListToBST(ArrayList<Integer> sortedList, BiTreeNode tree){
        if(tree != null){
            arrayListToBST(sortedList, tree.left);
            tree.data = sortedList.remove(sortedList.size()-1);
            arrayListToBST(sortedList, tree.right);
        }
    }

    static BiTreeNode arrayToBST(Integer[] array) {
        Integer[] sortedArray = Sorting.mergeSort(array,0, array.length);
        return BiTree.arrayToBiTree(sortedArray, 1);
    }
}
