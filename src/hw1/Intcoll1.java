/*
 * **** Classwork for CIS2168 at Temple University ****
 * File created and owned by William Power.
 * No license.  It is against the academic honesty policy to
 * copy the code in this file, or any file in the repo.
 */
package hw1;
//*********************************************************************
// FILE NAME    : Intcoll1.java
// DESCRIPTION  : This file contains the class Intcoll1.
//
// Stores unique integers greater than 1 in a stack.  New ints are inserted
// at the end if they are not in the stack already. 0 is the end of stack sentinel
// 
// Omits are handled by swapping last int with omitted int.
//
// Size is not tracked.  Size is returned by iterating over stack and counting.
//*********************************************************************

public class Intcoll1 {

    private int[] c;
    
    /* Generic constructor
     * Input: none
     * Return: new Intcoll1 object
    */
    public Intcoll1() {
        c = new int[500 + 1];
        c[0] = 0;
    }
    
    /* Given size constructor
     * Input: int i, size of container
     * Return: new Intcoll1 object
    */
    public Intcoll1(int i) {
        c = new int[i + 1];
        c[0] = 0;
    }

    /* Overwrites the contents of the collection with those in obj
     * Input: Intcoll1 obj, the collection to be copied
     * Return: void
    */
    public void copy(Intcoll1 obj) {
        if (this != obj) {
            c = new int[obj.c.length];
            int j = 0;
            while (obj.c[j] != 0) {
                c[j] = obj.c[j];
                j++;
            }
            c[j] = 0;
        }
    }
    
    /* Checks if the value is in the collection
     * Input: int i, value to search for
     * Return: boolean
    */
    public boolean belongs(int i) {
        int j = 0;
        while ((c[j] != 0) && (c[j] != i)) {
            j++;
        }
        return ((i > 0) && (c[j] == i));
    }
    
    /* Inserts the value into the list if not already present.  Handles resizing.
     * Input: int i, value to insert
     * Return: void
    */
    public void insert(int i) {
        if (i > 0) {
            int j = 0;
            while ((c[j] != 0) && (c[j] != i)) {
                j++;
            }
            //cj is either i or 0
            if (c[j] == 0) {
                if (j == c.length - 1) {
                    //Hit capacity. No room for 0    
                    int[] newC = new int[c.length*2];
                    
                    //copy c to newC
                    for( int k=0; k<c.length;k++ ){
                        newC[k] =c[k];
                    }
                    //replace pointer to old c to newC
                    c = newC;
                }
                c[j] = i;
                c[j + 1] = 0;
            }
        }
    }
    
    /* Removes i from the collection if it is present.
     * Input: int i, value to omit
     * Return: void
    */
    public void omit(int i) {
        if (i > 0) {
            int j = 0;
            while ((c[j] != 0) && (c[j] != i)) {
                j++;
            }
            if (c[j] == i) {
                int k = j + 1;
                while (c[k] != 0) {
                    k++;
                }
                c[j] = c[k - 1];
                c[k - 1] = 0;
            }
        }
    }
    
    /* Returns the number of ints in the collection.
     * Input: none
     * Return: int, number of ints in collection
    */
    public int get_howmany() {
        int j = 0, howmany = 0;

        while (c[j] != 0) {
            howmany++;
            j++;
        }
        return howmany;
    }
    
    /* Prints contents of collection to System.out
     * Input: none 
     * Return: void
    */
    public void print() {
        int j = 0;
        System.out.println();
        while (c[j] != 0) {
            System.out.println(c[j]);
            j++;
        }
    }
    
    /* Checks if given collection contains the same ints.
     * Input: Intcoll1 obj, the collection to be checked
     * Return: boolean, do they match?
    */
    public boolean equals(Intcoll1 obj) {
        int j = 0;
        boolean result = true;
        while ((c[j] != 0) && result) {
            result = obj.belongs(c[j]);
            j++;
        }
        j = 0;
        while ((obj.c[j] != 0) && result) {
            result = belongs(obj.c[j]);
            j++;
        }
        return result;
    }
    
    public static void main(  String[] args ){
        
    }
}
