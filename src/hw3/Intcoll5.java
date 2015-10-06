/*
 * **** Classwork for CIS2168 at Temple University ****
 * File created and owned by William Power.
 * No license.  It is against the academic honesty policy to
 * copy the code in this file, or any file in the repo.
 */
package hw3;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Intcoll5 - Collection now uses an actual Java api collection as its core.
 *
 * - c now points to a object of LinkedList<Integer> type. - No longer have a
 * howmany field. - Need to use just the API of the LinkedList class to
 * implement our class
 *
 *  **Read the IteratorDemo, LinkedListsDemo in classexamples to see how the
 * methods in the class work. **
 *
 * @author wpower
 */
public class Intcoll5 {

    private LinkedList<Integer> c;

    /* Generic constructor
     * Input: none
     * Return: new Intcoll3 object
     */
    public Intcoll5() {
        c = new LinkedList<>();
    }

    /* Given howmany constructor
     * Input: int i, howmany of container
     * Return: new Intcoll3 object
     */
    public Intcoll5(int i) {
        c = new LinkedList<>();
    }

    /* Overwrites the contents of the collection with those in obj
     * Input: Intcoll5 obj, the collection to be copied
     * Return: void
     */
    public void copy(Intcoll5 obj) {
        this.c.clear();
        ListIterator<Integer> iter = obj.c.listIterator();
        while (iter.hasNext()) {
            int n = iter.next();
            c.add(n);
        }
    }

    /* Checks if the value is in the collection
     * Input: int i, value to search for
     * Return: boolean
     */
    public boolean belongs(int i) {
        return c.contains(new Integer(i));
    }

    /* Inserts the value into the list if not already present.  Handles resizing.
     * Input: int i, value to insert
     * Return: void
     */
    public void insert(int i) {
        c.add(i);
    }

    /* Removes i from the collection if it is present.
     * Input: int i, value to omit
     * Return: void
     */
    public void omit(int i) {
        c.remove(new Integer(i));
    }

    /* Returns the number of ints in the collection.
     * Input: none
     * Return: int, number of ints in collection
     */
    public int get_howmany() {
        return c.size();
    }

    /* Prints contents of collection to System.out
     * Input: none 
     * Return: void
     */
    public void print() {
        ListIterator iter = c.listIterator();

        System.out.print("(");
        while (iter.hasNext()) {
            System.out.print(" " + iter.next());
        }
        System.out.print(" )");
    }

    /* Checks if given collection contains the same ints.
     * Input: Intcoll5 obj, the collection to be checked
     * Return: boolean, do they match?
     */
    public boolean equals(Intcoll5 obj) {
        return (this != obj) && c.equals(obj.c);
    }

    public static void main(String[] args) {
        Intcoll5 A = new Intcoll5();
        A.insert(1);
        A.insert(15);
        A.insert(10);

        Intcoll5 B = new Intcoll5();
        B.insert(2);
        B.insert(25);
        B.insert(10);
        
        System.out.println("A:");
        A.print();

        System.out.println("\nB:");
        B.print();

        System.out.println("\nA.omit(1): ");
        A.omit(1);
        A.print();
        System.out.println("\nA.omit(100): ");
        A.omit(100);
        A.print();
        
        System.out.println("\nA.copy(B): ");
        A.copy(B);
        A.print();
        
        System.out.println("\nA == B : " + A.equals(B));

    }
}
