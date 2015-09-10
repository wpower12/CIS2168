/*
 * **** Classwork for CIS2168 at Temple University ****
 * File created and owned by William Power.
 * No license.  It is against the academic honesty policy to
 * copy the code in this file, or any file in the repo.
 */
package hw1;
//*********************************************************************
// FILE NAME    : Intcoll2.java
// DESCRIPTION  : Same as Intcoll 1 but without the 0 sentinel 
//              : Instead, tracks its own howmany.            
/*TODO:
    Add lots of testing in client
*/
//*********************************************************************

public class Intcoll2 {
    private int[] c;
    private int howmany;
    
    /* Generic constructor
     * Input: none
     * Return: new Intcoll2 object
    */
    public Intcoll2() {
        c = new int[500];
        howmany = 0;
    }
    
    /* Given howmany constructor
     * Input: int i, howmany of container
     * Return: new Intcoll2 object
    */
    public Intcoll2(int i) {
        c = new int[i];
        howmany = 0;
    }

    /* Overwrites the contents of the collection with those in obj
     * Input: Intcoll2 obj, the collection to be copied
     * Return: void
    */
    public void copy(Intcoll2 obj) {
        if (this != obj) {
            c = new int[obj.c.length];
            int j = 0;
            while (j < obj.get_howmany() ) {
                c[j] = obj.c[j];
                j++;
            }
            howmany = obj.get_howmany();
        }
    }
    
    /* Checks if the value is in the collection
     * Input: int i, value to search for
     * Return: boolean
    */
    public boolean belongs(int i) {
        int j = 0;
        while ( (j < howmany) && (c[j] != i)) {
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
            while ((j < howmany) && (c[j] != i)) {
                j++;
            }
            //i is either howmany or the location of a copy
            if (j == howmany) {
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
                howmany++;
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
            while ((j < howmany) && (c[j] != i)) {
                j++;
            }
            if (c[j] == i) {
                int k = howmany - 1;
                c[j] = c[k];
                howmany--;
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
        int j = 0;
        System.out.println();
        while (j < howmany) {
            System.out.println(c[j]);
            j++;
        }
    }
    
    /* Checks if given collection contains the same ints.
     * Input: Intcoll2 obj, the collection to be checked
     * Return: boolean, do they match?
    */
    public boolean equals(Intcoll2 obj) {
        int j = 0;
        boolean result = ( howmany == obj.get_howmany() );
        while ((j < howmany) && result) {
            result = obj.belongs(c[j]);
            j++;
        }
        return result;
    }
}
