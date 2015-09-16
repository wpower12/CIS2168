/*
 * **** Classwork for CIS2168 at Temple University ****
 * File created and owned by William Power.
 * No license.  It is against the academic honesty policy to
 * copy the code in this file, or any file in the repo.
 */
package hw2;

/**
 *
 * @author wpower
 */
public class Intcoll4 {

    private int howmany;
    private ListNode c;

    private class ListNode {

        private int info;
        private ListNode link;

        public ListNode() {
            info = 0;
            link = null;
        }
    }

    /* Generic constructor
     * Input: none
     * Return: new Intcoll3 object
     */
    public Intcoll4() {
        c = null;
        howmany = 0;
    }

    /* Given howmany constructor
     * Input: int i, howmany of container
     * Return: new Intcoll3 object
     */
    public Intcoll4(int i) {
        c = null;
        howmany = 0;
    }

    /* Overwrites the contents of the collection with those in obj
     * Input: Intcoll4 obj, the collection to be copied
     * Return: void
     */
    public void copy(Intcoll4 obj) {
        if( this != obj ){
            howmany = obj.get_howmany();
            ListNode curr = obj.c;
            ListNode prev = null;
            ListNode n;
            while( curr != null ){
                n = new ListNode();
                n.info = curr.info;
                if( prev != null ){
                    prev.link = n;
                } else {
                    c = n;
                }
                curr = curr.link;
                prev = n;
            }
        }
    } 

    /* Checks if the value is in the collection
     * Input: int i, value to search for
     * Return: boolean
     */
    public boolean belongs(int i) {
        ListNode cur = c;
        while (cur != null && cur.info != i) {
            cur = cur.link;
        }
        return cur != null;
    }

    /* Inserts the value into the list if not already present.  Handles resizing.
     * Input: int i, value to insert
     * Return: void
     */
    public void insert(int i) {
        if (!belongs(i)) {
            ListNode n = new ListNode();
            n.info = i;
            n.link = c;
            c = n;
            howmany++;
        }
    }

    /* Removes i from the collection if it is present.
     * Input: int i, value to omit
     * Return: void
     */
    public void omit(int i) {
        ListNode prev = null;
        ListNode curr = c;
        while (curr != null && curr.info != i) {
            prev = curr;
            curr = curr.link;
        }
        if (curr != null) {
            if (prev == null) {
                c = curr.link;
            } else {
                prev.link = curr.link;
            }
            howmany--;
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
        ListNode curr = c;
        System.out.print("( ");
        while (curr != null) {
            System.out.print(curr.info + " ");
            curr = curr.link;
        }
        System.out.println(")");
    }

    /* Checks if given collection contains the same ints.
     * Input: Intcoll4 obj, the collection to be checked
     * Return: boolean, do they match?
     */
    public boolean equals(Intcoll4 obj) {
        ListNode curr = c;
        boolean match = (howmany == obj.get_howmany());
        while (curr != null && match) {
            if (!obj.belongs(curr.info)) {
                match = false;
            } else {
                curr = curr.link;
            }
        }
        return match;
    }

}
