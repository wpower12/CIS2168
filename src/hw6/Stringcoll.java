/*
 * **** Classwork for CIS2168 at Temple University ****
 * File created and owned by William Power.
 * No license.  It is against the academic honesty policy to
 * copy the code in this file, or any file in the repo.
 */
package hw6;

/**
 * Replace all needed elements to make intcoll6 work while storing strings,
 * not integers.
 *
 * DONT EXTEND ANYTHING HERE. THIS IS THE BASE CLASS
 *
 * @author wpower
 */
public class Stringcoll {

    /**
     * *
     * We make this static so we can keep all the nodes enclosed in our outer
     * class. In java, a static class can only occur inside another class. The
     * behaviour is not like C/C++, static in this instance does not mean you
     * can only have one instance of the class. It means the class is basically
     * only envokeable from within the outer class? Ask.
     */
    private static class BTNode {

        String info;
        BTNode left, right;

        private BTNode(String s) {
            info = s;
            left = null;
            right = null;
        }

        private BTNode(String s, BTNode l, BTNode r) {
            info = s;
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
    public Stringcoll() {
        c = null;
        howmany = 0;
    }

    /* Alternate constructor
     * Input: int i, size of container
     * Return: new Intcoll3 object
     */
    public Stringcoll(int i) {
        c = null;
        howmany = 0;
    }

    /* Overwrites the contents of the collection with those in obj
     * Input: Stringcoll obj, the collection to be copied
     * Return: void
     */
    public void copy(Stringcoll obj) {
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
    public int belongs(String s) {
        BTNode p = c;
        while (p != null && !p.info.equals(s)) {
            if (p.info.compareTo(s) < 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return (p != null) ? 1:0;
    }

    /* Inserts the value into the list if not already present.  Handles resizing.
     * Input: int i, value to insert
     * Return: void
     */
    public void insert(String s) {
        BTNode pred = null, p = c;
        while (p != null && !(p.info.compareTo(s) == 0)) {
            pred = p;
            if (p.info.compareTo(s) > 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }

        if (p == null) {
            p = new BTNode(s);
            if (pred == null) {
                c = p;
            } else {
                if (pred.info.compareTo(s) > 0) {
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
    public void omit(String s) {
        BTNode pred = null, p = c;
        while (p != null && !(p.info.compareTo(s) == 0)) {
            pred = p;
            if (p.info.compareTo(s) > 0) {
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
                if (p == old.left) {
                    pred.left = p.left;
                } else {
                    pred.right = p.left;
                }
                p.left = old.left;
                p.right = old.right;

                if (old_pred != null) {
                    old_pred.left = p;
                } else {
                    //Root
                    c = p;
                }

            } else if (p.left != null && p.right == null) {
                //Only Left node exists.
                if (pred != null) {
                    if (pred.info.compareTo(p.info) > 0) {
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
                    if (pred.info.compareTo(p.info) > 0) {
                        pred.left = p.right;
                    } else {
                        pred.right = p.right;
                    }
                } else {    //Root case
                    c = p.right;
                }
            } else {
                //Both children null - leaf - easy!
                if (pred.info.compareTo(p.info) > 0) {
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

    private void printnode_inorder(BTNode n) {
        if (n != null) {
            printnode_inorder(n.left);
            System.out.print(n.info + " ");
            printnode_inorder(n.right);
        }
    }

    /*
     * Pretty Printing Trees 
     *  This is a recursive method to print some trees.  This works by tracking
     * a queue of characters as we go from node to node.  The push and pop
     * functions just add and delete characters from the queue as we traverse
     * the nodes in preorder.
     * 
     * The queue is tracking what characters need to 'go before' a node when we
     * actually print its line to the console.  Pre order helps us here because
     * we will get them in an order that makes sense for printing in our nested
     * method.
     */
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
        //This assumes the size of all pushes is 4, this needs to be tracked/changed
        queue = queue.substring(0, queue.length() - 4);
    }

    /* Checks if given collection contains the same ints.
     * Input: Stringcoll obj, the collection to be checked
     * Return: boolean, do they match?
     */
    /**
     * If we traverse one tree and do the check equals, we take time
     * proportional to the depth of the tree we call .belongs() on
     *
     * So if we traverse the obj tree, and call belongs on ours, hopefully
     * we have time O(logn) on our belongs.
     *
     * We can do even better!
     *
     * If we think of equals as comparing sorted arrays of the ints in the trees
     * we can then imagine equals as comparing each slot and making sure its the
     * same.
     *
     * Instead of actually keeping an array, we could just traverse both trees in
     * order at the same time. While doing this, we make sure the n-est element
     * (nth smallest elements) are the same. This leads to a equals method
     * that occurs in O(n) time!!!
     *
     * Woot. This beats our recursive solutions average time of
     * n items, logn belongs each: O(n logn)
     *
     *
     *
     * To simplify things, were gonna start with actually filling arrays and
     * then checking. This is still order n.
     *
     *
     */
    public boolean equals(Stringcoll obj) {
        boolean result = (this != obj) && (howmany == obj.howmany);
        if (result) {
            String[] a = new String[howmany];
            String[] b = new String[howmany];
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

    /**
     * toArray: Given a tree root, will fill array a with a sorted list of the
     * integers contained in the tree. i is the number of nodes, tracked
     * recursivley. Returns the number of nodes in the tree.
     *
     * This is an <Inorder Traversal> so we always travers left, visit the
     * node, then traverse right.
     *
     * When we traverse left, we are looking at all the smaller nodes, so we
     * know they will be in the array before the current node. So, we
     * make num_nodes equal to all of the nodes that would be inserted by
     * toArray on the left subtree. Since our method returns the count, we can
     * do the recursive call as shown below.
     *
     * Notice, on the left traverse, we pass just i, the number of nodes already
     * in the array.
     *
     * On the right traverse, we pass num_nodes+i+1 because we have added a node
     * to the total node count, and then we add the nodes from the left sub tree.
     * and we add all nodes from prior to this node (i).
     *
     * Since this happens recursivly, we know our num_node counts will be correct.
     */
    private static int toArray(BTNode t, String[] a, int i) {
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
            return (belongs(t.info)==1) && recursiveEquals(t.left) && recursiveEquals(t.right);
        } else {    //Null leaves need to return true, or we poison our result
            return true;
        }
    }

    public static void main(String args[]) {

        Stringcoll A = new Stringcoll();
        Stringcoll B = new Stringcoll();

        A.insert("e");
        A.insert("c");
        A.insert("b");
        A.insert("d");
        A.insert("a");
        A.insert("l");
        A.insert("m");
        A.insert("q");
        A.insert("z");
        A.insert("w");
        
        B.copy(A);
        A.prettyprint();

        String c;

        //Internal, Non Root Omit
        c = "c";
        System.out.println("A.omit(" + c + ")");
        A.omit(c);
        A.prettyprint();

        //Internal, Root Omit
        c = "e";
        System.out.println("A.omit(" + c + ")");
        A.omit(c);
        A.prettyprint();

        //One childs
        c = "m";
        System.out.println("A.omit(" + c + ")");
        A.omit(c);
        A.prettyprint();
        c = "q";
        System.out.println("A.omit(" + c + ")");
        A.omit(c);
        A.prettyprint();

        //Leaf Omit
        c = "w";
        System.out.println("A.omit(" + c + ")");
        A.omit(c);
        A.prettyprint();
        
        //Deep Copy/Equals
        System.out.println("B:");
        B.prettyprint();
        
        System.out.println("A.equals(B)= false? : "+A.equals(B));
        System.out.println("A.copy(B)");
        A.copy(B);
        System.out.println("A.equals(B)= true? : "+A.equals(B));
    }

}
