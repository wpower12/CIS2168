/*
 * **** Classwork for CIS2168 at Temple University ****
 * File created and owned by William Power.
 * No license.  It is against the academic honesty policy to
 * copy the code in this file, or any file in the repo.
 */
package ec1;

import java.util.Stack;

/**
 * <Extra Credit>
 *
 * Implement:
 * btNode remove( btNode t, int i )
 *
 * returns the root of a tree that has all elements greater than i removed
 *
 * Turn In:
 * Recursive Version
 *
 * Iterative Version
 *
 * @author wpower
 */
public class IntcollEC1 {

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
    public IntcollEC1() {
        c = null;
        howmany = 0;
    }

    /* Alternate constructor
     * Input: int i, size of container
     * Return: new Intcoll3 object
     */
    public IntcollEC1(int i) {
        c = null;
        howmany = 0;
    }

    /* Overwrites the contents of the collection with those in obj
     * Input: IntcollEC1 obj, the collection to be copied
     * Return: void
     */
    public void copy(IntcollEC1 obj) {
        c = copyNodes(obj.c);
        howmany = obj.get_howmany();
    }

    /**
     * Recursive function to copy nodes. Build a new node by recursivley copying
     * its non null children.
     *
     * A copy is essentially a traversal then. So we can mirror the traversal
     * code used in the print method.
     *
     * If we want a copy that matches the structure of the source tree, we can
     * either 'build up' with a postorder traversal or 'build down' with a
     * preorder traversal. In this method, we create then node, then call
     * the recursive method to create its children. IOW, were building down
     * with a pre order traversal.
     *
     */
    private BTNode copyNodes(BTNode t) {
        BTNode n = null;
        if (t != null) {
            //Note the <Pre Order Traversal>
            n = new BTNode(t.info); //'Visit Root' and Build node first
            n.left = copyNodes(t.left);
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
        if (p != null) {    //p either null or the node to delete.
            howmany--;
            if (p.left != null && p.right != null) {
                //Both children present - Need to do the Hilbert Greedy Delete
                BTNode old = p; //Saving the node we are replacing.
                BTNode old_pred = pred;
                //Finding the 'predecessor' - rightmost leaf in left tree
                pred = p;
                p = p.left;
                while (p.right != null) {
                    pred = p;
                    p = p.right;
                }

                //Handle children of predecessor/moved node
                pred.left = p.left;
                p.left = old.left;
                p.right = old.right;

                if (old_pred != null) {
                    //Not root
                    if (p.info < old_pred.info) {
                        old_pred.left = p;
                    } else {
                        old_pred.right = p;
                    }
                } else {
                    //Root
                    c = p;
                }

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
        printnode_inorder(c);
        //printnode_preorder(c);
        //printnode_postorder(c);
        System.out.print(")\n");
    }

    private void printnode_preorder(BTNode n) {
        if (n != null) {
            System.out.print(n.info + " ");
            printnode_preorder(n.left);
            printnode_preorder(n.right);
        }
    }

    private void printnode_postorder(BTNode n) {
        if (n != null) {
            printnode_postorder(n.left);
            printnode_postorder(n.right);
            System.out.print(n.info + " ");
        }
    }

    private void printnode_inorder(BTNode n) {
        if (n != null) {
            printnode_inorder(n.left);
            System.out.print(n.info + " ");
            printnode_inorder(n.right);
        }
    }

    private String queue;

    public void prettyprint() {
        queue = "";
        p_print(c);
    }

    private void p_print(BTNode n) {
        if (n != null) {
            System.out.print("(" + n.info + ")\n");
            if (n.right != null) {
                System.out.print(queue.toString() + " `--");
                push('|');
                p_print(n.right);
                pop();
            }
            if (n.left != null) {
                System.out.print(queue.toString() + " `--");
                push(' ');  //Need to push the number of spaces equal to the 
                //Digits of the last top node printed?
                p_print(n.left);
                pop();
            }
        }
    }

    private void push(char c) {
        queue += " " + c + "  ";
    }

    private void pop() {
        queue = queue.substring(0, queue.length() - 4);
    }

    public boolean equals(IntcollEC1 obj) {
        boolean result = (this != obj) && (howmany == obj.howmany);
        if (result) {
            int[] a = new int[howmany];
            int[] b = new int[howmany];
            int count_a, count_b;
            count_a = toArray(c, a, 0);
            count_b = toArray(obj.c, b, 0);
            int i = 0;
            while (result && (i < howmany)) {
                result = (a[i] == b[i]);
                i++;
            }
        }
        return result;
    }

    private static int toArray(BTNode t, int[] a, int i) {
        int num_nodes = 0;
        if (t != null) {
            num_nodes = toArray(t.left, a, i);                //Left
            a[num_nodes + 1] = t.info;                            //Visit
            num_nodes += toArray(t.right, a, num_nodes + i + 1);  //Right
        }
        return num_nodes;
    }

    //Look, recursive equals! - nlogn 
    private boolean recursiveEquals(BTNode t) {
        if (t != null) {
            return belongs(t.info) && recursiveEquals(t.left) && recursiveEquals(t.right);
        } else {    //Null leaves need to return true, or we poison our result
            return true;
        }
    }

    public void remove(int n) {
        c = remove_recursive( c, n );
        //c = remove_imperative(c, n);
    }

    private BTNode remove_recursive(BTNode t, int n) {
        if (t == null) {
            return null;    //Base Case
        } else {
            if (t.info <= n) { 
                t.right = remove_recursive(t.right, n); 
                return t;
            } else {
                return remove_recursive(t.left, n);
            }
        }
    }

    private BTNode remove_imperative(BTNode t, int n) {
        Stack<BTNode> stack = new Stack<>();
        BTNode root, pred;
        //rtLR
        stack.push( null ); //Pred
        stack.push( t );    //Inital root
        while( !stack.empty() ){
        //Visit Root - Either Keep Node or make pred.right = rt.left
            root = stack.pop();
            pred = stack.pop();
//            if( ){
//                
//            }
        //Push Left to Stack
            //Push correct pred
        //Push Right to Stack
            //Push correct pred
        
        }
        return t;
    }

    public static void main(String[] args) {
        IntcollEC1 A = new IntcollEC1();

        System.out.print("Testing Insert: \n");
        A.insert(20);
        A.insert(10);
        A.insert(50);
        A.insert(5);
        A.insert(8);
        A.insert(40);
        A.insert(60);
        A.insert(35);
        A.insert(45);
        A.insert(30);
        A.insert(38);

        System.out.print("A: \n");
        A.prettyprint();

        A.remove(30);
        System.out.print("A.remove(30): \n");
        A.prettyprint();
        
    }
}
