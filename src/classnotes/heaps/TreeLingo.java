/*
 * **** Classwork for CIS2168 at Temple University ****
 * File created and owned by William Power.
 * No license.  It is against the academic honesty policy to
 * copy the code in this file, or any file in the repo.
 */
package classnotes.heaps;

/**
 * @author wpower
 * 
 * <Labeling Nodes in a Generic Tree>
 * 
 * An interesting label scheme is to label the root with 1, and then to label
 * all other nodes by taking looking at any labeled nodes children.  The left
 * child of a node is labeled 2*l, and the right child is labeled 2*l+1.
 * 
 * We can use these labels to build linked lists to represent the tree.
 * 
 * We can also represent the tree in an array by using these labels.  If we
 * have a array sized to the max label, then each entry is either a null value
 * or represents the value of that node in the tree.
 * 
 * The max size of these arrays is dependant on the location of the last element.
 * In the worst case, the last node is on a path of only right links to the root, 
 * if theres n nodes then, we need an array of size 2^n.  Thats not great.
 * 
 * This means we cannot use sequential representation on only well formed complete
 * trees.  Otherwise, theres just no way you can hold the array in memory. 
 */
public class TreeLingo {
    
}
