/*
 * **** Classwork for CIS2168 at Temple University ****
 * File created and owned by William Power.
 * No license.  It is against the academic honesty policy to
 * copy the code in this file, or any file in the repo.
 */
package hw4;

/**
 * Intcoll6 - Collection uses Binary Search Tree
 *
 *
 * @author wpower
 */
public class Intcoll6 {

    /**
     * *
     * We make this static so we can keep all the nodes enclodes in our outer
     * class. In java, a static class can only occur inside another class. The
     * behaviour is not like C/C++, static in this instance does not mean you
     * can only have one instance of the class.
     */
    private static class BTNode {

        int info;
        BTNode left, right;

        private BTNode(int i) {
            info = i;
            left = null;
            right = null;
        }

        private BTNode(int i, BTNode l, BTNode r) {
            info = i;
            left = l;
            right = r;
        }
    }

    private BTNode c;
    private int howmany;

    /* Generic constructor
     * Input: none
     * Return: new Intcoll3 object
     */
    public Intcoll6() {
        c = null;
        howmany = 0;
    }

    /* Alternate constructor
     * Input: int i, size of container
     * Return: new Intcoll3 object
     */
    public Intcoll6(int i) {
        c = null;
        howmany = 0;
    }

    /* Overwrites the contents of the collection with those in obj
     * Input: Intcoll6 obj, the collection to be copied
     * Return: void
     */
    public void copy(Intcoll6 obj) {

    }

    /* Checks if the value is in the collection
     * Input: int i, value to search for
     * Return: boolean
     */
    public boolean belongs(int i) {
        BTNode p = c;
        while (p != null && p.info != i) {
            if (i < p.info) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return p != null;
    }

    /* Inserts the value into the list if not already present.  Handles resizing.
     * Input: int i, value to insert
     * Return: void
     */
    public void insert(int i) {
        BTNode pred = null, p = c;
        while (p != null && p.info != i) {
            pred = p;
            if (i < p.info) {
                p = p.left;
            } else {
                p = p.right;
            }
        }

        if (p == null) {
            p = new BTNode(i);
            if (pred == null) {
                c = p;
            } else {
                if (i < pred.info) {
                    pred.left = p;
                } else {
                    pred.right = p;
                }
            }
            howmany++;
        }
    }

    /* Removes i from the collection if it is present.
     * Input: int i, value to omit
     * Return: void
     */
    /**
     * Omit needs to implement the delete method discussed in the classexamples
     * package.
     *
     * The three main cases need to be dealt with as we traverse the tree,
     * starting at the root.
     *
     */
    public void omit(int i) {
        BTNode pred = null, p = c;
        while (p != null && p.info != i) {
            pred = p;
            if (i < p.info) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        //Now p points to either null, or a node with value i
        //This is where we write out the logic from the class examples
        
        if( p != null ){
            howmany--;
            
            //Leaf node
            if( p.left != null && p.right != null ){
                //Both children present.
            } 
            
        }
    }

    /* Returns the number of ints in the collection.
     * Input: none
     * Return: int, number of ints in collection
     */
    public int get_howmany() {
        return howmany;
    }

    /* Prints contents of collection to System.out
     * Input: none 
     * Return: void
     */
    public void print() {
        System.out.print("( ");
        printnode(c);
        System.out.print(")\n");
    }

    private void printnode(BTNode n) {
        if (n != null) {
            System.out.print(n.info+" ");
            printnode(n.left);
            printnode(n.right);
        }
    }

    /* Checks if given collection contains the same ints.
     * Input: Intcoll6 obj, the collection to be checked
     * Return: boolean, do they match?
     */
    public boolean equals(Intcoll6 obj) {
        return false;
    }

    public static void main(String[] args) {
        Intcoll6 A = new Intcoll6();
        A.insert(1);
        A.insert(15);
        A.insert(10);
        A.insert(10);
        A.insert(2000);
        A.print();
        System.out.print("A.get_howmany(): "+A.get_howmany()+"\n");
        System.out.print("A.belongs(8): "+A.belongs(8)+"\n");
        System.out.print("A.belongs(10): "+A.belongs(10)+"\n");
        
        System.out.print("A.omit(2000): \n");
        A.omit( 2000 );
        A.print();
    }
}
