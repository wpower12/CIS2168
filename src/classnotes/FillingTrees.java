/*
 * **** Classwork for CIS2168 at Temple University ****
 * File created and owned by William Power.
 * No license.  It is against the academic honesty policy to
 * copy the code in this file, or any file in the repo.
 */
package classnotes;

/**
 *
 * @author wpower
 *
 *
 * If given a list of integers, and a strcutured tree (nodes with no info, but
 * links) we would like a way to fill the tree and make it a BST.
 *
 * To do this, we remember that an inorder traversal visits the nodes of a tree
 * in the order in which we would fill them in comparison correct order.
 *
 * That is, we can do an in order traversal and during our visit, make the info
 * member for that node the next int in our sorted list.
 *
 * So we Sort->Traverse->Profit
 *
 * In the class example, we use bubble sort. Swapping elements to build a sorted
 * sub section of the array until the entire array is the sorted subsection.
 * 
 * Assume we have sort finished.
 * 
 * 
 * 
 */
public class FillingTrees {

    public static void bubblesort(int[] a) {
        int temp, i, j;
        //Remember how to implement this, read your old algo book.
    }

    public static void main(String[] args) {

    }
}
