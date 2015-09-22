/*
 * **** Classwork for CIS2168 at Temple University ****
 * File created and owned by William Power.
 * No license.  It is against the academic honesty policy to
 * copy the code in this file, or any file in the repo.
 */
package classexamples;

/**
 *
 * @author wpower
 */
public class BinaryTrees {

    /*
     <Binary Trees> are a data structure that organizes data with nodes.

     Nodes may have at most 2 children.  These are referred to as the
     left node and right node.  

     The <depth of a node> is the distance of that node from the root node
     This is also the length of the path from the node to the root, counting
     Nodes.  

     The <depth of a tree> is that of its deepest node.

     Binary trees are typically used to stored ordered data.  The left and 
     right children of a node then take on special meaning.  If a node 
     represents some quantity with a ordering, that is, it makes sense to 
     say less than or greater than, then the left node points to only elements
     less than the parent, and the right node points to only elements
     greater than the parent.
    
     This can reduce the search done on the elements dramatically, as long as
     some care is taken building the tree.
    
     When we organize a tree like this, we refer to it as a <Binary Search Tree>
    
     There can be multiple trees representing the same set of elements that all
     satisfy the ordering requirements of the BST.  
    
     If you have n nodes with n elements, than if you draw some binary tree with
     those nodes, you will be able to assign elements to nodes in such a way that
     you have a correct BST.   
    
     In other words, <Any n-node binary tree can represent a BST for a set of n 
     ordered elements.>
     
     HOWEVER!  The efficiency of the search in a BST is dependant on the structure
     of the tree.  More specifically, the search speed depends on the depth of
     the tree.  Any worst case search goes to the end of a branch.  Any search
     for a non existing member goes down a full branch.
    
     For a binary tree, at depth d, we can have at most 2^d nodes.  Therefore,
     if we have n nodes to store in a tree of depth d, then
    
     :   n <= 1 + 2^1 + 2^2 + ... + 2^d-1 = 2^d - 1   //Sum of Arithmatic Series
    
     Or, for a given n, the depth is atleast d = log(n+1).  
     IOW, best case for d is:
    
     :   d <= ceil( log(n+1) )
    
     You can always create a tree with this depth, after rounding to integers
     and being careful.  We call this the minimum depth tree.  
    
     For a tree like this, searching is on the order of the depth, and therefore
     on the order of log(n).
    
     Insert and delete are also on the order of log(n), provided the 
     implementation maintains the minimum depth criteria.  This is the first
     data structure weve seen that supports all three main collection methods.
     Insert, Search, Delete are all linear time.
    
     Details of their implementation are found below, above their actual methods.
     */
    public class BST {

        BinaryTree root;

        private class BinaryTree {

            int value;
            BinaryTree left;
            BinaryTree right;

            private BinaryTree(int i) {
                value = i;
                left = null;
                right = null;
            }
        }

        public BST() {
            root = null;
        }

        /* Search
            Mimic Binary Search!  There are three cases for each node we look at
        
        <Equal to Nodes Value> 
        :   Return the value!  You're done.
        
        <Less Than Node Value>
        :   Follow left link, if null, value isnt in the collection.
        
        <Greater Than Node Value>
        :   Follow right link, if null, value isnt in the collection.
        
         */
        public boolean search(int i) {

            return true;
        }

        /* Insert
         Naeiieve Method:
         - First do a search.  
         - When you get to a node with a null, youve reache where the element goes.  
         Add a node.
         */
        public void insert(int i) {
            if (root != null) {

            } else {
                root = new BinaryTree(i);
            }
        }
        /* Delete
         First we search, then there are a few cases depending on where we find
            the element to delete.
        
         <Leaf Node> 
         :   If the search yields a leaf node, all we do is make that node null
         in its parent.  
        
         <Internal Node with one child>
         :   If the search yields an internal node with one child, its simple
         to reassign that child as the child on the correct side of the elements
         parent.  
        
         <Internal Node with two children>
         :   If we have 2 child nodes, we have our hardest situation.  
         One method is to find an element in the tree that could be removed by
         one of the above methods, and replace the item to delete.  That is, find 
         an element that we can remove, and still maintain the BST, and replace
         the item to delete with it.  
        
         We notice that you can always remove the largest item in the left 
         subtree, or the smallest item in the right subtree to maintain the BST.
        
         These elements, the leftlargest and rightsmallest, can be found by 
         following the right links in the left tree, and the left links in the
         right tree. Wooooooooooo thats a tongue twister.
         */

        public void delete(int i) {

        }
    }

    public static void main(String[] args) {

    }
}
