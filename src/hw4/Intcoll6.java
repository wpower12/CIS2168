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
     * We make this static so we can keep all the nodes enclosed in our outer
     * class. In java, a static class can only occur inside another class. The
     * behaviour is not like C/C++, static in this instance does not mean you
     * can only have one instance of the class. It means the class is basically
     * only envokeable from within the outer class? Ask.
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
        c = copyNodes(obj.c);
    }

    /**
     * Recursive function to copy nodes. Build a new node by recursivley copying
     * its non null children.
     */
    private BTNode copyNodes(BTNode t) {
        BTNode n = new BTNode(t.info);
        if (t.left != null) {
            n.left = copyNodes(t.left);
        }
        if (t.right != null) {
            n.right = copyNodes(t.right);
        }
        return n;
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
        //This is where we write out the logic from the class examples
        if (p != null) {    //p either null or the node to delete.
            howmany--;
            if (p.left != null && p.right != null) {
                //Both children present - Need to do the Hilbert Greedy Delete
                BTNode old = p; //Saving the node we are overwriting.
                //Finding the 'successor' - Leftmost leaf in right tree
                pred = p;
                p = p.right;
                while (p.left != null) {
                    pred = p;
                    p = p.left;
                }
                //Overwriting the value. 
                old.info = p.info;
                pred.left = null;
            } else if (p.left != null && p.right == null) {
                //Only Left node exists.
                if (pred != null) {
                    if (p.info < pred.info) {
                        pred.left = p.left;
                    } else {
                        pred.right = p.left;
                    }
                } else {    //Root case
                    c = p.left;
                }
            } else if (p.right != null && p.left == null) {
                //Only right node exists
                if (pred != null) {
                    if (p.info < pred.info) {
                        pred.left = p.right;
                    } else {
                        pred.right = p.right;
                    }
                } else {    //Root case
                    c = p.right;
                }
            } else {
                //Both children null - leaf - easy!
                if (p.info < pred.info) {
                    pred.left = null;
                } else {
                    pred.right = null;
                }
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

    /**
     * printnode - Recursivly print the tree in order. This works because our
     * invariant for the datastructure is that all nodes in n.left are less than
     * the value in the node, and all nodes in n.right are greater than the
     * value in the node.
     *
     * We Do a check for null, then follow that guideline to print. First we
     * print everything less than the given node, then we print the node, then
     * we print everything greater than the node.
     *
     * This is, without a doubt, the coolest recursive thing I have seen in data
     * structures.
     *
     * Apparently this greatly informs how we can recusivley define the delete
     * methods later. For now, the delete method is implemented in an iterative
     * manner. I'd like to get he recursive version working soon.
     */
    private void printnode(BTNode n) {
        if (n != null) {
            printnode(n.left);
            System.out.print(n.info + " ");
            printnode(n.right);
        }
    }

    /* Checks if given collection contains the same ints.
     * Input: Intcoll6 obj, the collection to be checked
     * Return: boolean, do they match?
     */
    public boolean equals(Intcoll6 obj) {
        if (this != obj) {
            return checkEquals(obj.c);
        } else {
            return true;
        }
    }
    
    //Look, recursive equals!
    private boolean checkEquals(BTNode t) {
        if (t != null) {
            return this.belongs(t.info) && checkEquals(t.left) && checkEquals(t.right);
        } else {    //Null leaves need to return true, or we poison our result
            return true;
        }
    }

    public static void main(String[] args) {
        Intcoll6 A = new Intcoll6();
        A.insert(10);
        A.insert(1);
        A.insert(16);
        A.insert(20);
        A.insert(2000);
        A.insert(15);
        A.insert(13);
        A.print();
        System.out.print("A.get_howmany(): " + A.get_howmany() + "\n");
        System.out.print("A.belongs(8): " + A.belongs(8) + "\n");
        System.out.print("A.belongs(10): " + A.belongs(10) + "\n");

        Intcoll6 B = new Intcoll6();
        System.out.print("B.copy(A) \n");
        B.copy(A);
        System.out.print("B: ");
        B.print();

        System.out.print("Testing Omit Cases \n");
        System.out.print("A.omit(2000), A:  \n");
        A.omit(2000);
        A.print();

        System.out.print("A.omit(1), A: \n");
        A.omit(1);
        A.print();

        System.out.print("A.omit(15), A: \n");
        A.omit(15);
        A.print();

        System.out.print("A.omit(10), A: \n");
        A.omit(10);
        A.print();

        System.out.print("B: ");
        B.print();

        System.out.print("A.equals(B) = " + A.equals(B) + "\n");
        System.out.print("B.copy(A) \n");
        B.copy(A);
        System.out.print("A.equals(B) = " + A.equals(B) + "\n");

    }
}
